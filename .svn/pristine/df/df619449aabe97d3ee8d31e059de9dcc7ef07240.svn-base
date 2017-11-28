package com.anrong.wulan.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.UserRoleMapper;
import com.anrong.wulan.admin.po.UserRole;
import com.anrong.wulan.admin.service.UserRoleService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class UserRoleServiceImpl extends GenericServiceImpl<UserRole, Long>	implements UserRoleService {
 
	@Resource
	private UserRoleMapper userRoleMapper;

	@Override
	public int countBySelective(UserRole userRole) {
		return userRoleMapper.countBySelective(userRole);
	}

	@Override
	public GenericDao<UserRole, Long> getDao() {
		return userRoleMapper;
	}

}
