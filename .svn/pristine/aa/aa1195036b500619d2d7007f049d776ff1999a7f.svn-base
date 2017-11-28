package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.MonthActiveUserRetentionMapper;
import com.anrong.wulan.admin.po.MonthActiveUserRetention;
import com.anrong.wulan.admin.service.MonthActiveUserRetentionService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;
@Service
public class MonthActiveUserRetentionServiceImpl extends
GenericServiceImpl<MonthActiveUserRetention, Object> implements MonthActiveUserRetentionService {

	@Resource
	private MonthActiveUserRetentionMapper monthActiveUserRetentionMapper;
	@Override
	public Page<MonthActiveUserRetention> queryUserRetention(Integer p,
			Map<String, Object> params) {
		int pageSize = monthActiveUserRetentionMapper.queryRetentionCount(params).size();
		Page<MonthActiveUserRetention> page = new Page<MonthActiveUserRetention>(p, 10, pageSize);
		params.put("size",10);
		params.put("start",page.getStart());
		List<MonthActiveUserRetention> list = monthActiveUserRetentionMapper.queryRetention(params);
		page.setItems(list);
		return page;
	}

	@Override
	public GenericDao<MonthActiveUserRetention, Object> getDao() {
		return null;
	}

	@Override
	public List<MonthActiveUserRetention> queryUserRetentionIndex(
			Map<String, Object> params) {
		return monthActiveUserRetentionMapper.queryRetentionIndex(params);
	}


}
