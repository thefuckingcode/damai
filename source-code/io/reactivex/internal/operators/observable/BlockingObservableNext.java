package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.b;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import tb.k22;
import tb.vj1;

/* compiled from: Taobao */
public final class BlockingObservableNext<T> implements Iterable<T> {
    final ObservableSource<T> source;

    /* compiled from: Taobao */
    static final class NextIterator<T> implements Iterator<T> {
        private Throwable error;
        private boolean hasNext = true;
        private boolean isNextConsumed = true;
        private final ObservableSource<T> items;
        private T next;
        private final NextObserver<T> observer;
        private boolean started;

        NextIterator(ObservableSource<T> observableSource, NextObserver<T> nextObserver) {
            this.items = observableSource;
            this.observer = nextObserver;
        }

        private boolean moveToNext() {
            if (!this.started) {
                this.started = true;
                this.observer.setWaiting();
                new ObservableMaterialize(this.items).subscribe(this.observer);
            }
            try {
                vj1<T> takeNext = this.observer.takeNext();
                if (takeNext.h()) {
                    this.isNextConsumed = false;
                    this.next = takeNext.e();
                    return true;
                }
                this.hasNext = false;
                if (takeNext.f()) {
                    return false;
                }
                Throwable d = takeNext.d();
                this.error = d;
                throw ExceptionHelper.wrapOrThrow(d);
            } catch (InterruptedException e) {
                this.observer.dispose();
                this.error = e;
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }

        public boolean hasNext() {
            Throwable th = this.error;
            if (th != null) {
                throw ExceptionHelper.wrapOrThrow(th);
            } else if (!this.hasNext) {
                return false;
            } else {
                if (!this.isNextConsumed || moveToNext()) {
                    return true;
                }
                return false;
            }
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.error;
            if (th != null) {
                throw ExceptionHelper.wrapOrThrow(th);
            } else if (hasNext()) {
                this.isNextConsumed = true;
                return this.next;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class NextObserver<T> extends b<vj1<T>> {
        private final BlockingQueue<vj1<T>> buf = new ArrayBlockingQueue(1);
        final AtomicInteger waiting = new AtomicInteger();

        NextObserver() {
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

        /* access modifiers changed from: package-private */
        public void setWaiting() {
            this.waiting.set(1);
        }

        public vj1<T> takeNext() throws InterruptedException {
            setWaiting();
            BlockingHelper.verifyNonBlocking();
            return this.buf.take();
        }

        public void onNext(vj1<T> vj1) {
            if (this.waiting.getAndSet(0) == 1 || !vj1.h()) {
                while (!this.buf.offer(vj1)) {
                    vj1<T> poll = this.buf.poll();
                    if (poll != null && !poll.h()) {
                        vj1 = poll;
                    }
                }
            }
        }
    }

    public BlockingObservableNext(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new NextIterator(this.source, new NextObserver());
    }
}
