package com.taobao.downloader.adpater;

/* compiled from: Taobao */
public interface Logger {
    void debug(String str, String str2);

    void error(String str, String str2);

    void error(String str, String str2, Throwable th);

    void info(String str, String str2);

    void warn(String str, String str2);
}
