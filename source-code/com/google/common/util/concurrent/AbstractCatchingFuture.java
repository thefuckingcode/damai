package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.util.concurrent.e;
import com.google.errorprone.annotations.ForOverride;
import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

/* access modifiers changed from: package-private */
@GwtCompatible
/* compiled from: Taobao */
public abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends e.a<V> implements Runnable {
    @NullableDecl
    Class<X> exceptionType;
    @NullableDecl
    F fallback;
    @NullableDecl
    ListenableFuture<? extends V> inputFuture;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        AsyncCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Throwable */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public /* bridge */ /* synthetic */ Object doFallback(Object obj, Throwable th) throws Exception {
            return doFallback((AsyncFunction) ((AsyncFunction) obj), th);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            setResult((ListenableFuture) ((ListenableFuture) obj));
        }

        /* access modifiers changed from: package-private */
        public ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> asyncFunction, X x) throws Exception {
            ListenableFuture<? extends V> apply = asyncFunction.apply(x);
            ds1.r(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }

        /* access modifiers changed from: package-private */
        public void setResult(ListenableFuture<? extends V> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        CatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Throwable */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        @NullableDecl
        public /* bridge */ /* synthetic */ Object doFallback(Object obj, Throwable th) throws Exception {
            return doFallback((Function) ((Function) obj), th);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(@NullableDecl V v) {
            set(v);
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public V doFallback(Function<? super X, ? extends V> function, X x) throws Exception {
            return (V) function.apply(x);
        }
    }

    AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f) {
        this.inputFuture = (ListenableFuture) ds1.p(listenableFuture);
        this.exceptionType = (Class) ds1.p(cls);
        this.fallback = (F) ds1.p(f);
    }

    static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(listenableFuture, cls, function);
        listenableFuture.addListener(catchingFuture, MoreExecutors.f(executor, catchingFuture));
        return catchingFuture;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    @ForOverride
    public abstract T doFallback(F f, X x) throws Exception;

    /* access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        ListenableFuture<? extends V> listenableFuture = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f = this.fallback;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (cls != null && f != null) {
            return str + "exceptionType=[" + cls + "], fallback=[" + ((Object) f) + jl1.ARRAY_END_STR;
        } else if (pendingToString == null) {
            return null;
        } else {
            return str + pendingToString;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.google.common.util.concurrent.AbstractCatchingFuture<V, X extends java.lang.Throwable, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    public final void run() {
        Object obj;
        Throwable th;
        ListenableFuture<? extends V> listenableFuture = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f = this.fallback;
        boolean z = true;
        boolean z2 = (listenableFuture == null) | (cls == null);
        if (f != null) {
            z = false;
        }
        if (!(z | z2) && !isCancelled()) {
            this.inputFuture = null;
            try {
                obj = Futures.d(listenableFuture);
                th = null;
            } catch (ExecutionException e) {
                th = (Throwable) ds1.p(e.getCause());
                obj = null;
                if (th == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                obj = null;
                if (th == null) {
                }
            }
            if (th == null) {
                set(obj);
            } else if (!n.a(th, cls)) {
                setFuture(listenableFuture);
            } else {
                try {
                    Object doFallback = doFallback(f, th);
                    this.exceptionType = null;
                    this.fallback = null;
                    setResult(doFallback);
                } catch (Throwable th3) {
                    this.exceptionType = null;
                    this.fallback = null;
                    throw th3;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @ForOverride
    public abstract void setResult(@NullableDecl T t);

    static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(asyncCatchingFuture, MoreExecutors.f(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }
}
