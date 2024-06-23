package com.taobao.tao.remotebusiness.login;

/* compiled from: Taobao */
public interface IRemoteLogin {
    LoginContext getLoginContext();

    boolean isLogining();

    boolean isSessionValid();

    void login(onLoginListener onloginlistener, boolean z);
}
