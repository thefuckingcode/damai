package com.ta.utdid2.device;

@Deprecated
/* compiled from: Taobao */
public class Device {
    private String deviceId = "";
    private String imei = "";
    private String imsi = "";
    private long mCheckSum = 0;
    private long mCreateTimestamp = 0;
    private String utdid = "";

    /* access modifiers changed from: package-private */
    public long getCheckSum() {
        return this.mCheckSum;
    }

    /* access modifiers changed from: package-private */
    public long getCreateTimestamp() {
        return this.mCreateTimestamp;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getUtdid() {
        return this.utdid;
    }

    /* access modifiers changed from: package-private */
    public void setCheckSum(long j) {
        this.mCheckSum = j;
    }

    /* access modifiers changed from: package-private */
    public void setCreateTimestamp(long j) {
        this.mCreateTimestamp = j;
    }

    /* access modifiers changed from: package-private */
    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    /* access modifiers changed from: package-private */
    public void setImei(String str) {
        this.imei = str;
    }

    /* access modifiers changed from: package-private */
    public void setImsi(String str) {
        this.imsi = str;
    }

    /* access modifiers changed from: package-private */
    public void setUtdid(String str) {
        this.utdid = str;
    }
}
