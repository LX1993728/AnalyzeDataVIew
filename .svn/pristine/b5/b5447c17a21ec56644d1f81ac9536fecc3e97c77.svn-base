package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.ActiveUserOsMapper;
import com.anrong.wulan.admin.po.ActiveUserOs;
import com.anrong.wulan.admin.service.ActiveUserOsService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class ActiveUserOsServiceImpl extends
		GenericServiceImpl<ActiveUserOs, Long> implements ActiveUserOsService {

	@Resource
	private ActiveUserOsMapper activeUserOsMapper;

	@Override
	public GenericDao<ActiveUserOs, Long> getDao() {
		return activeUserOsMapper;
	}

	@Override
	public List<ActiveUserOs> queryActiveUserTotal(Map<String, Object> params) {
		return activeUserOsMapper.queryActiveUserTotal(params);
	}

}
