package com.taobao.statistic.core;

@Deprecated
/* compiled from: Taobao */
public class Device {
    private String imei = "";
    private String imsi = "";
    private String udid = "";

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getUdid() {
        return this.udid;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public void setUdid(String str) {
        this.udid = str;
    }
}
