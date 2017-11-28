package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.NewUserHourMapper;
import com.anrong.wulan.admin.po.NewUserHour;
import com.anrong.wulan.admin.service.NewUserHourService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class NewUserHourServiceImpl extends
		GenericServiceImpl<NewUserHour, Long> implements NewUserHourService {

	@Resource
	private NewUserHourMapper newUserHourMapper;

	@Override
	public GenericDao<NewUserHour, Long> getDao() {
		return newUserHourMapper;
	}

	@Override
	public List<NewUserHour> queryNewUserCountDay(Map<String, Object> map) {
		return newUserHourMapper.queryNewUserCountDay(map);
	}

	@Override
	public List<NewUserHour> queryUserCount(Map<String, Object> params) {
		return newUserHourMapper.queryUserCount(params);
	}

	@Override
	public List<NewUserHour> queryNewUserTimeToday(Map<String, Object> params) {
		return newUserHourMapper.queryNewUserTimeToday(params);
	}

	@Override
	public List<NewUserHour> queryNewUserTimeYestaday(Map<String, Object> params) {
		return newUserHourMapper.queryNewUserTimeYestaday(params);
	}

}
