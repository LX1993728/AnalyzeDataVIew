package com.anrong.wulan.admin.po;

import java.io.Serializable;

public class AppPlatform implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private int id;
    
    private String appKey;
    
    private String platform;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
    
    

}
