package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.TotalUserHour;
import com.anrong.wulan.core.generic.GenericDao;

public interface TotalUserHourMapper extends GenericDao<TotalUserHour, Long> {

    TotalUserHour queryTotalUserHour(Map<String, Object> map);

    TotalUserHour queryAppTotalUserCount(Map<String, Object> map);

    List<TotalUserHour> selectRecordMonth(Map<String, Object> params);
    
    List<TotalUserHour> queryTotalUser(Map<String,Object> map);
}
