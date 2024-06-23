package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.nf0;

@GwtIncompatible
/* compiled from: Taobao */
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
    private final nf0 executionList = new nf0();

    ListenableFutureTask(Callable<V> callable) {
        super(callable);
    }

    public static <V> ListenableFutureTask<V> create(Callable<V> callable) {
        return new ListenableFutureTask<>(callable);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.executionList.a(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public void done() {
        this.executionList.b();
    }

    public static <V> ListenableFutureTask<V> create(Runnable runnable, @NullableDecl V v) {
        return new ListenableFutureTask<>(runnable, v);
    }

    ListenableFutureTask(Runnable runnable, @NullableDecl V v) {
        super(runnable, v);
    }
}
