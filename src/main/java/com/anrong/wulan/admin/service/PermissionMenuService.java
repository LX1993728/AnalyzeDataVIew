package com.anrong.wulan.admin.service;

import com.anrong.wulan.admin.po.PermissionMenu;
import com.anrong.wulan.core.generic.GenericService;

public interface PermissionMenuService extends GenericService<PermissionMenu, Long> {

	/**
	 * 查询权限按钮关联次数
	 * @param permissionMenu
	 * @return
	 */
	int countBySelection(PermissionMenu permissionMenu);
}
