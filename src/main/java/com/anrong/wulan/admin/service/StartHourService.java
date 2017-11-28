package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.StartHour;
import com.anrong.wulan.core.generic.GenericService;

public interface StartHourService extends GenericService<StartHour, Long>{
    
    List<StartHour> selectRecord(Map<String, Object> params);

    List<StartHour> selectRecordMonth(Map<String, Object> params);

    List<StartHour> queryTop10Start(Map<String, Object> params);

	StartHour queryStartHour(Map<String, Object> params);

}
