package com.ut.mini.crashhandler;

import java.util.Map;

/* compiled from: Taobao */
public interface IUTCrashCaughtListner {
    Map<String, String> onCrashCaught(Thread thread, Throwable th);
}
