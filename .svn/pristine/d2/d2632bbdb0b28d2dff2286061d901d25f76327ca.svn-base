package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;
import com.anrong.wulan.admin.po.DurationHour;
import com.anrong.wulan.core.generic.GenericDao;

public interface DurationHourMapper extends GenericDao<DurationHour,Long>{
    
	DurationHour queryDurationHour(Map<String,Object> map);
    
    List<DurationHour> queryAvgSingleUseTime(Map<String,Object> map);

    List<DurationHour> selectRecordMonth(Map<String, Object> params);

    List<DurationHour> queryAvgDayUseTime(Map<String, Object> params);
	
	List<DurationHour> queryDurationHourCount(Map<String, Object> params);
}
