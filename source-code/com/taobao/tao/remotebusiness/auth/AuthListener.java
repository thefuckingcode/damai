package com.taobao.tao.remotebusiness.auth;

/* compiled from: Taobao */
public interface AuthListener {
    void onAuthCancel(String str, String str2);

    void onAuthFail(String str, String str2);

    void onAuthSuccess();
}
