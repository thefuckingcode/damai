package com.alibaba.android.onescheduler.threadpool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import tb.nf0;

/* compiled from: Taobao */
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
    private final nf0 executionList = new nf0();

    ListenableFutureTask(@NonNull Callable<V> callable) {
        super(callable);
    }

    @NonNull
    public static <V> ListenableFutureTask<V> create(@NonNull Callable<V> callable) {
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

    @Nullable
    public static <V> ListenableFutureTask<V> create(@NonNull Runnable runnable, @Nullable V v) {
        return new ListenableFutureTask<>(runnable, v);
    }

    ListenableFutureTask(@NonNull Runnable runnable, @Nullable V v) {
        super(runnable, v);
    }
}
