package com.taobao.tao.log.monitor;

/* compiled from: Taobao */
public interface TLogMonitor {
    void stageError(String str, String str2, String str3);

    void stageError(String str, String str2, Throwable th);

    void stageInfo(String str, String str2, String str3);
}
