package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.e;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.k;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class Futures extends j {

    /* compiled from: Taobao */
    private static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> callback;
        final Future<V> future;

        CallbackListener(Future<V> future2, FutureCallback<? super V> futureCallback) {
            this.future = future2;
            this.callback = futureCallback;
        }

        public void run() {
            try {
                this.callback.onSuccess(Futures.d(this.future));
            } catch (ExecutionException e) {
                this.callback.onFailure(e.getCause());
            } catch (Error | RuntimeException e2) {
                this.callback.onFailure(e2);
            }
        }

        public String toString() {
            return e.b(this).h(this.callback).toString();
        }
    }

    /* compiled from: Taobao */
    private static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.g<V> implements Runnable {
        private ListenableFuture<V> delegate;

        NonCancellationPropagatingFuture(ListenableFuture<V> listenableFuture) {
            this.delegate = listenableFuture;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.delegate = null;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            ListenableFuture<V> listenableFuture = this.delegate;
            if (listenableFuture == null) {
                return null;
            }
            return "delegate=[" + listenableFuture + jl1.ARRAY_END_STR;
        }

        public void run() {
            ListenableFuture<V> listenableFuture = this.delegate;
            if (listenableFuture != null) {
                setFuture(listenableFuture);
            }
        }
    }

    /* compiled from: Taobao */
    private static final class a<T> {
        static /* synthetic */ void a(a aVar, ImmutableList immutableList, int i) {
            throw null;
        }
    }

    public static <V> void a(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        ds1.p(futureCallback);
        listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    @Partially$GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> b(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return AbstractCatchingFuture.create(listenableFuture, cls, function, executor);
    }

    @Partially$GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> c(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return AbstractCatchingFuture.create(listenableFuture, cls, asyncFunction, executor);
    }

    @CanIgnoreReturnValue
    public static <V> V d(Future<V> future) throws ExecutionException {
        ds1.A(future.isDone(), "Future was expected to be done: %s", future);
        return (V) q.a(future);
    }

    public static <V> ListenableFuture<V> e(Throwable th) {
        ds1.p(th);
        return new k.a(th);
    }

    public static <V> ListenableFuture<V> f(@NullableDecl V v) {
        if (v == null) {
            return k.b.c;
        }
        return new k.b(v);
    }

    @Beta
    public static <I, O> ListenableFuture<O> g(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, function, executor);
    }

    @Beta
    public static <I, O> ListenableFuture<O> h(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, asyncFunction, executor);
    }

    @Beta
    @GwtIncompatible
    public static <V> ListenableFuture<V> i(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        return TimeoutFuture.d(listenableFuture, j, timeUnit, scheduledExecutorService);
    }
}
