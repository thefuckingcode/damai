package com.taobao.monitor.impl.trace;

/* compiled from: Taobao */
public interface IDispatcher<LISTENER> {
    void addListener(LISTENER listener);

    void removeListener(LISTENER listener);
}
