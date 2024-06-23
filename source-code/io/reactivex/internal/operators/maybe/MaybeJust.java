package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.c;
import io.reactivex.disposables.a;
import io.reactivex.internal.fuseable.ScalarCallable;

/* compiled from: Taobao */
public final class MaybeJust<T> extends c<T> implements ScalarCallable<T> {
    final T value;

    public MaybeJust(T t) {
        this.value = t;
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return this.value;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.c
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(a.a());
        maybeObserver.onSuccess(this.value);
    }
}
