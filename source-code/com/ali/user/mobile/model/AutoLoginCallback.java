package com.ali.user.mobile.model;

/* compiled from: Taobao */
public interface AutoLoginCallback {
    void onBizFail(int i, String str);

    void onNetworkError();

    void onSuccess();
}
