package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;

/* compiled from: Taobao */
public final class CompletableToObservable<T> extends d<T> {
    final CompletableSource source;

    /* compiled from: Taobao */
    static final class ObserverCompletableObserver implements CompletableObserver {
        private final Observer<?> observer;

        ObserverCompletableObserver(Observer<?> observer2) {
            this.observer = observer2;
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            this.observer.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.observer.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }
    }

    public CompletableToObservable(CompletableSource completableSource) {
        this.source = completableSource;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ObserverCompletableObserver(observer));
    }
}
