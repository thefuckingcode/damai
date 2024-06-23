package com.alibaba.motu.crashreporter;

import java.util.Map;

/* compiled from: Taobao */
public interface IUTCrashCaughtListener {
    Map<String, Object> onCrashCaught(Thread thread, Throwable th);
}
