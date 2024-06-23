package com.ali.user.mobile.login.ui;

/* compiled from: Taobao */
public interface OneKeyLoginView extends BaseLoginView {
    void onGetAccessTokenFail();

    void onNeedVerifyMobileForReg(String str, String str2);

    void waitTokenLogin(String str, long j);
}
