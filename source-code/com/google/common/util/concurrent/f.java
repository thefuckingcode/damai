package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import tb.ds1;

@GwtCompatible
/* compiled from: Taobao */
final class f<V> extends e<V> {
    private final ListenableFuture<V> a;

    f(ListenableFuture<V> listenableFuture) {
        this.a = (ListenableFuture) ds1.p(listenableFuture);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture, com.google.common.util.concurrent.AbstractFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.a.addListener(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean cancel(boolean z) {
        return this.a.cancel(z);
    }

    @Override // java.util.concurrent.Future, com.google.common.util.concurrent.AbstractFuture
    public V get() throws InterruptedException, ExecutionException {
        return this.a.get();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean isCancelled() {
        return this.a.isCancelled();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean isDone() {
        return this.a.isDone();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String toString() {
        return this.a.toString();
    }

    @Override // java.util.concurrent.Future, com.google.common.util.concurrent.AbstractFuture
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.a.get(j, timeUnit);
    }
}
