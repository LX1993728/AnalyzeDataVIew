package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.WeekActiveUserRetentionMapper;
import com.anrong.wulan.admin.po.WeekActiveUserRetention;
import com.anrong.wulan.admin.service.WeekActiveUserRetentionService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;
@Service
public class WeekActiveUserRetentionServiceImpl extends
GenericServiceImpl<WeekActiveUserRetention, Object> implements WeekActiveUserRetentionService {

	@Resource
	private WeekActiveUserRetentionMapper weekActiveUserRetentionMapper;
	@Override
	public Page<WeekActiveUserRetention> queryUserRetention(Integer p,
			Map<String, Object> params) {
		int count = weekActiveUserRetentionMapper.queryRetentionCount(params).size();
		Page<WeekActiveUserRetention> page = new Page<WeekActiveUserRetention>(p, 10, count);
		params.put("size", 10);
		params.put("start", page.getStart());
		List<WeekActiveUserRetention> list = weekActiveUserRetentionMapper.queryRetention(params);
		page.setItems(list);
		return page;
	}

	@Override
	public GenericDao<WeekActiveUserRetention, Object> getDao() {
		return null;
	}


}
