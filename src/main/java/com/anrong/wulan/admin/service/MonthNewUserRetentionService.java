package com.anrong.wulan.admin.service;

import java.util.Map;

import com.anrong.wulan.admin.po.MonthNewUserRetention;
import com.anrong.wulan.core.generic.GenericService;
import com.anrong.wulan.core.util.Page;

public interface MonthNewUserRetentionService extends GenericService<MonthNewUserRetention, Object> {
	Page<MonthNewUserRetention> queryUserRetention(Integer p,Map<String, Object> params);
}
