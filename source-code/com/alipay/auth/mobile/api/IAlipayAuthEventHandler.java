package com.alipay.auth.mobile.api;

/* compiled from: Taobao */
public interface IAlipayAuthEventHandler {
    void alipayAuthDidCancel();

    void alipayAuthFailure();

    void alipayAuthSuccess(String str);
}
