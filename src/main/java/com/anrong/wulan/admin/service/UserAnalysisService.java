package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.UserAnalysis;
import com.anrong.wulan.core.generic.GenericService;

public interface UserAnalysisService extends GenericService<UserAnalysis, Long> {

	List<UserAnalysis> queryUserAnalysisByParams(Map<String, Object> params);

}
