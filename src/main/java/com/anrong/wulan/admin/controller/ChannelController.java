package com.anrong.wulan.admin.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anrong.wulan.admin.common.DateUtil;
import com.anrong.wulan.admin.po.ChannelStatisticsDay;
import com.anrong.wulan.admin.service.ChannelStatisticsDayService;
import com.anrong.wulan.core.util.DateKit;
import com.anrong.wulan.core.util.Page;
import com.anrong.wulan.core.util.QueryTermsUtil;
import com.anrong.wulan.core.util.Strings;

/**
 * 
 * 渠道分析
 * 
 * @author ZJR
 * 
 */
@Controller
@RequestMapping(value = "/channelStatistics")
public class ChannelController {

	@Resource
	private ChannelStatisticsDayService channelService;

	/**
	 * 渠道分析页面
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/channelView")
	public String earlyWarnningView(
			@RequestParam(required = false, defaultValue = "1") Integer p,
			Model model, HttpServletRequest request,@RequestParam(required = false)String channelName) throws UnsupportedEncodingException {
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		//获取所有渠道名称
		if(StringUtils.isEmpty(channelName)){
			channelName = request.getParameter("channelName");
		}else{
			channelName= Strings.toUTF8(channelName);
			/*try {
				channelName=URLDecoder.decode(channelName, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}*/
		}
		List<ChannelStatisticsDay> nameList =channelService.getChannelName(params);
		model.addAttribute("nameList", nameList);
		if(nameList!=null&&nameList.size()>0){
			if(channelName!=""&&channelName!=null){
				params.put("channelName", channelName);
				model.addAttribute("channelName", channelName);
			}else{
				params.put("channelName", nameList.get(0).getChannelName());
				model.addAttribute("channelName", nameList.get(0).getChannelName());
			}
		}
		Page<ChannelStatisticsDay> channelList = channelService.getChannelData(params, p);
		model.addAttribute("channelList", channelList);
		return "channel_analysis";
	}
	
	/**
	 * 跳转渠道详细页面
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/channelDetailed")
	public String channelDetailed(
			@RequestParam(required = false, defaultValue = "1") Integer p,
			Model model, HttpServletRequest request,@RequestParam(required = false)String channelName) throws UnsupportedEncodingException {
		
		//根据渠道名称查询所有数据
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		if(StringUtils.isNotEmpty(channelName)){
			channelName= Strings.toUTF8(channelName);
			params.put("channelName", channelName);
		}
		
		Page<ChannelStatisticsDay> channelList = channelService.getChannelNameDetailData(params, p);
		model.addAttribute("channelListDetailed", channelList);
		return "channel_analysis_detailed";
	}
	/**
	 * 查询预TOP5渠道新增用户
	 * @throws UnsupportedEncodingException 
	 * 
	 **/

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getTop5ChannelNewUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getTop5ChannelNewUser(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		//初始化新增用户渠道TOP5的ECHARTS数据
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String)params.get("startTime"), (String)params.get("endTime"));
		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		
		Map<String, Object> ResultSeriesData = new HashMap<String, Object>();
		result.put("xAxis", xAxis);
		//查询出top5的渠道名称
		List<ChannelStatisticsDay> chanelNameTop5 = channelService.getNewUserChanelNameTop5(params);
		for (int i = 0; i < chanelNameTop5.size(); i++) {
			params.put("channelName", chanelNameTop5.get(i).getChannelName());
			//根据top5的渠道名称查询相关渠道所有数据
			List<ChannelStatisticsDay> getTop5ChanelNameData=channelService.getChanelNameTop5Data(params);
			long [] seriesData = new long[xAxis.size()];
			for (ChannelStatisticsDay newUser : getTop5ChanelNameData) {
				int off = 0;
				String statisticDate = DateKit.format(newUser.getStatisticsDate(), "YYYY-MM-dd");
				for (int l = off; off < xAxis.size(); l++) {
					if (l < xAxis.size()) {
						if (statisticDate.equals(xAxis.get(l))) {
							off = l;
							seriesData[l] = newUser.getNewUserDay();
							break;
						}
					} else {
						off = l;
					}
				}
			}
			ResultSeriesData.put(chanelNameTop5.get(i).getChannelName(), seriesData);
		}
		result.put("ResultSeriesData", ResultSeriesData);
		return result;
	}
	
	/**
	 * 查询首页TOP5预渠道活跃用户
	 * @throws UnsupportedEncodingException 
	 * 
	 **/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getTop5ActiveUserByChanel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getTop5ActiveUserByChanel(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>)queryTerms.get("params");
		
		// 初始化活跃用户渠道TOP5的ECHARTS数据
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String)params.get("startTime"), (String)params.get("endTime"));
		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}

		Map<String, Object> ResultSeriesData = new HashMap<String, Object>();
		result.put("xAxis", xAxis);
		// 查询出top5的渠道名称
		List<ChannelStatisticsDay> chanelNameTop5 = channelService
				.getActiveUserChanelNameTop5(params);
		for (int i = 0; i < chanelNameTop5.size(); i++) {
			params.put("channelName", chanelNameTop5.get(i).getChannelName());
			// 根据top5的渠道名称查询相关渠道所有数据
			List<ChannelStatisticsDay> getTop5ChanelNameData = channelService
					.getChanelNameTop5Data(params);
			long[] seriesData = new long[xAxis.size()];
			for (ChannelStatisticsDay newUser : getTop5ChanelNameData) {
				int off = 0;
				String statisticDate = DateKit.format(
						newUser.getStatisticsDate(), "YYYY-MM-dd");
				for (int l = off; off < xAxis.size(); l++) {
					if (l < xAxis.size()) {
						if (statisticDate.equals(xAxis.get(l))) {
							off = l;
							seriesData[l] = newUser.getActiveUserDay();
							break;
						}
					} else {
						off = l;
					}
				}
			}
			ResultSeriesData.put(chanelNameTop5.get(i).getChannelName(),
					seriesData);
		}
		result.put("ResultSeriesData", ResultSeriesData);
		return result;
	}
	
	
	/**
	 * 查询首页TOP5预渠道人均使用时长
	 * @throws UnsupportedEncodingException 
	 * 
	 **/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getTop5AvgUserByChanel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getTop5AvgUserByChanel(HttpServletRequest request) throws UnsupportedEncodingException {
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>)queryTerms.get("params");
		// 初始化活跃用户渠道TOP5的ECHARTS数据
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String)params.get("startTime"), (String)params.get("endTime"));
		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		Map<String, Object> ResultSeriesData = new HashMap<String, Object>();
		result.put("xAxis", xAxis);
		// 查询出top5的渠道名称
		List<ChannelStatisticsDay> chanelNameTop5 = channelService
				.getAvgUserChanelNameTop5(params);
		for (int i = 0; i < chanelNameTop5.size(); i++) {
			params.put("channelName", chanelNameTop5.get(i).getChannelName());
			// 根据top5的渠道名称查询相关渠道所有数据
			List<ChannelStatisticsDay> getTop5ChanelNameData = channelService
					.getChanelNameTop5Data(params);
			long[] seriesData = new long[xAxis.size()];
			for (ChannelStatisticsDay newUser : getTop5ChanelNameData) {
				int off = 0;
				String statisticDate = DateKit.format(
						newUser.getStatisticsDate(), "YYYY-MM-dd");
				for (int l = off; off < xAxis.size(); l++) {
					if (l < xAxis.size()) {
						if (statisticDate.equals(xAxis.get(l))) {
							off = l;
							seriesData[l] = newUser.getAvgUserDay();
							break;
						}
					} else {
						off = l;
					}
				}
			}
			ResultSeriesData.put(chanelNameTop5.get(i).getChannelName(),
					seriesData);
		}
		result.put("ResultSeriesData", ResultSeriesData);
		return result;
	}
	
	
	
	/**
	 * 查询渠道新增用户详细
	 * @throws UnsupportedEncodingException 
	 * 
	 **/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getChannelNewUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getChannelNewUser(HttpServletRequest request) throws UnsupportedEncodingException {
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>)queryTerms.get("params");
		
		
		//初始化ECHARTS数据
		List<String> legend = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String)params.get("startTime"), (String)params.get("endTime"));
		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		List<ChannelStatisticsDay> newUserList = channelService.getNewUserByChanelName(params); //原来写法
		long[] seriesData = new long[xAxis.size()];
		if (null != newUserList) {
			for (ChannelStatisticsDay newUser : newUserList) {
				int off = 0;
				String statisticDate = DateKit.format(newUser.getStatisticsDate(), "YYYY-MM-dd");
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						if (statisticDate.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = newUser.getNewUserDay();
							break;
						}
					} else {
						off = i;
					}
				}
			}
		}
		legend.add("新增用户");
		result.put("xAxis", xAxis);
		result.put("legend", legend);
		result.put("seriesData", seriesData);
		return result;
	}
	
	/**
	 * 查询预渠道活跃用户
	 * @throws UnsupportedEncodingException 
	 * 
	 **/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getActiveUserByChanel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getNewUserByChanel(HttpServletRequest request) throws UnsupportedEncodingException {
		List<String> xAxis = new ArrayList<String>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>)queryTerms.get("params");
		
		//获取所有渠道名称
		String channelName = request.getParameter("channelName");
		if(StringUtils.isNotEmpty(channelName)){
			channelName=Strings.toUTF8(channelName);
			params.put("channelName", channelName);
		}
		//初始化ECHARTS数据
		List<String> legend = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String)params.get("startTime"), (String)params.get("endTime"));
				
		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		long[] seriesData = new long[xAxis.size()];
		List<ChannelStatisticsDay> newUserList = channelService.getActiveUserByChanel(params);
		if (null != newUserList) {
			for (ChannelStatisticsDay newUser : newUserList) {
				int off = 0;
				String statisticDate = DateKit.format(
						newUser.getStatisticsDate(), "YYYY-MM-dd");
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						if (statisticDate.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = newUser.getActiveUserDay();
							break;
						}
					} else {
						off = i;
					}
				}
			}
		}
		legend.add("活跃用户");
		result.put("xAxis", xAxis);
		result.put("legend", legend);
		result.put("seriesData", seriesData);
		return result;
	}
	/**
	 * 查询预渠道人均使用时长
	 * @throws UnsupportedEncodingException 
	 * 
	 **/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getAvgUserByChanel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAvgUserByChanel(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>)queryTerms.get("params");
		//获取所有渠道名称
		String channelName = request.getParameter("channelName");
		if(StringUtils.isNotEmpty(channelName)){
			channelName=Strings.toUTF8(channelName);
			params.put("channelName", channelName);
		}
		//初始化ECHARTS数据
		List<String> legend = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String)params.get("startTime"), (String)params.get("endTime"));
		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		long[] seriesData = new long[xAxis.size()];
		List<ChannelStatisticsDay> newUserList = channelService.getAvgUserByChanel(params);
		
		if (null != newUserList) {
			for (ChannelStatisticsDay newUser : newUserList) {
				int off = 0;
				String statisticDate = DateKit.format(
						newUser.getStatisticsDate(), "YYYY-MM-dd");
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						if (statisticDate.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = newUser.getAvgUserDay();
							break;
						}
					} else {
						off = i;
					}
				}
			}
		}
		legend.add("人均使用时长");
		result.put("xAxis", xAxis);
		result.put("legend", legend);
		result.put("seriesData", seriesData);
		return result;
	}
	/**
	 * 查询预渠道活跃用户
	 * 
	 **/
	@RequestMapping(value = "/changePlatForm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> changePlantForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String appkey = request.getParameter("appKey");
		String platform = request.getParameter("platForm");
		session.setAttribute("appKey", appkey);
		session.setAttribute("appPlatform", platform);
		session.setAttribute("platFormCheck",platform.split("[+]"));
		return null;
	}
}
