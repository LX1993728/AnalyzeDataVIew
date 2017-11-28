package com.anrong.wulan.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.PermissionMenuMapper;
import com.anrong.wulan.admin.po.PermissionMenu;
import com.anrong.wulan.admin.service.PermissionMenuService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class PermissionMenuServiceImpl extends
		GenericServiceImpl<PermissionMenu, Long> implements
		PermissionMenuService {

	@Resource
	private PermissionMenuMapper permissionMenuMapper;
	@Override
	public GenericDao<PermissionMenu, Long> getDao() {
		return permissionMenuMapper;
	}
	@Override
	public int countBySelection(PermissionMenu permissionMenu) {
		return permissionMenuMapper.countBySelective(permissionMenu);
	}

}
