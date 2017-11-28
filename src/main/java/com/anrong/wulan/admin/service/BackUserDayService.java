package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.BackUserDay;
import com.anrong.wulan.core.generic.GenericService;

public interface BackUserDayService extends GenericService<BackUserDay, Long> {

	List<BackUserDay> selectBack(Map<String, Object> params);

}
