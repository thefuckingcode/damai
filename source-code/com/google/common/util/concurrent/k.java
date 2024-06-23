package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtCompatible
/* compiled from: Taobao */
abstract class k<V> implements ListenableFuture<V> {
    private static final Logger a = Logger.getLogger(k.class.getName());

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class a<V> extends AbstractFuture.g<V> {
        a(Throwable th) {
            setException(th);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b<V> extends k<V> {
        static final b<Object> c = new b<>(null);
        @NullableDecl
        private final V b;

        b(@NullableDecl V v) {
            this.b = v;
        }

        @Override // java.util.concurrent.Future, com.google.common.util.concurrent.k
        public V get() {
            return this.b;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + ((Object) this.b) + "]]";
        }
    }

    k() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        ds1.q(runnable, "Runnable was null.");
        ds1.q(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = a;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws ExecutionException;

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        ds1.p(timeUnit);
        return get();
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}
