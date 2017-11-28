package com.anrong.wulan.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anrong.wulan.admin.po.AppInfo;
import com.anrong.wulan.admin.po.AppPlatform;
import com.anrong.wulan.admin.po.MonthActiveUserRetention;
import com.anrong.wulan.admin.service.AppGeneralizeService;
import com.anrong.wulan.admin.service.AppInfoService;
import com.anrong.wulan.admin.service.AppPlatformService;
import com.anrong.wulan.admin.service.MonthActiveUserRetentionService;
import com.anrong.wulan.admin.service.TotalUserHourService;
import com.anrong.wulan.admin.vo.ActiveUserVO;
import com.anrong.wulan.admin.vo.AppGeneralizeVO;

/**
 * @author ZYJ
 */

@Controller
@RequestMapping(value = "/datas")
public class DataStatisticsController {
	@Resource
	private AppInfoService appInfoService;

	@Resource
	private AppPlatformService appPlatformService;

	@Resource
	private TotalUserHourService totalUserHourService;
	
	@Resource
	private MonthActiveUserRetentionService monthActiveUserRetentionService;
	
	@Resource
	private AppGeneralizeService appGeneralizeService;
	/**
	 * 
	 * 数据统计首页
	 * @throws UnsupportedEncodingException 
	 */
	@RequiresPermissions("data:common")
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		// 主体
		Subject subject = SecurityUtils.getSubject();
		// 身份
		ActiveUserVO activeUser = (ActiveUserVO) subject.getPrincipal();
		model.addAttribute("activeUser", activeUser);
		
		HttpSession session = request.getSession(true);
		Map<String, Object> params = new HashMap<String, Object>();

		// 当前登录的用户
		session.setAttribute("username", activeUser.getUsername());
		// 获取前端传的参数
		String parameterAppKey = request.getParameter("appKey");
		String appName = request.getParameter("appName");
		// 首页刷新后判断session中是否有值
		List<AppPlatform> appPlatformList = null;
		String appPlatform = "";
		if (session.getAttribute("appKey") == null) {
			// 通过userId查询appInfoList
			List<AppInfo> appInfoList = appInfoService.selectByAppId(activeUser.getUserId());
			if (appInfoList.size() > 0) {
				// 通过appKey查询appPlatformList
				appPlatformList = appPlatformService.getAppPlatform(appInfoList.get(0).getAppKey());
				session.setAttribute("appPlatformList", appPlatformList);
				// app信息list
				session.setAttribute("appInfoList", appInfoList);
				// 登录后首页初始显示的app和平台
				session.setAttribute("appKey", appInfoList.get(0).getAppKey());
				session.setAttribute("appInfo", appInfoList.get(0).getAppName());
			}
			for (int i = 0; i < appPlatformList.size(); i++) {
				appPlatform += appPlatformList.get(i).getPlatform()+"+";
			}
			session.setAttribute("appPlatform", appPlatform);
			session.setAttribute("platFormCheck",appPlatform.split("[+]"));
			//根据平台查询
			if (appPlatformList !=null && appPlatformList.size()>0) {
				String[] str=new String[appPlatformList.size()];
				for (int i = 0; i < appPlatformList.size(); i++) {
					str[i]=appPlatformList.get(i).getPlatform();
				}
				params.put("logTypes", str);
			}
		}else{
			appPlatformList = appPlatformService.getAppPlatform(session.getAttribute("appKey").toString());
			session.setAttribute("appPlatformList", appPlatformList);
			String logType = (String) session.getAttribute("appPlatform");
			if (logType!=null) {
				if (logType.indexOf("+") != -1) {
					String[] split = logType.split("[+]");
					params.put("logTypes",split );
				} else {
					params.put("logType", logType);
				}
			}
		}
		if(parameterAppKey!=null && appName!=null ){
			appPlatformList = appPlatformService.getAppPlatform(parameterAppKey);
			session.setAttribute("appPlatformList", appPlatformList);
			session.setAttribute("appInfo", appName);
			session.setAttribute("appKey",parameterAppKey);
			session.setAttribute("platFormCheck", null);
		}
		//获取已经选中的平台
		String appKey = (String) session.getAttribute("appKey");
		// 今日
		if(parameterAppKey!=null){
			appKey=parameterAppKey;
		}
		params.put("appKey", appKey);
		
		
//		AppSummaryVO appSummaryVO = totalUserHourService
//				.queryAppTotalUserCount(params);
//		//首頁用户概况
//		model.addAttribute("sums", appSummaryVO);
		List<MonthActiveUserRetention> retentionList = monthActiveUserRetentionService
				.queryUserRetentionIndex(params);
		model.addAttribute("retentionMonthList", retentionList);
		//首页应用概况和新增的今天昨天的用户数
		AppGeneralizeVO appGeneralizeVO = appGeneralizeService.appGeneralize(params);
		model.addAttribute("generalize", appGeneralizeVO);
		return "index";
	}
}
