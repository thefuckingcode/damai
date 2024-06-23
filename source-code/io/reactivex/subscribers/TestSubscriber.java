package io.reactivex.subscribers;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: Taobao */
public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Subscription {
    private final Subscriber<? super T> h;
    private volatile boolean i;
    private final AtomicReference<Subscription> j;
    private final AtomicLong k;
    private QueueSubscription<T> l;

    /* compiled from: Taobao */
    enum EmptySubscriber implements FlowableSubscriber<Object> {
        INSTANCE;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
        }
    }

    public TestSubscriber() {
        this(EmptySubscriber.INSTANCE, AbsPerformance.LONG_NIL);
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (!this.i) {
            this.i = true;
            SubscriptionHelper.cancel(this.j);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        cancel();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.i;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.e) {
            this.e = true;
            if (this.j.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            this.d++;
            this.h.onComplete();
        } finally {
            this.a.countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (!this.e) {
            this.e = true;
            if (this.j.get() == null) {
                this.c.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            Thread.currentThread();
            this.c.add(th);
            if (th == null) {
                this.c.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.h.onError(th);
        } finally {
            this.a.countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (!this.e) {
            this.e = true;
            if (this.j.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        Thread.currentThread();
        if (this.g == 2) {
            while (true) {
                try {
                    T poll = this.l.poll();
                    if (poll != null) {
                        this.b.add(poll);
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    this.c.add(th);
                    this.l.cancel();
                    return;
                }
            }
        } else {
            this.b.add(t);
            if (t == null) {
                this.c.add(new NullPointerException("onNext received a null value"));
            }
            this.h.onNext(t);
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        Thread.currentThread();
        if (subscription == null) {
            this.c.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.j.compareAndSet(null, subscription)) {
            subscription.cancel();
            if (this.j.get() != SubscriptionHelper.CANCELLED) {
                this.c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + subscription));
            }
        } else {
            int i2 = this.f;
            if (i2 != 0 && (subscription instanceof QueueSubscription)) {
                QueueSubscription<T> queueSubscription = (QueueSubscription) subscription;
                this.l = queueSubscription;
                int requestFusion = queueSubscription.requestFusion(i2);
                this.g = requestFusion;
                if (requestFusion == 1) {
                    this.e = true;
                    Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.l.poll();
                            if (poll != null) {
                                this.b.add(poll);
                            } else {
                                this.d++;
                                return;
                            }
                        } catch (Throwable th) {
                            this.c.add(th);
                            return;
                        }
                    }
                }
            }
            this.h.onSubscribe(subscription);
            long andSet = this.k.getAndSet(0);
            if (andSet != 0) {
                subscription.request(andSet);
            }
            a();
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j2) {
        SubscriptionHelper.deferredRequest(this.j, this.k, j2);
    }

    public TestSubscriber(long j2) {
        this(EmptySubscriber.INSTANCE, j2);
    }

    public TestSubscriber(Subscriber<? super T> subscriber, long j2) {
        if (j2 >= 0) {
            this.h = subscriber;
            this.j = new AtomicReference<>();
            this.k = new AtomicLong(j2);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }
}
