package com.taobao.tao.remotebusiness.auth;

/* compiled from: Taobao */
public interface IRemoteAuth {
    void authorize(String str, String str2, String str3, boolean z, AuthListener authListener);

    String getAuthToken();

    boolean isAuthInfoValid();

    boolean isAuthorizing();
}
