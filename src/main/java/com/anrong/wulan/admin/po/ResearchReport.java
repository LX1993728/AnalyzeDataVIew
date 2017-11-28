package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZYJ
 *
 * 研报（除了事件和渠道）
 */

public class ResearchReport implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7380583935326388439L;

	/*id*/
	private Integer id;
	
	/*时间*/
	private Date date;
	
	/*用户总量*/
	private Integer userTotal;

	/*活跃用户总量*/
	private Integer activeUserTotal;

	/*用户留存总量*/
	private Integer userRetainedTotal;

	/*活跃用户留存总量*/
	private Integer activeUserRetainedTotal;

	/*应用异常总数*/
	private Integer applicationExceTotal;

	/*应用启动总次数*/
	private Integer applicationStartTotal;

	/*页面异常总数*/
	private Integer pageExceTotal;

	/*页面访问总数*/
	private Integer pageVisitTotal;

	/*用户评论总数*/
	private Integer userCommentsTotal;

	/*用户好评总数*/
	private Integer userPraiseTotal;

	/*用户访问评论模块总数*/
	private Integer visitTotal;
	
	/*未评论数*/
	private Integer noComments;
	
	public Integer getNoComments() {
		return noComments;
	}

	public void setNoComments(Integer noComments) {
		this.noComments = noComments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getUserTotal() {
		return userTotal;
	}

	public void setUserTotal(Integer userTotal) {
		this.userTotal = userTotal;
	}

	public Integer getActiveUserTotal() {
		return activeUserTotal;
	}

	public void setActiveUserTotal(Integer activeUserTotal) {
		this.activeUserTotal = activeUserTotal;
	}

	public Integer getUserRetainedTotal() {
		return userRetainedTotal;
	}

	public void setUserRetainedTotal(Integer userRetainedTotal) {
		this.userRetainedTotal = userRetainedTotal;
	}

	public Integer getActiveUserRetainedTotal() {
		return activeUserRetainedTotal;
	}

	public void setActiveUserRetainedTotal(Integer activeUserRetainedTotal) {
		this.activeUserRetainedTotal = activeUserRetainedTotal;
	}

	public Integer getApplicationExceTotal() {
		return applicationExceTotal;
	}

	public void setApplicationExceTotal(Integer applicationExceTotal) {
		this.applicationExceTotal = applicationExceTotal;
	}

	public Integer getApplicationStartTotal() {
		return applicationStartTotal;
	}

	public void setApplicationStartTotal(Integer applicationStartTotal) {
		this.applicationStartTotal = applicationStartTotal;
	}

	public Integer getPageExceTotal() {
		return pageExceTotal;
	}

	public void setPageExceTotal(Integer pageExceTotal) {
		this.pageExceTotal = pageExceTotal;
	}

	public Integer getPageVisitTotal() {
		return pageVisitTotal;
	}

	public void setPageVisitTotal(Integer pageVisitTotal) {
		this.pageVisitTotal = pageVisitTotal;
	}

	public Integer getUserCommentsTotal() {
		return userCommentsTotal;
	}

	public void setUserCommentsTotal(Integer userCommentsTotal) {
		this.userCommentsTotal = userCommentsTotal;
	}

	public Integer getUserPraiseTotal() {
		return userPraiseTotal;
	}

	public void setUserPraiseTotal(Integer userPraiseTotal) {
		this.userPraiseTotal = userPraiseTotal;
	}

	public Integer getVisitTotal() {
		return visitTotal;
	}

	public void setVisitTotal(Integer visitTotal) {
		this.visitTotal = visitTotal;
	}

	@Override
	public String toString() {
		return "ResearchReport [id=" + id + ", date=" + date + ", userTotal=" + userTotal + ", activeUserTotal="
				+ activeUserTotal + ", userRetainedTotal=" + userRetainedTotal + ", activeUserRetainedTotal="
				+ activeUserRetainedTotal + ", applicationExceTotal=" + applicationExceTotal
				+ ", applicationStartTotal=" + applicationStartTotal + ", pageExceTotal=" + pageExceTotal
				+ ", pageVisitTotal=" + pageVisitTotal + ", userCommentsTotal=" + userCommentsTotal
				+ ", userPraiseTotal=" + userPraiseTotal + ", visitTotal=" + visitTotal + "]";
	}

	
}
