package com.alimm.xadsdk.base.net;

import java.util.List;

/* compiled from: Taobao */
public class AdNetResponse {
    private byte[] mBytes;
    private boolean mCallSucceed;
    private List<String> mCookies;
    private int mErrorCode = 0;
    private String mErrorMsg;
    private int mResponseCode = -1;

    public AdNetResponse(int i, String str, int i2, byte[] bArr) {
        this.mErrorCode = i;
        this.mErrorMsg = str;
        this.mResponseCode = i2;
        this.mBytes = bArr;
    }

    public byte[] getBytes() {
        return this.mBytes;
    }

    public List<String> getCookies() {
        return this.mCookies;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public boolean isCallSucceed() {
        return this.mCallSucceed;
    }

    public void setBytes(byte[] bArr) {
        this.mBytes = bArr;
    }

    public void setCallSucceed(boolean z) {
        this.mCallSucceed = z;
    }

    public void setCookies(List<String> list) {
        this.mCookies = list;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public void setErrorMsg(String str) {
        this.mErrorMsg = str;
    }

    public void setResponseCode(int i) {
        this.mResponseCode = i;
    }
}
