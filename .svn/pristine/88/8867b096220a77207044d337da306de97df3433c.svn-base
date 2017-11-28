package com.anrong.wulan.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

import com.anrong.wulan.admin.po.CoreEvent;
import com.anrong.wulan.admin.service.CoreEventService;
import com.anrong.wulan.core.util.Page;
import com.anrong.wulan.core.util.QueryTermsUtil;
import com.google.common.collect.Maps;

/**
 * 事件分析
 * 
 * @author TY
 * 
 */
@Controller
@RequestMapping(value = "/event")
public class EventAnalysisController {

	@Resource
	private CoreEventService coreEventService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/analysis")
	public String event(
			@RequestParam(required = false, defaultValue = "1") Integer p,
			Model model, HttpServletRequest request,
			@RequestParam(required = false) String eventId) throws UnsupportedEncodingException {
		HttpSession session = request.getSession(true);
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		String eventName = null;
		List<CoreEvent> eventIdList = coreEventService.queryEventId(params);
		// 获取当前事件ID
		// if(request.getParameter("eventId")!=null ||
		// (String)session.getAttribute("eventId") !=null ){
		// params.put("eventId",request.getParameter("eventId")!=null?
		// Integer.parseInt(request.getParameter("eventId")):Integer.parseInt((String)session.getAttribute("eventId")));
		// session.setAttribute("eventId", request.getParameter("eventId"));
		// }else if (eventIdList.size()>0) {
		// params.put("eventId",eventIdList.get(0).getEventId());
		// }
		// int eventId = 0;
		// if (params.get("eventId") != null) {
		// eventId = (int) params.get("eventId");
		// }
		// for (int i = 0; i < eventIdList.size(); i++) {
		// if (eventId == eventIdList.get(i).getEventId()) {
		// eventName = eventIdList.get(i).getEventName();
		// }
		// }
		if (eventId != null) {
			params.put("eventId", Integer.parseInt(eventId));
			session.setAttribute("eventId", eventId);
		} else if ((String) session.getAttribute("eventId") != null) {
			params.put("eventId",
					Integer.parseInt((String) session.getAttribute("eventId")));
		} else if (eventIdList.size() > 0) {
			params.put("eventId", eventIdList.get(0).getEventId());
		}
		for (int i = 0; i < eventIdList.size(); i++) {
			if ((int) params.get("eventId") == eventIdList.get(i).getEventId()) {
				eventName = eventIdList.get(i).getEventName();
			}
		}
		Page<CoreEvent> eventList = coreEventService.queryNode(p, params);
		model.addAttribute("eventModel", eventList);
		model.addAttribute("eventIdList", eventIdList);
		model.addAttribute("eventName", eventName);
		return "event_analysis";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/eventClickCharts", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> eventClickCharts(HttpServletRequest request,
			@RequestParam(required = false) String eventId) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Map<String, Object> queryTerms = QueryTermsUtil.getQueryTerms(request);
		Map<String, Object> params = (Map<String, Object>) queryTerms
				.get("params");
		// String parameter = request.getParameter("eventId");
		List<CoreEvent> eventIdList = coreEventService.queryEventId(params);
		// if(Integer.parseInt(parameter)!=1 ||
		// (String)session.getAttribute("eventII")!=null){
		// try {
		// params.put("eventId",Integer.parseInt(request.getParameter("eventId"))!=1
		// ?
		// Integer.parseInt((String)session.getAttribute("eventII")):Integer.parseInt(request.getParameter("eventId")));
		//
		// } catch (Exception e) {
		// }
		// params.put("eventId",Integer.parseInt(request.getParameter("eventId"))!=1
		// ?
		// Integer.parseInt(request.getParameter("eventId")):Integer.parseInt((String)session.getAttribute("eventII")));
		// session.setAttribute("eventII", request.getParameter("eventId"));
		// }else if(eventIdList.size()>0){
		// params.put("eventId",eventIdList.get(0).getEventId());
		// }
		if ((String) session.getAttribute("eventId") != null) {
			params.put("eventId",
					Integer.parseInt((String) session.getAttribute("eventId")));
		} else if (eventId != null) {
			params.put("eventId", Integer.parseInt(eventId));
			session.setAttribute("eventId", eventId);
		} else if (eventIdList.size() > 0) {
			params.put("eventId", eventIdList.get(0).getEventId());
		}
		String sortId = request.getParameter("sortId");
		List<String> xAxis = new ArrayList<String>();
		long[] seriesData = null;
		long[] reachData = null;
		List<CoreEvent> coreEventList = coreEventService.queryEcharts(params);
		List<CoreEvent> corePathEventList = coreEventService
				.queryPathCharts(params);
		if (null != coreEventList) {
			if (coreEventList.size() == 0) {
				result.put("res", "暂无数据");
				return result;
			}
			reachData = new long[corePathEventList.size()];
			seriesData = new long[corePathEventList.size()];
			for (int i = 0; i < corePathEventList.size(); i++) {
				xAxis.add(corePathEventList.get(i).getEventPath());
				seriesData[i] = corePathEventList.get(i).getPathNum();
				reachData[i] = corePathEventList.get(i).getReachPathNum();
			}
			List<Map<String, Object>> seriesDataList = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> reachDataList = new ArrayList<Map<String, Object>>();
			for (int j = 0; j < coreEventList.size(); j++) {
				Map<String, Object> seriesMap = new HashMap<String, Object>();
				Map<String, Object> reachMap = new HashMap<String, Object>();
				if (sortId.equals("eventClicks")) {
					seriesMap.put("value", coreEventList.get(j)
							.getEventTrigger());
					reachMap.put("value", coreEventList.get(j).getReach());
				} else if (sortId.equals("eventUser")) {
					seriesMap.put("value", coreEventList.get(j).getCountUser());
					reachMap.put("value", coreEventList.get(j).getReachUser());
				}
				seriesMap.put("name", coreEventList.get(j).getEventNode());
				reachMap.put("name", coreEventList.get(j).getEventNode());
				seriesDataList.add(seriesMap);
				reachDataList.add(reachMap);
			}
			result.put("trigger", "触发数");
			result.put("reach", "达成数");
			result.put("xAxis", xAxis);
			result.put("seriesData", seriesData);
			result.put("reachData", reachData);
			result.put("seriesDataList", seriesDataList);
			result.put("reachDataList", reachDataList);
		}
		return result;
	}

	/* 核心事件 */
	@RequestMapping(value = "/coreEvent")
	@ResponseBody
	public List<Object> coreEvent(HttpServletRequest request) {

		Map<String, Object> params = Maps.newHashMap();
		List<CoreEvent> coreEventByParam = coreEventService
				.coreEventByParam(params);

		List<Object> lists = new ArrayList<>();

		if (coreEventByParam != null && coreEventByParam.size() != 0) {

			for (CoreEvent ce : coreEventByParam) {
				ce.setUnFinishNumber(ce.getEventNumber() - ce.getFinishNumber());
				lists.add(ce);
			}
		}
		return lists;
	}

}