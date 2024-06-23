package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.c;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.a;
import java.util.concurrent.Callable;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class MaybeFromCallable<T> extends c<T> implements Callable<T> {
    final Callable<? extends T> callable;

    public MaybeFromCallable(Callable<? extends T> callable2) {
        this.callable = callable2;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) this.callable.call();
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.c
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable b = a.b();
        maybeObserver.onSubscribe(b);
        if (!b.isDisposed()) {
            try {
                Object obj = (Object) this.callable.call();
                if (b.isDisposed()) {
                    return;
                }
                if (obj == 0) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(obj);
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
