package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import tb.ql;

/* compiled from: Taobao */
public final class CompletableDelay extends a {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final CompletableSource source;
    final TimeUnit unit;

    /* compiled from: Taobao */
    final class Delay implements CompletableObserver {
        final CompletableObserver s;
        private final ql set;

        /* compiled from: Taobao */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            public void run() {
                Delay.this.s.onComplete();
            }
        }

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

        Delay(ql qlVar, CompletableObserver completableObserver) {
            this.set = qlVar;
            this.s = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            ql qlVar = this.set;
            Scheduler scheduler = CompletableDelay.this.scheduler;
            OnComplete onComplete = new OnComplete();
            CompletableDelay completableDelay = CompletableDelay.this;
            qlVar.add(scheduler.scheduleDirect(onComplete, completableDelay.delay, completableDelay.unit));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            ql qlVar = this.set;
            Scheduler scheduler = CompletableDelay.this.scheduler;
            OnError onError = new OnError(th);
            CompletableDelay completableDelay = CompletableDelay.this;
            qlVar.add(scheduler.scheduleDirect(onError, completableDelay.delayError ? completableDelay.delay : 0, completableDelay.unit));
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
            this.s.onSubscribe(this.set);
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler2, boolean z) {
        this.source = completableSource;
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.delayError = z;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new Delay(new ql(), completableObserver));
    }
}
