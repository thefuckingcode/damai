package com.taobao.application.common.impl;

/* compiled from: Taobao */
public interface ICallbackGroup<T> {
    void addCallback(T t);

    void removeCallback(T t);
}
