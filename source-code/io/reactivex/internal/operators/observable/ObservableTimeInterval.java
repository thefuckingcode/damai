package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import tb.em2;

/* compiled from: Taobao */
public final class ObservableTimeInterval<T> extends AbstractObservableWithUpstream<T, em2<T>> {
    final Scheduler scheduler;
    final TimeUnit unit;

    /* compiled from: Taobao */
    static final class TimeIntervalObserver<T> implements Observer<T>, Disposable {
        final Observer<? super em2<T>> actual;
        long lastTime;
        Disposable s;
        final Scheduler scheduler;
        final TimeUnit unit;

        TimeIntervalObserver(Observer<? super em2<T>> observer, TimeUnit timeUnit, Scheduler scheduler2) {
            this.actual = observer;
            this.scheduler = scheduler2;
            this.unit = timeUnit;
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
            long now = this.scheduler.now(this.unit);
            long j = this.lastTime;
            this.lastTime = now;
            this.actual.onNext(new em2(t, now - j, this.unit));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.lastTime = this.scheduler.now(this.unit);
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableTimeInterval(ObservableSource<T> observableSource, TimeUnit timeUnit, Scheduler scheduler2) {
        super(observableSource);
        this.scheduler = scheduler2;
        this.unit = timeUnit;
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super em2<T>> observer) {
        this.source.subscribe(new TimeIntervalObserver(observer, this.unit, this.scheduler));
    }
}
