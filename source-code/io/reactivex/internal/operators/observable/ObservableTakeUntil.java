package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.u82;

/* compiled from: Taobao */
public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends U> other;

    /* compiled from: Taobao */
    final class TakeUntil implements Observer<U> {
        private final ArrayCompositeDisposable frc;
        private final u82<T> serial;

        TakeUntil(ArrayCompositeDisposable arrayCompositeDisposable, u82<T> u82) {
            this.frc = arrayCompositeDisposable;
            this.serial = u82;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.frc.dispose();
            this.serial.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.frc.dispose();
            this.serial.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(U u) {
            this.frc.dispose();
            this.serial.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.frc.setResource(1, disposable);
        }
    }

    /* compiled from: Taobao */
    static final class TakeUntilObserver<T> extends AtomicBoolean implements Observer<T> {
        private static final long serialVersionUID = 3451719290311127173L;
        final Observer<? super T> actual;
        final ArrayCompositeDisposable frc;
        Disposable s;

        TakeUntilObserver(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.actual = observer;
            this.frc = arrayCompositeDisposable;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.frc.dispose();
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.frc.dispose();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.frc.setResource(0, disposable);
            }
        }
    }

    public ObservableTakeUntil(ObservableSource<T> observableSource, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.other = observableSource2;
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        u82 u82 = new u82(observer);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        TakeUntilObserver takeUntilObserver = new TakeUntilObserver(u82, arrayCompositeDisposable);
        observer.onSubscribe(arrayCompositeDisposable);
        this.other.subscribe(new TakeUntil(arrayCompositeDisposable, u82));
        this.source.subscribe(takeUntilObserver);
    }
}
