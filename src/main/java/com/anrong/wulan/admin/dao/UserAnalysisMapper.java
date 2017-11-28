package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.UserAnalysis;
import com.anrong.wulan.core.generic.GenericDao;

public interface UserAnalysisMapper extends GenericDao<UserAnalysis, Long> {

	List<UserAnalysis> queryUserAnalysisByParams(Map<String, Object> params);

}
