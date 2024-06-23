package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Taobao */
public final class ObservableConcatWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {
    final MaybeSource<? extends T> other;

    /* compiled from: Taobao */
    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;
        final Observer<? super T> actual;
        boolean inMaybe;
        MaybeSource<? extends T> other;

        ConcatWithObserver(Observer<? super T> observer, MaybeSource<? extends T> maybeSource) {
            this.actual = observer;
            this.other = maybeSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        @Override // io.reactivex.MaybeObserver, io.reactivex.Observer
        public void onComplete() {
            if (this.inMaybe) {
                this.actual.onComplete();
                return;
            }
            this.inMaybe = true;
            DisposableHelper.replace(this, null);
            MaybeSource<? extends T> maybeSource = this.other;
            this.other = null;
            maybeSource.subscribe(this);
        }

        @Override // io.reactivex.MaybeObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.MaybeObserver, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && !this.inMaybe) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.actual.onNext(t);
            this.actual.onComplete();
        }
    }

    public ObservableConcatWithMaybe(d<T> dVar, MaybeSource<? extends T> maybeSource) {
        super(dVar);
        this.other = maybeSource;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ConcatWithObserver(observer, this.other));
    }
}
