package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.a;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import tb.k22;

/* compiled from: Taobao */
public final class ObservableIgnoreElementsCompletable<T> extends a implements FuseToObservable<T> {
    final ObservableSource<T> source;

    /* compiled from: Taobao */
    static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        final CompletableObserver actual;
        Disposable d;

        IgnoreObservable(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.d = disposable;
            this.actual.onSubscribe(this);
        }
    }

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public d<T> fuseToObservable() {
        return k22.n(new ObservableIgnoreElements(this.source));
    }

    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new IgnoreObservable(completableObserver));
    }
}
