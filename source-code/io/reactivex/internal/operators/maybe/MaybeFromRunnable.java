package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.c;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.a;
import java.util.concurrent.Callable;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class MaybeFromRunnable<T> extends c<T> implements Callable<T> {
    final Runnable runnable;

    public MaybeFromRunnable(Runnable runnable2) {
        this.runnable = runnable2;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        this.runnable.run();
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.c
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable b = a.b();
        maybeObserver.onSubscribe(b);
        if (!b.isDisposed()) {
            try {
                this.runnable.run();
                if (!b.isDisposed()) {
                    maybeObserver.onComplete();
                }
            } catch (Throwable th) {
                ff0.b(th);
                if (!b.isDisposed()) {
                    maybeObserver.onError(th);
                } else {
                    k22.u(th);
                }
            }
        }
    }
}
