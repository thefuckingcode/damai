package com.taobao.monitor.performance;

/* compiled from: Taobao */
public interface IApmAdapterFactory {
    IWXApmAdapter createApmAdapter();

    IWXApmAdapter createApmAdapterByType(String str);
}
