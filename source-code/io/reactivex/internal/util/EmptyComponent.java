package io.reactivex.internal.util;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.k22;

/* compiled from: Taobao */
public enum EmptyComponent implements FlowableSubscriber<Object>, Observer<Object>, MaybeObserver<Object>, SingleObserver<Object>, CompletableObserver, Subscription, Disposable {
    INSTANCE;

    public static <T> Observer<T> asObserver() {
        return INSTANCE;
    }

    public static <T> Subscriber<T> asSubscriber() {
        return INSTANCE;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    @Override // io.reactivex.MaybeObserver, io.reactivex.CompletableObserver, io.reactivex.Observer, org.reactivestreams.Subscriber
    public void onComplete() {
    }

    @Override // io.reactivex.MaybeObserver, io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.Observer, org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        k22.u(th);
    }

    @Override // io.reactivex.Observer, org.reactivestreams.Subscriber
    public void onNext(Object obj) {
    }

    @Override // io.reactivex.MaybeObserver, io.reactivex.SingleObserver, io.reactivex.CompletableObserver, io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        disposable.dispose();
    }

    @Override // io.reactivex.MaybeObserver, io.reactivex.SingleObserver
    public void onSuccess(Object obj) {
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        subscription.cancel();
    }
}
