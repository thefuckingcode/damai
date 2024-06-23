package com.alibaba.motu.crashreporter;

/* compiled from: Taobao */
public interface ICrashReportSendListener {
    void afterSend(boolean z, CrashReport crashReport);

    void beforeSend(CrashReport crashReport);

    String getName();
}
