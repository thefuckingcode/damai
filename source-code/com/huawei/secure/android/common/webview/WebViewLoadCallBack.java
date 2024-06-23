package com.huawei.secure.android.common.webview;

/* compiled from: Taobao */
public interface WebViewLoadCallBack {

    /* compiled from: Taobao */
    public enum ErrorCode {
        HTTP_URL,
        URL_NOT_IN_WHITE_LIST,
        OTHER
    }

    void onCheckError(String str, ErrorCode errorCode);
}
