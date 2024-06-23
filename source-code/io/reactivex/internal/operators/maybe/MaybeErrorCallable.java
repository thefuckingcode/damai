package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.c;
import io.reactivex.disposables.a;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import tb.ff0;

/* compiled from: Taobao */
public final class MaybeErrorCallable<T> extends c<T> {
    final Callable<? extends Throwable> errorSupplier;

    public MaybeErrorCallable(Callable<? extends Throwable> callable) {
        this.errorSupplier = callable;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.c
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Throwable th;
        maybeObserver.onSubscribe(a.a());
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.errorSupplier.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            ff0.b(th);
        }
        maybeObserver.onError(th);
    }
}
