package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;
import com.anrong.wulan.admin.po.NewUserRegionDay;
import com.anrong.wulan.core.generic.GenericDao;

public interface NewUserRegionDayMapper extends GenericDao<NewUserRegionDay, Long> {
	
	List<NewUserRegionDay> queryNewUserByRegion(Map<String,Object> map);
	
	List<NewUserRegionDay> queryUserProportion(Map<String,Object> map);
	
	List<NewUserRegionDay> queryTopNewUserPer(Map<String,Object> map);
	
	NewUserRegionDay getProvinceCount(Map<String,Object> map);

	List<NewUserRegionDay> areaUserRegionChart(Map<String, Object> params);
}
