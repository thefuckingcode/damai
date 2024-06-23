package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import tb.k22;

/* compiled from: Taobao */
public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {
    final long limit;

    /* compiled from: Taobao */
    static final class TakeObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        boolean done;
        long remaining;
        Disposable subscription;

        TakeObserver(Observer<? super T> observer, long j) {
            this.actual = observer;
            this.remaining = j;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.subscription.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.subscription.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.subscription.dispose();
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                k22.u(th);
                return;
            }
            this.done = true;
            this.subscription.dispose();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.done) {
                long j = this.remaining;
                long j2 = j - 1;
                this.remaining = j2;
                if (j > 0) {
                    boolean z = j2 == 0;
                    this.actual.onNext(t);
                    if (z) {
                        onComplete();
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.subscription, disposable)) {
                this.subscription = disposable;
                if (this.remaining == 0) {
                    this.done = true;
                    disposable.dispose();
                    EmptyDisposable.complete(this.actual);
                    return;
                }
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableTake(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.limit = j;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeObserver(observer, this.limit));
    }
}
