package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.AgeDistribution;
import com.anrong.wulan.core.generic.GenericService;

public interface AgeDistributionService extends GenericService<AgeDistribution, Long> {
	
	List<AgeDistribution> queryByParams(Map<String, Object> params);
}
