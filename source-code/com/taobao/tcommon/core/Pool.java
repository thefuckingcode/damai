package com.taobao.tcommon.core;

/* compiled from: Taobao */
public interface Pool<T> {
    T offer();

    boolean recycle(T t);
}
