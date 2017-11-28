package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.DayActiveUserRetention;
import com.anrong.wulan.core.generic.GenericDao;

public interface DayActiveUserRetentionMapper extends GenericDao<DayActiveUserRetention, Object> {
	List<DayActiveUserRetention> queryRetentionCount(Map<String, Object> params);
	List<DayActiveUserRetention> queryRetention(Map<String, Object> params);
}
