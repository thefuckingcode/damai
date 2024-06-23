package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import tb.ds1;

@GwtCompatible
@CanIgnoreReturnValue
/* compiled from: Taobao */
public abstract class h<V> extends g<V> implements ListenableFuture<V> {

    /* compiled from: Taobao */
    public static abstract class a<V> extends h<V> {
        private final ListenableFuture<V> a;

        protected a(ListenableFuture<V> listenableFuture) {
            this.a = (ListenableFuture) ds1.p(listenableFuture);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.h
        /* renamed from: b */
        public final ListenableFuture<V> delegate() {
            return this.a;
        }
    }

    protected h() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        b().addListener(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public abstract ListenableFuture<? extends V> b();
}
