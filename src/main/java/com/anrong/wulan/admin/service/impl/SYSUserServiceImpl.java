package com.anrong.wulan.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anrong.wulan.admin.dao.AppInfoMapper;
import com.anrong.wulan.admin.dao.SYSRole_UserMapper;
import com.anrong.wulan.admin.dao.SYSUserCustomMapper;
import com.anrong.wulan.admin.dao.UserAppMapper;
import com.anrong.wulan.admin.dao.UserMapper;
import com.anrong.wulan.admin.po.AppInfo;
import com.anrong.wulan.admin.po.SYSRole;
import com.anrong.wulan.admin.po.SYSRole_User;
import com.anrong.wulan.admin.po.SYSRole_UserExample;
import com.anrong.wulan.admin.po.SYSRole_UserExample.Criteria;
import com.anrong.wulan.admin.po.User;
import com.anrong.wulan.admin.po.UserApp;
import com.anrong.wulan.admin.service.SYSUserService;
import com.anrong.wulan.admin.vo.SYSUserVO;
import com.anrong.wulan.core.util.Page;

@Service
@Transactional
public class SYSUserServiceImpl implements SYSUserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private SYSUserCustomMapper sysUserCustomMapper;

	@Autowired
	private SYSRole_UserMapper sysRole_UserMapper;

	@Autowired
	private UserAppMapper userAppMapper;

	@Override
	public Page<User> getUsersByCriteria(SYSUserVO sysUserVO) {
		// 当前要查询的下标位置
		Integer offset = (sysUserVO.getP() - 1) * sysUserVO.getPageSize();
		sysUserVO.setOffset(offset);
		// 查询符合条件记录的总条数
		Integer totalSize = sysUserCustomMapper.findUserCountByCriteria(sysUserVO);
		// 查询符合条件的记录数据
		List<User> users = sysUserCustomMapper.findUserListByCriteria(sysUserVO);
		Page<User> page = new Page<>(sysUserVO.getP(), sysUserVO.getPageSize(), totalSize);
		page.setItems(users);
		return page;
	}

	@Override
	public Long getCountByUserName(SYSUserVO sysUserVO) {
		return sysUserCustomMapper.getCountByUserName(sysUserVO.getUsername());
	}

	@Override
	public Boolean addUser(SYSUserVO sysUserVO) {
		User user = new User();
		user.setUsername(sysUserVO.getUsername());
		user.setState("-1".equals(sysUserVO.getState()) ? "1" : sysUserVO.getState());
		SimpleHash simpleHash = new SimpleHash("md5", sysUserVO.getPassword(), null, 1);
		user.setPassword(simpleHash.toString());
		user.setCreateTime(new Date());
		Integer result = userMapper.insert(user);
		if (result < 1) {
			return false;
		}
		// 为新插入的用户绑定角色
		List<Integer> roleIds = sysUserVO.getRoleIds();
		int insertCount = 0;
		for (Integer roleid : roleIds) {
			SYSRole_User record = new SYSRole_User();
			record.setRoleid(roleid);
			record.setUserid(Integer.parseInt(user.getId().toString()));
			insertCount += sysRole_UserMapper.insert(record);
		}
		// 绑定appInfo
		List<Integer> appIds = sysUserVO.getAppIds();
		for (Integer appId : appIds) {
			UserApp userApp = new UserApp();
			userApp.setAppInfoId(appId);
			userApp.setUserId(user.getId());
			userAppMapper.insertSelective(userApp);
		}
		return insertCount == roleIds.size();
	}

	@Override
	public List<Integer> getRoleIdsByUserId(Long id) {
		SYSRole_UserExample example = new SYSRole_UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(Integer.parseInt(id.toString()));
		List<SYSRole_User> sysRoleUsers = sysRole_UserMapper.selectByExample(example);
		List<Integer> roleIds = new ArrayList<>();
		for (SYSRole_User sysRole_User : sysRoleUsers) {
			roleIds.add(sysRole_User.getRoleid());
		}
		return roleIds;
	}

	@Override
	@Cacheable(value="userCache",key="#root.methodName + #p0")
	public User getUserByUserId(Long id) {
		User user = userMapper.selectByPrimaryKey(id);
		if (user != null) {
			return user;
		}
		return null;
	}

	@Override
	@CacheEvict(value="userCache",allEntries=true)
	public Boolean updateUser(SYSUserVO sysUserVO) {
		// 用户更新(用户一定存在)

		// 判断更新成功的标志
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;

		// 1. 更新用户基本信息
		User user = new User();
		user.setId(sysUserVO.getId());
		user.setUsername(sysUserVO.getUsername());
		user.setState("-1".equals(sysUserVO.getState()) ? "1" : sysUserVO.getState());
		String password = (sysUserVO.getPassword() == null || "".equals(sysUserVO.getPassword())) ? null
				: (new SimpleHash("md5", sysUserVO.getPassword(), null, 1)).toString();
		user.setPassword(password);
		user.setCreateTime(sysUserVO.getCreateTime());
		count1 = userMapper.updateByPrimaryKeySelective(user);

		// 2. 解除该用户与所有原始角色的绑定
		SYSRole_UserExample example = new SYSRole_UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(Integer.parseInt(user.getId().toString()));
		List<SYSRole_User> sysRoleUsers = sysRole_UserMapper.selectByExample(example);
		for (SYSRole_User sysRole_UserOri : sysRoleUsers) {
			count2 += sysRole_UserMapper.deleteByPrimaryKey(sysRole_UserOri.getId());
		}

		// 3. 解除该用户与所有APPINFO的绑定
		List<UserApp> userAppOrigins = userAppMapper.selectByUserId(user.getId());
		for (UserApp userAppOri : userAppOrigins) {
			count3 += userAppMapper.deleteByPrimaryKey(userAppOri.getId());
		}

		// 4. 重新绑定所有新的角色
		List<Integer> roleIds = sysUserVO.getRoleIds();
		for (Integer roleid : roleIds) {
			SYSRole_User record = new SYSRole_User();
			record.setRoleid(roleid);
			record.setUserid(Integer.parseInt(user.getId().toString()));
			count4 += sysRole_UserMapper.insert(record);
		}

		// 5. 重新绑定所有新的APPINFO
		List<Integer> appIds = sysUserVO.getAppIds();
		for (Integer appId : appIds) {
			UserApp userApp = new UserApp();
			userApp.setAppInfoId(appId);
			userApp.setUserId(user.getId());
			count5 += userAppMapper.insertSelective(userApp);
		}
		Boolean successFlag = (count1 == 1) && (count2 == sysRoleUsers.size()) && (count3 == userAppOrigins.size())
				&& (count4 == roleIds.size()) && (count5 == appIds.size());
		return successFlag;
	}

	@Override
	public List<Integer> getAppIdsByUserId(Long id) {
		List<UserApp> userApps = userAppMapper.selectByUserId(id);
		if (userApps.size() > 0) {
			List<Integer> uAppids = new ArrayList<>();
			for (UserApp userApp : userApps) {
				uAppids.add(new Long(userApp.getAppInfoId()).intValue());
			}
			return uAppids;
		}
		return null;
	}

	@Override
	@CacheEvict(value="userCache",allEntries=true)
	public Boolean deleteUser(Integer id) {
		int count1 = 0, count2 = 0, count3 = 0;
		// 1.解除该用户与他的角色绑定
		SYSRole_UserExample example = new SYSRole_UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(Integer.parseInt(id.toString()));
		List<SYSRole_User> sysRoleUsers = sysRole_UserMapper.selectByExample(example);
		for (SYSRole_User sysRole_UserOri : sysRoleUsers) {
			count1 += sysRole_UserMapper.deleteByPrimaryKey(sysRole_UserOri.getId());
		}
		// 2.解除该用户与他的APPINFO绑定
		List<UserApp> userAppOrigins = userAppMapper.selectByUserId(id.longValue());
		for (UserApp userAppOri : userAppOrigins) {
			count2 += userAppMapper.deleteByPrimaryKey(userAppOri.getId());
		}
		// 3.删除该用户
		count3 += userMapper.deleteByPrimaryKey(id.longValue());
		Boolean successFlag = (count3 == 1) && (count1 == sysRoleUsers.size()) && (count2 == userAppOrigins.size());
		return successFlag;
	}

}
