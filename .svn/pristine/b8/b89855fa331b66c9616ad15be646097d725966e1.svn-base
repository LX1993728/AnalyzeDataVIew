package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.MonthNewUserRetentionMapper;
import com.anrong.wulan.admin.po.MonthNewUserRetention;
import com.anrong.wulan.admin.service.MonthNewUserRetentionService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;
@Service
public class MonthNewUserRetentionServiceImpl extends
GenericServiceImpl<MonthNewUserRetention, Object> implements MonthNewUserRetentionService {
	
	@Resource
	private MonthNewUserRetentionMapper monthNewUserRetentionMapper;
	@Override
	public Page<MonthNewUserRetention> queryUserRetention(Integer p,
			Map<String, Object> params) {
		int pageSize = monthNewUserRetentionMapper.queryRetentionCount(params).size();
		Page<MonthNewUserRetention> page = new Page<MonthNewUserRetention>(p, 10, pageSize);
		params.put("size",10);
		params.put("start",page.getStart());
		List<MonthNewUserRetention> list = monthNewUserRetentionMapper.queryRetention(params);
		page.setItems(list);
		return page;
	}

	@Override
	public GenericDao<MonthNewUserRetention, Object> getDao() {
		return null;
	}


}
