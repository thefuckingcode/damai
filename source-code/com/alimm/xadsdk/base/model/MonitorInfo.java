package com.alimm.xadsdk.base.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.common.track.model.a;

/* compiled from: Taobao */
public class MonitorInfo implements BaseInfo {
    @JSONField(name = a.C0103a.a)
    private String mSdk;
    @JSONField(name = "time")
    private int mTime;
    @JSONField(name = "url")
    private String mUrl;

    public String getSdk() {
        return this.mSdk;
    }

    public int getTime() {
        return this.mTime;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public MonitorInfo setSdk(String str) {
        this.mSdk = str;
        return this;
    }

    public MonitorInfo setTime(int i) {
        this.mTime = i;
        return this;
    }

    public MonitorInfo setUrl(String str) {
        this.mUrl = str;
        return this;
    }

    public String toString() {
        return "MonitorInfo{sdk=" + this.mSdk + ", url=" + this.mUrl + "}";
    }
}
