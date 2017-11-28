package com.anrong.wulan.admin.po;

import java.util.Date;

public class AnalyzePage {
    private Long id;

    private String pagecode;

    private String name;

    private Long totalnumber;

    private Long totaltimes;

    private Float totalnumberproportion;

    private Float totaltimesproportion;

    private Long stayaverage;

    private Float departurerate;

    private Date currentday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPagecode() {
        return pagecode;
    }

    public void setPagecode(String pagecode) {
        this.pagecode = pagecode == null ? null : pagecode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getTotalnumber() {
        return totalnumber;
    }

    public void setTotalnumber(Long totalnumber) {
        this.totalnumber = totalnumber;
    }

    public Long getTotaltimes() {
        return totaltimes;
    }

    public void setTotaltimes(Long totaltimes) {
        this.totaltimes = totaltimes;
    }

    public Float getTotalnumberproportion() {
        return totalnumberproportion;
    }

    public void setTotalnumberproportion(Float totalnumberproportion) {
        this.totalnumberproportion = totalnumberproportion;
    }

    public Float getTotaltimesproportion() {
        return totaltimesproportion;
    }

    public void setTotaltimesproportion(Float totaltimesproportion) {
        this.totaltimesproportion = totaltimesproportion;
    }

    public Long getStayaverage() {
        return stayaverage;
    }

    public void setStayaverage(Long stayaverage) {
        this.stayaverage = stayaverage;
    }

    public Float getDeparturerate() {
        return departurerate;
    }

    public void setDeparturerate(Float departurerate) {
        this.departurerate = departurerate;
    }

    public Date getCurrentday() {
        return currentday;
    }

    public void setCurrentday(Date currentday) {
        this.currentday = currentday;
    }
}