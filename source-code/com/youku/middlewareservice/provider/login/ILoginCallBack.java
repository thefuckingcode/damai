package com.youku.middlewareservice.provider.login;

/* compiled from: Taobao */
public interface ILoginCallBack {
    void isInLoginState();

    void onCancel();

    void onFailed();

    void onLogout();

    void onSuccess();
}
