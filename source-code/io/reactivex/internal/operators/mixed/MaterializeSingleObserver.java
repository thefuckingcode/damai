package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaterializeSingleObserver<T> implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver, Disposable {
    final SingleObserver<? super Notification<T>> downstream;
    Disposable upstream;

    public MaterializeSingleObserver(SingleObserver<? super Notification<T>> singleObserver) {
        this.downstream = singleObserver;
    }

    @Override // io.reactivex.MaybeObserver, io.reactivex.SingleObserver, io.reactivex.CompletableObserver
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // io.reactivex.MaybeObserver, io.reactivex.CompletableObserver
    public void onComplete() {
        this.downstream.onSuccess(Notification.createOnComplete());
    }

    @Override // io.reactivex.MaybeObserver, io.reactivex.SingleObserver
    public void onSuccess(T t) {
        this.downstream.onSuccess(Notification.createOnNext(t));
    }

    @Override // io.reactivex.MaybeObserver, io.reactivex.SingleObserver, io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        this.downstream.onSuccess(Notification.createOnError(th));
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
    }
}
