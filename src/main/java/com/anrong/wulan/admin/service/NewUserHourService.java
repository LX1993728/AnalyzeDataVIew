package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.NewUserHour;
import com.anrong.wulan.core.generic.GenericService;

public interface NewUserHourService extends GenericService<NewUserHour, Long> {

	/**
	 * 新增用户数按天查询
	 * 
	 * @param map
	 * @return
	 */
	List<NewUserHour> queryNewUserCountDay(Map<String, Object> map);

	/**
	 * 新增用户echarts表数据
	 * 
	 * @param params
	 * @return
	 */
	List<NewUserHour> queryUserCount(Map<String, Object> params);

	/**
	 * 时段分析今天新增用户
	 * 
	 * @param map
	 * @return
	 */
	List<NewUserHour> queryNewUserTimeToday(Map<String, Object> map);

	/**
	 * 时段分析昨天新增用户
	 * 
	 * @param map
	 * @return
	 */
	List<NewUserHour> queryNewUserTimeYestaday(Map<String, Object> map);

}
