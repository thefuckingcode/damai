package com.taobao.update.datasource.logger;

/* compiled from: Taobao */
public interface Log {
    int d(String str);

    int e(String str);

    int e(String str, Throwable th);

    int i(String str);

    int v(String str);

    int w(String str);

    int w(String str, Throwable th);
}
