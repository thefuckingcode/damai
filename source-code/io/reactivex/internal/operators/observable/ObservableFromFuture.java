package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import tb.ff0;

/* compiled from: Taobao */
public final class ObservableFromFuture<T> extends d<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public ObservableFromFuture(Future<? extends T> future2, long j, TimeUnit timeUnit) {
        this.future = future2;
        this.timeout = j;
        this.unit = timeUnit;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.internal.observers.DeferredScalarDisposable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                TimeUnit timeUnit = this.unit;
                deferredScalarDisposable.complete(ObjectHelper.requireNonNull(timeUnit != null ? this.future.get(this.timeout, timeUnit) : this.future.get(), "Future returned null"));
            } catch (Throwable th) {
                ff0.b(th);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th);
                }
            }
        }
    }
}
