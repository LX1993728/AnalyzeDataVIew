package com.anrong.wulan.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.AppPlatformMapper;
import com.anrong.wulan.admin.po.AppPlatform;
import com.anrong.wulan.admin.service.AppPlatformService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class AppPlatformServiceImpl extends
		GenericServiceImpl<AppPlatform, Long> implements AppPlatformService {

	@Resource
	private AppPlatformMapper appPlatformMapper;

	@Override
	public GenericDao<AppPlatform, Long> getDao() {
		return appPlatformMapper;
	}

	@Override
	public List<AppPlatform> getAppPlatform(String appKey) {
		return appPlatformMapper.getAppPlatform(appKey);
	}

}
