package com.anrong.wulan.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anrong.wulan.admin.po.ActiveUserRegionDay;
import com.anrong.wulan.admin.po.NewUserRegionDay;
import com.anrong.wulan.admin.po.ProvinceCityDetailData;
import com.anrong.wulan.admin.po.StartRegionDay;
import com.anrong.wulan.admin.service.ActiveUserRegionDayService;
import com.anrong.wulan.admin.service.AppInfoService;
import com.anrong.wulan.admin.service.AppPlatformService;
import com.anrong.wulan.admin.service.NewUserRegionDayService;
import com.anrong.wulan.admin.service.ProvinceCityDetailDataService;
import com.anrong.wulan.core.util.Page;
import com.anrong.wulan.core.util.QueryTermsUtil;

/**
 * 地区统计
 * 
 * @author TY
 *
 */
@Controller
@RequestMapping(value = "/area")
public class DataAreaControlller {
	@Resource
	private NewUserRegionDayService newUserRegionDayService;
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private AppPlatformService appPlatformService;
	@Resource
	private ActiveUserRegionDayService activeUserRegionDayService;
	@Resource
	private ProvinceCityDetailDataService areaDetailService;

	/**
	 * 
	 * 地区统计
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/datarea")
	public String datArea(
			@RequestParam(required = false, defaultValue = "1") Integer p,
			Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		Page<ProvinceCityDetailData> areaList = areaDetailService
				.getProvinceCityData(p, params);
		model.addAttribute("areaDetailList", areaList);
		return "data_area";
	}

	/**
	 * 新增用戶图表
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/regionChart", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> newUserRegion(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		String chartsFlag = request.getParameter("chartsFlag");
		long[] seriesData = null;
		List<NewUserRegionDay> newUserRegionList = null;
		List<ActiveUserRegionDay> activeUserRegionList = null;
		List<StartRegionDay> startRegionList = null;
		if (chartsFlag.equals("activeUserCharts")) {
			activeUserRegionList = activeUserRegionDayService
					.queryActtiveUserByRegion(params);
		} else if (chartsFlag.equals("startCharts")) {
			startRegionList = activeUserRegionDayService
					.queryStartTimeTotal(params);
		} else {
			newUserRegionList = newUserRegionDayService
					.queryNewUserByRegion(params);
		}
		if (newUserRegionList != null && newUserRegionList.size() > 0) {
			seriesData = new long[newUserRegionList.size()];
			for (int j = 0; j < newUserRegionList.size(); j++) {
				xAxis.add(newUserRegionList.get(j).getRegion());
			}
			for (NewUserRegionDay newUserRegionDay : newUserRegionList) {
				int off = 0;
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						String area = newUserRegionDay.getRegion();
						if (area.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = newUserRegionDay.getNewUserTotal();
							break;
						}
					} else {
						off = i;
					}
				}
			}
			legend.add("新增用户");
		} else if (activeUserRegionList != null
				&& activeUserRegionList.size() > 0) {
			seriesData = new long[activeUserRegionList.size()];
			for (int j = 0; j < activeUserRegionList.size(); j++) {
				xAxis.add(activeUserRegionList.get(j).getProvince());
			}
			for (ActiveUserRegionDay activeUserRegionObj : activeUserRegionList) {
				int off = 0;
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						String area = activeUserRegionObj.getProvince();
						if (area.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = activeUserRegionObj
									.getActtiveUserTotal();
							break;
						}
					} else {
						off = i;
					}
				}
			}
			legend.add("活跃用户");
		} else if (startRegionList != null && startRegionList.size() > 0) {
			seriesData = new long[startRegionList.size()];
			for (int j = 0; j < startRegionList.size(); j++) {
				xAxis.add(startRegionList.get(j).getRegion());
			}
			for (StartRegionDay startRegionDayObj : startRegionList) {
				int off = 0;
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						String area = startRegionDayObj.getRegion();
						if (area.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = startRegionDayObj
									.getStartTimeTotal();
							break;
						}
					} else {
						off = i;
					}
				}
			}
			legend.add("启动次数");
		} else {
			result.put("res", "暂无数据");
			return result;
		}
		result.put("xAxis", xAxis);
		result.put("legend", legend);
		result.put("seriesData", seriesData);
		return result;
	}

	/**
	 * 首页地图 —— 用户分布
	 * 
	 * @author ZJR
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/areaUserRegionChart", method = RequestMethod.GET)
	@ResponseBody
	public Object areaUserRegionChart(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		List<NewUserRegionDay> areaUserRegionList = newUserRegionDayService
				.areaUserRegionChart(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("北京", 0);
		result.put("上海", 0);
		result.put("重庆", 0);
		result.put("天津", 0);
		result.put("台湾", 0);
		result.put("香港", 0);
		result.put("澳门", 0);
		result.put("河北", 0);
		result.put("山西", 0);
		result.put("内蒙古", 0);
		result.put("黑龙江", 0);
		result.put("吉林", 0);
		result.put("辽宁", 0);
		result.put("陕西", 0);
		result.put("甘肃", 0);
		result.put("青海", 0);
		result.put("新疆", 0);
		result.put("宁夏", 0);
		result.put("河南", 0);
		result.put("江苏", 0);
		result.put("浙江", 0);
		result.put("安徽", 0);
		result.put("江西", 0);
		result.put("福建", 0);
		result.put("湖北", 0);
		result.put("湖南", 0);
		result.put("广东", 0);
		result.put("广西", 0);
		result.put("海南", 0);
		result.put("四川", 0);
		result.put("云南", 0);
		result.put("山东", 0);
		result.put("贵州", 0);
		result.put("西藏", 0);
		for (String in : result.keySet()) {
			for (NewUserRegionDay nd : areaUserRegionList) {
				if (in.equals(nd.getProvince())) {
					result.put(in, nd.getProvinceCount());
				}
			}
		}
		return result;
	}
}
