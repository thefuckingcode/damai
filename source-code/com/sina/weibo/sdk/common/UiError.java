package com.sina.weibo.sdk.common;

/* compiled from: Taobao */
public class UiError {
    public int errorCode;
    public String errorDetail;
    public String errorMessage;

    public UiError(int i, String str, String str2) {
        this.errorCode = i;
        this.errorMessage = str;
        this.errorDetail = str2;
    }
}
