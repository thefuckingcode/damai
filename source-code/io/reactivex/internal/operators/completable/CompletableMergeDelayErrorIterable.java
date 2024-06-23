package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.a;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import tb.ff0;
import tb.ql;

/* compiled from: Taobao */
public final class CompletableMergeDelayErrorIterable extends a {
    final Iterable<? extends CompletableSource> sources;

    public CompletableMergeDelayErrorIterable(Iterable<? extends CompletableSource> iterable) {
        this.sources = iterable;
    }

    @Override // io.reactivex.a
    public void subscribeActual(CompletableObserver completableObserver) {
        ql qlVar = new ql();
        completableObserver.onSubscribe(qlVar);
        try {
            Iterator it = (Iterator) ObjectHelper.requireNonNull(this.sources.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicThrowable atomicThrowable = new AtomicThrowable();
            while (!qlVar.isDisposed()) {
                try {
                    if (!it.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                completableObserver.onComplete();
                                return;
                            } else {
                                completableObserver.onError(terminate);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!qlVar.isDisposed()) {
                        try {
                            CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(it.next(), "The iterator returned a null CompletableSource");
                            if (!qlVar.isDisposed()) {
                                atomicInteger.getAndIncrement();
                                completableSource.subscribe(new CompletableMergeDelayErrorArray.MergeInnerCompletableObserver(completableObserver, qlVar, atomicThrowable, atomicInteger));
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            ff0.b(th);
                            atomicThrowable.addThrowable(th);
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    ff0.b(th2);
                    atomicThrowable.addThrowable(th2);
                }
            }
        } catch (Throwable th3) {
            ff0.b(th3);
            completableObserver.onError(th3);
        }
    }
}
