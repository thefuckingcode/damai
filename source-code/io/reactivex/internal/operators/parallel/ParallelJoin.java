package io.reactivex.internal.operators.parallel;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.k22;

/* compiled from: Taobao */
public final class ParallelJoin<T> extends b<T> {
    final boolean delayErrors;
    final int prefetch;
    final a<? extends T> source;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final JoinSubscriptionBase<T> parent;
        final int prefetch;
        long produced;
        volatile SimplePlainQueue<T> queue;

        JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i) {
            this.parent = joinSubscriptionBase;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        /* access modifiers changed from: package-private */
        public SimplePlainQueue<T> getQueue() {
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
            this.queue = spscArrayQueue;
            return spscArrayQueue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.parent.onNext(this, t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                subscription.request((long) this.prefetch);
            }
        }

        public void request(long j) {
            long j2 = this.produced + j;
            if (j2 >= ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j2);
                return;
            }
            this.produced = j2;
        }

        public void requestOne() {
            long j = this.produced + 1;
            if (j == ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j);
                return;
            }
            this.produced = j;
        }
    }

    /* compiled from: Taobao */
    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
            if (r13 == false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
            if (r15 == false) goto L_0x0065;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
            r3.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
            if (r15 == false) goto L_0x0011;
         */
        public void drainLoop() {
            boolean z;
            T poll;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
            int length = joinInnerSubscriberArr.length;
            Subscriber<? super T> subscriber = this.actual;
            int i = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (!this.cancelled) {
                        Throwable th = (Throwable) this.errors.get();
                        if (th == null) {
                            boolean z2 = this.done.get() == 0;
                            int i2 = 0;
                            boolean z3 = true;
                            while (true) {
                                if (i2 >= joinInnerSubscriberArr.length) {
                                    break;
                                }
                                JoinInnerSubscriber<T> joinInnerSubscriber = joinInnerSubscriberArr[i2];
                                SimplePlainQueue<T> simplePlainQueue = joinInnerSubscriber.queue;
                                if (!(simplePlainQueue == null || (poll = simplePlainQueue.poll()) == null)) {
                                    subscriber.onNext(poll);
                                    joinInnerSubscriber.requestOne();
                                    j2++;
                                    if (j2 == j) {
                                        break;
                                    }
                                    z3 = false;
                                }
                                i2++;
                            }
                        } else {
                            cleanup();
                            subscriber.onError(th);
                            return;
                        }
                    } else {
                        cleanup();
                        return;
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    Throwable th2 = (Throwable) this.errors.get();
                    if (th2 != null) {
                        cleanup();
                        subscriber.onError(th2);
                        return;
                    }
                    boolean z4 = this.done.get() == 0;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            SimplePlainQueue<T> simplePlainQueue2 = joinInnerSubscriberArr[i3].queue;
                            if (simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) {
                                z = false;
                                break;
                            }
                            i3++;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z4 && z) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (!(j2 == 0 || j == AbsPerformance.LONG_NIL)) {
                    this.requested.addAndGet(-j2);
                }
                int i4 = get();
                if (i4 != i || (i4 = addAndGet(-i)) != 0) {
                    i = i4;
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable th) {
            if (this.errors.compareAndSet(null, th)) {
                cancelAll();
                drain();
            } else if (th != this.errors.get()) {
                k22.u(th);
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != AbsPerformance.LONG_NIL) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    cancelAll();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.errors.compareAndSet(null, missingBackpressureException)) {
                        this.actual.onError(missingBackpressureException);
                        return;
                    } else {
                        k22.u(missingBackpressureException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                cancelAll();
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;
        final Subscriber<? super T> actual;
        volatile boolean cancelled;
        final AtomicInteger done = new AtomicInteger();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();
        final JoinInnerSubscriber<T>[] subscribers;

        JoinSubscriptionBase(Subscriber<? super T> subscriber, int i, int i2) {
            this.actual = subscriber;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                joinInnerSubscriberArr[i3] = new JoinInnerSubscriber<>(this, i2);
            }
            this.subscribers = joinInnerSubscriberArr;
            this.done.lazySet(i);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    cleanup();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelAll() {
            int i = 0;
            while (true) {
                JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
                if (i < joinInnerSubscriberArr.length) {
                    joinInnerSubscriberArr[i].cancel();
                    i++;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void cleanup() {
            int i = 0;
            while (true) {
                JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
                if (i < joinInnerSubscriberArr.length) {
                    joinInnerSubscriberArr[i].queue = null;
                    i++;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void drain();

        /* access modifiers changed from: package-private */
        public abstract void onComplete();

        /* access modifiers changed from: package-private */
        public abstract void onError(Throwable th);

        /* access modifiers changed from: package-private */
        public abstract void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t);

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }
    }

    /* compiled from: Taobao */
    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
            if (r13 == false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
            if (r15 == false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
            if (((java.lang.Throwable) r18.errors.get()) == null) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
            r3.onError(r18.errors.terminate());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
            r3.onComplete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
            if (r15 == false) goto L_0x0011;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
            return;
         */
        public void drainLoop() {
            boolean z;
            T poll;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.subscribers;
            int length = joinInnerSubscriberArr.length;
            Subscriber<? super T> subscriber = this.actual;
            int i = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (!this.cancelled) {
                        boolean z2 = this.done.get() == 0;
                        int i2 = 0;
                        boolean z3 = true;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            JoinInnerSubscriber<T> joinInnerSubscriber = joinInnerSubscriberArr[i2];
                            SimplePlainQueue<T> simplePlainQueue = joinInnerSubscriber.queue;
                            if (!(simplePlainQueue == null || (poll = simplePlainQueue.poll()) == null)) {
                                subscriber.onNext(poll);
                                joinInnerSubscriber.requestOne();
                                j2++;
                                if (j2 == j) {
                                    break;
                                }
                                z3 = false;
                            }
                            i2++;
                        }
                    } else {
                        cleanup();
                        return;
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        cleanup();
                        return;
                    }
                    boolean z4 = this.done.get() == 0;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            SimplePlainQueue<T> simplePlainQueue2 = joinInnerSubscriberArr[i3].queue;
                            if (simplePlainQueue2 != null && !simplePlainQueue2.isEmpty()) {
                                z = false;
                                break;
                            }
                            i3++;
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z4 && z) {
                        if (((Throwable) this.errors.get()) != null) {
                            subscriber.onError(this.errors.terminate());
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                if (!(j2 == 0 || j == AbsPerformance.LONG_NIL)) {
                    this.requested.addAndGet(-j2);
                }
                int i4 = get();
                if (i4 != i || (i4 = addAndGet(-i)) != 0) {
                    i = i4;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable th) {
            this.errors.addThrowable(th);
            this.done.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                if (!joinInnerSubscriber.getQueue().offer(t) && joinInnerSubscriber.cancel()) {
                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                if (this.requested.get() != 0) {
                    this.actual.onNext(t);
                    if (this.requested.get() != AbsPerformance.LONG_NIL) {
                        this.requested.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1);
                } else if (!joinInnerSubscriber.getQueue().offer(t)) {
                    joinInnerSubscriber.cancel();
                    this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.done.decrementAndGet();
                    drainLoop();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            drainLoop();
        }
    }

    public ParallelJoin(a<? extends T> aVar, int i, boolean z) {
        this.source = aVar;
        this.prefetch = i;
        this.delayErrors = z;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        JoinSubscriptionBase joinSubscriptionBase;
        if (this.delayErrors) {
            joinSubscriptionBase = new JoinSubscriptionDelayError(subscriber, this.source.parallelism(), this.prefetch);
        } else {
            joinSubscriptionBase = new JoinSubscription(subscriber, this.source.parallelism(), this.prefetch);
        }
        subscriber.onSubscribe(joinSubscriptionBase);
        this.source.subscribe(joinSubscriptionBase.subscribers);
    }
}
