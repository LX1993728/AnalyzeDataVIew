package com.anrong.wulan.admin.service.impl;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.UserDaysLostMapper;
import com.anrong.wulan.admin.po.UserDaysLost;
import com.anrong.wulan.admin.service.UserDaysLostService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class UserDaysLostServiceImpl extends GenericServiceImpl<UserDaysLost, Long> implements UserDaysLostService {
	@Resource
	private UserDaysLostMapper userDaysLostMapper;

	@Override
	public GenericDao<UserDaysLost, Long> getDao() {
		return userDaysLostMapper;
	}

	@Override
	public UserDaysLost selectDay(Map<String, Object> params) {
		return userDaysLostMapper.selectDay(params);
	}

}
