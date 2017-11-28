package com.anrong.wulan.admin.service;

import java.util.List;
import java.util.Map;

import com.anrong.wulan.admin.po.ChannelStatisticsDay;
import com.anrong.wulan.core.generic.GenericService;
import com.anrong.wulan.core.util.Page;

public interface ChannelStatisticsDayService extends
		GenericService<ChannelStatisticsDay, Long> {
	/**
	 * 获取渠道活跃用户
	 * @param params
	 * @return
	 */
	List<ChannelStatisticsDay> getActiveUserByChanel(Map<String, Object> params);
	/**
	 * 查询新增用户情况
	 * @param params
	 * @return
	 */
	List<ChannelStatisticsDay> getNewUserByChanelName(Map<String, Object> params);
	
	/**
	 * 查询TOP5新增用户渠道名称
	 * @param params
	 * @return
	 */
	List<ChannelStatisticsDay> getNewUserChanelNameTop5(Map<String, Object> params);
	/**
	 * 查询TOP5活跃用户渠道名称
	 * @param params
	 * @return
	 */
	List<ChannelStatisticsDay> getActiveUserChanelNameTop5(Map<String, Object> params);
	/**
	 * 查询TOP5人均使用时长渠道名称
	 * @param params
	 * @return
	 */
	List<ChannelStatisticsDay> getAvgUserChanelNameTop5(Map<String, Object> params);
	/**
	 * 根据top5的渠道名称查询用户渠道所有数据
	 * @param params
	 * @return
	 */
	List<ChannelStatisticsDay> getChanelNameTop5Data(Map<String, Object> params);
	/**
	 * 根据渠道名字子页面新增用户渠道数据查询
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	Page<ChannelStatisticsDay> getChannelNameDetailData(Map<String, Object> params,Integer pageBounds);
	
	
	/**
	 * 获取渠道人均使用时长
	 * @param params
	 * @return
	 */
	List<ChannelStatisticsDay> getAvgUserByChanel(Map<String, Object> params);
	/**
	 * 渠道数据
	 * @param params
	 * @param pageBounds
	 * @return
	 */
	Page<ChannelStatisticsDay> getChannelData(Map<String, Object> params,Integer pageBounds);
	/**
	 * 获取渠道名称
	 * @param params
	 * @return
	 */
	List<ChannelStatisticsDay> getChannelName(Map<String, Object> params);

}
