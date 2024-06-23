package com.taobao.aranger.intf;

import androidx.annotation.Keep;

@Keep
/* compiled from: Taobao */
public interface IServiceProxy {
    void create(String str, Object... objArr) throws Exception;

    Object invoke(String str, Object[] objArr) throws Exception;
}
