package com.anrong.wulan.admin.service;
/**
 * 系统用户的管理——业务层
 * @author liuxun
 *
 */


import java.util.List;

import com.anrong.wulan.admin.po.User;
import com.anrong.wulan.admin.vo.SYSUserVO;
import com.anrong.wulan.core.util.Page;

public interface SYSUserService {
	// 根据条件查询用户列表
	public Page<User> getUsersByCriteria(SYSUserVO sysUserVO);
	
	// 根据用户名查询用户
	public Long  getCountByUserName(SYSUserVO sysUserVO);

	// 为系统添加用户（管理员）
	public Boolean addUser(SYSUserVO sysUserVO);

	// 根据用户ID查询所具有的角色id
	public List<Integer> getRoleIdsByUserId(Long id);
	
	// 根据用户ID查询所具有的角色id
	public List<Integer> getAppIdsByUserId(Long id);
	
	//根据用户ID查询用户基本信息
	public User getUserByUserId(Long id);

	// 修改用户信息
	public Boolean updateUser(SYSUserVO sysUserVO);

	// 删除用户(不仅仅是简单的删除)
	public Boolean deleteUser(Integer id);
	
}
