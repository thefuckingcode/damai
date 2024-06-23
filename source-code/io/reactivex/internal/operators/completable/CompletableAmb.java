package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.ff0;
import tb.k22;
import tb.ql;

/* compiled from: Taobao */
public final class CompletableAmb extends a {
    private final CompletableSource[] sources;
    private final Iterable<? extends CompletableSource> sourcesIterable;

    /* compiled from: Taobao */
    static final class Amb implements CompletableObserver {
        private final AtomicBoolean once;
        private final CompletableObserver s;
        private final ql set;

        Amb(AtomicBoolean atomicBoolean, ql qlVar, CompletableObserver completableObserver) {
            this.once = atomicBoolean;
            this.set = qlVar;
            this.s = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            if (this.once.compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (this.once.compareAndSet(false, true)) {
                this.set.dispose();
                this.s.onError(th);
                return;
            }
            k22.u(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }
    }

    public CompletableAmb(CompletableSource[] completableSourceArr, Iterable<? extends CompletableSource> iterable) {
        this.sources = completableSourceArr;
        this.sourcesIterable = iterable;
    }

    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        int i;
        CompletableSource[] completableSourceArr = this.sources;
        if (completableSourceArr == null) {
            completableSourceArr = new CompletableSource[8];
            try {
                i = 0;
                for (CompletableSource completableSource : this.sourcesIterable) {
                    if (completableSource == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), completableObserver);
                        return;
                    }
                    if (i == completableSourceArr.length) {
                        CompletableSource[] completableSourceArr2 = new CompletableSource[((i >> 2) + i)];
                        System.arraycopy(completableSourceArr, 0, completableSourceArr2, 0, i);
                        completableSourceArr = completableSourceArr2;
                    }
                    int i2 = i + 1;
                    completableSourceArr[i] = completableSource;
                    i = i2;
                }
            } catch (Throwable th) {
                ff0.b(th);
                EmptyDisposable.error(th, completableObserver);
                return;
            }
        } else {
            i = completableSourceArr.length;
        }
        ql qlVar = new ql();
        completableObserver.onSubscribe(qlVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        Amb amb = new Amb(atomicBoolean, qlVar, completableObserver);
        for (int i3 = 0; i3 < i; i3++) {
            CompletableSource completableSource2 = completableSourceArr[i3];
            if (!qlVar.isDisposed()) {
                if (completableSource2 == null) {
                    Throwable nullPointerException = new NullPointerException("One of the sources is null");
                    if (atomicBoolean.compareAndSet(false, true)) {
                        qlVar.dispose();
                        completableObserver.onError(nullPointerException);
                        return;
                    }
                    k22.u(nullPointerException);
                    return;
                }
                completableSource2.subscribe(amb);
            } else {
                return;
            }
        }
        if (i == 0) {
            completableObserver.onComplete();
        }
    }
}
