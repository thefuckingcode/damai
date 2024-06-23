package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Callable;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class ObservableFromCallable<T> extends d<T> implements Callable<T> {
    final Callable<? extends T> callable;

    public ObservableFromCallable(Callable<? extends T> callable2) {
        this.callable = callable2;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) ObjectHelper.requireNonNull(this.callable.call(), "The callable returned a null value");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.internal.observers.DeferredScalarDisposable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                deferredScalarDisposable.complete(ObjectHelper.requireNonNull(this.callable.call(), "Callable returned null"));
            } catch (Throwable th) {
                ff0.b(th);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th);
                } else {
                    k22.u(th);
                }
            }
        }
    }
}
