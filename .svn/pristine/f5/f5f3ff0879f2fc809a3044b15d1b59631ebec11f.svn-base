package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.WeekNewUserRetentionMapper;
import com.anrong.wulan.admin.po.WeekNewUserRetention;
import com.anrong.wulan.admin.service.WeekNewUserRetentionService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;
@Service
public class WeekNewUserRetentionServiceImpl extends
GenericServiceImpl<WeekNewUserRetention, Object> implements WeekNewUserRetentionService {
	@Resource
	private WeekNewUserRetentionMapper weekNewUserRetentionMapper;

	@Override
	public Page<WeekNewUserRetention> queryUserRetention(Integer p,
			Map<String, Object> params) {
		int count = weekNewUserRetentionMapper.queryRetentionCount(params).size();
		Page<WeekNewUserRetention> page = new Page<WeekNewUserRetention>(p, 10, count);
		params.put("size", 10);
		params.put("start", page.getStart());
		List<WeekNewUserRetention> list = weekNewUserRetentionMapper.queryRetention(params);
		page.setItems(list);
		return page;
	}

	@Override
	public GenericDao<WeekNewUserRetention, Object> getDao() {
		return null;
	}


}
