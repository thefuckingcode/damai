package com.youku.gaiax.quickjs;

/* compiled from: Taobao */
public interface BridgeModuleListener {
    long callAsync(long j, long j2, String str);

    long callPromise(long j, String str);

    long callSync(long j, String str);

    void wrapAsJSValueException(Exception exc);
}
