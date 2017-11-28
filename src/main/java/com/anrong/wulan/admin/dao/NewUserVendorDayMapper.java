package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.NewUserVendorDay;
import com.anrong.wulan.core.generic.GenericDao;

public interface NewUserVendorDayMapper extends GenericDao<NewUserVendorDay, Long> {
	
	List<NewUserVendorDay> queryNewUser(Map<String,Object> map);
	
	List<NewUserVendorDay> queryNewUserProportion(Map<String,Object> map);
	
	NewUserVendorDay queryHotVendor(Map<String,Object> map);
	
	NewUserVendorDay queryFastVendor(Map<String,Object> map);
	//取设备前五个	
	List<NewUserVendorDay> getModelData();
}
