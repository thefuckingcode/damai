package com.youku.playerservice.axp.interceptor;

/* compiled from: Taobao */
public interface Chain {
    int getAction();

    <T> T getParam();

    void proceed();

    <T> void setParam(T t);
}
