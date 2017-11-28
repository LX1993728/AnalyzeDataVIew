package com.anrong.wulan.admin.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anrong.wulan.admin.po.ChannelPromotion;
import com.anrong.wulan.admin.po.CoreEvent;
import com.anrong.wulan.admin.po.ReportData;
import com.anrong.wulan.admin.po.ResearchReport;
import com.anrong.wulan.admin.service.ChannelPromotionService;
import com.anrong.wulan.admin.service.CoreEventService;
import com.anrong.wulan.admin.service.ReportDataService;
import com.anrong.wulan.admin.service.ReportMenuService;
import com.anrong.wulan.admin.service.ResearchReportService;
import com.anrong.wulan.core.util.Strings;
import com.google.common.collect.Maps;

/**
 * 研报所需数据
 * @author ZYJ
 *
 */

@Controller
@RequestMapping(value = "/researchreport") 
public class ResearchReportController {
	
	@Resource
	private ResearchReportService researchReportService;
	
	@Resource
	private ChannelPromotionService channelService;
	
	@Resource
	private CoreEventService coreEventService;
	
	@Resource
	private  ReportMenuService reportMenuService;
	
	@Resource
	private ReportDataService reortDataService;
	//时间格式
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
    Calendar c = Calendar.getInstance();
	
 // 每月的最后一天凌晨 执行 0 0 23 L * ? 
// 	@Scheduled(cron="0/5 * *  * * ? ")
// 	public void  get(){
// 		System.err.println("轮训执行");
// 	}
    
    
	/*研报首页*/
	@SuppressWarnings("unused")
	@RequestMapping(value="/researchreportindex")
	public String researchReportIndex(Model model){
		
		Map<String, Object> params = Maps.newHashMap();
		
		List<ResearchReport> lists = researchReportService.queryByDate();
		
		/*应用启动总数*/
		int startTotal=0;
		/*应用异常总数*/
		int startExceTotal=0;
		/*页面访问总数*/
		int visitPageTotal=0;
		/*页面访问异常总数*/
		int visitExceTotal=0;
		/*用户好评总数*/
		int praise = 0;
		/*用户评价总数*/
		int comments =0;
		/*用户访问评论模块总数*/
		int visitTotal =0;
		/*当月*/
		ResearchReport sameMonth=null;
		/*上月*/
		ResearchReport lastMonth=null;
		/*前一月*/
		ResearchReport previousMonth=null;
		/*前前一月*/
		ResearchReport preMonth=null;
		
		
        c.setTime(new Date());
        
        /*当月时间*/
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        
        /*上月时间*/
        c.add(Calendar.MONTH, -1);
        Date n = c.getTime();
        String nn = format.format(n);
        
        /*前一月时间*/
        c.add(Calendar.MONTH, -1);
        Date d = c.getTime();
        String dd = format.format(d);
        
        /*前前一月时间*/
        c.add(Calendar.MONTH, -1);
        Date da = c.getTime();
        String dad = format.format(da);
        
		if(lists!=null){
			for (ResearchReport report : lists) {
				startTotal+=report.getApplicationStartTotal();
				startExceTotal+=report.getApplicationExceTotal();
				visitPageTotal+=report.getPageVisitTotal();
				visitExceTotal+=report.getPageExceTotal();
				praise += report.getUserPraiseTotal();
				comments +=report.getUserCommentsTotal();
				visitTotal +=report.getVisitTotal();
				c.setTime(report.getDate());
				Date date= c.getTime();
		        String reportDate = format.format(date);
				if(reportDate.compareTo(mon)==0){
					sameMonth=report;
				}else if(reportDate.compareTo(nn)==0){
					lastMonth=report;
				}else if(reportDate.compareTo(dd)==0){
					previousMonth=report;
				}else if(reportDate.compareTo(dad)==0){
					preMonth=report;
				}
			}
		}
		
		System.out.println("应用启动："+startTotal+"启动异常："+startExceTotal+"访问页面总数："+visitPageTotal+"访问异常："+visitExceTotal);
		Map<String, Object> map = Maps.newHashMap();
		
		
		/*本月用户增量*/
			//本月新增用户
			int sameAddtotal = sameMonth.getUserTotal()-lastMonth.getUserTotal();
//			model.addAttribute("addUser", Strings.splitNumber(sameAddtotal));
			map.put("本月用户增量", sameAddtotal);
		
		/*用户环比增长率*/
			NumberFormat numberFormat = NumberFormat.getInstance();
			numberFormat.setMaximumFractionDigits(2);
			double userGrowRate = Strings.splitString(numberFormat.format((float) sameAddtotal / (float) lastMonth.getUserTotal() * 100));
//			model.addAttribute("userGrowRate", userGrowRate+"%");
			map.put("用户环比增长率", userGrowRate);
		
		/*新增用户环比增长率*/
			//上月新增用户总量
			int lastUserTotal =lastMonth.getUserTotal()-previousMonth.getUserTotal();
			int userRate = sameAddtotal-lastUserTotal;
			double newUserRate = Strings.splitString(numberFormat.format((float) userRate / (float) lastUserTotal * 100));
//			model.addAttribute("newUserRate", newUserRate+"%");
			map.put("新增用户环比增长率", newUserRate);
		
		/*活跃用户增量*/
			int actvieUser = sameMonth.getActiveUserTotal()-lastMonth.getActiveUserTotal();
			model.addAttribute("actvieUser", actvieUser);
			map.put("活跃用户增量", actvieUser);
		/*活跃用户增长率*/
			double activeUserRate = Strings.splitString(numberFormat.format((float) actvieUser / (float) lastMonth.getActiveUserTotal() * 100));
//			model.addAttribute("activeUserRate", activeUserRate+"%");
			map.put("活跃用户增长率", activeUserRate);
		/*活跃用户占比增量*/
			double sameAC = Strings.splitString(numberFormat.format((float) sameMonth.getActiveUserTotal() / (float) sameMonth.getUserTotal() * 100));
			double lastAC = Strings.splitString(numberFormat.format((float) lastMonth.getActiveUserTotal() / (float) lastMonth.getUserTotal() * 100));
			double slAC = sameAC-lastAC;
			model.addAttribute("slAC", slAC);
			map.put("活跃用户占比增量", slAC);
		/*活跃用户占比增长率*/
			double lastACRate = Strings.splitString(numberFormat.format((float) slAC / (float) lastAC * 100));
//			model.addAttribute("lastACRate", lastACRate+"%");
			map.put("活跃用户占比增长率", lastACRate);
		
		/*活跃用户留存率*/
			//当月活跃用户留存增量
			int slActUserRe = sameMonth.getActiveUserRetainedTotal()-lastMonth.getActiveUserRetainedTotal();
			//当月活跃用户留存增率
			double slActUserReRate = Strings.splitString(numberFormat.format((float) slActUserRe / (float) lastMonth.getActiveUserRetainedTotal() * 100));
			//上月活跃用户留存增量
			int lpActReUser = lastMonth.getActiveUserRetainedTotal()-previousMonth.getActiveUserRetainedTotal();
			//上月活跃用户留存增率
			double lpActUserReRate = Strings.splitString(numberFormat.format((float) lpActReUser / (float) previousMonth.getActiveUserRetainedTotal() * 100));
			
			double slpActUserRate = slActUserReRate-lpActUserReRate;
			
			//结果
			double ActUserReRate = Strings.splitString(numberFormat.format((float) slpActUserRate / (float) lpActUserReRate * 100));
//			model.addAttribute("ActUserReRate", ActUserReRate+"%");
			map.put("活跃用户留存率", ActUserReRate);
		/*活跃用户留存占比增量*/
			double actUserRe = ActUserReRate-lpActUserReRate;
			model.addAttribute("actUserRe", actUserRe+"%");
			map.put("活跃用户留存占比增量", actUserRe);
			
		/*活跃用户留存占比增长率*/
			double ActUserRate = Strings.splitString(numberFormat.format((float) actUserRe / (float) lpActUserReRate * 100));
//			model.addAttribute("ActUserRate", ActUserRate+"%");
			map.put("活跃用户留存占比增长率", ActUserRate);
			
		/*本月用户留存增量*/
			int userRetained=sameMonth.getUserRetainedTotal()-lastMonth.getUserRetainedTotal();
//			model.addAttribute("userRetained", (double)userRetained);
			map.put("本月用户留存增量", userRetained);
		/*用户留存率增量*/
			double slUserRe = Strings.splitString(numberFormat.format((float) sameMonth.getUserRetainedTotal() / (float) lastUserTotal * 100));
			//前一月新增用户总量
			int ppUserTotal=previousMonth.getUserTotal()-preMonth.getUserTotal();
			double lpUserRe = Strings.splitString(numberFormat.format((float)lastMonth.getUserRetainedTotal() / (float)ppUserTotal * 100));
			double slpUserRe = slUserRe-lpUserRe;
//			model.addAttribute("slpUserRe", Strings.splitNumber(slpUserRe));
			map.put("用户留存率增量", slpUserRe);
		/*应用操作异常率*/
			double startExceRate = Strings.splitString(numberFormat.format((float) startExceTotal / (float) startTotal * 100));
//			model.addAttribute("startExceRate", startExceRate+"%");
			map.put("应用操作异常率", startExceRate);
		/*当月应用异常率*/
			double applicationExceRate = Strings.splitString(numberFormat.format((float) sameMonth.getApplicationExceTotal() / (float) sameMonth.getApplicationStartTotal() * 100));
//			model.addAttribute("applicationExceRate", applicationExceRate+"%");
			map.put("当月应用异常率", applicationExceRate);
		/*应用异常增长率*/
			int slApplicationExce = sameMonth.getApplicationExceTotal()-lastMonth.getApplicationExceTotal();
			double slApplicationExceRate = Strings.splitString(numberFormat.format((float) slApplicationExce / (float) lastMonth.getApplicationExceTotal() * 100));
//			model.addAttribute("slApplicationExceRate", slApplicationExceRate+"%");
			map.put("应用异常增长率", slApplicationExceRate);
		/*页面操作异常率*/
			double pageVisitExceRate = Strings.splitString(numberFormat.format((float) visitExceTotal / (float) visitPageTotal * 100));
//			model.addAttribute("pageVisitExceRate", pageVisitExceRate+"%");
			map.put("页面操作异常率", pageVisitExceRate);
		/*当月页面异常率*/
			double sPageExceRate = Strings.splitString(numberFormat.format((float) sameMonth.getPageExceTotal() / (float) sameMonth.getPageVisitTotal() * 100));
//			model.addAttribute("sPageExceRate", sPageExceRate+"%");
			map.put("当月页面异常率", sPageExceRate);
		/*当月页面异常增长率*/
			int slPageExce = sameMonth.getPageExceTotal()-lastMonth.getPageExceTotal();
			double slPageExceRate = Strings.splitString(numberFormat.format((float) slPageExce / (float) lastMonth.getPageExceTotal() * 100));
//			model.addAttribute("slPageExceRate", slPageExceRate+"%");
			map.put("当月页面异常增长率", slPageExceRate);
		/*用户评价率*/
			double cvRate = Strings.splitString(numberFormat.format((float) comments / (float) visitTotal * 100));
//			model.addAttribute("cvRate", cvRate+"%");
			map.put("用户评价率", cvRate);
		/*用户好评率*/
			double pc = Strings.splitString(numberFormat.format((float) praise / (float) comments * 100));
//			model.addAttribute("pc", pc+"%");
			map.put("用户好评率", pc);
		/*用户好评增长率*/
			int slp = sameMonth.getUserPraiseTotal()-lastMonth.getUserPraiseTotal();
			double slpRate = Strings.splitString(numberFormat.format((float) slp / (float) lastMonth.getUserPraiseTotal() * 100));
//			model.addAttribute("slpRate", slpRate+"%");
			map.put("用户好评增长率", slpRate);
		/*用户评价增长率*/
			int slc = sameMonth.getUserCommentsTotal()-lastMonth.getUserCommentsTotal();
			double slcRate = Strings.splitString(numberFormat.format((float) slc / (float) lastMonth.getUserCommentsTotal() * 100));
//			model.addAttribute("slcRate", slcRate+"%");
			map.put("用户评价增长率", slcRate);
		/*核心事件完成率*/
			
			List<CoreEvent> coreEventByParam = coreEventService.coreEventByParam(params);
			//核心事件总量
			int eventNum=0;
			//完成核心事件总量
			int finishNum=0;
			if(coreEventByParam!=null && coreEventByParam.size()!=0){
				
				for (CoreEvent ce : coreEventByParam) {
					eventNum+=ce.getEventNumber();
					finishNum+=ce.getFinishNumber();
				}
			}
			/*double feRate = Strings.splitString(numberFormat.format((float) finishNum / (float) eventNum * 100));
			model.addAttribute("feRate", feRate+"%");
			map.put("核心事件完成率", feRate);*/
		/*渠道总量*/	
			List<ChannelPromotion> channelList = channelService.reportChannel(params);
			model.addAttribute("channelNum", channelList.size());
			map.put("渠道总量", channelList.size());
		/*用户增长最多渠道*/
		
			model.addAttribute("channelName", "应用宝");
//			map.put("用户增长最多渠道", value);
		/*留存率最高渠道*/
		
			model.addAttribute("channelH", "豌豆荚");
//			map.put("", value);
			
			List<ReportData> queryReportData = reortDataService.queryReportData();
			
			if(queryReportData!=null && queryReportData.size()!=0){
				for (ReportData rd : queryReportData) {
					
					for (String key : map.keySet()) {  
						  
					    if(key.equals(rd.getName())){
					    	rd.setData(Double.parseDouble(map.get(key).toString()));
					    	int update = reortDataService.update(rd);
						    if(update==1){
						    	System.out.println("更新成功");
						    }else{
						    	System.err.println("更新失败");
						    }
					    }
					}  
				}
			}
		
			queryReportData = reortDataService.queryReportData();
			
			//前端放数据
			/*用户环比增长率 的权重 和 星级评论级别临时变量*/
			int uprw = 0;
			int uprd= 0;
			
			/*新增用户环比增长率的权重 和 星级评论级别临时变量*/
			int  nuprw = 0;
			int  nuprd = 0;
			/*活跃用户增长率 的权重 和 星级评论级别临时变量*/
			int auw = 0;
			int aud = 0;
			/*活跃用户占比增量 的权重 和 星级评论级别临时变量*/
			int aurw = 0;
			int aurd = 0;
			/*活跃用户占比增长率 的权重 和 星级评论级别临时变量*/
			int aurrw = 0;
			int aurrd = 0;
			/*活跃用户留存率 的权重 和 星级评论级别临时变量*/
			int acturrw = 0;
			int acturrd = 0;
			/*活跃用户留存占比增量 的权重 和 星级评论级别临时变量*/
			 int actrupw = 0;
			 int actrupd = 0;
			/*活跃用户留存占比增率的权重 和 星级评论级别临时变量*/
			int acturprw = 0 ;
			int acturprd = 0 ;
			/*用户留存率增量 的权重 和 星级评论级别临时变量*/
			int ruaddw = 0;
			int ruaddd = 0;
			/*应用操作异常率的权重 和 星级评论级别临时变量*/
			int apperw = 0 ;
			int apperd = 0 ;
			/*当月应用异常率 的权重 和 星级评论级别临时变量*/
			int sapperw = 0 ;
			int sapperd = 0 ;
			/*应用异常增长率的权重 和 星级评论级别临时变量*/
			int appeprw = 0;
			int appeprd = 0;
			/*页面操作异常率 的权重 和 星级评论级别临时变量*/
			int pagew = 0;
			int paged = 0;
			/* 当月应用异常率 的权重 和 星级评论级别临时变量*/
			int spagew = 0;
			int spaged = 0;
			/*应用异常增长率 的权重 和 星级评论级别临时变量*/
			int spageprw = 0; 
			int spageprd = 0; 
			/*用户评价率 的权重 和 星级评论级别临时变量*/
			int ucrw = 0; 
			int ucrd = 0; 
			/*用户好评率 的权重 和 星级评论级别临时变量*/
			int userpw = 0;
			int userpd = 0;
			/*用户好评增长率 的权重 和 星级评论级别临时变量*/
			int upprw = 0;
			int upprd = 0;
			/*用户评价增长率 的权重 和 星级评论级别临时变量*/
			int ucprw =0;
			int ucprd =0;
			
			for (ReportData rd : queryReportData) {
				
				Integer firdata = rd.getFirdata();
				Integer sdata = rd.getSdata();
				Integer thirdata = rd.getThirdata();
				Integer fordata = rd.getFordata();
				
				//用户数据健康度
				if(rd.getName().equals("本月用户增量")){
//					model.addAttribute("addUser", Strings.splitNumber(rd.getData()));
					model.addAttribute("addUser", 1000);
				}else if(rd.getName().equals("用户环比增长率")){
					uprw=rd.getWeight();
					if(rd.getData()<firdata){
						uprd=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						uprd=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						uprd=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						uprd=4;
					}else {
						uprd=5;
					}
//					model.addAttribute("userGrowRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("userGrowRate", 22.00+"%");
				}else if(rd.getName().equals("新增用户环比增长率")){
					nuprw=rd.getWeight();
					if(rd.getData()<firdata){
						nuprd=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						nuprd=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						nuprd=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						nuprd=4;
					}else {
						nuprd=5;
					}
//					model.addAttribute("newUserRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("newUserRate", 11.60+"%");
					
					///////////////////////////////////////////
				}else if(rd.getName().equals("活跃用户增量")){
//					model.addAttribute("actvieUser", Strings.splitNumber(rd.getData()));
					model.addAttribute("actvieUser", 200);
				}else if(rd.getName().equals("活跃用户增长率")){
					auw = rd.getWeight();
					if(rd.getData()<firdata){
						aud=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						aud=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						aud=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						aud=4;
					}else {
						aud=5;
					}
//					model.addAttribute("activeUserRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("activeUserRate", 33.01+"%");
				}else if(rd.getName().equals("活跃用户占比增量")){
					aurw = rd.getWeight();
					if(rd.getData()<firdata){
						aurd=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						aurd=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						aurd=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						aurd=4;
					}else {
						aurd=5;
					}
//					model.addAttribute("slAC", Strings.splitNumber(rd.getData()));
					model.addAttribute("slAC", 2.36+"%");
				}else if(rd.getName().equals("活跃用户占比增长率")){
					aurrw = rd.getWeight();
					if(rd.getData()<firdata){
						aurrd=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						aurrd=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						aurrd=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						aurrd=4;
					}else {
						aurrd=5;
					}
//					model.addAttribute("lastACRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("lastACRate", 56.10+"%");
					
					///////////////////////////////////////////////////////
				}else if(rd.getName().equals("活跃用户留存率")){
					acturrw = rd.getWeight();
					if(rd.getData()<firdata){
						acturrd=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						acturrd=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						acturrd=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						acturrd=4;
					}else {
						acturrd=5;
					}
//					model.addAttribute("ActUserReRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("ActUserReRate", 66.02+"%");
				}else if(rd.getName().equals("活跃用户留存占比增量")){
					actrupw = rd.getWeight();
					if(rd.getData()<firdata){
						actrupd=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						actrupd=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						actrupd=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						actrupd=4;
					}else {
						actrupd=5;
					}
//					model.addAttribute("actUserRe", Strings.splitNumber(rd.getData()));
					model.addAttribute("actUserRe", 0.23+"%");
				}else if(rd.getName().equals("活跃用户留存占比增长率")){
					acturprw = rd.getWeight();
					if(rd.getData()<firdata){
						acturprd=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						acturprd=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						acturprd=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						acturprd=4;
					}else {
						acturprd=5;
					}
//					model.addAttribute("ActUserRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("ActUserRate", 1.03+"%");
					
					///////////////////////////////////////////////////////
				}else if(rd.getName().equals("本月用户留存增量")){
//					model.addAttribute("userRetained", Strings.splitNumber(rd.getData()));
					model.addAttribute("userRetained", 323);
				}else if(rd.getName().equals("用户留存率增量")){
					ruaddw =  rd.getWeight();
					if(rd.getData()<firdata){
						ruaddd=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						ruaddd=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						ruaddd=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						ruaddd=4;
					}else {
						ruaddd=5;
					}
//					model.addAttribute("slpUserRe", Strings.splitNumber(rd.getData()));
					model.addAttribute("slpUserRe", 6.00+"%");
					
					///////////////////////////////////////////////////
				}else if(rd.getName().equals("应用操作异常率")){
					apperw = rd.getWeight();
					if(rd.getData()<firdata){
						apperd=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						apperd=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						apperd=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						apperd=4;
					}else {
						apperd=5;
					}
//					model.addAttribute("startExceRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("startExceRate", 3.08+"%");
				}else if(rd.getName().equals("当月应用异常率")){
					sapperw = rd.getWeight();
					if(rd.getData()<firdata){
						sapperd=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						sapperd=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						sapperd=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						sapperd=4;
					}else {
						sapperd=5;
					}
//					model.addAttribute("applicationExceRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("applicationExceRate", 0.68+"%");
				}else if(rd.getName().equals("应用异常增长率")){
					appeprw = rd.getWeight();
					if(rd.getData()<firdata){
						appeprd=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						appeprd=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						appeprd=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						appeprd=4;
					}else {
						appeprd=5;
					}
//					model.addAttribute("slApplicationExceRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("slApplicationExceRate", 0.31+"%");
					
					///////////////////////////////////////////
				}else if(rd.getName().equals("页面操作异常率")){
					pagew = rd.getWeight();
					if(rd.getData()<firdata){
						paged=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						paged=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						paged=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						paged=4;
					}else {
						paged=5;
					}
//					model.addAttribute("pageVisitExceRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("pageVisitExceRate", 4.02+"%");
				}else if(rd.getName().equals("当月页面异常率")){
					spagew = rd.getWeight();
					if(rd.getData()<firdata){
						spaged=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						spaged=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						spaged=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						spaged=4;
					}else {
						spaged=5;
					}
//					model.addAttribute("sPageExceRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("sPageExceRate", 2.30+"%");
				}else if(rd.getName().equals("当月页面异常增长率")){
					spageprw = rd.getWeight();
					if(rd.getData()<firdata){
						spageprd=1;
					}else if(firdata< rd.getData() && rd.getData()<=sdata){
						spageprd=2;
					}else if(sdata< rd.getData() && rd.getData()<=thirdata){
						spageprd=3;
					} else if(thirdata< rd.getData() && rd.getData()<=fordata){
						spageprd=4;
					}else {
						spageprd=5;
					}
//					model.addAttribute("slPageExceRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("slPageExceRate", 0.37+"%");
					/////////////////////////////////
					
				}else if(rd.getName().equals("用户评价率")){
					 ucrw = rd.getWeight();
						if(rd.getData()<firdata){
							ucrd=1;
						}else if(firdata< rd.getData() && rd.getData()<=sdata){
							ucrd=2;
						}else if(sdata< rd.getData() && rd.getData()<=thirdata){
							ucrd=3;
						} else if(thirdata< rd.getData() && rd.getData()<=fordata){
							ucrd=4;
						}else {
							ucrd=5;
						}
//					model.addAttribute("cvRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("cvRate", 66.10+"%");
				}else if(rd.getName().equals("用户好评率")){
					userpw = rd.getWeight(); 
						if(rd.getData()<firdata){
							userpd=1;
						}else if(firdata< rd.getData() && rd.getData()<=sdata){
							userpd=2;
						}else if(sdata< rd.getData() && rd.getData()<=thirdata){
							userpd=3;
						} else if(thirdata< rd.getData() && rd.getData()<=fordata){
							userpd=4;
						}else {
							userpd=5;
						}
//					model.addAttribute("pc", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("pc", 53.26+"%");
					
					//////////////
				}else if(rd.getName().equals("用户好评增长率")){
					upprw = rd.getWeight(); 
						if(rd.getData()<firdata){
							upprd=1;
						}else if(firdata< rd.getData() && rd.getData()<=sdata){
							upprd=2;
						}else if(sdata< rd.getData() && rd.getData()<=thirdata){
							upprd=3;
						} else if(thirdata< rd.getData() && rd.getData()<=fordata){
							upprd=4;
						}else {
							upprd=5;
						}
//					model.addAttribute("slpRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("slpRate", 49.38+"%");
				}else if(rd.getName().equals("用户评价增长率")){
					ucprw = rd.getWeight();
						if(rd.getData()<firdata){
							ucprd=1;
						}else if(firdata< rd.getData() && rd.getData()<=sdata){
							ucprd=2;
						}else if(sdata< rd.getData() && rd.getData()<=thirdata){
							ucprd=3;
						} else if(thirdata< rd.getData() && rd.getData()<=fordata){
							ucprd=4;
						}else {
							ucprd=5;
						}
//					model.addAttribute("slcRate", Strings.splitNumber(rd.getData())+"%");
					model.addAttribute("slcRate", 65.01+"%");
				}else if(rd.getName().equals("")){
					
				}else if(rd.getName().equals("")){
					
				}else if(rd.getName().equals("")){
					
				}
			}
			
			//用户评价和权重
			 model.addAttribute("upp", new BigDecimal(Strings.splitString(numberFormat.format((float) ((uprw * uprd) + (nuprw* nuprd)) / (float) (uprw+nuprw)))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 model.addAttribute("upw", new BigDecimal(Strings.splitString(numberFormat.format((float) (uprw+nuprw) / (float) 2))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 
			 //活跃用户增量 评价和权重
			 model.addAttribute("aud", new BigDecimal(Strings.splitString(numberFormat.format((float) ((auw * aud)+(aurw * aurd)+(aurrw * aurrd)) / (float) (auw+aurw+aurrw)))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 model.addAttribute("auw", new BigDecimal(Strings.splitString(numberFormat.format((float) (auw+aurw+aurrw) / (float) 3))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 
			 //活跃用户留存占比
			 model.addAttribute("acturrw", new BigDecimal(Strings.splitString(numberFormat.format((float) ((acturrw * acturrd)+(actrupw * actrupd)+(acturprw * acturprd)) / (float) (acturrw+actrupw+acturprw)))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 model.addAttribute("acturrd", new BigDecimal(Strings.splitString(numberFormat.format((float) (acturrw+actrupw+acturprw) / (float) 3))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 
			 //用户留存率增量 
			 model.addAttribute("ruaddw", new BigDecimal(ruaddw).setScale(0, BigDecimal.ROUND_HALF_UP));
			 model.addAttribute("ruaddd", new BigDecimal(ruaddd).setScale(0, BigDecimal.ROUND_HALF_UP));
			 
			 //应用异常
			 model.addAttribute("appew", new BigDecimal(Strings.splitString(numberFormat.format((float) ((apperw * apperd)+(sapperw * sapperd)+(appeprw * appeprd)) / (float) (apperw+sapperw+appeprw)))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 model.addAttribute("apped", new BigDecimal(Strings.splitString(numberFormat.format((float) (apperw+sapperw+appeprw) / (float) 3))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 
			 //页面异常
			 model.addAttribute("pagew", new BigDecimal(Strings.splitString(numberFormat.format((float) ((pagew * paged)+(spaged * sapperd)+(spageprw * spageprd)) / (float) (pagew+spagew+spageprw)))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 model.addAttribute("paged", new BigDecimal(Strings.splitString(numberFormat.format((float) (pagew+spagew+spageprw) / (float) 3))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 
			 //用户平率
			 model.addAttribute("ucrw", new BigDecimal(Strings.splitString(numberFormat.format((float) ((ucrw * ucrd) + (userpw* userpd)) / (float) (ucrw+userpw)))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 model.addAttribute("ucrd", new BigDecimal(Strings.splitString(numberFormat.format((float) (ucrw+userpw) / (float) 2))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 
			 //用户评论增长率
			 model.addAttribute("upprw", new BigDecimal(Strings.splitString(numberFormat.format((float) ((upprw * upprd) + (ucprw* ucprd)) / (float) (upprw+ucprw)))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 model.addAttribute("upprd", new BigDecimal(Strings.splitString(numberFormat.format((float) (upprw+ucprw) / (float) 2))).setScale(0, BigDecimal.ROUND_HALF_UP));
			 
			 
		return "research_report";
	}
	
	
	/*获取研报里面的用户评论*/
	@RequestMapping(value="/getuserPC")
	@ResponseBody
	public List<ResearchReport> getUserPC(HttpServletRequest request){
		
		List<ResearchReport> reports = new ArrayList<>();
        
		List<ResearchReport> lists = researchReportService.queryByDate();
		
		if(lists!=null && lists.size()!=0){
			/*当月时间*/
			c.setTime(new Date());
	        c.add(Calendar.MONTH, -1);
	        Date m = c.getTime();
	        String mon = format.format(m);
	        
	        /*前月时间*/
	        c.add(Calendar.MONTH, -1);
	        Date n = c.getTime();
	        String non = format.format(n);
	        
			for (ResearchReport report : lists) {
				
				c.setTime(report.getDate());
				Date date= c.getTime();
		        String reportDate = format.format(date);
		        if(reportDate.compareTo(mon)==0){
		        	ResearchReport re = new ResearchReport();
		        	re=report;
		        	reports.add(re);
		        }else if(reportDate.compareTo(non)==0){
		        	ResearchReport rer = new ResearchReport();
		        	rer=report;
		        	reports.add(rer);
		        }
			}
		}
		
		return reports;
	}
	
	

}
