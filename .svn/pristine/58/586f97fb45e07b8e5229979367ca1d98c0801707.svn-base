package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.DayActiveUserRetentionMapper;
import com.anrong.wulan.admin.po.DayActiveUserRetention;
import com.anrong.wulan.admin.service.DayActiveUserRetentionService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;
@Service
public class DayActiveUserRetentionServiceImpl extends
	GenericServiceImpl<DayActiveUserRetention, Object> implements
		DayActiveUserRetentionService {
	@Resource
	private DayActiveUserRetentionMapper dayActiveUserRetentionMapper;
	@Override
	public Page<DayActiveUserRetention> queryUserRetention(Integer p,
			Map<String, Object> params) {
		int pageSize = dayActiveUserRetentionMapper.queryRetentionCount(params).size();
		Page<DayActiveUserRetention> page = new Page<DayActiveUserRetention>(p, 10, pageSize);
		params.put("size",10);
		params.put("start",page.getStart());
		List<DayActiveUserRetention> list = dayActiveUserRetentionMapper.queryRetention(params);
		page.setItems(list);
		return page;
	}

	@Override
	public GenericDao<DayActiveUserRetention, Object> getDao() {
		return null;
	}

}
