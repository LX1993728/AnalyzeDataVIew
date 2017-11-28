package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.anrong.wulan.admin.dao.ActiveUserRegionDayMapper;
import com.anrong.wulan.admin.dao.ActiveUserVendorDayMapper;
import com.anrong.wulan.admin.dao.NewUserVendorDayMapper;
import com.anrong.wulan.admin.dao.StartRegionDayMapper;
import com.anrong.wulan.admin.dao.StartVendorDayMapper;
import com.anrong.wulan.admin.po.ActiveUserRegionDay;
import com.anrong.wulan.admin.po.ActiveUserVendorDay;
import com.anrong.wulan.admin.po.NewUserVendorDay;
import com.anrong.wulan.admin.po.StartRegionDay;
import com.anrong.wulan.admin.po.StartVendorDay;
import com.anrong.wulan.admin.service.ActiveUserRegionDayService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
@Service
public class ActiveUserRegionDayServiceImpl extends GenericServiceImpl<ActiveUserRegionDay, Long> implements ActiveUserRegionDayService {
	@Resource
	private ActiveUserRegionDayMapper activeUserRegionDayService;
	
	@Resource
	private StartRegionDayMapper startRegionDayMapper;
	
	@Resource
	private NewUserVendorDayMapper newUserVendorDayMapper;
	
	@Resource
	private StartVendorDayMapper startVendorDayMapper;
	
	@Resource
	private ActiveUserVendorDayMapper activeUserVendorDayMapper;
	
	@Override
	public List<ActiveUserRegionDay> queryActtiveUserByRegion(Map<String, Object> map) {
		return activeUserRegionDayService.queryActtiveUserByRegion(map);
	}

	@Override
	public GenericDao<ActiveUserRegionDay, Long> getDao() {
		return null;
	}

	@Override
	public List<StartRegionDay> queryStartTimeTotal(Map<String, Object> map) {
		return startRegionDayMapper.queryStartTimeTotal(map);
	}

	@Override
	public List<NewUserVendorDay> queryNewUser(Map<String, Object> map) {
		return newUserVendorDayMapper.queryNewUser(map);
	}

	@Override
	public List<NewUserVendorDay> queryNewUserProportion(Map<String, Object> map) {
		return newUserVendorDayMapper.queryNewUserProportion(map);
	}

	@Override
	public List<StartVendorDay> queryStartTime(Map<String, Object> map) {
		return startVendorDayMapper.queryStartTime(map);
	}

	@Override
	public List<ActiveUserVendorDay> queryActiveUserTotal(
			Map<String, Object> map) {
		return activeUserVendorDayMapper.queryActiveUserTotal(map);
	}

	@Override
	public NewUserVendorDay queryHotVendor(Map<String, Object> map) {
		return newUserVendorDayMapper.queryHotVendor(map);
	}

	@Override
	public NewUserVendorDay queryFastVendor(Map<String, Object> map) {
		return newUserVendorDayMapper.queryFastVendor(map);
	}
}
