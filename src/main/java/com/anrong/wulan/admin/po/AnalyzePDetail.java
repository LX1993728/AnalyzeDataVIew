package com.anrong.wulan.admin.po;

import java.util.Date;

public class AnalyzePDetail {
    private Long id;

    private String name;

    private Integer type;

    private String targetname;

    private String mode;

    private Long stayaverage;

    private Date currentday;

    private Long times;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTargetname() {
        return targetname;
    }

    public void setTargetname(String targetname) {
        this.targetname = targetname == null ? null : targetname.trim();
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    public Long getStayaverage() {
        return stayaverage;
    }

    public void setStayaverage(Long stayaverage) {
        this.stayaverage = stayaverage;
    }

    public Date getCurrentday() {
        return currentday;
    }

    public void setCurrentday(Date currentday) {
        this.currentday = currentday;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }
}