package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.DayNewUserRetentionMapper;
import com.anrong.wulan.admin.po.DayNewUserRetention;
import com.anrong.wulan.admin.service.DayNewUserRetentionService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;
@Service
public class DayNewUserRetentionServiceImpl extends
	GenericServiceImpl<DayNewUserRetention, Object> implements
		DayNewUserRetentionService {
	@Resource
	private DayNewUserRetentionMapper dayNewUserRetentionMapper;
	@Override
	public Page<DayNewUserRetention> queryUserRetention(Integer p,
			Map<String, Object> params) {
		int pageSize = dayNewUserRetentionMapper.queryRetentionCount(params).size();
		Page<DayNewUserRetention> page = new Page<DayNewUserRetention>(p, 10, pageSize);
		params.put("size",10);
		params.put("start",page.getStart());
		List<DayNewUserRetention> list = dayNewUserRetentionMapper.queryRetention(params);
		page.setItems(list);
		return page;
	}

	@Override
	public GenericDao<DayNewUserRetention, Object> getDao() {
		return null;
	}

}
