package com.anrong.wulan.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.ActiveUserHourMapper;
import com.anrong.wulan.admin.dao.AppGeneralizeMapper;
import com.anrong.wulan.admin.dao.NewUserHourMapper;
import com.anrong.wulan.admin.dao.NewUserRegionMapper;
import com.anrong.wulan.admin.po.ActiveUserHour;
import com.anrong.wulan.admin.po.ActiveUserRegionDay;
import com.anrong.wulan.admin.po.NewUserHour;
import com.anrong.wulan.admin.po.NewUserRegion;
import com.anrong.wulan.admin.service.AppGeneralizeService;
import com.anrong.wulan.admin.vo.AppGeneralizeVO;

@Service
public class AppGeneralizeServiceImpl implements AppGeneralizeService {

	@Resource
	private AppGeneralizeMapper appGeneralizeMapper;

	@Resource
	private NewUserRegionMapper newUserRegionMapper;
	
	@Resource
	private NewUserHourMapper newUserHourMapper;
	
	@Resource
	private ActiveUserHourMapper activeUserHourMapper;
	@Override
	public AppGeneralizeVO appGeneralize(Map<String, Object> params) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE, -1);
		AppGeneralizeVO generalizeVO = new AppGeneralizeVO();
		//新增活跃今天和昨天的用户总数
		//今天的
		params.put("date", dateFormat.format(calendar.getTime()));
		NewUserRegion newUserRegion = newUserRegionMapper.getNewUser(params);
		if(newUserRegion != null){
			generalizeVO.setTodayNewSum(newUserRegion.getNewUserTotal());
		}
		ActiveUserRegionDay activeUserRegionDaya = appGeneralizeMapper.getActiveUserSum(params);
		if(activeUserRegionDaya != null){
			generalizeVO.setTodayActiveSum(activeUserRegionDaya.getActtiveUserTotal());
		}
		//昨日此时
		calendar.add(Calendar.DATE, -1);
		int i = calendar.get(Calendar.HOUR_OF_DAY);
		params.put("sign", i);
		params.put("date",dateFormat.format(calendar.getTime()));
		NewUserHour newUserHour = newUserHourMapper.queryNewUserBySign(params);
		if(newUserHour != null){
			generalizeVO.setYesterdayMomentNewSum(newUserHour.getNewUser());
		}
		ActiveUserHour activeUserHour = activeUserHourMapper.queryActiveTotalBySign(params);
		if(activeUserHour != null){
			generalizeVO.setYesterdayMomentActiveSum(activeUserHour.getActiveUser());
		}
		//昨天的
		NewUserRegion newUserRegion2 = newUserRegionMapper.getNewUser(params);
		if(newUserRegion2 != null){
			generalizeVO.setYesterdayNewSum(newUserRegion2.getNewUserTotal());
		}
		ActiveUserRegionDay activeUserRegionDay2 = appGeneralizeMapper.getActiveUserSum(params);
		if(activeUserRegionDay2 != null){
			generalizeVO.setYesterdayActiveSum(activeUserRegionDay2.getActtiveUserTotal());
		}
		//应用概括
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -1);
		params.put("date", dateFormat.format(calendar.getTime()));
		ActiveUserRegionDay activeUserRegionDay = appGeneralizeMapper.appGeneralize(params);
		if(activeUserRegionDay != null){
			generalizeVO.setSevenActive(activeUserRegionDay.getSevenActiveTotal());
			generalizeVO.setThirtyActive(activeUserRegionDay.getThirtyActiveTotal());
			//计算上下浮动
			
			calendar.add(Calendar.DATE, -1);
			params.put("date", dateFormat.format(calendar.getTime()));
			ActiveUserRegionDay activeUserRegion = appGeneralizeMapper.appGeneralize(params);
			if(activeUserRegion != null){
				//七天浮动
				int sevenActiveTotal1 = activeUserRegionDay.getSevenActiveTotal();
				int sevenActiveTotal2 = activeUserRegion.getSevenActiveTotal();
				double sevenFloat = sevenActiveTotal1 - sevenActiveTotal2;
				double seven = (sevenFloat / sevenActiveTotal1) * 100;
				generalizeVO.setSevenActiveFloat(Double.parseDouble(String.format("%.2f", seven)));
				//30天浮动
				int thirtyActiveTotal1 = activeUserRegionDay.getThirtyActiveTotal();
				int thirtyActiveTotal2 = activeUserRegion.getThirtyActiveTotal();
				double thirtyFloat = thirtyActiveTotal1 - thirtyActiveTotal2;
				double thirty = (thirtyFloat / thirtyActiveTotal1) * 100;
				generalizeVO.setThirtyActiveFloat(Double.parseDouble(String.format("%.2f", thirty)));
			}
		}
		return generalizeVO;
	}
	
}
