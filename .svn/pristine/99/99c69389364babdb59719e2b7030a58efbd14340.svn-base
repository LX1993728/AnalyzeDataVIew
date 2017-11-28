package com.anrong.wulan.admin.service.impl;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.UserCountsLostMapper;
import com.anrong.wulan.admin.po.UserCountsLost;
import com.anrong.wulan.admin.service.UserCountsLostService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class UserCountsLostServiceImpl extends GenericServiceImpl<UserCountsLost, Long>
		implements UserCountsLostService {
	@Resource
	private UserCountsLostMapper userCountsLostMapper;

	@Override
	public GenericDao<UserCountsLost, Long> getDao() {
		return userCountsLostMapper;
	}

	@Override
	public UserCountsLost selectCounts(Map<String, Object> params) {
		return userCountsLostMapper.selectCounts(params);
	}

}
