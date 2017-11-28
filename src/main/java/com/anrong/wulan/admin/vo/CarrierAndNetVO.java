package com.anrong.wulan.admin.vo;

import java.io.Serializable;

public class CarrierAndNetVO implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String carrier;
    
    private String network;
    
    private int newUser;
    
    private String newUserRate;
    
    private int start;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public int getNewUser() {
        return newUser;
    }

    public void setNewUser(int newUser) {
        this.newUser = newUser;
    }

    public String getNewUserRate() {
        return newUserRate;
    }

    public void setNewUserRate(String newUserRate) {
        this.newUserRate = newUserRate;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
    
    
    
    

}
