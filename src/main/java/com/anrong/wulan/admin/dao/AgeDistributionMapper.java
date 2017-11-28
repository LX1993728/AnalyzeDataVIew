package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.AgeDistribution;
import com.anrong.wulan.core.generic.GenericDao;

public interface AgeDistributionMapper extends GenericDao<AgeDistribution, Long> {
	
	List<AgeDistribution> queryByParams(Map<String, Object> params);

}
