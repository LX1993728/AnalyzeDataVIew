package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.AgeDistributionMapper;
import com.anrong.wulan.admin.po.AgeDistribution;
import com.anrong.wulan.admin.service.AgeDistributionService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class AgeDistributionServiceImpl extends GenericServiceImpl<AgeDistribution, Long> implements AgeDistributionService {

	@Resource
	private AgeDistributionMapper ageDistributionMapper;
	
	@Override
	public GenericDao<AgeDistribution, Long> getDao() {
		return ageDistributionMapper;
	}
	
	//查询所有数据
	public List<AgeDistribution> queryByParams(Map<String, Object> params) {
		
		return ageDistributionMapper.queryByParams(params);
	}

}
