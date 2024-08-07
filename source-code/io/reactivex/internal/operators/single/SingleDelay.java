package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.e;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public final class SingleDelay<T> extends e<T> {
    final boolean delayError;
    final Scheduler scheduler;
    final SingleSource<? extends T> source;
    final long time;
    final TimeUnit unit;

    /* compiled from: Taobao */
    final class Delay implements SingleObserver<T> {
        final SingleObserver<? super T> s;
        private final SequentialDisposable sd;

        /* compiled from: Taobao */
        final class OnError implements Runnable {
            private final Throwable e;

            OnError(Throwable th) {
                this.e = th;
            }

            public void run() {
                Delay.this.s.onError(this.e);
            }
        }

        /* compiled from: Taobao */
        final class OnSuccess implements Runnable {
            private final T value;

            OnSuccess(T t) {
                this.value = t;
            }

            public void run() {
                Delay.this.s.onSuccess(this.value);
            }
        }

        Delay(SequentialDisposable sequentialDisposable, SingleObserver<? super T> singleObserver) {
            this.sd = sequentialDisposable;
            this.s = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            SequentialDisposable sequentialDisposable = this.sd;
            Scheduler scheduler = SingleDelay.this.scheduler;
            OnError onError = new OnError(th);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.replace(scheduler.scheduleDirect(onError, singleDelay.delayError ? singleDelay.time : 0, singleDelay.unit));
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.sd.replace(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            SequentialDisposable sequentialDisposable = this.sd;
            Scheduler scheduler = SingleDelay.this.scheduler;
            OnSuccess onSuccess = new OnSuccess(t);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.replace(scheduler.scheduleDirect(onSuccess, singleDelay.time, singleDelay.unit));
        }
    }

    public SingleDelay(SingleSource<? extends T> singleSource, long j, TimeUnit timeUnit, Scheduler scheduler2, boolean z) {
        this.source = singleSource;
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.delayError = z;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.e
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.onSubscribe(sequentialDisposable);
        this.source.subscribe(new Delay(sequentialDisposable, singleObserver));
    }
}
