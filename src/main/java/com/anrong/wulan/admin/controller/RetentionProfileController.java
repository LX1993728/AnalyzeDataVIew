package com.anrong.wulan.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anrong.wulan.admin.po.DayActiveUserRetention;
import com.anrong.wulan.admin.po.DayNewUserRetention;
import com.anrong.wulan.admin.po.MonthActiveUserRetention;
import com.anrong.wulan.admin.po.MonthNewUserRetention;
import com.anrong.wulan.admin.po.WeekActiveUserRetention;
import com.anrong.wulan.admin.po.WeekNewUserRetention;
import com.anrong.wulan.admin.service.DayActiveUserRetentionService;
import com.anrong.wulan.admin.service.DayNewUserRetentionService;
import com.anrong.wulan.admin.service.MonthActiveUserRetentionService;
import com.anrong.wulan.admin.service.MonthNewUserRetentionService;
import com.anrong.wulan.admin.service.WeekActiveUserRetentionService;
import com.anrong.wulan.admin.service.WeekNewUserRetentionService;
import com.anrong.wulan.core.util.Page;
import com.anrong.wulan.core.util.QueryTermsUtil;

/**
 * 
 * @author TY
 *
 */
@Controller
@RequestMapping(value = "/retained")
public class RetentionProfileController {
	@Resource
	private DayNewUserRetentionService dayNewUserService;
	@Resource
	private DayActiveUserRetentionService dayActiveUserService;
	@Resource
	private WeekActiveUserRetentionService weekActiveUserService;
	@Resource
	private WeekNewUserRetentionService weekNewUserService;
	@Resource
	private MonthActiveUserRetentionService monthActiveUserService;
	@Resource
	private MonthNewUserRetentionService monthNewUserService;
	
	@RequestMapping(value = "/profile",method = RequestMethod.GET)
	public String profile(){
		return "retained_profile";
	}
	
	@RequestMapping(value = "/profile",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> profileData(
			@RequestParam(required = false, defaultValue = "1") Integer p,
			HttpServletRequest request, 
			@RequestParam(required = false) String click,
			@RequestParam(required = false) String dateTerms) throws UnsupportedEncodingException {
		HttpSession session = request.getSession(true);
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		//返回map
		Map<String, Object> result = new HashMap<>();
		if (click == null && session.getAttribute("clickId") != null) {
			click = (String) session.getAttribute("clickId");
		}
		if (click == null || click.equals("") || click.equals("newUserClick")) {
			if (dateTerms == null || dateTerms.equals("")
					|| dateTerms.equals("dayClick")) {
				Page<DayNewUserRetention> dayNewUserRetentions = dayNewUserService
						.queryUserRetention(p, params);
				result.put("flag","0");
				result.put("retentionList", dayNewUserRetentions);
			} else if (dateTerms.equals("monthClick")) {
				Page<MonthNewUserRetention> monthNewUserRetentions = monthNewUserService
						.queryUserRetention(p, params);
				result.put("flag","4");
				result.put("retentionList", monthNewUserRetentions);
			} else if (dateTerms.equals("weekClick")) {
				Page<WeekNewUserRetention> weekNewUserRetentions = weekNewUserService
						.queryUserRetention(p, params);
				result.put("flag","2");
				result.put("retentionList", weekNewUserRetentions);
			}
			session.setAttribute("clickId", click);
			
			result.put("eventFlag", click);
		} else if (click.equals("activeUserClick")) {
			if (dateTerms == null || dateTerms.equals("")
					|| dateTerms.equals("dayClick")) {
				Page<DayActiveUserRetention> dayActiveUserRetentions = dayActiveUserService
						.queryUserRetention(p, params);
				result.put("flag","1");
				result.put("retentionList", dayActiveUserRetentions);
			} else if (dateTerms.equals("monthClick")) {
				Page<MonthActiveUserRetention> monthActiveUserRetentions = monthActiveUserService
						.queryUserRetention(p, params);
				result.put("flag","5");
				result.put("retentionList", monthActiveUserRetentions);
			} else if (dateTerms.equals("weekClick")) {
				Page<WeekActiveUserRetention> weekActiveUserRetentions = weekActiveUserService
						.queryUserRetention(p, params);
				result.put("flag","3");
				result.put("retentionList", weekActiveUserRetentions);
			}
			session.setAttribute("clickId", click);
			
			result.put("eventFlag", click);
		}
		result.put("startDate", params.get("startTime"));
		result.put("endDate", params.get("endTime"));
		return result;
	}
}
