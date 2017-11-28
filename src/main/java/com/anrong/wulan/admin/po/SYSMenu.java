package com.anrong.wulan.admin.po;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class SYSMenu implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    @JsonIgnore
    private String url;

    @JsonProperty("pId")
    private Integer pid;

    @JsonIgnore
    private String iconstyle;
    
    private Boolean checked = false; //非数据库字段

    public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIconstyle() {
        return iconstyle;
    }

    public void setIconstyle(String iconstyle) {
        this.iconstyle = iconstyle == null ? null : iconstyle.trim();
    }
}