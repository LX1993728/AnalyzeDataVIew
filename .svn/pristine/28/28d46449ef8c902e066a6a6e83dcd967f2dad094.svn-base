package com.anrong.wulan.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anrong.wulan.admin.po.AppPlatform;
import com.anrong.wulan.admin.service.AppPlatformService;
import com.anrong.wulan.admin.service.NewUserHourService;
import com.anrong.wulan.core.util.Strings;

/**
 * 平台类型
 * 
 * @author WYL
 * 
 */
@Controller
@RequestMapping(value = "/appPlatform")
public class AppPlatformController {

	@Resource
	private AppPlatformService appPlatformService;

	@Resource
	private NewUserHourService newUserHourService;

	/**
	 * 通过appKey查询所对应的平台类型
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getAppPlatform", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAppPlatform(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 前台传值
		String appKey = request.getParameter("appKey");
		appKey=Strings.toUTF8(appKey);
//		appKey = MyURLDecoder.urlDecoder(appKey);
		String appName = request.getParameter("appName");
		appName =Strings.toUTF8(appName);
//		appName = MyURLDecoder.urlDecoder(appName);

		List<AppPlatform> appPlatformList = appPlatformService
				.getAppPlatform(appKey);
		if (appPlatformList.size() > 0) {
			// 根据查询结果的条数分别返回页面不同的结果
			String platform = "";
			if (appPlatformList.size() > 1) {
				for (int i = 0; i < appPlatformList.size(); i++) {
					if (i == appPlatformList.size() - 1) {
						platform += appPlatformList.get(i).getPlatform();
					} else {
						platform += appPlatformList.get(i).getPlatform() + "+";
					}
				}
				AppPlatform appPlatform = new AppPlatform();
				appPlatform.setPlatform(platform);
				appPlatformList.add(0, appPlatform);
				result.put("appPlatformList", appPlatformList);
			}
			if (appPlatformList.size() == 1) {
				result.put("appPlatformList", appPlatformList);
			}
			// 用户点击的app和获得的平台信息保存在session中
			HttpSession session = request.getSession(false);
			session.setAttribute("appInfo", appName);
			session.setAttribute("appKey", appKey);
			session.setAttribute("appPlatform", appPlatformList.get(0)
					.getPlatform());
			session.setAttribute("appPlatformList", appPlatformList);
			// 相应的app没有平台类型
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("appInfo", appName);
			session.setAttribute("appKey", appKey);
		}

		return result;

	}

	/**
	 * 平台下拉列表改变后保存platform
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveAppPlatform", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> saveAppPlatform(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 前台传值
//		String platform = request.getParameter("platform");
		String platform =Strings.toUTF8(request.getParameter("platform"));

		// 用户点击的app和获得的平台信息保存在session中
		HttpSession session = request.getSession(true);
		session.setAttribute("appPlatform", platform);
		result.put("appPlatform", platform);
		return result;

	}

	/**
	 * 通过appKey和logType 查询所有appVsersion
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryAllAppVersion", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> queryAllAppVersion(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		String logType = (String) session.getAttribute("appPlatform");
		String appKey = (String) session.getAttribute("appKey");

		params.put("appKey", appKey);
		if (logType.indexOf("+") != -1) {
			params.put("logTypes", logType.split("[+]"));
		} else {
			params.put("logType", logType);
		}
		// 用户点击的app和获得的平台信息保存在session中
		// session.setAttribute("appPlatform", platform);
		// result.put("appPlatform", platform);
		return result;

	}

	/**
	 * 保存选中的appVersion
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveSelectVersion", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> saveSelectVersion(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		String version = request.getParameter("version");
		if (version == null) {
			session.removeAttribute("versions");
		} else {
			String[] versions = version.split(",");
			// 用户点击的appVersion保存在session中
			session.setAttribute("versions", versions);
		}
		return result;

	}

}
