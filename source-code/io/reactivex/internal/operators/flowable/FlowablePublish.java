package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.ff0;
import tb.im;
import tb.k22;

/* compiled from: Taobao */
public final class FlowablePublish<T> extends im<T> implements HasUpstreamPublisher<T> {
    static final long CANCELLED = Long.MIN_VALUE;
    final int bufferSize;
    final AtomicReference<PublishSubscriber<T>> current;
    final Publisher<T> onSubscribe;
    final b<T> source;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class FlowablePublisher<T> implements Publisher<T> {
        private final int bufferSize;
        private final AtomicReference<PublishSubscriber<T>> curr;

        FlowablePublisher(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.curr = atomicReference;
            this.bufferSize = i;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            PublishSubscriber<T> publishSubscriber;
            InnerSubscriber<T> innerSubscriber = new InnerSubscriber<>(subscriber);
            subscriber.onSubscribe(innerSubscriber);
            while (true) {
                publishSubscriber = this.curr.get();
                if (publishSubscriber == null || publishSubscriber.isDisposed()) {
                    PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.curr, this.bufferSize);
                    if (!this.curr.compareAndSet(publishSubscriber, publishSubscriber2)) {
                        continue;
                    } else {
                        publishSubscriber = publishSubscriber2;
                    }
                }
                if (publishSubscriber.add(innerSubscriber)) {
                    break;
                }
            }
            if (innerSubscriber.get() == FlowablePublish.CANCELLED) {
                publishSubscriber.remove(innerSubscriber);
            } else {
                innerSubscriber.parent = publishSubscriber;
            }
            publishSubscriber.dispatch();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class InnerSubscriber<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        volatile PublishSubscriber<T> parent;

        InnerSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            PublishSubscriber<T> publishSubscriber;
            if (get() != FlowablePublish.CANCELLED && getAndSet(FlowablePublish.CANCELLED) != FlowablePublish.CANCELLED && (publishSubscriber = this.parent) != null) {
                publishSubscriber.remove(this);
                publishSubscriber.dispatch();
            }
        }

        public long produced(long j) {
            return BackpressureHelper.producedCancel(this, j);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                PublishSubscriber<T> publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.dispatch();
                }
            }
        }
    }

    /* compiled from: Taobao */
    static final class PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscriber[] EMPTY = new InnerSubscriber[0];
        static final InnerSubscriber[] TERMINATED = new InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<PublishSubscriber<T>> current;
        volatile SimpleQueue<T> queue;
        final AtomicReference<Subscription> s = new AtomicReference<>();
        final AtomicBoolean shouldConnect;
        int sourceMode;
        final AtomicReference<InnerSubscriber[]> subscribers = new AtomicReference<>(EMPTY);
        volatile Object terminalEvent;

        PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
            this.bufferSize = i;
        }

        /* access modifiers changed from: package-private */
        public boolean add(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == TERMINATED) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean checkTerminated(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!NotificationLite.isComplete(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    this.current.compareAndSet(this, null);
                    InnerSubscriber[] andSet = this.subscribers.getAndSet(TERMINATED);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i < length) {
                            andSet[i].child.onError(error);
                            i++;
                        }
                    } else {
                        k22.u(error);
                    }
                    return true;
                } else if (z) {
                    this.current.compareAndSet(this, null);
                    InnerSubscriber[] andSet2 = this.subscribers.getAndSet(TERMINATED);
                    int length2 = andSet2.length;
                    while (i < length2) {
                        andSet2[i].child.onComplete();
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0114, code lost:
            if (r16 == false) goto L_0x0116;
         */
        public void dispatch() {
            int i;
            long j;
            long j2;
            T t;
            T t2;
            if (getAndIncrement() == 0) {
                int i2 = 1;
                int i3 = 1;
                while (true) {
                    Object obj = this.terminalEvent;
                    SimpleQueue<T> simpleQueue = this.queue;
                    boolean z = simpleQueue == null || simpleQueue.isEmpty();
                    if (!checkTerminated(obj, z)) {
                        if (!z) {
                            InnerSubscriber[] innerSubscriberArr = this.subscribers.get();
                            int length = innerSubscriberArr.length;
                            long j3 = AbsPerformance.LONG_NIL;
                            int length2 = innerSubscriberArr.length;
                            int i4 = 0;
                            int i5 = 0;
                            while (true) {
                                j = 0;
                                if (i4 >= length2) {
                                    break;
                                }
                                long j4 = innerSubscriberArr[i4].get();
                                if (j4 >= 0) {
                                    j3 = Math.min(j3, j4);
                                } else if (j4 == FlowablePublish.CANCELLED) {
                                    i5++;
                                }
                                i4++;
                                z = z;
                            }
                            boolean z2 = z;
                            if (length == i5) {
                                Object obj2 = this.terminalEvent;
                                try {
                                    t2 = simpleQueue.poll();
                                } catch (Throwable th) {
                                    ff0.b(th);
                                    this.s.get().cancel();
                                    obj2 = NotificationLite.error(th);
                                    this.terminalEvent = obj2;
                                    t2 = null;
                                }
                                if (!checkTerminated(obj2, t2 == null)) {
                                    if (this.sourceMode != i2) {
                                        this.s.get().request(1);
                                    }
                                    i = i3;
                                } else {
                                    return;
                                }
                            } else {
                                i = i3;
                                int i6 = 0;
                                while (true) {
                                    j2 = (long) i6;
                                    if (j2 >= j3) {
                                        break;
                                    }
                                    Object obj3 = this.terminalEvent;
                                    try {
                                        t = simpleQueue.poll();
                                    } catch (Throwable th2) {
                                        ff0.b(th2);
                                        this.s.get().cancel();
                                        obj3 = NotificationLite.error(th2);
                                        this.terminalEvent = obj3;
                                        t = null;
                                    }
                                    boolean z3 = t == null;
                                    if (!checkTerminated(obj3, z3)) {
                                        if (z3) {
                                            z2 = z3;
                                            break;
                                        }
                                        Object value = NotificationLite.getValue(t);
                                        int length3 = innerSubscriberArr.length;
                                        int i7 = 0;
                                        while (i7 < length3) {
                                            InnerSubscriber innerSubscriber = innerSubscriberArr[i7];
                                            if (innerSubscriber.get() > j) {
                                                innerSubscriber.child.onNext(value);
                                                innerSubscriber.produced(1);
                                            }
                                            i7++;
                                            j = 0;
                                        }
                                        i6++;
                                        z2 = z3;
                                        j = 0;
                                    } else {
                                        return;
                                    }
                                }
                                if (i6 > 0) {
                                    if (this.sourceMode != 1) {
                                        this.s.get().request(j2);
                                    }
                                }
                                if (j3 != 0) {
                                }
                            }
                            i3 = i;
                            i2 = 1;
                        } else {
                            i = i3;
                        }
                        i3 = addAndGet(-i);
                        if (i3 != 0) {
                            i2 = 1;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            InnerSubscriber[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber[] innerSubscriberArr2 = TERMINATED;
            if (innerSubscriberArr != innerSubscriberArr2 && this.subscribers.getAndSet(innerSubscriberArr2) != innerSubscriberArr2) {
                this.current.compareAndSet(this, null);
                SubscriptionHelper.cancel(this.s);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                dispatch();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.error(th);
                dispatch();
                return;
            }
            k22.u(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                dispatch();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
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
                        this.terminalEvent = NotificationLite.complete();
                        dispatch();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        subscription.request((long) this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                subscription.request((long) this.bufferSize);
            }
        }

        /* access modifiers changed from: package-private */
        public void remove(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerSubscriberArr[i2].equals(innerSubscriber)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerSubscriberArr2 = EMPTY;
                        } else {
                            InnerSubscriber[] innerSubscriberArr3 = new InnerSubscriber[(length - 1)];
                            System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                            System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                            innerSubscriberArr2 = innerSubscriberArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
        }
    }

    private FlowablePublish(Publisher<T> publisher, b<T> bVar, AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
        this.onSubscribe = publisher;
        this.source = bVar;
        this.current = atomicReference;
        this.bufferSize = i;
    }

    public static <T> im<T> create(b<T> bVar, int i) {
        AtomicReference atomicReference = new AtomicReference();
        return k22.q(new FlowablePublish(new FlowablePublisher(atomicReference, i), bVar, atomicReference, i));
    }

    @Override // tb.im
    public void connect(Consumer<? super Disposable> consumer) {
        PublishSubscriber<T> publishSubscriber;
        while (true) {
            publishSubscriber = this.current.get();
            if (publishSubscriber != null && !publishSubscriber.isDisposed()) {
                break;
            }
            PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.current, this.bufferSize);
            if (this.current.compareAndSet(publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean z = true;
        if (publishSubscriber.shouldConnect.get() || !publishSubscriber.shouldConnect.compareAndSet(false, true)) {
            z = false;
        }
        try {
            consumer.accept(publishSubscriber);
            if (z) {
                this.source.subscribe((FlowableSubscriber) publishSubscriber);
            }
        } catch (Throwable th) {
            ff0.b(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.onSubscribe.subscribe(subscriber);
    }
}
