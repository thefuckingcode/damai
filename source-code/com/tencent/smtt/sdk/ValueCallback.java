package com.tencent.smtt.sdk;

public interface ValueCallback<T> extends android.webkit.ValueCallback<T> {
    @Override // android.webkit.ValueCallback
    void onReceiveValue(T t);
}
