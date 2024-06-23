package com.taobao.android.utils.pools;

/* compiled from: Taobao */
public interface Pools$Pool<T> {
    T acquire();

    boolean release(T t);

    void shutdown();
}
