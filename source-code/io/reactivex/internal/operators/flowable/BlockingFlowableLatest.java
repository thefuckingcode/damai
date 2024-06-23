package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.subscribers.b;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import tb.k22;
import tb.vj1;

/* compiled from: Taobao */
public final class BlockingFlowableLatest<T> implements Iterable<T> {
    final Publisher<? extends T> source;

    /* compiled from: Taobao */
    static final class LatestSubscriberIterator<T> extends b<vj1<T>> implements Iterator<T> {
        vj1<T> iteratorNotification;
        final Semaphore notify = new Semaphore(0);
        final AtomicReference<vj1<T>> value = new AtomicReference<>();

        LatestSubscriberIterator() {
        }

        public boolean hasNext() {
            vj1<T> vj1 = this.iteratorNotification;
            if (vj1 == null || !vj1.g()) {
                vj1<T> vj12 = this.iteratorNotification;
                if ((vj12 == null || vj12.h()) && this.iteratorNotification == null) {
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
            if (!hasNext() || !this.iteratorNotification.h()) {
                throw new NoSuchElementException();
            }
            T e = this.iteratorNotification.e();
            this.iteratorNotification = null;
            return e;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            k22.u(th);
        }

        @Override // org.reactivestreams.Subscriber
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

    public BlockingFlowableLatest(Publisher<? extends T> publisher) {
        this.source = publisher;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        LatestSubscriberIterator latestSubscriberIterator = new LatestSubscriberIterator();
        io.reactivex.b.fromPublisher(this.source).materialize().subscribe((FlowableSubscriber<? super vj1<T>>) latestSubscriberIterator);
        return latestSubscriberIterator;
    }
}
