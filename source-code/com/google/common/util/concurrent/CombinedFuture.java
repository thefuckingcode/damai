package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtCompatible
/* compiled from: Taobao */
final class CombinedFuture<V> extends AggregateFuture<Object, V> {

    /* compiled from: Taobao */
    private final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask {
        private final AsyncCallable<V> callable;
        final /* synthetic */ CombinedFuture this$0;

        public AsyncCallableInterruptibleTask(CombinedFuture combinedFuture, AsyncCallable<V> asyncCallable, Executor executor) {
            super(combinedFuture, executor);
            this.callable = (AsyncCallable) ds1.p(asyncCallable);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public /* bridge */ /* synthetic */ void setValue(Object obj) {
            setValue((ListenableFuture) ((ListenableFuture) obj));
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public ListenableFuture<V> runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return (ListenableFuture) ds1.r(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        /* access modifiers changed from: package-private */
        public void setValue(ListenableFuture<V> listenableFuture) {
            throw null;
        }
    }

    /* compiled from: Taobao */
    private final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask {
        private final Callable<V> callable;
        final /* synthetic */ CombinedFuture this$0;

        public CallableInterruptibleTask(CombinedFuture combinedFuture, Callable<V> callable2, Executor executor) {
            super(combinedFuture, executor);
            this.callable = (Callable) ds1.p(callable2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws Exception {
            this.thrownByExecute = false;
            return this.callable.call();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(V v) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;
        final /* synthetic */ CombinedFuture this$0;
        boolean thrownByExecute = true;

        public CombinedFutureInterruptibleTask(CombinedFuture combinedFuture, Executor executor) {
            this.listenerExecutor = (Executor) ds1.p(executor);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptibly(T t, Throwable th) {
            if (th == null) {
                setValue(t);
            } else if (th instanceof ExecutionException) {
                th.getCause();
                throw null;
            } else if (th instanceof CancellationException) {
                throw null;
            } else {
                throw null;
            }
        }

        /* access modifiers changed from: package-private */
        public final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException unused) {
                if (this.thrownByExecute) {
                    throw null;
                }
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public abstract void setValue(T t);
    }

    /* compiled from: Taobao */
    private final class CombinedFutureRunningState extends AggregateFuture<Object, V>.RunningState {
        private CombinedFutureInterruptibleTask task;
        final /* synthetic */ CombinedFuture this$0;

        CombinedFutureRunningState(CombinedFuture combinedFuture, ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z, CombinedFutureInterruptibleTask combinedFutureInterruptibleTask) {
            super(immutableCollection, z, false);
            this.task = combinedFutureInterruptibleTask;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void collectOneValue(boolean z, int i, @NullableDecl Object obj) {
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void handleAllCompleted() {
            CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.task;
            Objects.requireNonNull(combinedFutureInterruptibleTask);
            combinedFutureInterruptibleTask.execute();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void interruptTask() {
            CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.task;
            if (combinedFutureInterruptibleTask != null) {
                combinedFutureInterruptibleTask.interruptTask();
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void releaseResourcesAfterFailure() {
            super.releaseResourcesAfterFailure();
            this.task = null;
        }
    }
}
