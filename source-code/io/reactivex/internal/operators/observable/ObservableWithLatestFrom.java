package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;
import tb.ff0;
import tb.u82;

/* compiled from: Taobao */
public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    final ObservableSource<? extends U> other;

    /* compiled from: Taobao */
    final class WithLastFrom implements Observer<U> {
        private final WithLatestFromObserver<T, U, R> wlf;

        WithLastFrom(WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.wlf = withLatestFromObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.wlf.otherError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(U u) {
            this.wlf.lazySet(u);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.wlf.setOther(disposable);
        }
    }

    /* compiled from: Taobao */
    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;
        final Observer<? super R> actual;
        final BiFunction<? super T, ? super U, ? extends R> combiner;
        final AtomicReference<Disposable> other = new AtomicReference<>();
        final AtomicReference<Disposable> s = new AtomicReference<>();

        WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.actual = observer;
            this.combiner = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.s);
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.s.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Object obj = get();
            if (obj != null) {
                try {
                    this.actual.onNext(ObjectHelper.requireNonNull(this.combiner.apply(t, obj), "The combiner returned a null value"));
                } catch (Throwable th) {
                    ff0.b(th);
                    dispose();
                    this.actual.onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.s, disposable);
        }

        public void otherError(Throwable th) {
            DisposableHelper.dispose(this.s);
            this.actual.onError(th);
        }

        public boolean setOther(Disposable disposable) {
            return DisposableHelper.setOnce(this.other, disposable);
        }
    }

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.combiner = biFunction;
        this.other = observableSource2;
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super R> observer) {
        u82 u82 = new u82(observer);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(u82, this.combiner);
        u82.onSubscribe(withLatestFromObserver);
        this.other.subscribe(new WithLastFrom(withLatestFromObserver));
        this.source.subscribe(withLatestFromObserver);
    }
}
