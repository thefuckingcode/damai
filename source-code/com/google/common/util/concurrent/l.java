package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import tb.nf0;
import tb.nk2;

/* compiled from: Taobao */
class l<V> extends g<V> implements ListenableFuture<V> {
    private static final ThreadFactory a;
    private static final Executor b;

    static {
        ThreadFactory b2 = new nk2().e(true).f("ListenableFutureAdapter-thread-%d").b();
        a = b2;
        b = Executors.newCachedThreadPool(b2);
    }

    static /* synthetic */ Future b(l lVar) {
        throw null;
    }

    static /* synthetic */ nf0 c(l lVar) {
        throw null;
    }
}
