package com.huawei.agconnect.core.service.auth;

/* compiled from: Taobao */
public interface TokenSnapshot {

    /* compiled from: Taobao */
    public enum State {
        SIGNED_IN,
        TOKEN_UPDATED,
        TOKEN_INVALID,
        SIGNED_OUT
    }

    State getState();

    String getToken();
}
