package com.anrong.wulan.admin.service;

import java.util.List;

import com.anrong.wulan.admin.po.SYSPermission;
import com.anrong.wulan.admin.po.SYSRole;
import com.anrong.wulan.admin.vo.SYSRoleVO;
import com.anrong.wulan.core.util.Page;

public interface SYSRoleService {
   // 获取角色列表
	public List<SYSRole> findAllRoles();

	// 按指定条件对角色分页查询
	public Page<SYSRole> getRolesByCriteria(SYSRoleVO sysRoleVO);

	// 获取指定角色下的权限资源
	public List<SYSPermission> getPermissionsOfRole(Integer id);

	// 添加角色
	public Boolean addRole(SYSRoleVO sysRoleVO);

	// 根据主键获取角色
	public SYSRole getRolesByPrimaryId(Integer id);

	// 添加角色
	public Boolean updateRole(SYSRoleVO sysRoleVO);

	// 删除角色
	public Boolean deleteRole(Integer id);

	// 判断该角色是否被用户关联
	public Boolean isBindUsers(Integer id);

	
}
