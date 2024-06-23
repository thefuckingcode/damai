package com.taobao.weex.devtools.common;

/* compiled from: Taobao */
public interface ThreadBound {
    boolean checkThreadAccess();

    <V> V postAndWait(UncheckedCallable<V> uncheckedCallable);

    void postAndWait(Runnable runnable);

    void postDelayed(Runnable runnable, long j);

    void removeCallbacks(Runnable runnable);

    void verifyThreadAccess();
}
