package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import tb.vj1;

/* compiled from: Taobao */
public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, vj1<T>> {

    /* compiled from: Taobao */
    static final class MaterializeObserver<T> implements Observer<T>, Disposable {
        final Observer<? super vj1<T>> actual;
        Disposable s;

        MaterializeObserver(Observer<? super vj1<T>> observer) {
            this.actual = observer;
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
            this.actual.onNext(vj1.a());
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onNext(vj1.b(th));
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.actual.onNext(vj1.c(t));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableMaterialize(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super vj1<T>> observer) {
        this.source.subscribe(new MaterializeObserver(observer));
    }
}
