package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import tb.ff0;

/* compiled from: Taobao */
public final class CompletableErrorSupplier extends a {
    final Callable<? extends Throwable> errorSupplier;

    public CompletableErrorSupplier(Callable<? extends Throwable> callable) {
        this.errorSupplier = callable;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        Throwable th;
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.errorSupplier.call(), "The error returned is null");
        } catch (Throwable th2) {
            th = th2;
            ff0.b(th);
        }
        EmptyDisposable.error(th, completableObserver);
    }
}
