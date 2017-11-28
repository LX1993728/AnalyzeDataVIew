package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.MonthNewUserRetention;
import com.anrong.wulan.core.generic.GenericDao;

public interface MonthNewUserRetentionMapper extends
		GenericDao<MonthNewUserRetention, Object> {

	List<MonthNewUserRetention> queryRetentionCount(Map<String, Object> params);

	List<MonthNewUserRetention> queryRetention(Map<String, Object> params);
}
