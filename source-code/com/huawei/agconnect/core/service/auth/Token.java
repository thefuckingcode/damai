package com.huawei.agconnect.core.service.auth;

/* compiled from: Taobao */
public interface Token {
    long getExpiration();

    long getIssuedAt();

    long getNotBefore();

    String getTokenString();
}
