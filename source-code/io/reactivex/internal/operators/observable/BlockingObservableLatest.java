package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.d;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.b;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import tb.k22;
import tb.vj1;

/* compiled from: Taobao */
public final class BlockingObservableLatest<T> implements Iterable<T> {
    final ObservableSource<T> source;

    /* compiled from: Taobao */
    static final class BlockingObservableLatestIterator<T> extends b<vj1<T>> implements Iterator<T> {
        vj1<T> iteratorNotification;
        final Semaphore notify = new Semaphore(0);
        final AtomicReference<vj1<T>> value = new AtomicReference<>();

        BlockingObservableLatestIterator() {
        }

        public boolean hasNext() {
            vj1<T> vj1 = this.iteratorNotification;
            if (vj1 == null || !vj1.g()) {
                if (this.iteratorNotification == null) {
                    try {
                        BlockingHelper.verifyNonBlocking();
                        this.notify.acquire();
                        vj1<T> andSet = this.value.getAndSet(null);
                        this.iteratorNotification = andSet;
                        if (andSet.g()) {
                            throw ExceptionHelper.wrapOrThrow(andSet.d());
                        }
                    } catch (InterruptedException e) {
                        dispose();
                        this.iteratorNotification = vj1.b(e);
                        throw ExceptionHelper.wrapOrThrow(e);
                    }
                }
                return this.iteratorNotification.h();
            }
            throw ExceptionHelper.wrapOrThrow(this.iteratorNotification.d());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T e = this.iteratorNotification.e();
                this.iteratorNotification = null;
                return e;
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            k22.u(th);
        }

        @Override // io.reactivex.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((vj1) ((vj1) obj));
        }

        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }

        public void onNext(vj1<T> vj1) {
            if (this.value.getAndSet(vj1) == null) {
                this.notify.release();
            }
        }
    }

    public BlockingObservableLatest(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        d.wrap(this.source).materialize().subscribe(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }
}
