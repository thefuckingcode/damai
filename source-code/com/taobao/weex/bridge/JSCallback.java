package com.taobao.weex.bridge;

/* compiled from: Taobao */
public interface JSCallback {
    void invoke(Object obj);

    void invokeAndKeepAlive(Object obj);
}
