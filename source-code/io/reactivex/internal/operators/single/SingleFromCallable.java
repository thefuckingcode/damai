package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.a;
import io.reactivex.e;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class SingleFromCallable<T> extends e<T> {
    final Callable<? extends T> callable;

    public SingleFromCallable(Callable<? extends T> callable2) {
        this.callable = callable2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.e
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Disposable b = a.b();
        singleObserver.onSubscribe(b);
        if (!b.isDisposed()) {
            try {
                Object obj = (Object) ObjectHelper.requireNonNull(this.callable.call(), "The callable returned a null value");
                if (!b.isDisposed()) {
                    singleObserver.onSuccess(obj);
                }
            } catch (Throwable th) {
                ff0.b(th);
                if (!b.isDisposed()) {
                    singleObserver.onError(th);
                } else {
                    k22.u(th);
                }
            }
        }
    }
}
