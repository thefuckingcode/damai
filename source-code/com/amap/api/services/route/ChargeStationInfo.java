package com.amap.api.services.route;

import com.amap.api.services.core.LatLonPoint;

/* compiled from: Taobao */
public class ChargeStationInfo {
    private int a;
    private LatLonPoint b;
    private LatLonPoint c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    public int getAmperage() {
        return this.l;
    }

    public String getBrandName() {
        return this.f;
    }

    public int getChargePercent() {
        return this.h;
    }

    public int getChargeTime() {
        return this.i;
    }

    public int getMaxPower() {
        return this.g;
    }

    public String getName() {
        return this.e;
    }

    public String getPoiId() {
        return this.d;
    }

    public LatLonPoint getProjectivePoint() {
        return this.c;
    }

    public int getRemainingCapacity() {
        return this.j;
    }

    public LatLonPoint getShowPoint() {
        return this.b;
    }

    public int getStepIndex() {
        return this.a;
    }

    public int getVoltage() {
        return this.k;
    }

    public void setAmperage(int i2) {
        this.l = i2;
    }

    public void setBrandName(String str) {
        this.f = str;
    }

    public void setChargePercent(int i2) {
        this.h = i2;
    }

    public void setChargeTime(int i2) {
        this.i = i2;
    }

    public void setMaxPower(int i2) {
        this.g = i2;
    }

    public void setName(String str) {
        this.e = str;
    }

    public void setPoiId(String str) {
        this.d = str;
    }

    public void setProjectivePoint(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public void setRemainingCapacity(int i2) {
        this.j = i2;
    }

    public void setShowPoint(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void setStepIndex(int i2) {
        this.a = i2;
    }

    public void setVoltage(int i2) {
        this.k = i2;
    }
}
