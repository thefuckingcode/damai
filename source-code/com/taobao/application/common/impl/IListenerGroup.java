package com.taobao.application.common.impl;

/* compiled from: Taobao */
public interface IListenerGroup<T> {
    void addListener(T t);

    void removeListener(T t);
}
