package com.anrong.wulan.admin.service;


import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.anrong.wulan.admin.po.ChannelPromotion;
import com.anrong.wulan.admin.po.CoreEvent;
import com.anrong.wulan.admin.po.ReportData;
import com.anrong.wulan.admin.po.ReportMenu;
import com.anrong.wulan.admin.po.ResearchReport;
import com.anrong.wulan.admin.service.ChannelPromotionService;
import com.anrong.wulan.admin.service.CoreEventService;
import com.anrong.wulan.admin.service.ResearchReportService;
import com.anrong.wulan.core.util.Strings;
import com.google.common.collect.Maps;

@Component
public class SaveReportDataUtil {
	
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

//    @Scheduled(cron="0/5 * * * * ?") 
//   	public void reportData(){
//    	System.err.println("圣诞节快乐");
//    	System.out.println("轮训调用");
//    }
    
    // 每月的最后一天凌晨 执行 0 0 23 L * ? 
//    @Scheduled(cron="0 0 23 L * ?")
	public void saveReportData(){/*
		
		Map<String, Object> params = Maps.newHashMap();
		
		List<ResearchReport> lists = researchReportService.queryByDate();
		
		应用启动总数
		int startTotal=0;
		应用异常总数
		int startExceTotal=0;
		页面访问总数
		int visitPageTotal=0;
		页面访问异常总数
		int visitExceTotal=0;
		用户好评总数
		int praise = 0;
		用户评价总数
		int comments =0;
		用户访问评论模块总数
		int visitTotal =0;
		当月
		ResearchReport sameMonth=null;
		上月
		ResearchReport lastMonth=null;
		前一月
		ResearchReport previousMonth=null;
		前前一月
		ResearchReport preMonth=null;
		
		
        c.setTime(new Date());
        
        当月时间
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        
        上月时间
        c.add(Calendar.MONTH, -1);
        Date n = c.getTime();
        String nn = format.format(n);
        
        前一月时间
        c.add(Calendar.MONTH, -1);
        Date d = c.getTime();
        String dd = format.format(d);
        
        前前一月时间
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
		
//		System.out.println("应用启动："+startTotal+"启动异常："+startExceTotal+"访问页面总数："+visitPageTotal+"访问异常："+visitExceTotal);
		Map<String, Object> obj = Maps.newHashMap();
		List<ReportData> list = new ArrayList<>();
		用户增量
			//本月新增用户
			int sameAddtotal = sameMonth.getUserTotal()-lastMonth.getUserTotal();
//			obj.
			ReportData reportData = new ReportData();
		用户环比增长率
			NumberFormat numberFormat = NumberFormat.getInstance();
			numberFormat.setMaximumFractionDigits(2);
			double userGrowRate = Strings.splitString(numberFormat.format((float) sameAddtotal / (float) lastMonth.getUserTotal() * 100));
		
		新增用户环比增长率
			//上月新增用户总量
			int lastUserTotal =lastMonth.getUserTotal()-previousMonth.getUserTotal();
			int userRate = sameAddtotal-lastUserTotal;
			double newUserRate = Strings.splitString(numberFormat.format((float) userRate / (float) lastUserTotal * 100));
		
		活跃用户增量
			int actvieUser = sameMonth.getActiveUserTotal()-lastMonth.getActiveUserTotal();
			
		活跃用户增长率
			double activeUserRate = Strings.splitString(numberFormat.format((float) actvieUser / (float) lastMonth.getActiveUserTotal() * 100));
			
		活跃用户占比增量
			double sameAC = Strings.splitString(numberFormat.format((float) sameMonth.getActiveUserTotal() / (float) sameMonth.getUserTotal() * 100));
			double lastAC = Strings.splitString(numberFormat.format((float) lastMonth.getActiveUserTotal() / (float) lastMonth.getUserTotal() * 100));
			double slAC = sameAC-lastAC;
		
		活跃用户占比增长率
			double lastACRate = Strings.splitString(numberFormat.format((float) slAC / (float) lastAC * 100));
		
		用户留存增量
			int userRetained=sameMonth.getUserRetainedTotal()-lastMonth.getUserRetainedTotal();
			
		用户留存率增量
			double slUserRe = Strings.splitString(numberFormat.format((float) sameMonth.getUserRetainedTotal() / (float) lastUserTotal * 100));
			//前一月新增用户总量
			int ppUserTotal=previousMonth.getUserTotal()-preMonth.getUserTotal();
			double lpUserRe = Strings.splitString(numberFormat.format((float)lastMonth.getUserRetainedTotal() / (float)ppUserTotal * 100));
			double slpUserRe = slUserRe-lpUserRe;
		
		活跃用户留存率
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
			
		活跃用户留存占比增量
			double actUserRe = ActUserReRate-lpActUserReRate;
			
		活跃用户占比增长率
			double ActUserRate = Strings.splitString(numberFormat.format((float) actUserRe / (float) lpActUserReRate * 100));
			
		应用操作异常率
			double startExceRate = Strings.splitString(numberFormat.format((float) startExceTotal / (float) startTotal * 100));
		
		当月应用异常率
			double applicationExceRate = Strings.splitString(numberFormat.format((float) sameMonth.getApplicationExceTotal() / (float) sameMonth.getApplicationStartTotal() * 100));
			
		应用异常增长率
			int slApplicationExce = sameMonth.getApplicationExceTotal()-lastMonth.getApplicationExceTotal();
			double slApplicationExceRate = Strings.splitString(numberFormat.format((float) slApplicationExce / (float) lastMonth.getApplicationExceTotal() * 100));
			
		页面异常率
			double pageVisitExceRate = Strings.splitString(numberFormat.format((float) visitExceTotal / (float) visitPageTotal * 100));
		
		当月页面异常率
			double sPageExceRate = Strings.splitString(numberFormat.format((float) sameMonth.getPageExceTotal() / (float) sameMonth.getPageVisitTotal() * 100));
		
		当月页面异常增长率
			int slPageExce = sameMonth.getPageExceTotal()-lastMonth.getPageExceTotal();
			double slPageExceRate = Strings.splitString(numberFormat.format((float) slPageExce / (float) lastMonth.getPageExceTotal() * 100));
		
		用户评价率
			double cvRate = Strings.splitString(numberFormat.format((float) comments / (float) visitTotal * 100));
			
		用户好评率
			double pc = Strings.splitString(numberFormat.format((float) praise / (float) comments * 100));
			
		用户好评增长率
			int slp = sameMonth.getUserPraiseTotal()-lastMonth.getUserPraiseTotal();
			double slpRate = Strings.splitString(numberFormat.format((float) slp / (float) lastMonth.getUserPraiseTotal() * 100));
		
		用户评价增长率
			int slc = sameMonth.getUserCommentsTotal()-lastMonth.getUserCommentsTotal();
			double slcRate = Strings.splitString(numberFormat.format((float) slc / (float) lastMonth.getUserCommentsTotal() * 100));
		
		核心事件完成率
			
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
			double feRate = Strings.splitString(numberFormat.format((float) finishNum / (float) eventNum * 100));
			
		渠道总量
			List<ChannelPromotion> channelList = channelService.reportChannel(params);
//			model.addAttribute("channelNum", channelList.size());
			
		用户增长最多渠道
		
//			model.addAttribute("channelName", "应用宝");
			
		留存率最高渠道
		
//			model.addAttribute("channelH", "豌豆荚");
			
	
			List<ReportMenu> queryReportMenu = reportMenuService.queryReportMenu();
			
//			List<ReportData> queryReportData = reortDataService.queryReportData();
			
//			for (ReportData rd : queryReportData) {
				
				for (ReportMenu rm : queryReportMenu) {
					
				}
				
//			}
	
	*/}
}
