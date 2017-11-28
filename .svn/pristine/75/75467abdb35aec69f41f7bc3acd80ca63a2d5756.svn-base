package com.anrong.wulan.admin.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 研报里面的数据
 * @author ZYJ
 */
public class ReportData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4168414321303891465L;

	private Integer id ;
	
	/*研报菜单ID*/
	private Integer rmid;
	
	/*研报数据字段名称*/
	private String name;
	
	/*数据结果*/
	private Double data;
	
	/*类型*/
	private String type;
	
	/*权重*/
	private Integer weight;
	
	/*存入时间*/
	private Date date;
	
	/*评价阶段数据第一*/
	private Integer firdata;
	
	/*评价阶段数据第二*/
	private Integer sdata;
	
	/*评价阶段数据第三*/
	private Integer thirdata;
	
	/*评价阶段数据第四*/
	private Integer fordata;
	
	/*评价阶段数据第五*/
	private Integer fivdata;
	

	public ReportData() {
		super();
	}

	public ReportData(Integer rmid, String name, Double data, String type, Integer weight, Date date) {
		super();
		this.rmid = rmid;
		this.name = name;
		this.data = data;
		this.type = type;
		this.weight = weight;
		this.date = date;
	}



	public ReportData(Integer rmid, String name, Integer weight, Integer firdata, Integer sdata,
			Integer thirdata, Integer fordata, Integer fivdata) {
		super();
		this.rmid = rmid;
		this.name = name;
		this.weight = weight;
		this.firdata = firdata;
		this.sdata = sdata;
		this.thirdata = thirdata;
		this.fordata = fordata;
		this.fivdata = fivdata;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRmid() {
		return rmid;
	}

	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getData() {
		return data;
	}

	public void setData(Double data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getFirdata() {
		return firdata;
	}

	public void setFirdata(Integer firdata) {
		this.firdata = firdata;
	}

	public Integer getSdata() {
		return sdata;
	}

	public void setSdata(Integer sdata) {
		this.sdata = sdata;
	}

	public Integer getThirdata() {
		return thirdata;
	}

	public void setThirdata(Integer thirdata) {
		this.thirdata = thirdata;
	}

	public Integer getFordata() {
		return fordata;
	}

	public void setFordata(Integer fordata) {
		this.fordata = fordata;
	}

	public Integer getFivdata() {
		return fivdata;
	}

	public void setFivdata(Integer fivdata) {
		this.fivdata = fivdata;
	}

	@Override
	public String toString() {
		return "ReportData [id=" + id + ", rmid=" + rmid + ", name=" + name + ", data=" + data + ", type=" + type
				+ ", weight=" + weight + ", date=" + date + ", firdata=" + firdata + ", sdata=" + sdata + ", thirdata="
				+ thirdata + ", fordata=" + fordata + ", fivdata=" + fivdata + "]";
	}

}
