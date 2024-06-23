package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.c;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.a;
import io.reactivex.functions.Action;
import java.util.concurrent.Callable;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class MaybeFromAction<T> extends c<T> implements Callable<T> {
    final Action action;

    public MaybeFromAction(Action action2) {
        this.action = action2;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        this.action.run();
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.c
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable b = a.b();
        maybeObserver.onSubscribe(b);
        if (!b.isDisposed()) {
            try {
                this.action.run();
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
