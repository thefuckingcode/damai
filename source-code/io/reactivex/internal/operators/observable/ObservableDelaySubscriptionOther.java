package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import tb.k22;

/* compiled from: Taobao */
public final class ObservableDelaySubscriptionOther<T, U> extends d<T> {
    final ObservableSource<? extends T> main;
    final ObservableSource<U> other;

    /* compiled from: Taobao */
    final class DelayObserver implements Observer<U> {
        final Observer<? super T> child;
        boolean done;
        final SequentialDisposable serial;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public final class OnComplete implements Observer<T> {
            OnComplete() {
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                DelayObserver.this.child.onComplete();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                DelayObserver.this.child.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(T t) {
                DelayObserver.this.child.onNext(t);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DelayObserver.this.serial.update(disposable);
            }
        }

        DelayObserver(SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.serial = sequentialDisposable;
            this.child = observer;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                ObservableDelaySubscriptionOther.this.main.subscribe(new OnComplete());
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                k22.u(th);
                return;
            }
            this.done = true;
            this.child.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(U u) {
            onComplete();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.serial.update(disposable);
        }
    }

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.main = observableSource;
        this.other = observableSource2;
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.other.subscribe(new DelayObserver(sequentialDisposable, observer));
    }
}
