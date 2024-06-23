package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.Callable;
import tb.ff0;

/* compiled from: Taobao */
public final class CompletableFromCallable extends a {
    final Callable<?> callable;

    public CompletableFromCallable(Callable<?> callable2) {
        this.callable = callable2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        Disposable b = io.reactivex.disposables.a.b();
        completableObserver.onSubscribe(b);
        try {
            this.callable.call();
            if (!b.isDisposed()) {
                completableObserver.onComplete();
            }
        } catch (Throwable th) {
            ff0.b(th);
            if (!b.isDisposed()) {
                completableObserver.onError(th);
            }
        }
    }
}
