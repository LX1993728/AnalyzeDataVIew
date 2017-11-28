package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.SingleUserMapper;
import com.anrong.wulan.admin.dao.StartHourMapper;
import com.anrong.wulan.admin.dao.TotalUserHourMapper;
import com.anrong.wulan.admin.po.SingleUser;
import com.anrong.wulan.admin.po.StartHour;
import com.anrong.wulan.admin.po.TotalUserHour;
import com.anrong.wulan.admin.service.TotalUserHourService;
import com.anrong.wulan.admin.vo.AppSummaryVO;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;

@Service
public class TotalUserHourServiceImpl extends
		GenericServiceImpl<TotalUserHour, Long> implements TotalUserHourService {

	@Resource
	private TotalUserHourMapper totalUserHourMapper;
	@Resource
	private StartHourMapper startHourMapper;
	@Resource
	private SingleUserMapper singleUserMapper;

	@Override
	public TotalUserHour queryTotalUserCount(Map<String, Object> map) {
		return totalUserHourMapper.queryTotalUserHour(map);
	}

	@Override
	public AppSummaryVO queryAppTotalUserCount(Map<String, Object> map) {
		TotalUserHour totalUserHour = totalUserHourMapper
				.queryAppTotalUserCount(map);
		if (totalUserHour == null) {
			totalUserHour = new TotalUserHour();
		}
		SingleUser singleUser = singleUserMapper.querySingleUser(map);
		if (singleUser == null) {
			singleUser = new SingleUser();
		}
		StartHour startHour = startHourMapper.queryAppAllStartCount(map);
		if (startHour == null) {
			startHour = new StartHour();
		}
		StartHour startHourThirty = startHourMapper.queryThirtyStartCount(map);
		if (startHourThirty == null) {
			startHourThirty = new StartHour();
		}

		AppSummaryVO appSummaryVO = new AppSummaryVO();
		// 累计用户
		appSummaryVO.setTotalUser(totalUserHour.getTotalUser());
		// 一次性用户
		appSummaryVO.setSingleUser(singleUser.getSingleUser());
		appSummaryVO.setSimple(singleUser.getSample());
		// 启动总次数
		appSummaryVO.setTotalStart(startHour.getTotalStart());
		// 30日启动次数
		appSummaryVO.setThirtyStart(startHourThirty.getThirtyStart());

		return appSummaryVO;
	}

	@Override
	public GenericDao<TotalUserHour, Long> getDao() {
		return totalUserHourMapper;
	}

	@Override
	public List<TotalUserHour> selectRecordMonth(Map<String, Object> params) {
		return totalUserHourMapper.selectRecordMonth(params);
	}

	@Override
	public List<StartHour> queryStartTotalTime(Map<String, Object> map) {
		return startHourMapper.queryStartTotalTime(map);
	}

	@Override
	public List<TotalUserHour> queryTotalUser(Map<String, Object> map) {
		return totalUserHourMapper.queryTotalUser(map);
	}

	@Override
	public List<StartHour> queryStarTimeAvg(Map<String, Object> map) {
		return startHourMapper.queryStarTimeAvg(map);
	}

	@Override
	public List<StartHour> queryStartProportion(Map<String, Object> map) {
		return startHourMapper.queryStartProportion(map);
	}

	@Override
	public List<StartHour> queryTotalStartBySign(Map<String, Object> map) {
		return startHourMapper.queryTotalStartBySign(map);
	}

	@Override
	public TotalUserHour queryTotalUserHour(Map<String, Object> params) {
		return totalUserHourMapper.queryTotalUserHour(params);
	}

	@Override
	public List<StartHour> queryHighTime(Map<String, Object> map) {
		return startHourMapper.queryHighTime(map);
	}

	@Override
	public StartHour queryLowTime(Map<String, Object> map) {
		return startHourMapper.queryLowTime(map);
	}

	@Override
	public StartHour queryHighTimeStartPer(Map<String, Object> map) {
		return startHourMapper.queryHighTimeStartPer(map);
	}

	@Override
	public StartHour querylowTimeStartPer(Map<String, Object> map) {
		return startHourMapper.querylowTimeStartPer(map);
	}
}
