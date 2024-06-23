package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.a;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
public final class CompletableNever extends a {
    public static final a INSTANCE = new CompletableNever();

    private CompletableNever() {
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        completableObserver.onSubscribe(EmptyDisposable.NEVER);
    }
}
