package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.a;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.im;
import tb.ql;

/* compiled from: Taobao */
public final class FlowableRefCount<T> extends AbstractFlowableWithUpstream<T, T> {
    volatile ql baseDisposable = new ql();
    final ReentrantLock lock = new ReentrantLock();
    final im<T> source;
    final AtomicInteger subscriptionCount = new AtomicInteger();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class ConnectionSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 152064694420235350L;
        final ql currentBase;
        final AtomicLong requested = new AtomicLong();
        final Disposable resource;
        final Subscriber<? super T> subscriber;

        ConnectionSubscriber(Subscriber<? super T> subscriber2, ql qlVar, Disposable disposable) {
            this.subscriber = subscriber2;
            this.currentBase = qlVar;
            this.resource = disposable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
            this.resource.dispose();
        }

        /* access modifiers changed from: package-private */
        public void cleanup() {
            FlowableRefCount.this.lock.lock();
            try {
                if (FlowableRefCount.this.baseDisposable == this.currentBase) {
                    im<T> imVar = FlowableRefCount.this.source;
                    if (imVar instanceof Disposable) {
                        ((Disposable) imVar).dispose();
                    }
                    FlowableRefCount.this.baseDisposable.dispose();
                    FlowableRefCount.this.baseDisposable = new ql();
                    FlowableRefCount.this.subscriptionCount.set(0);
                }
            } finally {
                FlowableRefCount.this.lock.unlock();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.requested, j);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class DisposeConsumer implements Consumer<Disposable> {
        private final Subscriber<? super T> subscriber;
        private final AtomicBoolean writeLocked;

        DisposeConsumer(Subscriber<? super T> subscriber2, AtomicBoolean atomicBoolean) {
            this.subscriber = subscriber2;
            this.writeLocked = atomicBoolean;
        }

        public void accept(Disposable disposable) {
            try {
                FlowableRefCount.this.baseDisposable.add(disposable);
                FlowableRefCount flowableRefCount = FlowableRefCount.this;
                flowableRefCount.doSubscribe(this.subscriber, flowableRefCount.baseDisposable);
            } finally {
                FlowableRefCount.this.lock.unlock();
                this.writeLocked.set(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class DisposeTask implements Runnable {
        private final ql current;

        DisposeTask(ql qlVar) {
            this.current = qlVar;
        }

        public void run() {
            FlowableRefCount.this.lock.lock();
            try {
                if (FlowableRefCount.this.baseDisposable == this.current && FlowableRefCount.this.subscriptionCount.decrementAndGet() == 0) {
                    im<T> imVar = FlowableRefCount.this.source;
                    if (imVar instanceof Disposable) {
                        ((Disposable) imVar).dispose();
                    }
                    FlowableRefCount.this.baseDisposable.dispose();
                    FlowableRefCount.this.baseDisposable = new ql();
                }
            } finally {
                FlowableRefCount.this.lock.unlock();
            }
        }
    }

    public FlowableRefCount(im<T> imVar) {
        super(imVar);
        this.source = imVar;
    }

    private Disposable disconnect(ql qlVar) {
        return a.c(new DisposeTask(qlVar));
    }

    private Consumer<Disposable> onSubscribe(Subscriber<? super T> subscriber, AtomicBoolean atomicBoolean) {
        return new DisposeConsumer(subscriber, atomicBoolean);
    }

    /* access modifiers changed from: package-private */
    public void doSubscribe(Subscriber<? super T> subscriber, ql qlVar) {
        ConnectionSubscriber connectionSubscriber = new ConnectionSubscriber(subscriber, qlVar, disconnect(qlVar));
        subscriber.onSubscribe(connectionSubscriber);
        this.source.subscribe((FlowableSubscriber) connectionSubscriber);
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.lock.lock();
        if (this.subscriptionCount.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.source.connect(onSubscribe(subscriber, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                    this.lock.unlock();
                }
            }
        } else {
            try {
                doSubscribe(subscriber, this.baseDisposable);
            } finally {
                this.lock.unlock();
            }
        }
    }
}
