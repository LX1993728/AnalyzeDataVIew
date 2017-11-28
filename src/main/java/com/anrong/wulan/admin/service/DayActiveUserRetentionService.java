package com.anrong.wulan.admin.service;

import java.util.Map;

import com.anrong.wulan.admin.po.DayActiveUserRetention;
import com.anrong.wulan.core.generic.GenericService;
import com.anrong.wulan.core.util.Page;

public interface DayActiveUserRetentionService extends GenericService<DayActiveUserRetention, Object> {
	Page<DayActiveUserRetention> queryUserRetention(Integer p,Map<String, Object> params);
}
