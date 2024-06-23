package com.youku.alixplayer.opensdk.interceptor;

/* compiled from: Taobao */
public interface Chain<T> {
    int getAction();

    T getParam();

    void proceed();

    void setParam(T t);
}
