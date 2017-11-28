package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZYJ
 * 
 */
public class AgeDistribution implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1841803071110077520L;

	private Integer id;
	
	private String name;
	/*平台类型*/
	private String logType;
    
	/*程序id*/
    private String appKey;
    
    /*时间*/
    private Date statisticsDate;
    
    /*年龄*/
    private Integer age;
    
    /*数量*/
    private Integer number;
    
    /*性别*/
    private Integer sex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public Date getStatisticsDate() {
		return statisticsDate;
	}

	public void setStatisticsDate(Date statisticsDate) {
		this.statisticsDate = statisticsDate;
	}


	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "AgeDistribution [id=" + id + ", name=" + name + ", logType=" + logType + ", appKey=" + appKey
				+ ", statisticsDate=" + statisticsDate + ", age=" + age + ", number=" + number + ",sex=" + sex + "]";
	}
}
