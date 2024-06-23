package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayError;
    final int prefetch;
    final Function<? super b<T>, ? extends Publisher<? extends R>> selector;

    /* compiled from: Taobao */
    static final class MulticastProcessor<T> extends b<T> implements FlowableSubscriber<T>, Disposable {
        static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
        static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
        int consumed;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        volatile SimpleQueue<T> queue;
        final AtomicReference<Subscription> s = new AtomicReference<>();
        int sourceMode;
        final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicInteger wip = new AtomicInteger();

        MulticastProcessor(int i, boolean z) {
            this.prefetch = i;
            this.limit = i - (i >> 2);
            this.delayError = z;
        }

        /* access modifiers changed from: package-private */
        public boolean add(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription<T>[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.subscribers.get();
                if (multicastSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[(length + 1)];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void completeAll() {
            MulticastSubscription<T>[] andSet = this.subscribers.getAndSet(TERMINATED);
            for (MulticastSubscription<T> multicastSubscription : andSet) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onComplete();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SimpleQueue<T> simpleQueue;
            SubscriptionHelper.cancel(this.s);
            if (this.wip.getAndIncrement() == 0 && (simpleQueue = this.queue) != null) {
                simpleQueue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            int i;
            Throwable th;
            Throwable th2;
            if (this.wip.getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.queue;
                int i2 = this.consumed;
                int i3 = this.limit;
                boolean z = this.sourceMode != 1;
                int i4 = 1;
                while (true) {
                    MulticastSubscription<T>[] multicastSubscriptionArr = this.subscribers.get();
                    int length = multicastSubscriptionArr.length;
                    if (!(simpleQueue == null || length == 0)) {
                        long j = AbsPerformance.LONG_NIL;
                        for (MulticastSubscription<T> multicastSubscription : multicastSubscriptionArr) {
                            long j2 = multicastSubscription.get();
                            if (j2 != Long.MIN_VALUE && j > j2) {
                                j = j2;
                            }
                        }
                        long j3 = 0;
                        while (true) {
                            i = (j3 > j ? 1 : (j3 == j ? 0 : -1));
                            if (i == 0) {
                                break;
                            } else if (isDisposed()) {
                                simpleQueue.clear();
                                return;
                            } else {
                                boolean z2 = this.done;
                                if (!z2 || this.delayError || (th2 = this.error) == null) {
                                    try {
                                        T poll = simpleQueue.poll();
                                        boolean z3 = poll == null;
                                        if (z2 && z3) {
                                            Throwable th3 = this.error;
                                            if (th3 != null) {
                                                errorAll(th3);
                                                return;
                                            } else {
                                                completeAll();
                                                return;
                                            }
                                        } else if (z3) {
                                            break;
                                        } else {
                                            int i5 = 0;
                                            for (int length2 = multicastSubscriptionArr.length; i5 < length2; length2 = length2) {
                                                MulticastSubscription<T> multicastSubscription2 = multicastSubscriptionArr[i5];
                                                if (multicastSubscription2.get() != Long.MIN_VALUE) {
                                                    multicastSubscription2.actual.onNext(poll);
                                                }
                                                i5++;
                                            }
                                            j3++;
                                            if (z && (i2 = i2 + 1) == i3) {
                                                this.s.get().request((long) i3);
                                                i2 = 0;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        ff0.b(th4);
                                        SubscriptionHelper.cancel(this.s);
                                        errorAll(th4);
                                        return;
                                    }
                                } else {
                                    errorAll(th2);
                                    return;
                                }
                            }
                        }
                        if (i == 0) {
                            if (isDisposed()) {
                                simpleQueue.clear();
                                return;
                            }
                            boolean z4 = this.done;
                            if (z4 && !this.delayError && (th = this.error) != null) {
                                errorAll(th);
                                return;
                            } else if (z4 && simpleQueue.isEmpty()) {
                                Throwable th5 = this.error;
                                if (th5 != null) {
                                    errorAll(th5);
                                    return;
                                } else {
                                    completeAll();
                                    return;
                                }
                            }
                        }
                        for (MulticastSubscription<T> multicastSubscription3 : multicastSubscriptionArr) {
                            BackpressureHelper.produced(multicastSubscription3, j3);
                        }
                    }
                    this.consumed = i2;
                    i4 = this.wip.addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                    if (simpleQueue == null) {
                        simpleQueue = this.queue;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void errorAll(Throwable th) {
            MulticastSubscription<T>[] andSet = this.subscribers.getAndSet(TERMINATED);
            for (MulticastSubscription<T> multicastSubscription : andSet) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(this.s.get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                k22.u(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0 || this.queue.offer(t)) {
                    drain();
                    return;
                }
                this.s.get().cancel();
                onError(new MissingBackpressureException());
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.s, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        QueueDrainHelper.request(subscription, this.prefetch);
                        return;
                    }
                }
                this.queue = QueueDrainHelper.createQueue(this.prefetch);
                QueueDrainHelper.request(subscription, this.prefetch);
            }
        }

        /* access modifiers changed from: package-private */
        public void remove(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription<T>[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.subscribers.get();
                if (multicastSubscriptionArr != TERMINATED && multicastSubscriptionArr != EMPTY) {
                    int length = multicastSubscriptionArr.length;
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (multicastSubscriptionArr[i2] == multicastSubscription) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            multicastSubscriptionArr2 = EMPTY;
                        } else {
                            MulticastSubscription<T>[] multicastSubscriptionArr3 = new MulticastSubscription[(length - 1)];
                            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i);
                            System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr3, i, (length - i) - 1);
                            multicastSubscriptionArr2 = multicastSubscriptionArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        /* access modifiers changed from: protected */
        @Override // io.reactivex.b
        public void subscribeActual(Subscriber<? super T> subscriber) {
            MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(subscriber, this);
            subscriber.onSubscribe(multicastSubscription);
            if (!add(multicastSubscription)) {
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
            } else if (multicastSubscription.isCancelled()) {
                remove(multicastSubscription);
            } else {
                drain();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        final Subscriber<? super T> actual;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.actual = subscriber;
            this.parent = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.drain();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                this.parent.drain();
            }
        }
    }

    /* compiled from: Taobao */
    static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {
        final Subscriber<? super R> actual;
        final MulticastProcessor<?> processor;
        Subscription s;

        OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            this.actual = subscriber;
            this.processor = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.s.cancel();
            this.processor.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
            this.processor.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
            this.processor.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            this.actual.onNext(r);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.s.request(j);
        }
    }

    public FlowablePublishMulticast(b<T> bVar, Function<? super b<T>, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(bVar);
        this.selector = function;
        this.prefetch = i;
        this.delayError = z;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super R> subscriber) {
        MulticastProcessor multicastProcessor = new MulticastProcessor(this.prefetch, this.delayError);
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.selector.apply(multicastProcessor), "selector returned a null Publisher")).subscribe(new OutputCanceller(subscriber, multicastProcessor));
            this.source.subscribe((FlowableSubscriber) multicastProcessor);
        } catch (Throwable th) {
            ff0.b(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
