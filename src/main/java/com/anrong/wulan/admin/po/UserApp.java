package com.anrong.wulan.admin.po;

import java.io.Serializable;

public class UserApp implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private long userId;

	private long appInfoId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getAppInfoId() {
		return appInfoId;
	}

	public void setAppInfoId(long appInfoId) {
		this.appInfoId = appInfoId;
	}

}
