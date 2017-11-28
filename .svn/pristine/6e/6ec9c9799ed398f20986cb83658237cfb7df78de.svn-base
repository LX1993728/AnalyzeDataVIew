package com.anrong.wulan.admin.controller;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anrong.wulan.admin.common.DateUtil;
import com.anrong.wulan.admin.po.ChannelPromotion;
import com.anrong.wulan.admin.po.CoreEvent;
import com.anrong.wulan.admin.po.SingleUser;
import com.anrong.wulan.admin.po.UserAnalysis;
import com.anrong.wulan.admin.service.AppInfoService;
import com.anrong.wulan.admin.service.AppPlatformService;
import com.anrong.wulan.admin.service.ChannelPromotionService;
import com.anrong.wulan.admin.service.CoreEventService;
import com.anrong.wulan.admin.service.DisposableUserService;
import com.anrong.wulan.admin.service.UserAnalysisService;
import com.anrong.wulan.core.util.DateKit;
import com.anrong.wulan.core.util.Page;
import com.anrong.wulan.core.util.QueryTermsUtil;
import com.google.common.collect.Maps;
/**
 * 数据
 * @author ZJR
 *
 */
@Controller
@RequestMapping(value="/DataAnalysis")
public class DataAnalysisController {
	
	@Resource
	private AppInfoService appInfoService;

	@Resource
	private AppPlatformService appPlatformService;

	@Resource
	private DisposableUserService disposableUserService;

	@Resource
	private ChannelPromotionService channelService;
	
	@Resource
	private CoreEventService coreEventService;
	
	@Resource
	private UserAnalysisService userAnalysisService;
	
	/**
	 * 
	 * 数据分析首页
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/datanalysis")
	public String dataAnalysis(@RequestParam(required = false, defaultValue = "1") Integer p,
			Model model,HttpServletRequest request) throws UnsupportedEncodingException{
		HttpSession session = request.getSession();
		//搜索条件筛选工具
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>)queryTerms.get("params");
//		String eventName =null;
		List<CoreEvent> eventIdList = coreEventService.queryEventId(params);
//		获取当前事件ID
		if(request.getParameter("eventId")!=null || (String)session.getAttribute("eventId") !=null ){
			params.put("eventId",request.getParameter("eventId")!=null? Integer.parseInt(request.getParameter("eventId")):Integer.parseInt((String)session.getAttribute("eventId")));
			session.setAttribute("eventId", request.getParameter("eventId"));
		}else if (eventIdList.size()>0) {
			params.put("eventId",eventIdList.get(0).getEventId());
		}
//		int eventId = 0;
//		if (params.get("eventId") != null) {
//			eventId = (int) params.get("eventId");
//		}
//		for (int i = 0; i < eventIdList.size(); i++) {
//			if (eventId == eventIdList.get(i).getEventId()) {
//				eventName = eventIdList.get(i).getEventName();
//			}
//		}
		Page<CoreEvent> eventList = coreEventService.queryNode(p, params);
		List<CoreEvent> bastPath = coreEventService.queryPathCharts(params);
		model.addAttribute("eventModel", eventList);
		model.addAttribute("bastPath", bastPath);
		return "data_analysis";
	
	}
	/**
	 * 
	 * 数据分析一次用户
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/onesUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> OnesUserEchart(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		ArrayList<String> xAxis = new ArrayList<String>();

		//搜索条件筛选工具
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>)queryTerms.get("params");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String)queryTerms.get("startDate"), (String)queryTerms.get("endDate"));
		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		long[] seriesData = new long[xAxis.size()];
		List<SingleUser> onesUserList = disposableUserService.selectSingleusers(params);
		for (SingleUser onesUser : onesUserList) {
			int off = 0;
			String statisticDate = DateKit.format(onesUser.getStatisticsDate(),
					"YYYY-MM-dd");
			for (int i = off; off < xAxis.size(); i++) {
				if (i < xAxis.size()) {
					if (statisticDate.equals(xAxis.get(i))) {
						off = i;
						seriesData[i] = onesUser.getSingleUser();
						break;
					}
				} else {
					off = i;
				}
			}
		}
		
		result.put("xAxis", xAxis);
		result.put("seriesData", seriesData);
		return result;

	}
	
	
	/**
	 * 数据分析模块分布图表
	 * @throws UnsupportedEncodingException 
	 */	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/channelLoad")
	@ResponseBody
	public List<Map<String, Object>>  channelLoad(HttpServletRequest request) throws UnsupportedEncodingException{
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		List<Map<String, Object>> channelMaps = new ArrayList<Map<String,Object>>();
		List<ChannelPromotion> channelList = channelService.queryUserCount(params);
		if(channelList.size()!=0){
			for (int i = 0; i < channelList.size(); i++) {
				Map<String, Object> channelMap =new HashMap<String, Object>();
				channelMap.put("value", channelList.get(i).getChannelUserCount());
				channelMap.put("name", channelList.get(i).getChannelName());
				channelMaps.add(channelMap);
			}
		}else {
			Map<String, Object> channelMap =new HashMap<String, Object>();
			channelMap.put("value", "0");
			channelMap.put("name", "暂无数据");
			channelMaps.add(channelMap);
		}
		return channelMaps;	
	}	
	/**
	 * 
	 * 数据分析年龄分布，性别比例加载
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ageEchart", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> ageEchart(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();

		//搜索条件筛选工具
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>)queryTerms.get("params");
		List<UserAnalysis> UserAnalysisByParams = userAnalysisService.queryUserAnalysisByParams(params);
		int boy = 0;
		int girl = 0;
		int total = 0;
		//计算年龄分布
		int[] firt = new int[5];
		int[] thir = new int[5];
		for (int i = 0; i < UserAnalysisByParams.size(); i++) {
			if(UserAnalysisByParams.get(i).getSex().equals("0")){
				boy +=UserAnalysisByParams.get(i).getNumber();
				int boyAge = UserAnalysisByParams.get(i).getNumber();
				if(UserAnalysisByParams.get(i).getAge()<20){
					firt[0]+=boyAge;
				}else if(UserAnalysisByParams.get(i).getAge()>=20 && UserAnalysisByParams.get(i).getAge()<35){
					firt[1]+=boyAge;
				}else if(UserAnalysisByParams.get(i).getAge()>=35 && UserAnalysisByParams.get(i).getAge()<45){
					firt[2]+=boyAge;
				}else if(UserAnalysisByParams.get(i).getAge()>=45 && UserAnalysisByParams.get(i).getAge()<60){
					firt[3]+=boyAge;
				}else if(UserAnalysisByParams.get(i).getAge()>=60){
					firt[4]+=boyAge;
				}
			}
			if(UserAnalysisByParams.get(i).getSex().equals("1")){
				girl +=UserAnalysisByParams.get(i).getNumber();
				int girlAge = UserAnalysisByParams.get(i).getNumber();
				if(UserAnalysisByParams.get(i).getAge()<20){
					thir[0]+=girlAge;
				}else if(UserAnalysisByParams.get(i).getAge()>=20 && UserAnalysisByParams.get(i).getAge()<35){
					thir[1]+=girlAge;
				}else if(UserAnalysisByParams.get(i).getAge()>=35 && UserAnalysisByParams.get(i).getAge()<45){
					thir[2]+=girlAge;
				}else if(UserAnalysisByParams.get(i).getAge()>=45 && UserAnalysisByParams.get(i).getAge()<60){
					thir[3]+=girlAge;
				}else if(UserAnalysisByParams.get(i).getAge()>=60){
					thir[4]+=girlAge;
				}
			}
		}
		//年龄分布结果值
		result.put("boyAge", firt);//
		result.put("girlAge", thir);
		total = boy+girl ;
		NumberFormat numberFormat = NumberFormat.getInstance();
		//设置精确到小数点后2位
		numberFormat.setMaximumFractionDigits(2);
		int boyResult =(int) (((float) boy  / (float) total) * 100);
		int girlResult = (int)(((float) girl / (float) total) * 100);
		result.put("boy", boyResult+"%");
		result.put("girl", girlResult+"%");	 
		return result;

	}
	
	/**
	 * 研报里面的渠道
	 */	
	@RequestMapping(value = "/reportChannel")
	@ResponseBody
	public List<Map<String, Object>>  reportChannel(HttpServletRequest request){
		Map<String, Object> params = Maps.newHashMap();
		List<Map<String, Object>> channelMaps = new ArrayList<Map<String,Object>>();
		List<ChannelPromotion> channelList = channelService.reportChannel(params);
		if(channelList.size()!=0){
			for (int i = 0; i < channelList.size(); i++) {
				Map<String, Object> channelMap =new HashMap<String, Object>();
				channelMap.put("value", channelList.get(i).getChannelUserCount());
				channelMap.put("name", channelList.get(i).getChannelName());
				channelMaps.add(channelMap);
			}
		}else {
			Map<String, Object> channelMap =new HashMap<String, Object>();
			channelMap.put("value", "0");
			channelMap.put("name", "暂无数据");
			channelMaps.add(channelMap);
		}
		return channelMaps;	
	}	

}