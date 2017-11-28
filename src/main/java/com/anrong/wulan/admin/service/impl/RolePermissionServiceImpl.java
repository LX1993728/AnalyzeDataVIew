package com.anrong.wulan.admin.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.RolePermissionMapper;
import com.anrong.wulan.admin.po.RolePermission;
import com.anrong.wulan.admin.service.RolePermissionService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

/**
 * 角色权限关联service实现类
 * @author Joshua
 *
 */
@Service
public class RolePermissionServiceImpl extends GenericServiceImpl<RolePermission, Long>	implements RolePermissionService {
	@Resource
	private RolePermissionMapper rolePermissionMapper;
	
	@Override
	public int countBySelective(RolePermission rolePermission) {
		return rolePermissionMapper.countBySelective(rolePermission);
	}

	@Override
	public GenericDao<RolePermission, Long> getDao() {
		return rolePermissionMapper;
	}
 

}
