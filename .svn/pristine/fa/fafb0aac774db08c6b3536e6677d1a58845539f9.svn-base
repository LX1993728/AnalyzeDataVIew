package com.anrong.wulan.admin.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anrong.wulan.admin.po.CoreEvent;
import com.anrong.wulan.admin.service.CoreEventService;
import com.anrong.wulan.core.util.Page;
import com.google.common.collect.Maps;

/**
 * 事件管理
 * @author ZYJ
 *
 */
@Controller
@RequestMapping(value = "/manager")
public class EventManagerController {
	
	@Resource
	private CoreEventService coreEventService;
	
	@RequestMapping(value = "/event")
	public String eventManager(
			@RequestParam(required = false, defaultValue = "1") Integer p,
			Model model, HttpServletRequest request) {
		Map<String, Object> params = Maps.newHashMap();
		Page<CoreEvent> coreEventListPage = coreEventService.queryCoreEvent(p, params);
		model.addAttribute("coreEventList", coreEventListPage);
		return "event_manager";
	}
	
	/*更新事件類型*/
	@RequestMapping(value = "/updateEvent",method = { RequestMethod.GET, RequestMethod.POST })
	public String update( Integer id,CoreEvent coreEvent) {
		coreEvent.setEventId(id);
		int update = coreEventService.updateEvent(coreEvent);
		if(update!=0){
			return "redirect:/rest/manager/event";
		}else{
			return "false";
		}
	}
	
	/*刪除事件*/
	@RequestMapping(value = "/deleteEvent",method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(Integer id) {
		int update = coreEventService.deleteEvent(id);
		if(update!=0){
			return "redirect:/rest/manager/event";
		}else{
			return "更改失败";
		}
	}

}
