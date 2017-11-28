package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.MonthActiveUserRetention;
import com.anrong.wulan.core.generic.GenericService;
import com.anrong.wulan.core.util.Page;

public interface MonthActiveUserRetentionService extends GenericService<MonthActiveUserRetention, Object> {
	Page<MonthActiveUserRetention> queryUserRetention(Integer p,Map<String, Object> params);
	List<MonthActiveUserRetention> queryUserRetentionIndex(Map<String, Object> params);
}
