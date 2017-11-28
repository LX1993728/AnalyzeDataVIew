package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;
import com.anrong.wulan.admin.po.WeekActiveUserRetention;
import com.anrong.wulan.core.generic.GenericDao;

public interface WeekActiveUserRetentionMapper extends GenericDao<WeekActiveUserRetention, Object> {
	List<WeekActiveUserRetention> queryRetentionCount(Map<String, Object> params);
	List<WeekActiveUserRetention> queryRetention(Map<String, Object> params);
}
