package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.anrong.wulan.admin.dao.NewUserRegionDayMapper;
import com.anrong.wulan.admin.po.NewUserRegionDay;
import com.anrong.wulan.admin.service.NewUserRegionDayService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class NewUserRegionDayServiceImpl extends
		GenericServiceImpl<NewUserRegionDay, Long> implements
		NewUserRegionDayService {

	@Resource
	private NewUserRegionDayMapper newUserRegionDayMapper;

	@Override
	public List<NewUserRegionDay> queryNewUserByRegion(Map<String, Object> map) {
		return newUserRegionDayMapper.queryNewUserByRegion(map);
	}

	@Override
	public GenericDao<NewUserRegionDay, Long> getDao() {
		return null;
	}

	@Override
	public List<NewUserRegionDay> queryUserProportion(Map<String, Object> map) {
		return newUserRegionDayMapper.queryUserProportion(map);
	}

	@Override
	public List<NewUserRegionDay> queryTopNewUserPer(Map<String, Object> map) {
		return newUserRegionDayMapper.queryTopNewUserPer(map);
	}

	@Override
	public NewUserRegionDay getProvinceCount(Map<String, Object> map) {
		return newUserRegionDayMapper.getProvinceCount(map);
	}

	
	/*用户分布*/
	@Override
	public List<NewUserRegionDay> areaUserRegionChart(Map<String, Object> params) {
		return newUserRegionDayMapper.areaUserRegionChart(params);
	}

}
