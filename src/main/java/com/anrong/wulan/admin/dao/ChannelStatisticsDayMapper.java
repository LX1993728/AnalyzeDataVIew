package com.anrong.wulan.admin.dao;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.ChannelStatisticsDay;
import com.anrong.wulan.core.generic.GenericDao;
/**
 * 渠道
 * @author ZJR
 * 
 *
 */
public interface ChannelStatisticsDayMapper extends GenericDao<ChannelStatisticsDay, Long> {

	List<ChannelStatisticsDay> getActiveUserByChanel(Map<String, Object> params);
	
	List<ChannelStatisticsDay> getNewUserByChanel(Map<String, Object> params);
	
	List<ChannelStatisticsDay> getNewUserByChanelCount(Map<String, Object> params);
	//查询TOP5新增用户渠道名称
	List<ChannelStatisticsDay> getNewUserChanelNameTop5(Map<String, Object> params);
	//查询TOP5活跃用户渠道名称
	List<ChannelStatisticsDay> getActiveUserChanelNameTop5(Map<String, Object> params);
	//查询TOP5活跃用户渠道名称
	List<ChannelStatisticsDay> getAvgUserChanelNameTop5(Map<String, Object> params);
	//根据top5的渠道名称查询用户渠道所有数据
	List<ChannelStatisticsDay> getChanelNameTop5Data(Map<String, Object> params);

	List<ChannelStatisticsDay> getAvgUserByChanel(Map<String, Object> params);

	List<ChannelStatisticsDay> getChannelDataCount(Map<String, Object> params);
	
	List<ChannelStatisticsDay> getChannelData(Map<String, Object> params);
	//获取所有渠道名称
	List<ChannelStatisticsDay> getChannelName(Map<String, Object> params);
}
