package com.anrong.wulan.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anrong.wulan.admin.dao.UserMapper;
import com.anrong.wulan.admin.dao.UserRoleMapper;
import com.anrong.wulan.admin.po.User;
import com.anrong.wulan.admin.po.UserRole;
import com.anrong.wulan.admin.service.UserService;
import com.anrong.wulan.core.entity.UserException;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 用户Service实现类
 *
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    
    @Override
    public GenericDao<User, Long> getDao() {
        return userMapper;
    }

    @Override
    @CacheEvict(value="userCache",allEntries=true)
    public int insert(User model) {
        return userMapper.insertSelective(model);
    }

    @Override
    @CacheEvict(value="userCache",allEntries=true)
    public int update(User model) {
        return userMapper.updateByPrimaryKeySelective(model);
    }
    

    /**
     * 删除用户时同时将用户角色关联也一起删掉
     */
    @Transactional
    @Override
    @CacheEvict(value="userCache",key="#p0")
    public int delete(Long id) {
    	userRoleMapper.deleteByUserId(id);
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User authentication(User user) {
        return userMapper.authentication(user);
    }

    @Override
    @Cacheable(value="userCache",key="#p0")
    public User selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @SuppressWarnings("unchecked")
	@Override
	@Cacheable(value="userCache",key="#username")
    public User selectByUsername(String username) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("username", username);
        PageBounds pageBounds = new PageBounds(1, 5);
        final List<User> list = userMapper.selectPage(param, pageBounds); 
        return list.size()>0?list.get(0):null;
    }

	@SuppressWarnings("rawtypes")
	@Override
	public List selectPage(Map<String, Object> params, PageBounds page) {
		 Map<String,Object> param = new HashMap<String,Object>();
		return userMapper.selectPage(param, page);
	}

	@Transactional
	@Override
	@CacheEvict(value="userCache",allEntries=true)
	public boolean insert(User user, List<Long> roleIds) {
		int i = this.insert(user);
		if(i!=1){
			return false;
		}
		Long userId = user.getId();
		//  同时将用户与角色的关联关系一并插入
		for(Long roleId : roleIds ){
			UserRole userRole = new UserRole();
			userRole.setRoleId(roleId);
			userRole.setUserId(userId);
			userRoleMapper.insert(userRole);
		}
		return true;
	}

	@Transactional
	@Override
	@CacheEvict(value="userCache",allEntries=true)
	public boolean update(User user, List<Long> roleIds) {
		
		int i = this.update(user);
		if(i!=1){
			throw new UserException("用户更新失败");
		}
		userRoleMapper.deleteByUserId(user.getId());
		Long userId = user.getId();
		//  同时将用户与角色的关联关系一并插入
		for(Long roleId : roleIds){
			UserRole userRole = new UserRole();
			userRole.setRoleId(roleId);
			userRole.setUserId(userId);
			userRoleMapper.insert(userRole);
		}
		return true;
	}

}
