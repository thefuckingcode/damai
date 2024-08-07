package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.t;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@CanIgnoreReturnValue
@GwtCompatible
/* compiled from: Taobao */
public abstract class g<V> extends t implements Future<V> {
    protected g() {
    }

    /* access modifiers changed from: protected */
    public abstract Future<? extends V> a();

    public boolean cancel(boolean z) {
        return a().cancel(z);
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return (V) a().get();
    }

    public boolean isCancelled() {
        return a().isCancelled();
    }

    public boolean isDone() {
        return a().isDone();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (V) a().get(j, timeUnit);
    }
}
