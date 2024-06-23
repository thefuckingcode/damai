package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import tb.k22;
import tb.ql;

/* compiled from: Taobao */
public final class CompletableMergeDelayErrorArray extends a {
    final CompletableSource[] sources;

    /* compiled from: Taobao */
    static final class MergeInnerCompletableObserver implements CompletableObserver {
        final CompletableObserver actual;
        final AtomicThrowable error;
        final ql set;
        final AtomicInteger wip;

        MergeInnerCompletableObserver(CompletableObserver completableObserver, ql qlVar, AtomicThrowable atomicThrowable, AtomicInteger atomicInteger) {
            this.actual = completableObserver;
            this.set = qlVar;
            this.error = atomicThrowable;
            this.wip = atomicInteger;
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            tryTerminate();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
                tryTerminate();
            } else {
                k22.u(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        /* access modifiers changed from: package-private */
        public void tryTerminate() {
            if (this.wip.decrementAndGet() == 0) {
                Throwable terminate = this.error.terminate();
                if (terminate == null) {
                    this.actual.onComplete();
                } else {
                    this.actual.onError(terminate);
                }
            }
        }
    }

    public CompletableMergeDelayErrorArray(CompletableSource[] completableSourceArr) {
        this.sources = completableSourceArr;
    }

    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        ql qlVar = new ql();
        AtomicInteger atomicInteger = new AtomicInteger(this.sources.length + 1);
        AtomicThrowable atomicThrowable = new AtomicThrowable();
        completableObserver.onSubscribe(qlVar);
        CompletableSource[] completableSourceArr = this.sources;
        for (CompletableSource completableSource : completableSourceArr) {
            if (!qlVar.isDisposed()) {
                if (completableSource == null) {
                    atomicThrowable.addThrowable(new NullPointerException("A completable source is null"));
                    atomicInteger.decrementAndGet();
                } else {
                    completableSource.subscribe(new MergeInnerCompletableObserver(completableObserver, qlVar, atomicThrowable, atomicInteger));
                }
            } else {
                return;
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate == null) {
                completableObserver.onComplete();
            } else {
                completableObserver.onError(terminate);
            }
        }
    }
}
