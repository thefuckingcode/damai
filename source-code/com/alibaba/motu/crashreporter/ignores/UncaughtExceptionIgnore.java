package com.alibaba.motu.crashreporter.ignores;

/* compiled from: Taobao */
public interface UncaughtExceptionIgnore {
    String getName();

    boolean uncaughtExceptionIgnore(Thread thread, Throwable th);
}
