package com.xiaomi.channel.commonutils.logger;

/* compiled from: Taobao */
public interface LoggerInterface {
    void log(String str);

    void log(String str, Throwable th);

    void setTag(String str);
}
