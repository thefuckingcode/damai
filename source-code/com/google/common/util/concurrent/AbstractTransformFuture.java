package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.util.concurrent.e;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;

/* access modifiers changed from: package-private */
@GwtCompatible
/* compiled from: Taobao */
public abstract class AbstractTransformFuture<I, O, F, T> extends e.a<O> implements Runnable {
    @NullableDecl
    F function;
    @NullableDecl
    ListenableFuture<? extends I> inputFuture;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        AsyncTransformFuture(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public /* bridge */ /* synthetic */ Object doTransform(Object obj, @NullableDecl Object obj2) throws Exception {
            return doTransform((AsyncFunction) ((AsyncFunction) obj), obj2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            setResult((ListenableFuture) ((ListenableFuture) obj));
        }

        /* access modifiers changed from: package-private */
        public ListenableFuture<? extends O> doTransform(AsyncFunction<? super I, ? extends O> asyncFunction, @NullableDecl I i) throws Exception {
            ListenableFuture<? extends O> apply = asyncFunction.apply(i);
            ds1.r(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.util.concurrent.ListenableFuture<? extends O> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public void setResult(ListenableFuture<? extends O> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        TransformFuture(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        @NullableDecl
        public /* bridge */ /* synthetic */ Object doTransform(Object obj, @NullableDecl Object obj2) throws Exception {
            return doTransform((Function) ((Function) obj), obj2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(@NullableDecl O o) {
            set(o);
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public O doTransform(Function<? super I, ? extends O> function, @NullableDecl I i) {
            return (O) function.apply(i);
        }
    }

    AbstractTransformFuture(ListenableFuture<? extends I> listenableFuture, F f) {
        this.inputFuture = (ListenableFuture) ds1.p(listenableFuture);
        this.function = (F) ds1.p(f);
    }

    static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        ds1.p(executor);
        AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(asyncTransformFuture, MoreExecutors.f(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    @ForOverride
    public abstract T doTransform(F f, @NullableDecl I i) throws Exception;

    /* access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f = this.function;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (f != null) {
            return str + "function=[" + ((Object) f) + jl1.ARRAY_END_STR;
        } else if (pendingToString == null) {
            return null;
        } else {
            return str + pendingToString;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.util.concurrent.AbstractTransformFuture<I, O, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void run() {
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f = this.function;
        boolean z = true;
        boolean isCancelled = isCancelled() | (listenableFuture == null);
        if (f != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.inputFuture = null;
            if (listenableFuture.isCancelled()) {
                setFuture(listenableFuture);
                return;
            }
            try {
                try {
                    Object doTransform = doTransform(f, Futures.d(listenableFuture));
                    this.function = null;
                    setResult(doTransform);
                } catch (Throwable th) {
                    this.function = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                setException(e.getCause());
            } catch (RuntimeException e2) {
                setException(e2);
            } catch (Error e3) {
                setException(e3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @ForOverride
    public abstract void setResult(@NullableDecl T t);

    static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function2, Executor executor) {
        ds1.p(function2);
        TransformFuture transformFuture = new TransformFuture(listenableFuture, function2);
        listenableFuture.addListener(transformFuture, MoreExecutors.f(executor, transformFuture));
        return transformFuture;
    }
}
