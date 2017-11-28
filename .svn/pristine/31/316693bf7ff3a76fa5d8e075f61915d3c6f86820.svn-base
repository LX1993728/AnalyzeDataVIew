package com.anrong.wulan.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.anrong.wulan.admin.dao.ChannelStatisticsDayMapper;
import com.anrong.wulan.admin.po.ChannelStatisticsDay;
import com.anrong.wulan.admin.service.ChannelStatisticsDayService;
import com.anrong.wulan.core.generic.GenericDao;
import com.anrong.wulan.core.generic.GenericServiceImpl;
import com.anrong.wulan.core.util.Page;

/**
 * 渠道
 * @author ZJR
 *
 */
@Service
public class ChannelStatisticsDayServiceImpl extends
		GenericServiceImpl<ChannelStatisticsDay, Long> implements ChannelStatisticsDayService {

	@Resource
	private ChannelStatisticsDayMapper channelMapper;

	@Override
	public List<ChannelStatisticsDay> getActiveUserByChanel(
			Map<String, Object> params) {
		return channelMapper.getActiveUserByChanel(params);
	}

	@Override
	public List<ChannelStatisticsDay> getNewUserByChanelName(
			Map<String, Object> params) {
		return channelMapper.getNewUserByChanel(params);
	}

	@Override
	public List<ChannelStatisticsDay> getNewUserChanelNameTop5(
			Map<String, Object> params) {
		return channelMapper.getNewUserChanelNameTop5(params);
	}
	
	@Override
	public List<ChannelStatisticsDay> getActiveUserChanelNameTop5(
			Map<String, Object> params) {
		return channelMapper.getActiveUserChanelNameTop5(params);
	}
	
	@Override
	public List<ChannelStatisticsDay> getAvgUserChanelNameTop5(
			Map<String, Object> params) {
		return channelMapper.getActiveUserChanelNameTop5(params);
	}
	
	@Override
	public List<ChannelStatisticsDay> getChanelNameTop5Data(
			Map<String, Object> params) {
		return channelMapper.getChanelNameTop5Data(params);
	}
	
	@Override
	public Page<ChannelStatisticsDay> getChannelNameDetailData(
			Map<String, Object> params, Integer p) {
		int pageSize = channelMapper.getNewUserByChanelCount(params).size();
		Page<ChannelStatisticsDay> page =  new Page<>(p,6,pageSize);
		params.put("size",6);
		params.put("start",page.getStart());
		List<ChannelStatisticsDay> list = channelMapper.getNewUserByChanel(params);
		page.setItems(list);
		return page;
	}
	
	@Override
	public List<ChannelStatisticsDay> getAvgUserByChanel(
			Map<String, Object> params) {
		return channelMapper.getAvgUserByChanel(params);
	}

	@Override
	public GenericDao<ChannelStatisticsDay, Long> getDao() {
		return channelMapper;
	}

	@Override
	public Page<ChannelStatisticsDay> getChannelData(
			Map<String, Object> params, Integer p) {
		int pageSize = channelMapper.getChannelDataCount(params).size();
		Page<ChannelStatisticsDay> page =  new Page<>(p,6,pageSize);
		params.put("size",6);
		params.put("start",page.getStart());
		List<ChannelStatisticsDay> list = channelMapper.getChannelData(params);
		page.setItems(list);
		return page;
	}

	@Override
	public List<ChannelStatisticsDay> getChannelName(
			Map<String, Object> params) {
		return channelMapper.getChannelName(params);
	}


}
