package com.taobao.aranger.intf;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public interface IDataFlow<T> {
    void readFromObject(T t);
}
