package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.DurationHour;
import com.anrong.wulan.core.generic.GenericService;
import com.anrong.wulan.core.util.Page;

public interface DurationHourService extends GenericService<DurationHour, Long> {

	List<DurationHour> selectRecordMonth(Map<String, Object> params);

	List<DurationHour> queryAvgSingleUseTime(Map<String, Object> map);

	DurationHour queryDurationHour(Map<String, Object> params);

//	DurationHour queryAvgDayUseTime(Map<String, Object> params);
	
	Page<DurationHour> queryDurationHourCount(Integer p,Map<String, Object> params);
}