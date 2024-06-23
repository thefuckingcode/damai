package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import tb.ff0;

/* compiled from: Taobao */
public final class ObservableError<T> extends d<T> {
    final Callable<? extends Throwable> errorSupplier;

    public ObservableError(Callable<? extends Throwable> callable) {
        this.errorSupplier = callable;
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        Throwable th;
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.errorSupplier.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            ff0.b(th);
        }
        EmptyDisposable.error(th, observer);
    }
}
