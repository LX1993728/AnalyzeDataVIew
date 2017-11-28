package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.User;
import com.anrong.wulan.core.generic.GenericService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;


/**
 * 用户 业务 接口
 * 
 **/
public interface UserService extends GenericService<User, Long> {

    /**
     * 用户验证
     * 
     * @param user
     * @return
     */
    User authentication(User user);

    /**
     * 根据用户名查询用户
     * 
     * @param username
     * @return
     */
    User selectByUsername(String username);
    
    /**
     * 分页查询
     * @param params
     * @param page
     * @return
     */
    @SuppressWarnings("rawtypes")
	List selectPage(Map<String,Object> params,PageBounds page);
    
    /**
     * 插入用户
     * @param user
     * @param roleIds
     * @return
     */
    boolean insert(User user,List<Long> roleIds);
    
    /**
     * 更新用户
     * @param user
     * @param roleIds
     * @return
     */
    boolean update(User user,List<Long> roleIds);
}
