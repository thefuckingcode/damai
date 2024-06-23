package com.alibaba.android.ultron.vfw.core;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
public interface IServiceManager {
    <T> T getService(@NonNull Class<T> cls);

    <T> void registerService(@NonNull Class<T> cls, @NonNull T t);
}
