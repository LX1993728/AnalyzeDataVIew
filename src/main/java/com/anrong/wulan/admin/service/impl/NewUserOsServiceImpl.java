package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.NewUserOsMapper;
import com.anrong.wulan.admin.po.NewUserOs;
import com.anrong.wulan.admin.service.NewUserOsService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class NewUserOsServiceImpl extends GenericServiceImpl<NewUserOs, Long>
		implements NewUserOsService {

	@Resource
	private NewUserOsMapper newUserOsMapper;

	@Override
	public GenericDao<NewUserOs, Long> getDao() {
		return newUserOsMapper;
	}

	@Override
	public List<NewUserOs> queryAllVersionOs(Map<String, Object> params) {
		return newUserOsMapper.queryAllVersionOs(params);
	}

	@Override
	public List<NewUserOs> queryNewUserTotal(Map<String, Object> params) {
		return newUserOsMapper.queryNewUserTotal(params);
	}

}
