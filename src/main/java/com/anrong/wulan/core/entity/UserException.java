package com.anrong.wulan.core.entity;

/**
 * 用户自定义异常
 * 
 * @author Joshua
 * 
 */
public class UserException extends RuntimeException {

	private static final long serialVersionUID = -6522329537755042518L;
	/**
	 * 异常发生的时间
	 */
	private long date = System.currentTimeMillis();
	
	
	public UserException() {
	}
	
	public UserException(String message){
		super(message);
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

}
