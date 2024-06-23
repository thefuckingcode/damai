package com.alibaba.analytics.core.selfmonitor;

/* compiled from: Taobao */
public interface CrashListener {
    void onCrash(Thread thread, Throwable th);
}
