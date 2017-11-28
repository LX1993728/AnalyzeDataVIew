package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.WeekNewUserRetention;
import com.anrong.wulan.core.generic.GenericDao;

public interface WeekNewUserRetentionMapper extends
		GenericDao<WeekNewUserRetention, Object> {

	List<WeekNewUserRetention> queryRetentionCount(Map<String, Object> params);

	List<WeekNewUserRetention> queryRetention(Map<String, Object> params);
}
