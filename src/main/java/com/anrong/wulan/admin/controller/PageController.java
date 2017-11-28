package com.anrong.wulan.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZYJ
 * 视图控制器,返回jsp视图给前端
 * 
 **/
@Controller
@RequestMapping("/page")
public class PageController {

	/**
	 * 登录页
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	/**
	 * dashboard页
	 */
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

	/**
	 * 404页
	 */
	@RequestMapping("/404")
	public String error404() {
		return "404";
	}

	/**
	 * 401页
	 */
	@RequestMapping("/401")
	public String error401() {
		return "401";
	}

	/**
	 * 500页
	 */
	@RequestMapping("/500")
	public String error500() {
		return "500";
	}

	@RequestMapping("/permission")
	public String permission() {
		return "system/permission";
	}

	@RequestMapping("/role")
	public String role() {
		return "system/role";
	}

	@RequestMapping("/user")
	public String user() {
		return "system/user";
	}

	@RequestMapping("/menu")
	public String menu() {
		return "system/menu";
	}

	/**
	 * 自定义事件
	 * 
	 * @return
	 */
	@RequestMapping("event")
	public String event() {
		return "/func/event";
	}

	/**
	 * 错误分析
	 * 
	 * @return
	 */
	@RequestMapping("errorAnalysis")
	public String errorAnalysis() {
		return "/error/errorAnalysis";
	}

	/**
	 * 错误列表
	 * 
	 * @return
	 */
	@RequestMapping("errorList")
	public String errorList() {
		return "/error/errorList";
	}

	/**
	 * 错误列表
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "/index";
	}

}