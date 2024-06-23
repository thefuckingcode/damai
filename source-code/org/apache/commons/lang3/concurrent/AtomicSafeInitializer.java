package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Taobao */
public abstract class AtomicSafeInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<AtomicSafeInitializer<T>> factory = new AtomicReference<>();
    private final AtomicReference<T> reference = new AtomicReference<>();

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public final T get() throws ConcurrentException {
        while (true) {
            T t = this.reference.get();
            if (t != null) {
                return t;
            }
            if (this.factory.compareAndSet(null, this)) {
                this.reference.set(initialize());
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract T initialize() throws ConcurrentException;
}
