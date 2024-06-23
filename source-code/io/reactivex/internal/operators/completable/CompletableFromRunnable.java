package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import tb.ff0;

/* compiled from: Taobao */
public final class CompletableFromRunnable extends a {
    final Runnable runnable;

    public CompletableFromRunnable(Runnable runnable2) {
        this.runnable = runnable2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        Disposable b = io.reactivex.disposables.a.b();
        completableObserver.onSubscribe(b);
        try {
            this.runnable.run();
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
