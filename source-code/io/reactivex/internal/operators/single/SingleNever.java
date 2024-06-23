package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.e;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
public final class SingleNever extends e<Object> {
    public static final e<Object> INSTANCE = new SingleNever();

    private SingleNever() {
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.e
    public void subscribeActual(SingleObserver<? super Object> singleObserver) {
        singleObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
