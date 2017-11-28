package com.anrong.wulan.admin.dao;

import java.util.Map;

import com.anrong.wulan.admin.po.UserCountsLost;
import com.anrong.wulan.core.generic.GenericDao;

public interface UserCountsLostMapper extends GenericDao<UserCountsLost, Long> {

	UserCountsLost selectCounts(Map<String, Object> params);

}
