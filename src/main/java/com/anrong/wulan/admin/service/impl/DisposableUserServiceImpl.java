package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.DisposableUserMapper;
import com.anrong.wulan.admin.po.SingleUser;
import com.anrong.wulan.admin.service.DisposableUserService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class DisposableUserServiceImpl  extends GenericServiceImpl<SingleUser, Long> implements DisposableUserService {

	@Resource 
	private DisposableUserMapper disposableUserMapper;
	
	@Override
	public List<SingleUser> selectSingleusers(Map<String, Object> params) {
		return disposableUserMapper.selectSingleusers(params);
	}

	@Override
	public GenericDao<SingleUser, Long> getDao() {
		return disposableUserMapper;
	}

}
