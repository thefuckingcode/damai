package com.alibaba.motu.crashreporter;

/* compiled from: Taobao */
public class NativeCrashContext {
    public final long faultAddress;
    public final long threadId;

    public NativeCrashContext(long j, long j2) {
        this.faultAddress = j;
        this.threadId = j2;
    }
}
