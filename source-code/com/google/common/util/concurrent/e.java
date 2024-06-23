package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import tb.ds1;

@Beta
@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public abstract class e<V> extends i<V> {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class a<V> extends e<V> implements AbstractFuture.Trusted<V> {
        a() {
        }

        @Override // com.google.common.util.concurrent.ListenableFuture, com.google.common.util.concurrent.AbstractFuture
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        @CanIgnoreReturnValue
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // java.util.concurrent.Future, com.google.common.util.concurrent.AbstractFuture
        @CanIgnoreReturnValue
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // java.util.concurrent.Future, com.google.common.util.concurrent.AbstractFuture
        @CanIgnoreReturnValue
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }
    }

    e() {
    }

    public static <V> e<V> from(ListenableFuture<V> listenableFuture) {
        return listenableFuture instanceof e ? (e) listenableFuture : new f(listenableFuture);
    }

    public final void addCallback(FutureCallback<? super V> futureCallback, Executor executor) {
        Futures.a(this, futureCallback, executor);
    }

    @Partially$GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> e<V> catching(Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return (e) Futures.b(this, cls, function, executor);
    }

    @Partially$GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    public final <X extends Throwable> e<V> catchingAsync(Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return (e) Futures.c(this, cls, asyncFunction, executor);
    }

    public final <T> e<T> transform(Function<? super V, T> function, Executor executor) {
        return (e) Futures.g(this, function, executor);
    }

    public final <T> e<T> transformAsync(AsyncFunction<? super V, T> asyncFunction, Executor executor) {
        return (e) Futures.h(this, asyncFunction, executor);
    }

    @GwtIncompatible
    public final e<V> withTimeout(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (e) Futures.i(this, j, timeUnit, scheduledExecutorService);
    }

    @Deprecated
    public static <V> e<V> from(e<V> eVar) {
        return (e) ds1.p(eVar);
    }
}
