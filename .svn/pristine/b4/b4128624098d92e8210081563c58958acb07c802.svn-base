package com.anrong.wulan.admin.service.impl;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.UserTimesLostMapper;
import com.anrong.wulan.admin.po.UserTimesLost;
import com.anrong.wulan.admin.service.UserTimesLostService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class UserTimesLostServiceImpl extends GenericServiceImpl<UserTimesLost, Long> implements UserTimesLostService {
	@Resource
	private UserTimesLostMapper userTimesLostMapper;

	@Override
	public GenericDao<UserTimesLost, Long> getDao() {
		return userTimesLostMapper;
	}

	@Override
	public UserTimesLost selectTimes(Map<String, Object> params) {
		return userTimesLostMapper.selectTimes(params);
	}

}
