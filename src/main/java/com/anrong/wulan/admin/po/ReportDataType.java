package com.anrong.wulan.admin.po;

/**
 * @author ZYJ
 * 研报数据类型
 */
public class ReportDataType {

	/*本月用户增量*/
	private static final String ADD_User="au";
	
	/*用户环比增长率*/
	private static final String ADD_USER_RATE = "aur";
	
	/*新增用户环比增长率*/
	private static final String NEW_USER_ADD_RATE="nuar";
	
	/*活跃用户增量*/
	private static final String ACT_USER_ADD = "aua";
	
	/*活跃用户增长率*/
	private static final String ACT_USER_ADD_RATE="auar";
	
	/*活跃用户占比增量*/
	private static final String ACT_USER_PRO="aup";
	
	/*活跃用户占比增长率*/
	private static final String ACT_USER_PRO_RATE="aupr";
	
	/*用户留存增量*/
	private static final String USER_RETA_PRO ="urp";
	
	/*用户留存率增量*/
	private static final String USER_RETA_RATE_pro ="urrpo";
	
	/*活跃用户留存率*/
	private static final String ACT_USER_RETA_RATE ="aurr";
	
	/*活跃用户留存占比增量*/
	private static final String ACT_USER_RETA_PRO= "aurp";
	
	/*活跃用户留存占比增长率*/
	private static final String ACT_USER_RETA_PRO_RATE = "aurpr";
	
	/*应用操作异常率*/
	private static final String APP_RATE="ar";
	
	/*当月应用异常率*/
	private static final String SAME_APPEXCE_RATE = "sar";
	
	/*应用异常增长率*/
	private static final String APPEXCE_PRO_RATE = "apr";
	
	/*页面异常率*/
	private static final String PAGE_EXCE_RATE = "per";
	
	/*当月页面异常率*/
	private static final String SAME_PAGE_EXCE_RATE = "sper";
	
	/*当月页面异常增长率*/
	private static final String SAME_PAGE_EXCE_PRO_RATE = "spepr";
	
	/*用户评价率*/
	private static final String USER_COMM_RATE = "ucr";
	
	/*用户好评率*/
	private static final String USER_PER_RATE = "upr";
	
	/*用户好评增长率*/
	private static final String USER_PER_PRO_RATE = "uppr";
	
	/*用户评价增长率*/
	private static final String USER_COMM_RETA_RATE="ucrr";
	
	/*核心事件完成率*/
	private static final String CORE_EVENT_FINISH_RATE = "cefr";
	
	/*渠道总量*/
	private static final String CHANNEL_TOTAL = "ct";
	
	/*用户增长最多渠道*/
	private static final String USER_CHANNEL_PRO="ucp";
	
	/*留存率最高渠道*/
	private static final String CHANNEL_RATE_B="crb";
}
