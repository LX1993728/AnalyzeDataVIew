package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.DayNewUserRetention;
import com.anrong.wulan.core.generic.GenericDao;

public interface DayNewUserRetentionMapper extends GenericDao<DayNewUserRetention, Object> {
	List<DayNewUserRetention> queryRetentionCount(Map<String, Object> params);
	List<DayNewUserRetention> queryRetention(Map<String, Object> params);
}
