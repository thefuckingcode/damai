package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import tb.ff0;

/* compiled from: Taobao */
public final class CompletableFromAction extends a {
    final Action run;

    public CompletableFromAction(Action action) {
        this.run = action;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        Disposable b = io.reactivex.disposables.a.b();
        completableObserver.onSubscribe(b);
        try {
            this.run.run();
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
