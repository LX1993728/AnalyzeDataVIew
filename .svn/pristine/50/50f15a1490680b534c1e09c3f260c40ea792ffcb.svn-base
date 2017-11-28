package com.anrong.wulan.admin.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
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
import com.anrong.wulan.admin.po.ActiveUserDay;
import com.anrong.wulan.admin.po.ActiveUserHour;
import com.anrong.wulan.admin.po.BackUserDay;
import com.anrong.wulan.admin.po.BootstrapPage;
import com.anrong.wulan.admin.po.DurationHour;
import com.anrong.wulan.admin.po.LostUserDay;
import com.anrong.wulan.admin.po.NewStartDetailData;
import com.anrong.wulan.admin.po.NewUserHour;
import com.anrong.wulan.admin.po.RetentionUserHour;
import com.anrong.wulan.admin.po.StartHour;
import com.anrong.wulan.admin.service.ActiveUserDayService;
import com.anrong.wulan.admin.service.ActiveUserHourService;
import com.anrong.wulan.admin.service.BackUserDayService;
import com.anrong.wulan.admin.service.DurationHourService;
import com.anrong.wulan.admin.service.LostUserDayService;
import com.anrong.wulan.admin.service.NewStartDetailDataService;
import com.anrong.wulan.admin.service.NewUserHourService;
import com.anrong.wulan.admin.service.RetentionDayService;
import com.anrong.wulan.admin.service.TotalUserHourService;
import com.anrong.wulan.core.util.DateKit;
import com.anrong.wulan.core.util.QueryTermsUtil;

/**
 * 数据概况
 * 
 * @author TY
 *
 */
@Controller
@RequestMapping(value = "/profile")
public class DataProfilingController {
	@Resource
	private NewUserHourService newUserHourService;
	@Resource
	private ActiveUserDayService actUserDayService;
	@Resource
	private DurationHourService durationHourService;
	@Resource
	private TotalUserHourService totalUserHourService;
	@Resource
	private NewStartDetailDataService newStartDetailDataService;
	@Resource
	private RetentionDayService retentionDayService;
	@Resource
	private LostUserDayService lostUserDayService;
	@Resource
	private BackUserDayService backUserDayService;
	@Resource
	private ActiveUserHourService activeUserHourService;

	/**
	 * 
	 * 数据概况
	 */
	@RequestMapping(value = "/dataprofiling",method=RequestMethod.GET)
	public String dataPro(){
		return "data_profiling";
	}
	//加载数据
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dataprofiling",method=RequestMethod.POST)
	@ResponseBody
	public BootstrapPage<NewStartDetailData> dataProfiling(
			@RequestParam(required = false, defaultValue = "1") Integer pageSize,
			@RequestParam(required = false, defaultValue = "1") Integer pageNumber,
			HttpServletRequest request) throws UnsupportedEncodingException {
		/*		HttpSession session = request.getSession(true);
		Map<String, Object> params = Maps.newHashMap();
		String appKey = (String) session.getAttribute("appKey");
		String logType = (String) session.getAttribute("appPlatform");
		String parameterAppKey = request.getParameter("appKey");
		String platForm = request.getParameter("platForm");
		if (parameterAppKey != null) {
			appKey = parameterAppKey;
			session.setAttribute("appKey", appKey);
		}
		if (platForm != null && platForm.length() != 0) {
			logType = platForm;
			session.setAttribute("appPlatform", logType);
			session.setAttribute("platFormCheck", logType.split("[+]"));

		}
		if (logType.indexOf("+") != -1) {
			String[] split = logType.split("[+]");
			params.put("logTypes", split);
		} else {
			params.put("logType", logType);
		}
		params.put("appKey", appKey);*/
		String paraStartDate = request.getParameter("startDate");
		String paraEndDate = request.getParameter("endDate");
		Date now = new Date();
		if(paraStartDate.equals("") && paraEndDate.equals("")){
			paraStartDate = DateKit.format(DateKit.getAnyDayByNo(now, -30),
					"YYYY-MM-dd");
			paraEndDate = DateKit.format(DateKit.getAnyDayByNo(now, -0),
					"YYYY-MM-dd");
		}
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>)queryTerms.get("params");
		params.put("startTime", paraStartDate);
		params.put("endTime", paraEndDate);
		BootstrapPage<NewStartDetailData> newUserList = newStartDetailDataService
				.queryUserDetailCount(pageSize,pageNumber, params);
		return newUserList;
	}

	/**
	 * 时段分析新增用户图表
	 * 
	 * @param request
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/newUserTime", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> newUserTime(HttpServletRequest request) throws ParseException {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		HttpSession session = request.getSession(false);
		String logType = (String) session.getAttribute("appPlatform");
		String appKey = (String) session.getAttribute("appKey");
		String TodayDate = request.getParameter("endDate");
		// 平台下拉框 以及选中checkbox
		if (logType.indexOf("+") != -1) {
			String[] split = logType.split("[+]");
			params.put("logTypes", split);
		} else {
			params.put("logType", logType);
		}
		params.put("appKey", appKey);
		if (logType.indexOf("+") != -1) {
			params.put("logTypes", logType.split("[+]"));
		} else {
			params.put("logType", logType.toUpperCase());
		}
		List<String> legend = new ArrayList<String>();
		for (int i = 0; i < 24; i++) {
			xAxis.add(i+".00");
		}
		long[] seriesData = new long[xAxis.size()];
		long[] seriesDataYes = new long[xAxis.size()];
		// 时间
		String toDate = null;
		Date now = new Date();
		if (TodayDate != null) {
			toDate = TodayDate;
		} else {
			toDate = DateKit.format(DateKit.getAnyDayByNo(now, -0),
					"YYYY-MM-dd");
		}
		params.put("toDate", toDate);

		//时段分析今天新增用户
		List<NewUserHour> newUserTimeList = newUserHourService.queryNewUserTimeToday(params);
		for (NewUserHour newUserTime : newUserTimeList) {
			int off = 0;
			String  StatisticsSign = (String)newUserTime.getStatisticsSign().toString()+".00";
			for (int i = off; off < xAxis.size(); i++) {
				if (i < xAxis.size()) {
					if (StatisticsSign.equals(xAxis.get(i))) {
						off = i;
						seriesData[i] = newUserTime.getNewUserCount();
						break;
					}
				} else {
					off = i;
				}
			}
		}
		//时段分析昨日新增用户	
		List<NewUserHour> newUserYesTimeList = newUserHourService.queryNewUserTimeYestaday(params);
		for (NewUserHour newUserYesTime : newUserYesTimeList) {
			int off = 0;
			String  StatisticsSign = (String)newUserYesTime.getStatisticsSign().toString()+".00";
			for (int i = off; off < xAxis.size(); i++) {
				if (i < xAxis.size()) {
					if (StatisticsSign.equals(xAxis.get(i))) {
						off = i;
						seriesDataYes[i] = newUserYesTime.getNewUserCount();
						break;
					}
				} else {
					off = i;
				}
			}
		}
		legend.add("今日新增用户");
		legend.add("昨日新增用户");
		result.put("xAxis", xAxis);
		result.put("legend", legend);
		result.put("seriesData", seriesData);
		result.put("seriesDataYes", seriesDataYes);
		return result;
	}

	/**
	 * 时段分析活跃用户图表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/actUserTime", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> actUserTime(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		HttpSession session = request.getSession(false);
		String logType = (String) session.getAttribute("appPlatform");
		String appKey = (String) session.getAttribute("appKey");
		String TodayDate = request.getParameter("endDate");
		// 平台下拉框 以及选中checkbox
		if (logType.indexOf("+") != -1) {
			String[] split = logType.split("[+]");
			params.put("logTypes", split);
		} else {
			params.put("logType", logType);
		}

		params.put("appKey", appKey);
		if (logType.indexOf("+") != -1) {
			params.put("logTypes", logType.split("[+]"));
		} else {
			params.put("logType", logType.toUpperCase());
		}
		List<String> legend = new ArrayList<String>();
		for (int i = 0; i < 24; i++) {
			xAxis.add(i+".00");
		}
		long[] seriesData = new long[xAxis.size()];
		long[] seriesDataYes = new long[xAxis.size()];
		// 时间
		String toDate = null;
		Date now = new Date();
		if (TodayDate != null) {
			toDate = TodayDate;
		} else {
			toDate = DateKit.format(DateKit.getAnyDayByNo(now, -0),
					"YYYY-MM-dd");
		}
		params.put("toDate", toDate);

		//时段分析今天活跃用户
		List<ActiveUserHour> actUserTimeList = activeUserHourService.queryActUserTimeToday(params);
		for (ActiveUserHour actUserTime : actUserTimeList) {
			int off = 0;
			String  StatisticsSign = (String)actUserTime.getStatisticsSign().toString()+".00";
			for (int i = off; off < xAxis.size(); i++) {
				if (i < xAxis.size()) {
					if (StatisticsSign.equals(xAxis.get(i))) {
						off = i;
						seriesData[i] = actUserTime.getActiveUserCount();
						break;
					}
				} else {
					off = i;
				}
			}
		}
		//时段分析昨日新增用户	
		List<ActiveUserHour> actUserYesTimeList = activeUserHourService.queryActUserTimeYestaday(params);
		for (ActiveUserHour actUserYesTime : actUserYesTimeList) {
			int off = 0;
			String  StatisticsSign = (String)actUserYesTime.getStatisticsSign().toString()+".00";
			for (int i = off; off < xAxis.size(); i++) {
				if (i < xAxis.size()) {
					if (StatisticsSign.equals(xAxis.get(i))) {
						off = i;
						seriesDataYes[i] = actUserYesTime.getActiveUserCount();
						break;
					}
				} else {
					off = i;
				}
			}
		}
		legend.add("今日活跃用户");
		legend.add("昨日活跃用户");
		result.put("xAxis", xAxis);
		result.put("legend", legend);
		result.put("seriesData", seriesData);
		result.put("seriesDataYes", seriesDataYes);

		return result;
	}

	/**
	 * 新增用户图表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> newUser(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		HttpSession session = request.getSession(false);
		String logType = (String) session.getAttribute("appPlatform");
		String appKey = (String) session.getAttribute("appKey");
		// 平台下拉框 以及选中checkbox
		if (logType.indexOf("+") != -1) {
			String[] split = logType.split("[+]");
			params.put("logTypes", split);
		} else {
			params.put("logType", logType);
		}

		params.put("appKey", appKey);
		if (logType.indexOf("+") != -1) {
			params.put("logTypes", logType.split("[+]"));
		} else {
			params.put("logType", logType.toUpperCase());
		}
		List<String> legend = new ArrayList<String>();
		String startTime = request.getParameter("startDate");
		String endTime = request.getParameter("endDate");
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates(startTime, endTime);
		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		long[] seriesData = new long[xAxis.size()];
		List<NewUserHour> newUserList = newUserHourService
				.queryNewUserCountDay(params);
		if (null != newUserList) {
			for (NewUserHour newUser : newUserList) {
				int off = 0;
				String statisticDate = DateKit.format(newUser.getDate(),
						"YYYY-MM-dd");
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						if (statisticDate.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = newUser.getNewUserCount();
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
	 * 活跃用户图表
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/activeUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> activeUser(HttpServletRequest request) throws UnsupportedEncodingException {

		/*HttpSession session = request.getSession(true);
		String logType = (String) session.getAttribute("appPlatform");
		String appKey = (String) session.getAttribute("appKey");
		String platForm = request.getParameter("platForm");
		String[] split = null;
		if (platForm != null) {
			split = platForm.split(",");
		}
		params.put("appKey", appKey);
		params.put("split", split);
		if (logType.indexOf("+") != -1) {
			params.put("logTypes", logType.split("[+]"));
		} else {
			params.put("logType", logType.toUpperCase());
		}
		String startTime = request.getParameter("startDate");
		String endTime = request.getParameter("endDate");
		params.put("startTime", startTime);
		params.put("endTime", endTime);*/
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String,Object> params= (Map<String,Object>)queryTerms.get("params");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String)params.get("startTime"), (String)params.get("endTime"));
		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		long[] seriesData = new long[xAxis.size()];
		List<ActiveUserDay> activeUserList = actUserDayService
				.queryActiveUserDay(params);
		for (ActiveUserDay actUser : activeUserList) {
			int off = 0;
			String statisticDate = DateKit.format(actUser.getStatisticsDate(),
					"YYYY-MM-dd");
			for (int i = off; off < xAxis.size(); i++) {
				if (i < xAxis.size()) {
					if (statisticDate.equals(xAxis.get(i))) {
						off = i;
						seriesData[i] = actUser.getActiveUser();
						break;
					}
				} else {
					off = i;
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
	 * 启动次数图表
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> startTime(HttpServletRequest request) throws UnsupportedEncodingException {
		/*Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		HttpSession session = request.getSession(true);
		String logType = (String) session.getAttribute("appPlatform");
		String appKey = (String) session.getAttribute("appKey");
		String platForm = request.getParameter("platForm");
		String[] split = null;
		if (platForm != null) {
			split = platForm.split(",");
		}
		params.put("appKey", appKey);
		params.put("split", split);
		if (logType.indexOf("+") != -1) {
			params.put("logTypes", logType.split("[+]"));
		} else {
			params.put("logType", logType.toUpperCase());
		}
		List<String> legend = new ArrayList<String>();
		String startTime = request.getParameter("startDate");
		String endTime = request.getParameter("endDate");
		params.put("startTime", startTime);
		params.put("endTime", endTime);*/

		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String,Object> params= (Map<String,Object>)queryTerms.get("params");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String)params.get("startTime"), (String)params.get("endTime"));

		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		long[] seriesData = new long[xAxis.size()];
		List<StartHour> startList = totalUserHourService
				.queryStartTotalTime(params);
		if (null != startList) {
			for (StartHour startHourObj : startList) {
				int off = 0;
				String statisticDate = DateKit.format(
						startHourObj.getStatisticsDate(), "YYYY-MM-dd");
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						if (statisticDate.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = startHourObj.getStartCount();
							break;
						}
					} else {
						off = i;
					}
				}
			}
		}
		legend.add("启动次数");
		result.put("xAxis", xAxis);
		result.put("legend", legend);
		result.put("seriesData", seriesData);
		return result;
	}

	/**
	 * 人均使用时长图表
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/avgUseTime", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> avgUseTime(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		// 搜索条件筛选工具
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms.get("params");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String) params.get("startTime"),(String) params.get("endTime"));
		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		long[] seriesData = new long[xAxis.size()];
		List<DurationHour> avgUseTimeList = durationHourService
				.queryAvgSingleUseTime(params);
		if (null != avgUseTimeList) {
			for (DurationHour durationHourObj : avgUseTimeList) {
				int off = 0;
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						if (durationHourObj.getStatisticsDate().equals(
								xAxis.get(i))) {
							off = i;
							seriesData[i] = Math.round(durationHourObj
									.getAvgSingleUseTime());
							break;
						}
					} else {
						off = i;
					}
				}
			}
		}
		result.put("xAxis", xAxis);
		result.put("seriesData", seriesData);
		return result;
	}

	/**
	 * 累计用户图表
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/totalUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> totalUser(HttpServletRequest request) throws UnsupportedEncodingException {

		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String,Object> params= (Map<String,Object>)queryTerms.get("params");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String)params.get("startTime"), (String)params.get("endTime"));

		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		long[] seriesData = new long[xAxis.size()];
		List<NewUserHour> newUserHourList = newUserHourService
				.queryUserCount(params);
		if (null != newUserHourList) {
			int userCountNum = 0;
			for (int i = 0; i < xAxis.size(); i++) {
				for (NewUserHour newUserHour : newUserHourList) {
					String statisticDate = DateKit.format(
							newUserHour.getDate(), "YYYY-MM-dd");
					if (statisticDate.equals(xAxis.get(i))) {
						userCountNum = newUserHour.getNewUserCount();
						seriesData[i] = userCountNum;
					}
				}
				seriesData[i] = userCountNum;
			}
		}
		legend.add("累计用户");
		result.put("xAxis", xAxis);
		result.put("legend", legend);
		result.put("seriesData", seriesData);
		return result;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/retentionUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> retentionUser(HttpServletRequest request,
			Model model) throws UnsupportedEncodingException {

		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String,Object> params= (Map<String,Object>)queryTerms.get("params");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String)params.get("startTime"), (String)params.get("endTime"));

		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		long[] seriesData = new long[xAxis.size()];
		List<RetentionUserHour> retentionDayList = retentionDayService
				.listRetent(params);
		if (null != retentionDayList) {
			for (RetentionUserHour retentionUserHour : retentionDayList) {
				int off = 0;
				String statisticDate = DateKit.format(
						retentionUserHour.getStstisticsDate(), "YYYY-MM-dd");
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						if (statisticDate.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = Math.round(retentionUserHour
									.getThirtyDayRetention());
							break;
						}
					} else {
						off = i;
					}
				}
			}
		}
		legend.add("留存用户");
		result.put("xAxis", xAxis);
		result.put("legend", legend);
		result.put("seriesData", seriesData);
		return result;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/lostUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> lostUser(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String,Object> params= (Map<String,Object>)queryTerms.get("params");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String)params.get("startTime"), (String)params.get("endTime"));

		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		long[] seriesData = new long[xAxis.size()];
		List<LostUserDay> lostUserDayList = lostUserDayService
				.selectLost(params);
		if (null != lostUserDayList) {
			for (LostUserDay lostUserDay : lostUserDayList) {
				int off = 0;
				String statisticDate = DateKit.format(
						lostUserDay.getStstisticsDate(), "YYYY-MM-dd");
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						if (statisticDate.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = Math.round(lostUserDay
									.getThirthDay());
							break;
						}
					} else {
						off = i;
					}
				}
			}
		}
		legend.add("流失用户");
		result.put("xAxis", xAxis);
		result.put("legend", legend);
		result.put("seriesData", seriesData);
		return result;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/backUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> backUser(HttpServletRequest request, Model model) throws UnsupportedEncodingException {

		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String,Object> params= (Map<String,Object>)queryTerms.get("params");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> dateList = DateUtil.findDates((String)params.get("startTime"), (String)params.get("endTime"));

		for (Date dateObj : dateList) {
			xAxis.add(sdf.format(dateObj));
		}
		long[] seriesData = new long[xAxis.size()];
		List<BackUserDay> backUserDayList = backUserDayService
				.selectBack(params);
		if (null != backUserDayList) {
			for (BackUserDay backUserDay : backUserDayList) {
				int off = 0;
				String statisticDate = DateKit.format(
						backUserDay.getStstisticsDate(), "YYYY-MM-dd");
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						if (statisticDate.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = Math.round(backUserDay
									.getThirthDay());
							break;
						}
					} else {
						off = i;
					}
				}
			}
		}
		legend.add("回流用户");
		result.put("xAxis", xAxis);
		result.put("legend", legend);
		result.put("seriesData", seriesData);
		return result;
	}
}
