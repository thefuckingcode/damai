package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import tb.ff0;

/* compiled from: Taobao */
public final class ObservableSkipWhile<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    /* compiled from: Taobao */
    static final class SkipWhileObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        boolean notSkipping;
        final Predicate<? super T> predicate;
        Disposable s;

        SkipWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate2) {
            this.actual = observer;
            this.predicate = predicate2;
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
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.notSkipping) {
                this.actual.onNext(t);
                return;
            }
            try {
                if (!this.predicate.test(t)) {
                    this.notSkipping = true;
                    this.actual.onNext(t);
                }
            } catch (Throwable th) {
                ff0.b(th);
                this.s.dispose();
                this.actual.onError(th);
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

    public ObservableSkipWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate2) {
        super(observableSource);
        this.predicate = predicate2;
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipWhileObserver(observer, this.predicate));
    }
}
