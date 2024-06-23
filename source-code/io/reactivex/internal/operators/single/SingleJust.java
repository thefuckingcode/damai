package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.a;
import io.reactivex.e;

/* compiled from: Taobao */
public final class SingleJust<T> extends e<T> {
    final T value;

    public SingleJust(T t) {
        this.value = t;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.e
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(a.a());
        singleObserver.onSuccess(this.value);
    }
}
