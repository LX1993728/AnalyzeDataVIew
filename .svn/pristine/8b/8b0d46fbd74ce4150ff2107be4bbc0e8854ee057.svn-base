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

import com.anrong.wulan.admin.po.ActiveUserCarrier;
import com.anrong.wulan.admin.po.ActiveUserNet;
import com.anrong.wulan.admin.po.NewUserCarrier;
import com.anrong.wulan.admin.po.NewUserNet;
import com.anrong.wulan.admin.po.StartNet;
import com.anrong.wulan.admin.po.StartUserCarrier;
import com.anrong.wulan.admin.service.ActiveUserCarrierService;
import com.anrong.wulan.admin.service.ActiveUserNetService;
import com.anrong.wulan.admin.service.NewUserCarrierService;
import com.anrong.wulan.admin.service.NewUserNetService;
import com.anrong.wulan.admin.service.StartNetService;
import com.anrong.wulan.admin.service.StartUserCarrierService;
import com.anrong.wulan.core.util.Page;
import com.anrong.wulan.core.util.QueryTermsUtil;

/**
 * 联网方式
 * 
 * @author ZJR
 *
 */
@Controller
@RequestMapping(value = "/network")
public class DataNetWorkController {
	@Resource
	private NewUserCarrierService newUserCarrierService;

	@Resource
	private ActiveUserCarrierService actUserCarrierService;

	@Resource
	private StartUserCarrierService startUserCarrierService;

	@Resource
	private NewUserNetService newUserNetService;

	@Resource
	private ActiveUserNetService activeUserService;

	@Resource
	private StartNetService startNetService;

	/**
	 * 
	 * 联网方式明细
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/datanetwork")
	public String dataNetwork(
			@RequestParam(required = false, defaultValue = "1") Integer p,
			Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		Page<NewUserNet> pageNet = newUserNetService.queryDetail(p, params);
		Page<NewUserCarrier> pageCarrier = newUserCarrierService.queryDetail(p,
				params);
		model.addAttribute("pageNet", pageNet);
		model.addAttribute("pageCarrier", pageCarrier);
		return "data_network";
	}

	/**
	 * 运营商 新增用户
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/operatorsNewUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> operatorsNewUser(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> yAxis = new ArrayList<String>();
		long[] seriesData = null;
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		List<NewUserCarrier> newUserCarrierList = newUserCarrierService
				.selectRecord(params);
		if (newUserCarrierList.size() == 0) {
			result.put("message", "暂无数据");
		} else {
			seriesData = new long[newUserCarrierList.size()];
			for (int i = 0; i < newUserCarrierList.size(); i++) {
				seriesData[i] = newUserCarrierList.get(i).getNewUser();
				yAxis.add(newUserCarrierList.get(i).getCarrier());
			}
			result.put("legend", "新增用户");
			result.put("yAxis", yAxis);
			result.put("seriesData", seriesData);
		}
		return result;
	}

	/**
	 * 运营商 活跃用户
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/operatorsActiveUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> operatorsActiveUser(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> yAxis = new ArrayList<String>();
		long[] seriesData = null;
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		List<ActiveUserCarrier> actUserCarrierList = actUserCarrierService
				.selectRecord(params);
		if (actUserCarrierList.size() == 0) {
			result.put("message", "暂无数据");
		} else {
			seriesData = new long[actUserCarrierList.size()];
			for (int i = 0; i < actUserCarrierList.size(); i++) {
				seriesData[i] = actUserCarrierList.get(i).getActiveUser();
				yAxis.add(actUserCarrierList.get(i).getCarrier());
			}
			result.put("legend", "活跃用户");
			result.put("yAxis", yAxis);
			result.put("seriesData", seriesData);
		}

		return result;
	}

	/**
	 * 运营商 启动次数
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/operatorsStart", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> operatorsStart(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> yAxis = new ArrayList<String>();
		long[] seriesData = null;
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		List<StartUserCarrier> starrCarrierList = startUserCarrierService
				.selectRecord(params);
		if (starrCarrierList.size() == 0) {
			result.put("message", "暂无数据");
		} else {
			seriesData = new long[starrCarrierList.size()];
			for (int i = 0; i < starrCarrierList.size(); i++) {
				seriesData[i] = starrCarrierList.get(i).getStart();
				yAxis.add(starrCarrierList.get(i).getCarrier());
			}
			result.put("legend", "启动次数");
			result.put("yAxis", yAxis);
			result.put("seriesData", seriesData);
		}
		return result;
	}

	/**
	 * 联网方式 新增用户
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/netNewUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> netNewUser(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> yAxis = new ArrayList<String>();
		long[] seriesData = null;
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		List<NewUserNet> newUserNetList = newUserNetService
				.queryNetNewUser(params);
		if (newUserNetList.size() == 0) {
			result.put("message", "暂无数据");
		} else {
			seriesData = new long[newUserNetList.size()];
			for (int i = 0; i < newUserNetList.size(); i++) {
				seriesData[i] = newUserNetList.get(i).getNewUser();
				yAxis.add(newUserNetList.get(i).getNetwork());
			}
			result.put("legend", "新增用户");
			result.put("yAxis", yAxis);
			result.put("seriesData", seriesData);
		}
		return result;
	}

	/**
	 * 联网方式 活跃用户
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/netActiveUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> netActiveUser(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> yAxis = new ArrayList<String>();
		long[] seriesData = null;
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		List<ActiveUserNet> actUserNetList = activeUserService
				.selectRecord(params);
		if (actUserNetList.size() == 0) {
			result.put("message", "暂无数据");
		} else {
			seriesData = new long[actUserNetList.size()];
			for (int i = 0; i < actUserNetList.size(); i++) {
				seriesData[i] = actUserNetList.get(i).getActiveUser();
				yAxis.add(actUserNetList.get(i).getNetwork());
			}
			result.put("legend", "活跃用户");
			result.put("yAxis", yAxis);
			result.put("seriesData", seriesData);
		}
		return result;
	}

	/**
	 * 联网方式 新增用户
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/netStart", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> netStart(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> yAxis = new ArrayList<String>();
		long[] seriesData = null;
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		List<StartNet> startNetList = startNetService.selectRecord(params);
		if (startNetList.size() == 0) {
			result.put("message", "暂无数据");
		} else {
			seriesData = new long[startNetList.size()];
			for (int i = 0; i < startNetList.size(); i++) {
				seriesData[i] = startNetList.get(i).getStart();
				yAxis.add(startNetList.get(i).getNetwork());
			}
			result.put("legend", "启动次数");
			result.put("yAxis", yAxis);
			result.put("seriesData", seriesData);
		}
		return result;
	}
}
