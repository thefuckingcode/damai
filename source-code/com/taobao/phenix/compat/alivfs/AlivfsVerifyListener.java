package com.taobao.phenix.compat.alivfs;

/* compiled from: Taobao */
public interface AlivfsVerifyListener {
    long getCurrentTime();

    boolean isExpectedTime(long j);

    boolean isTTLDomain(String str);
}
