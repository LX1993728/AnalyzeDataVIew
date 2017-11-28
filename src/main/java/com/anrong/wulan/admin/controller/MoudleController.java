package com.anrong.wulan.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
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

import com.anrong.wulan.admin.po.ModelInvoke;
import com.anrong.wulan.admin.service.AppInfoService;
import com.anrong.wulan.admin.service.AppPlatformService;
import com.anrong.wulan.admin.service.ModelInvokeService;
import com.anrong.wulan.core.util.DateKit;
import com.anrong.wulan.core.util.Page;
import com.anrong.wulan.core.util.QueryTermsUtil;
import com.anrong.wulan.core.util.Strings;

/**
 * 模块统计
 * 
 * @author ZYJ
 *
 */
@Controller
@RequestMapping(value = "/moudle")
public class MoudleController {
	@Resource
	private ModelInvokeService modelInvokeService;
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private AppPlatformService appPlatformService;

	/**
	 * 模块统计跳转页面
	 * @throws UnsupportedEncodingException 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/datamodule")
	public String dataModule(
			@RequestParam(required = false, defaultValue = "1") Integer p,
			Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		Page<ModelInvoke> modelInvokeList = modelInvokeService.queryDetail(p,
				params);

		model.addAttribute("moudleList", modelInvokeList);
		return "data_module";
	}

	/**
	 * 模块统计
	 * @throws UnsupportedEncodingException 
	 * 
	 **/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/moudleCharts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> moudleCharts(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		long[] seriesData = null;
		String moduleName = null;
		moduleName =Strings.toUTF8(request.getParameter("moduleName"));
//		try {
//			/*moduleName = URLDecoder.decode(request.getParameter("moduleName"),
//					"UTF-8");*/
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		List<ModelInvoke> modelInvokeList = null;
		if (moduleName.equals("UNDER10")) {
			modelInvokeList = modelInvokeService.selectRecordUnder(params);
		} else if (moduleName.equals("TOP10")) {
			modelInvokeList = modelInvokeService.selectRecord(params);
		}
		if (modelInvokeList != null) {
			if (modelInvokeList.size() == 0) {
				result.put("res", "暂无数据");
				return result;
			}
			seriesData = new long[modelInvokeList.size()];
			for (int j = 0; j < modelInvokeList.size(); j++) {
				xAxis.add(modelInvokeList.get(j).getModelName());
				seriesData[j] = modelInvokeList.get(j).getStatisticsInvokeNum();
			}
			result.put("xAxis", xAxis);
			result.put("seriesData", seriesData);
		}
		return result;
	}

	/**
	 * 首页TOP10模块
	 * 
	 **/
	@RequestMapping(value = "/getTopModelUse", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getTopModelUse(HttpServletRequest request,
			Model model) {
		HttpSession session = request.getSession(true);
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		List<String> xAxis = new ArrayList<String>();
		String logType = (String) session.getAttribute("appPlatform");
		String appKey = (String) session.getAttribute("appKey");
		String parameterAppKey = request.getParameter("appKey");
		String platForm = request.getParameter("platForm");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		if (parameterAppKey != null) {
			appKey = parameterAppKey;
		}
		if (platForm != null && platForm.length() != 0) {
			logType = platForm;
		}
		params.put("appKey", appKey);
		if (logType.indexOf("+") != -1) {
			String[] split = logType.split("[+]");
			params.put("logTypes", split);
			session.setAttribute("platFormCheck", split);
		} else {
			params.put("logType", logType);
			session.setAttribute("platFormCheck", logType);
		}

		// 获取当前日期
		Date now = new Date();
		if ("".equals(startDate) || "".equals(endDate)) {
			startDate = DateKit.format(DateKit.getAnyDayByNo(now, -30),
					"YYYY-MM-dd");
			endDate = DateKit.format(DateKit.getAnyDayByNo(now, -0),
					"YYYY-MM-dd");
		}

		String[] versions = new String[] {};
		if (session.getAttribute("versions") != null
				&& !session.getAttribute("versions").equals("")) {
			versions = (String[]) session.getAttribute("versions");
		}
		params.put("versions", versions);
		params.put("startTime", startDate);
		params.put("endTime", endDate);
		List<ModelInvoke> modelList = modelInvokeService
				.queryTop10Model(params);
		long[] seriesData = new long[modelList.size()];
		if (modelList != null) {
			if (modelList.size() == 0) {
				result.put("message", "暂无数据");
				return result;
			} else {
				Collections.reverse(modelList);
				seriesData = new long[modelList.size()];
				for (int i = 0; i < modelList.size(); i++) {
					seriesData[i] = modelList.get(i).getStatisticsInvokeNum();
					xAxis.add(modelList.get(i).getModelName());
				}
				result.put("yAxis", xAxis);
				result.put("seriesData", seriesData);
			}
		}
		return result;
	}
}
