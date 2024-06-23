package com.youku.arch.beast.apas;

/* compiled from: Taobao */
public class Namespace {
    private long mNativeId;

    public Namespace(long j) {
        this.mNativeId = j;
    }

    public native Config getConfig(int i);
}
