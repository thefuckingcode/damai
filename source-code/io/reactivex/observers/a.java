package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;

/* compiled from: Taobao */
public abstract class a<T> implements Observer<T> {
    private Disposable s;

    /* access modifiers changed from: protected */
    public final void cancel() {
        Disposable disposable = this.s;
        this.s = DisposableHelper.DISPOSED;
        disposable.dispose();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.validate(this.s, disposable, getClass())) {
            this.s = disposable;
            onStart();
        }
    }
}
