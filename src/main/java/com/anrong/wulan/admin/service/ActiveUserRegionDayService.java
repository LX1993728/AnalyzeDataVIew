package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;
import com.anrong.wulan.admin.po.ActiveUserRegionDay;
import com.anrong.wulan.admin.po.ActiveUserVendorDay;
import com.anrong.wulan.admin.po.NewUserVendorDay;
import com.anrong.wulan.admin.po.StartRegionDay;
import com.anrong.wulan.admin.po.StartVendorDay;
import com.anrong.wulan.core.generic.GenericService;

public interface ActiveUserRegionDayService extends
		GenericService<ActiveUserRegionDay, Long> {

	List<ActiveUserRegionDay> queryActtiveUserByRegion(Map<String, Object> map);

	List<StartRegionDay> queryStartTimeTotal(Map<String, Object> map);

	List<NewUserVendorDay> queryNewUser(Map<String, Object> map);

	List<NewUserVendorDay> queryNewUserProportion(Map<String, Object> map);

	NewUserVendorDay queryHotVendor(Map<String, Object> map);

	List<StartVendorDay> queryStartTime(Map<String, Object> map);

	List<ActiveUserVendorDay> queryActiveUserTotal(Map<String, Object> map);

	NewUserVendorDay queryFastVendor(Map<String, Object> map);
}
