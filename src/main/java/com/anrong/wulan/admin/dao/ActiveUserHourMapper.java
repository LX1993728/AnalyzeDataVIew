package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.ActiveUserHour;
import com.anrong.wulan.core.generic.GenericDao;

public interface ActiveUserHourMapper extends GenericDao<ActiveUserHour,Long>{
	//	时段分析今天活跃用户
    List<ActiveUserHour> queryActUserTimeToday(Map<String, Object> params);
    //	时段分析昨天活跃用户
    List<ActiveUserHour> queryActUserTimeYestaday(Map<String, Object> params);
    //昨日此时端活跃用户总数
    ActiveUserHour queryActiveTotalBySign(Map<String, Object> params);
}
