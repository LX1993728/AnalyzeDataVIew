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

import com.anrong.wulan.admin.po.ActiveUserOs;
import com.anrong.wulan.admin.po.ActiveUserVendorDay;
import com.anrong.wulan.admin.po.EquipmentModel;
import com.anrong.wulan.admin.po.NewUserOs;
import com.anrong.wulan.admin.po.NewUserVendorDay;
import com.anrong.wulan.admin.po.StartOs;
import com.anrong.wulan.admin.po.StartVendorDay;
import com.anrong.wulan.admin.po.VersionDetailModel;
import com.anrong.wulan.admin.service.ActiveUserOsService;
import com.anrong.wulan.admin.service.ActiveUserRegionDayService;
import com.anrong.wulan.admin.service.EquipmentModelService;
import com.anrong.wulan.admin.service.NewUserOsService;
import com.anrong.wulan.admin.service.StartOsService;
import com.anrong.wulan.admin.service.VersionDetailModelService;
import com.anrong.wulan.core.util.Page;
import com.anrong.wulan.core.util.QueryTermsUtil;

/**
 * 机型版本
 * 
 * @author TY
 *
 */
@Controller
@RequestMapping(value = "/version")
public class DataVersionController {
	@Resource
	private ActiveUserRegionDayService activeUserRegionDayService;
	@Resource
	private NewUserOsService newUserOsService;
	@Resource
	private ActiveUserOsService activeUserOsService;
	@Resource
	private StartOsService startOsService;
	@Resource
	private EquipmentModelService vendorDetailService;
	@Resource
	private VersionDetailModelService versionDetailService;

	/**
	 * 
	 * 机型版本
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dataversion")
	public String dataVersion(
			@RequestParam(required = false, defaultValue = "1") Integer p,
			Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		params.put("startDate", params.get("startTime"));
		params.put("endDate", params.get("endTime"));
		Page<EquipmentModel> vendorList = vendorDetailService
				.queryVendorDetail(p, params);
		Page<VersionDetailModel> versionList = versionDetailService
				.queryVersionDetail(p, params);
		model.addAttribute("pageVendor", vendorList);
		model.addAttribute("pageVersion", versionList);

		return "data_version";
	}

	/**
	 * 新增用戶图表
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/newUserVendorChart", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> newUserVendor(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		long[] seriesData = null;
		List<NewUserVendorDay> newUserVendorList = activeUserRegionDayService
				.queryNewUser(params);
		if (null != newUserVendorList) {
			if (newUserVendorList.size() == 0) {
				result.put("res", "暂无数据");
				return result;
			}
			seriesData = new long[newUserVendorList.size()];
			for (int j = 0; j < newUserVendorList.size(); j++) {
				xAxis.add(newUserVendorList.get(j).getVendor());
			}
			for (NewUserVendorDay newUserVendorObj : newUserVendorList) {
				int off = 0;
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						String vendor = newUserVendorObj.getVendor();
						if (vendor.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = newUserVendorObj.getNewUserTotal();
							break;
						}
					} else {
						off = i;
					}
				}
			}
			legend.add("新增用戶");
			result.put("legend", legend);
			result.put("xAxis", xAxis);
			result.put("seriesData", seriesData);
		}
		return result;
	}

	/**
	 * 活跃用戶图表
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/activeUserVendorChart", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> activeUserVendor(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		long[] seriesData = null;
		List<ActiveUserVendorDay> activeUserVendorList = activeUserRegionDayService
				.queryActiveUserTotal(params);
		if (null != activeUserVendorList) {
			if (activeUserVendorList.size() == 0) {
				result.put("res", "暂无数据");
				return result;
			}
			seriesData = new long[activeUserVendorList.size()];
			for (int j = 0; j < activeUserVendorList.size(); j++) {
				xAxis.add(activeUserVendorList.get(j).getVendor());
			}
			for (ActiveUserVendorDay activeUserVendorObj : activeUserVendorList) {
				int off = 0;
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						String vendor = activeUserVendorObj.getVendor();
						if (vendor.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = activeUserVendorObj
									.getActiveUserTotal();
							break;
						}
					} else {
						off = i;
					}
				}
			}
			legend.add("活跃用戶");
			result.put("xAxis", xAxis);
			result.put("legend", legend);
			result.put("seriesData", seriesData);
		}
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
	@RequestMapping(value = "/startTimeVendorChart", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> startTimeVendor(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		long[] seriesData = null;
		List<StartVendorDay> startTimeVendorList = activeUserRegionDayService
				.queryStartTime(params);
		if (null != startTimeVendorList) {
			if (startTimeVendorList.size() == 0) {
				result.put("res", "暂无数据");
				return result;
			}
			seriesData = new long[startTimeVendorList.size()];
			for (int j = 0; j < startTimeVendorList.size(); j++) {
				xAxis.add(startTimeVendorList.get(j).getVendor());
			}
			for (StartVendorDay startTimeVendorObj : startTimeVendorList) {
				int off = 0;
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						String vendor = startTimeVendorObj.getVendor();
						if (vendor.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = startTimeVendorObj
									.getStartTimeTotal();
							break;
						}
					} else {
						off = i;
					}
				}
			}
			legend.add("启动次数");
			result.put("xAxis", xAxis);
			result.put("legend", legend);
			result.put("seriesData", seriesData);
		}
		return result;
	}

	/**
	 * 操作系统新增用戶图表
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/newUserOsChart", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> newUserOs(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		long[] seriesData = null;
		List<NewUserOs> newUserOsList = newUserOsService
				.queryNewUserTotal(params);
		if (null != newUserOsList) {
			if (newUserOsList.size() == 0) {
				result.put("res", "暂无数据");
				return result;
			}
			seriesData = new long[newUserOsList.size()];
			for (int j = 0; j < newUserOsList.size(); j++) {
				xAxis.add(newUserOsList.get(j).getOs());
			}
			for (NewUserOs newUserOsObj : newUserOsList) {
				int off = 0;
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						String os = newUserOsObj.getOs();
						if (os.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = newUserOsObj.getNewUserCount();
							break;
						}
					} else {
						off = i;
					}
				}
			}
		}
		legend.add("新增用戶");
		result.put("xAxis", xAxis);
		result.put("legend", legend);
		result.put("seriesData", seriesData);
		return result;
	}

	/**
	 * 操作系统活跃用戶图表
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/activeUserOsChart", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> activeUserOs(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		long[] seriesData = null;
		List<ActiveUserOs> activeUserOsList = activeUserOsService
				.queryActiveUserTotal(params);
		if (null != activeUserOsList) {
			if (activeUserOsList.size() == 0) {
				result.put("res", "暂无数据");
				return result;
			}
			seriesData = new long[activeUserOsList.size()];
			for (int j = 0; j < activeUserOsList.size(); j++) {
				xAxis.add(activeUserOsList.get(j).getOs());
			}
			for (ActiveUserOs activeUserOsObj : activeUserOsList) {
				int off = 0;
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						String vendor = activeUserOsObj.getOs();
						if (vendor.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = activeUserOsObj.getActUserCount();
							break;
						}
					} else {
						off = i;
					}
				}
			}
		}
		legend.add("活跃用戶");
		result.put("xAxis", xAxis);
		result.put("legend", legend);
		result.put("seriesData", seriesData);
		return result;
	}

	/**
	 * 操作系统启动次数图表
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/startTimeOsChart", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> startTimeOs(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		List<String> legend = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		List<StartOs> startVendorList = startOsService
				.queryStartTimeTotal(params);
		long[] seriesData = null;
		if (null != startVendorList) {
			if (startVendorList.size() == 0) {
				result.put("res", "暂无数据");
				return result;
			}
			seriesData = new long[startVendorList.size()];
			for (int j = 0; j < startVendorList.size(); j++) {
				xAxis.add(startVendorList.get(j).getOs());
			}
			for (StartOs startOsObj : startVendorList) {
				int off = 0;
				for (int i = off; off < xAxis.size(); i++) {
					if (i < xAxis.size()) {
						String os = startOsObj.getOs();
						if (os.equals(xAxis.get(i))) {
							off = i;
							seriesData[i] = startOsObj.getStartTotal();
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
}
