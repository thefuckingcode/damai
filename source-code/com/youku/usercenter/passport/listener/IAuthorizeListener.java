package com.youku.usercenter.passport.listener;

/* compiled from: Taobao */
public interface IAuthorizeListener {
    void onExitApp();

    void onExpireLogout();

    void onUserLogin();

    void onUserLogout();
}
