package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.a;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import tb.ff0;

/* compiled from: Taobao */
public final class CompletableConcatIterable extends a {
    final Iterable<? extends CompletableSource> sources;

    /* compiled from: Taobao */
    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;
        final CompletableObserver actual;
        final SequentialDisposable sd = new SequentialDisposable();
        final Iterator<? extends CompletableSource> sources;

        ConcatInnerObserver(CompletableObserver completableObserver, Iterator<? extends CompletableSource> it) {
            this.actual = completableObserver;
            this.sources = it;
        }

        /* access modifiers changed from: package-private */
        public void next() {
            if (!this.sd.isDisposed() && getAndIncrement() == 0) {
                Iterator<? extends CompletableSource> it = this.sources;
                while (!this.sd.isDisposed()) {
                    try {
                        if (!it.hasNext()) {
                            this.actual.onComplete();
                            return;
                        }
                        try {
                            ((CompletableSource) ObjectHelper.requireNonNull(it.next(), "The CompletableSource returned is null")).subscribe(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            ff0.b(th);
                            this.actual.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        ff0.b(th2);
                        this.actual.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onComplete() {
            next();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            this.sd.replace(disposable);
        }
    }

    public CompletableConcatIterable(Iterable<? extends CompletableSource> iterable) {
        this.sources = iterable;
    }

    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, (Iterator) ObjectHelper.requireNonNull(this.sources.iterator(), "The iterator returned is null"));
            completableObserver.onSubscribe(concatInnerObserver.sd);
            concatInnerObserver.next();
        } catch (Throwable th) {
            ff0.b(th);
            EmptyDisposable.error(th, completableObserver);
        }
    }
}
