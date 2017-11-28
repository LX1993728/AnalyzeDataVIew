package com.anrong.wulan.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anrong.wulan.admin.po.ReportData;
import com.anrong.wulan.admin.service.ReportDataService;
import com.anrong.wulan.core.util.Page;

/**
 * 
 * @author ZYJ
 *
 */
@Controller
@RequestMapping(value="/report")
public class ReportDataController {

	
	@Resource
	private ReportDataService reortDataService;
	
	
	@RequestMapping(value = "/manager")
	public String eventManager(@RequestParam(required = false, defaultValue = "1") Integer p,HttpServletRequest request,Model model) {
		
		Page<ReportData> queryReportData = reortDataService.queryByPage(p);
		model.addAttribute("reportDate", queryReportData);
		return "report_manager";
	}
	
	@RequestMapping(value="/update",method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String updateReportData(ReportData reportData){
		 int update = reortDataService.update(reportData);
		 if(update==1){
				return "success";//"redirect:/rest/report/manager";
			}else{
				return "false";
			}
	}
	
}
