package com.anrong.wulan.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.AppInfoMapper;
import com.anrong.wulan.admin.po.AppInfo;
import com.anrong.wulan.admin.service.AppInfoService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class AppInfoServiceImpl extends GenericServiceImpl<AppInfo, Long>
		implements AppInfoService {

	@Resource
	private AppInfoMapper appInfoMapper;

	@Override
	public List<AppInfo> getAllApp() {
		return appInfoMapper.getAllApp();
	}

	@Override
	public GenericDao<AppInfo, Long> getDao() {
		return appInfoMapper;
	}

	@Override
	public List<AppInfo> selectByAppId(long userId) {
		return appInfoMapper.selectByAppId(userId);
	}

	@Override
	public AppInfo queryByAppName(String appName) {
		return appInfoMapper.queryByAppName(appName);
	}

}
