package com.anrong.wulan.core.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.common.collect.Maps;

public class QueryTermsUtil {

	/*获取查询条件*/
	public static Map<String, Object> getQueryTerms(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		Map<String, Object> params = Maps.newHashMap();
		String  appKey = (String)session.getAttribute("appKey");
		String logType = (String) session.getAttribute("appPlatform");
		String parameterAppKey = request.getParameter("appKey");
		String platForm = request.getParameter("platForm");
		String paraStartDate = request.getParameter("startDate");
		String paraEndDate = request.getParameter("endDate");
		String type = request.getParameter("type");
		paraStartDate=paraStartDate==""? null:paraStartDate;
		paraEndDate=paraEndDate==""? null:paraEndDate;
		if(parameterAppKey!=null){
			appKey=parameterAppKey;
			session.setAttribute("appKey", appKey);
		}
		if(platForm!=null && platForm.length()!=0){
			logType=platForm;
			session.setAttribute("appPlatform", logType);
			session.setAttribute("platFormCheck",logType.split("[+]"));

		}
		if (logType.indexOf("+") != -1) {
			String[] split = logType.split("[+]");
			params.put("logTypes", split);
		} else {
			params.put("logType", logType);
		}
		params.put("appKey", appKey);
		//用户类型
		if(type!=null){
			params.put("type", type);
		}
		String startDate = null;
		String endDate = null;
		Date now = new Date();
		String attrStartDate = (String)session.getAttribute("startDate");
		String attrEndDate = (String)session.getAttribute("endDate");
		if(paraStartDate!=null && paraEndDate!=null){
			startDate=paraStartDate;
			endDate=paraEndDate;
			session.setAttribute("startDate", paraStartDate);
			session.setAttribute("endDate", paraEndDate);
		}else if(attrStartDate!=null && attrEndDate!=null){
			startDate=attrStartDate;
			endDate=attrEndDate;
		}else{
			startDate=DateKit.format(DateKit.getAnyDayByNo(now, -30),
					"YYYY-MM-dd");
			endDate=DateKit.format(DateKit.getAnyDayByNo(now, -0),
					"YYYY-MM-dd");
		} 
		params.put("startTime", startDate);
		params.put("endTime", endDate);
		
		//汇总返回
		Map<String, Object> result = Maps.newHashMap();
		result.put("params", params);
		/*result.put("startDate", startDate);
		result.put("endDate", endDate);*/
		result.put("session", session);
		
		return result;
	}
}
