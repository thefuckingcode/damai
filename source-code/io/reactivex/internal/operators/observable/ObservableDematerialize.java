package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import tb.k22;
import tb.vj1;

/* compiled from: Taobao */
public final class ObservableDematerialize<T> extends AbstractObservableWithUpstream<vj1<T>, T> {

    /* compiled from: Taobao */
    static final class DematerializeObserver<T> implements Observer<vj1<T>>, Disposable {
        final Observer<? super T> actual;
        boolean done;
        Disposable s;

        DematerializeObserver(Observer<? super T> observer) {
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
            if (!this.done) {
                this.done = true;
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
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((vj1) ((vj1) obj));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(vj1<T> vj1) {
            if (this.done) {
                if (vj1.g()) {
                    k22.u(vj1.d());
                }
            } else if (vj1.g()) {
                this.s.dispose();
                onError(vj1.d());
            } else if (vj1.f()) {
                this.s.dispose();
                onComplete();
            } else {
                this.actual.onNext(vj1.e());
            }
        }
    }

    public ObservableDematerialize(ObservableSource<vj1<T>> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DematerializeObserver(observer));
    }
}
