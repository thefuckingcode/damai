package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import tb.ff0;
import tb.k22;
import tb.ql;

/* compiled from: Taobao */
public final class CompletableMergeIterable extends a {
    final Iterable<? extends CompletableSource> sources;

    /* compiled from: Taobao */
    static final class MergeCompletableObserver extends AtomicBoolean implements CompletableObserver {
        private static final long serialVersionUID = -7730517613164279224L;
        final CompletableObserver actual;
        final ql set;
        final AtomicInteger wip;

        MergeCompletableObserver(CompletableObserver completableObserver, ql qlVar, AtomicInteger atomicInteger) {
            this.actual = completableObserver;
            this.set = qlVar;
            this.wip = atomicInteger;
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            if (this.wip.decrementAndGet() == 0 && compareAndSet(false, true)) {
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.set.dispose();
            if (compareAndSet(false, true)) {
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

    public CompletableMergeIterable(Iterable<? extends CompletableSource> iterable) {
        this.sources = iterable;
    }

    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        ql qlVar = new ql();
        completableObserver.onSubscribe(qlVar);
        try {
            Iterator it = (Iterator) ObjectHelper.requireNonNull(this.sources.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            MergeCompletableObserver mergeCompletableObserver = new MergeCompletableObserver(completableObserver, qlVar, atomicInteger);
            while (!qlVar.isDisposed()) {
                try {
                    if (!it.hasNext()) {
                        mergeCompletableObserver.onComplete();
                        return;
                    } else if (!qlVar.isDisposed()) {
                        try {
                            CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(it.next(), "The iterator returned a null CompletableSource");
                            if (!qlVar.isDisposed()) {
                                atomicInteger.getAndIncrement();
                                completableSource.subscribe(mergeCompletableObserver);
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            ff0.b(th);
                            qlVar.dispose();
                            mergeCompletableObserver.onError(th);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    ff0.b(th2);
                    qlVar.dispose();
                    mergeCompletableObserver.onError(th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            ff0.b(th3);
            completableObserver.onError(th3);
        }
    }
}
