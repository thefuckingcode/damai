package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Taobao */
public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<T> reference = new AtomicReference<>();

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        T t = this.reference.get();
        if (t != null) {
            return t;
        }
        T initialize = initialize();
        return !this.reference.compareAndSet(null, initialize) ? this.reference.get() : initialize;
    }

    /* access modifiers changed from: protected */
    public abstract T initialize() throws ConcurrentException;
}
