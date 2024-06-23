package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.IPoint;

/* compiled from: Taobao */
public class MultiPointItem {
    private String customerId = null;
    private IPoint iPoint;
    private LatLng latLng;
    private Object object;
    private String snippet;
    private String title;

    public MultiPointItem(LatLng latLng2) {
        this.latLng = latLng2;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MultiPointItem)) {
            return false;
        }
        if (this.customerId != null) {
            MultiPointItem multiPointItem = (MultiPointItem) obj;
            if (multiPointItem.getCustomerId() != null) {
                return this.customerId.equals(multiPointItem.getCustomerId());
            }
        }
        return super.equals(obj);
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public IPoint getIPoint() {
        return this.iPoint;
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

    public Object getObject() {
        return this.object;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public void setIPoint(IPoint iPoint2) {
        this.iPoint = iPoint2;
    }

    public void setLatLng(LatLng latLng2) {
        this.latLng = latLng2;
    }

    public void setObject(Object obj) {
        this.object = obj;
    }

    public void setSnippet(String str) {
        this.snippet = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
