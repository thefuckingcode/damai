package com.huawei.hms.common.data;

/* compiled from: Taobao */
public interface Freezable<T> {
    T freeze();

    boolean isDataValid();
}
