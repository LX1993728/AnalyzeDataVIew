package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.BackUserDay;
import com.anrong.wulan.core.generic.GenericDao;

public interface BackUserDayMapper extends GenericDao<BackUserDay, Long> {

	List<BackUserDay> selectBack(Map<String, Object> params);

}
