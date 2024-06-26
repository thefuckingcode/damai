package com.youku.alixplugin;

import com.youku.kubus.NoProguard;
import java.lang.ref.WeakReference;

@NoProguard
/* compiled from: Taobao */
class RelayWeakReference<T> {
    private Callable<T> mGetResult;
    private WeakReference<T> mRealObj;

    /* compiled from: Taobao */
    public interface Callable<V> {
        V call();
    }

    public RelayWeakReference(T t, Callable<T> callable) {
        this.mRealObj = new WeakReference<>(t);
        this.mGetResult = callable;
    }

    public T get() {
        T t = this.mRealObj.get();
        if (t != null) {
            return t;
        }
        T call = this.mGetResult.call();
        if (call != null) {
            this.mRealObj = new WeakReference<>(call);
            return call;
        }
        throw new IllegalStateException("mGetResult.call() is null");
    }
}
