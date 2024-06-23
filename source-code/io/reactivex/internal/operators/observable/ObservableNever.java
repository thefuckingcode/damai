package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
public final class ObservableNever extends d<Object> {
    public static final d<Object> INSTANCE = new ObservableNever();

    private ObservableNever() {
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super Object> observer) {
        observer.onSubscribe(EmptyDisposable.NEVER);
    }
}
