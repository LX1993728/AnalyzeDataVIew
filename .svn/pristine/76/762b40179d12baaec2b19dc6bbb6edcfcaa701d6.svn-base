package com.anrong.wulan.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.UserAppMapper;
import com.anrong.wulan.admin.po.UserApp;
import com.anrong.wulan.admin.service.UserAppService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class UserAppServiceImpl extends GenericServiceImpl<UserApp, Long>
		implements UserAppService {

	@Resource
	private UserAppMapper userAppMapper;

	@Override
	public List<UserApp> selectByUserId(Long userId) {
		return userAppMapper.selectByUserId(userId);
	}

	@Override
	public GenericDao<UserApp, Long> getDao() {
		return userAppMapper;
	}

}
