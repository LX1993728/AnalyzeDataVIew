package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;
import com.anrong.wulan.admin.po.ActiveUserVendorDay;
import com.anrong.wulan.core.generic.GenericDao;

public interface ActiveUserVendorDayMapper extends GenericDao<ActiveUserVendorDay, Long> {
	List<ActiveUserVendorDay> queryActiveUserTotal(Map<String,Object> map);
}
