package com.anrong.wulan.admin.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anrong.wulan.admin.service.UserPortraitService;
import com.google.common.collect.Maps;

/**
 *@author ZYJ
 *
 */
@Controller
@RequestMapping(value="/userportrait")
public class UserPortraitController {

	@Resource
	private UserPortraitService userPortraitService;

	/* 用户画像首页 */
	@RequestMapping(value = "/index")
	public String index() {

		return "user_portrait";
	}

	@RequestMapping(value = "/userPortrait")
	public Map<String, Object> queryUserPortrait(HttpServletRequest request) {
		Map<String, Object> params = Maps.newHashMap();
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String area = request.getParameter("area");
		String topArea = request.getParameter("topArea");
		if (sex != null) {
			params.put("sex", sex);
		}
		if (age.equals("<20")) {
			params.put("beginAge", 0);
			params.put("endAge", 20);
		} else if (age.equals("20-35")) {
			params.put("beginAge", 20);
			params.put("endAge", 35);
		} else if (age.equals("35-45")) {
			params.put("beginAge", 35);
			params.put("endAge", 45);
		} else if (age.equals("45-60")) {
			params.put("beginAge", 45);
			params.put("endAge", 60);
		} else if (age.equals("60<")) {
			params.put("beginAge", 60);
			params.put("endAge", "&gt;60");
		}
		if (area != null) {
			params.put("province", area);
		}
		if (topArea != null) {
			params.put("province", topArea);
		}

		return null;
	}

}
