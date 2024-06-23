package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import tb.k22;
import tb.ql;

/* compiled from: Taobao */
public final class CompletableMergeArray extends a {
    final CompletableSource[] sources;

    /* compiled from: Taobao */
    static final class InnerCompletableObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -8360547806504310570L;
        final CompletableObserver actual;
        final AtomicBoolean once;
        final ql set;

        InnerCompletableObserver(CompletableObserver completableObserver, AtomicBoolean atomicBoolean, ql qlVar, int i) {
            this.actual = completableObserver;
            this.once = atomicBoolean;
            this.set = qlVar;
            lazySet(i);
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            if (decrementAndGet() == 0 && this.once.compareAndSet(false, true)) {
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                k22.u(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }
    }

    public CompletableMergeArray(CompletableSource[] completableSourceArr) {
        this.sources = completableSourceArr;
    }

    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        ql qlVar = new ql();
        InnerCompletableObserver innerCompletableObserver = new InnerCompletableObserver(completableObserver, new AtomicBoolean(), qlVar, this.sources.length + 1);
        completableObserver.onSubscribe(qlVar);
        CompletableSource[] completableSourceArr = this.sources;
        for (CompletableSource completableSource : completableSourceArr) {
            if (!qlVar.isDisposed()) {
                if (completableSource == null) {
                    qlVar.dispose();
                    innerCompletableObserver.onError(new NullPointerException("A completable source is null"));
                    return;
                }
                completableSource.subscribe(innerCompletableObserver);
            } else {
                return;
            }
        }
        innerCompletableObserver.onComplete();
    }
}
