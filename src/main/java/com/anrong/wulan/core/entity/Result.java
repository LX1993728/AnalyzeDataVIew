package com.anrong.wulan.core.entity;

import java.io.Serializable;

/**
 * 响应的结果
 * @author Joshua
 *
 */
public class Result implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3162436569902112614L;
	
	/**
	 * 消息
	 */
	private String message;
	
	/**
	 * 状态码
	 */
	private String statusCode;
	
	
	/**
	 * 是否成功
	 */
	private boolean success;


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public Result() {
		super();
	}

}
