package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import tb.u82;

/* compiled from: Taobao */
public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final boolean emitLast;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    /* compiled from: Taobao */
    static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip = new AtomicInteger(1);

        SampleTimedEmitLast(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j, timeUnit, scheduler);
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        public void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.actual.onComplete();
            }
        }

        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.actual.onComplete();
                }
            }
        }
    }

    /* compiled from: Taobao */
    static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j, timeUnit, scheduler);
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        public void complete() {
            this.actual.onComplete();
        }

        public void run() {
            emit();
        }
    }

    /* compiled from: Taobao */
    static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Observer<? super T> actual;
        final long period;
        Disposable s;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer = new AtomicReference<>();
        final TimeUnit unit;

        SampleTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            this.actual = observer;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        /* access modifiers changed from: package-private */
        public void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        /* access modifiers changed from: package-private */
        public abstract void complete();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancelTimer();
            this.s.dispose();
        }

        /* access modifiers changed from: package-private */
        public void emit() {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                this.actual.onNext(andSet);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            cancelTimer();
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
                Scheduler scheduler2 = this.scheduler;
                long j = this.period;
                DisposableHelper.replace(this.timer, scheduler2.schedulePeriodicallyDirect(this, j, j, this.unit));
            }
        }
    }

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler2, boolean z) {
        super(observableSource);
        this.period = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.emitLast = z;
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        u82 u82 = new u82(observer);
        if (this.emitLast) {
            this.source.subscribe(new SampleTimedEmitLast(u82, this.period, this.unit, this.scheduler));
        } else {
            this.source.subscribe(new SampleTimedNoLast(u82, this.period, this.unit, this.scheduler));
        }
    }
}
