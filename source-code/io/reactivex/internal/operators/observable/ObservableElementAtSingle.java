package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import java.util.NoSuchElementException;
import tb.k22;

/* compiled from: Taobao */
public final class ObservableElementAtSingle<T> extends e<T> implements FuseToObservable<T> {
    final T defaultValue;
    final long index;
    final ObservableSource<T> source;

    /* compiled from: Taobao */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final SingleObserver<? super T> actual;
        long count;
        final T defaultValue;
        boolean done;
        final long index;
        Disposable s;

        ElementAtObserver(SingleObserver<? super T> singleObserver, long j, T t) {
            this.actual = singleObserver;
            this.index = j;
            this.defaultValue = t;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                T t = this.defaultValue;
                if (t != null) {
                    this.actual.onSuccess(t);
                } else {
                    this.actual.onError(new NoSuchElementException());
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                k22.u(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (!this.done) {
                long j = this.count;
                if (j == this.index) {
                    this.done = true;
                    this.s.dispose();
                    this.actual.onSuccess(t);
                    return;
                }
                this.count = j + 1;
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableElementAtSingle(ObservableSource<T> observableSource, long j, T t) {
        this.source = observableSource;
        this.index = j;
        this.defaultValue = t;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public d<T> fuseToObservable() {
        return k22.n(new ObservableElementAt(this.source, this.index, this.defaultValue, true));
    }

    @Override // io.reactivex.e
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new ElementAtObserver(singleObserver, this.index, this.defaultValue));
    }
}
