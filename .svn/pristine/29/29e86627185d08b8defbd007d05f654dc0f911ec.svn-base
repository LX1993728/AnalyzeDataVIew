package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZYJ
 * 用户分析
 * */
public class UserAnalysis implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6176797293500350359L;
	
	/*id*/
	private Integer id;
	
	/*平台类型*/
	private String logType;
    
	/*程序id*/
    private String appKey;
    
    /*时间*/
    private Date statisticsDate;
    
    /*性别*/
    private String sex;
    
    /*年龄*/
    private Integer age;
    
    /*数量*/
    private Integer number;
    
    /*行业名称*/
    private String industryName;
    
    /*行业数量*/
    private Integer indusNumber;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public Integer getIndusNumber() {
		return indusNumber;
	}

	public void setIndusNumber(Integer indusNumber) {
		this.indusNumber = indusNumber;
	}

	
	
	public UserAnalysis() {
		super();
	}

	
	public UserAnalysis(Integer indusNumber) {
		super();
		this.indusNumber = indusNumber;
	}

	public UserAnalysis(String industryName, Integer indusNumber) {
		super();
		this.industryName = industryName;
		this.indusNumber = indusNumber;
	}

	@Override
	public String toString() {
		return "UserAnalysis [id=" + id + ", logType=" + logType + ", appKey=" + appKey + ", statisticsDate="
				+ statisticsDate + ", sex=" + sex + ", age=" + age + ", number=" + number + ", industryname="
				+ industryName + ", indusNumber=" + indusNumber + "]";
	}

}
