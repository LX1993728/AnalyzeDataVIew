package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.StartHour;
import com.anrong.wulan.admin.po.TotalUserHour;
import com.anrong.wulan.admin.vo.AppSummaryVO;
import com.anrong.wulan.core.generic.GenericService;

public interface TotalUserHourService extends GenericService<TotalUserHour, Long> {

    TotalUserHour queryTotalUserCount(Map<String, Object> map);

    AppSummaryVO queryAppTotalUserCount(Map<String, Object> map);

    List<TotalUserHour> selectRecordMonth(Map<String, Object> params);
    
    List<StartHour> queryStartTotalTime(Map<String, Object> map);
    
    List<TotalUserHour> queryTotalUser(Map<String,Object> map);
    ///启动次数均值
    List<StartHour> queryStarTimeAvg(Map<String, Object> map);
    
    //启动占比
    List<StartHour> queryStartProportion(Map<String,Object> map);
    
    //启动次数按时段分组 
    List<StartHour> queryTotalStartBySign(Map<String,Object> map);
    //今日概括
	TotalUserHour queryTotalUserHour(Map<String, Object> params);
		
    //繁忙时段
	List <StartHour> queryHighTime(Map<String,Object> map);
    
    //低谷时段
    StartHour queryLowTime(Map<String,Object> map);
    //繁忙时段启动占比
    StartHour queryHighTimeStartPer(Map<String,Object> map);
    //低谷时段启动占比
    StartHour querylowTimeStartPer(Map<String,Object> map);
}
