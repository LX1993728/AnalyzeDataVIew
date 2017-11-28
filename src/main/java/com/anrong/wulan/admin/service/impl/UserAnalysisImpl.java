package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.UserAnalysisMapper;
import com.anrong.wulan.admin.po.UserAnalysis;
import com.anrong.wulan.admin.service.UserAnalysisService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class UserAnalysisImpl extends GenericServiceImpl<UserAnalysis, Long> implements UserAnalysisService  {

	@Resource
	private UserAnalysisMapper userAnalysisMapper;
	
	@Override
	public GenericDao<UserAnalysis, Long> getDao() {
		return userAnalysisMapper;
	}

	@Override
	public List<UserAnalysis> queryUserAnalysisByParams(Map<String, Object> params) {
		
		return userAnalysisMapper.queryUserAnalysisByParams(params);
	}

}
