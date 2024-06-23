package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.a;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: Taobao */
public final class CompletableError extends a {
    final Throwable error;

    public CompletableError(Throwable th) {
        this.error = th;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.error(this.error, completableObserver);
    }
}
