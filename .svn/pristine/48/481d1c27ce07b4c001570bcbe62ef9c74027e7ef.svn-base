package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.StartHour;
import com.anrong.wulan.core.generic.GenericDao;

public interface StartHourMapper extends GenericDao<StartHour,Long>{
    
    StartHour queryStartCount(Map<String,Object> map);
    
    StartHour queryAppAllStartCount(Map<String,Object> map);
    
    StartHour queryThirtyStartCount(Map<String,Object> map);

    List<StartHour> selectRecord(Map<String, Object> params);

    List<StartHour> selectRecordMonth(Map<String, Object> params);

    List<StartHour> queryTop10Start(Map<String, Object> params);
    
    List<StartHour> queryStartTotalTime(Map<String, Object> map); 
    
    ///启动次数均值
    List<StartHour> queryStarTimeAvg(Map<String, Object> map);
    
    //启动占比
    List<StartHour> queryStartProportion(Map<String,Object> map);
    
    //启动次数按时段分组 
    List<StartHour> queryTotalStartBySign(Map<String,Object> map);
    
    List <StartHour> queryHighTime(Map<String, Object> map);
    
    StartHour queryLowTime(Map<String, Object> map);
    
    StartHour queryHighTimeStartPer(Map<String, Object> map);
    
    StartHour querylowTimeStartPer(Map<String, Object> map);
    
    StartHour queryStartHour(Map<String, Object> params);

}
