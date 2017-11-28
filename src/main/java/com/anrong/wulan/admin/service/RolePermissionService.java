package com.anrong.wulan.admin.service;


import com.anrong.wulan.admin.po.RolePermission;
import com.anrong.wulan.core.generic.GenericService;

/**
 * 角色权限关联
 * @author Joshua
 *
 */
public interface RolePermissionService  extends GenericService<RolePermission, Long> {

	/**
	 * 角色权限关联次数
	 * @param rolePermission
	 * @return
	 */
	int countBySelective(RolePermission rolePermission);
}
