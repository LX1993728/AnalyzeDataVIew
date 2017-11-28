package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.NewUserHour;
import com.anrong.wulan.core.generic.GenericDao;

public interface NewUserHourMapper extends GenericDao<NewUserHour, Long> {

	List<NewUserHour> queryNewUserCountDay(Map<String, Object> map);

	List<NewUserHour> queryUserCount(Map<String, Object> params);

	List<NewUserHour> queryNewUserTimeToday(Map<String, Object> params);

	List<NewUserHour> queryNewUserTimeYestaday(Map<String, Object> params);
	
	NewUserHour queryNewUserBySign(Map<String, Object> params);
}
