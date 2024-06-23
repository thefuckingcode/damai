package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    /* compiled from: Taobao */
    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        final Subscriber<? super R> actual;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        final AtomicLong requested = new AtomicLong();
        Subscription s;
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;

        ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode2) {
            this.actual = subscriber;
            this.mapper = function;
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = errorMode2;
            this.subscribers = new SpscLinkedArrayQueue<>(Math.min(i2, i));
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                drainAndCancel();
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelAll() {
            while (true) {
                InnerQueuedSubscriber<R> poll = this.subscribers.poll();
                if (poll != null) {
                    poll.cancel();
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void drain() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber;
            int i;
            long j;
            boolean z;
            SimpleQueue<R> queue;
            int i2;
            if (getAndIncrement() == 0) {
                InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.current;
                Subscriber<? super R> subscriber = this.actual;
                ErrorMode errorMode2 = this.errorMode;
                int i3 = 1;
                while (true) {
                    long j2 = this.requested.get();
                    if (innerQueuedSubscriber2 != null) {
                        innerQueuedSubscriber = innerQueuedSubscriber2;
                    } else if (errorMode2 == ErrorMode.END || ((Throwable) this.errors.get()) == null) {
                        boolean z2 = this.done;
                        innerQueuedSubscriber = this.subscribers.poll();
                        if (z2 && innerQueuedSubscriber == null) {
                            Throwable terminate = this.errors.terminate();
                            if (terminate != null) {
                                subscriber.onError(terminate);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        } else if (innerQueuedSubscriber != null) {
                            this.current = innerQueuedSubscriber;
                        }
                    } else {
                        cancelAll();
                        subscriber.onError(this.errors.terminate());
                        return;
                    }
                    if (innerQueuedSubscriber == null || (queue = innerQueuedSubscriber.queue()) == null) {
                        i = i3;
                        j = 0;
                        z = false;
                    } else {
                        i = i3;
                        j = 0;
                        while (true) {
                            i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                            if (i2 == 0) {
                                break;
                            } else if (this.cancelled) {
                                cancelAll();
                                return;
                            } else if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                                boolean isDone = innerQueuedSubscriber.isDone();
                                try {
                                    R poll = queue.poll();
                                    boolean z3 = poll == null;
                                    if (isDone && z3) {
                                        this.current = null;
                                        this.s.request(1);
                                        innerQueuedSubscriber = null;
                                        z = true;
                                        break;
                                    } else if (z3) {
                                        break;
                                    } else {
                                        subscriber.onNext(poll);
                                        j++;
                                        innerQueuedSubscriber.requestOne();
                                    }
                                } catch (Throwable th) {
                                    ff0.b(th);
                                    this.current = null;
                                    innerQueuedSubscriber.cancel();
                                    cancelAll();
                                    subscriber.onError(th);
                                    return;
                                }
                            } else {
                                this.current = null;
                                innerQueuedSubscriber.cancel();
                                cancelAll();
                                subscriber.onError(this.errors.terminate());
                                return;
                            }
                        }
                        z = false;
                        if (i2 == 0) {
                            if (this.cancelled) {
                                cancelAll();
                                return;
                            } else if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                                boolean isDone2 = innerQueuedSubscriber.isDone();
                                boolean isEmpty = queue.isEmpty();
                                if (isDone2 && isEmpty) {
                                    this.current = null;
                                    this.s.request(1);
                                    innerQueuedSubscriber = null;
                                    z = true;
                                }
                            } else {
                                this.current = null;
                                innerQueuedSubscriber.cancel();
                                cancelAll();
                                subscriber.onError(this.errors.terminate());
                                return;
                            }
                        }
                    }
                    if (!(j == 0 || j2 == AbsPerformance.LONG_NIL)) {
                        this.requested.addAndGet(-j);
                    }
                    if (z) {
                        innerQueuedSubscriber2 = innerQueuedSubscriber;
                        i3 = i;
                    } else {
                        i3 = addAndGet(-i);
                        if (i3 != 0) {
                            innerQueuedSubscriber2 = innerQueuedSubscriber;
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            drain();
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (this.errors.addThrowable(th)) {
                innerQueuedSubscriber.setDone();
                if (this.errorMode != ErrorMode.END) {
                    this.s.cancel();
                }
                drain();
                return;
            }
            k22.u(th);
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
            if (innerQueuedSubscriber.queue().offer(r)) {
                drain();
                return;
            }
            innerQueuedSubscriber.cancel();
            innerError(innerQueuedSubscriber, new MissingBackpressureException());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            k22.u(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                InnerQueuedSubscriber<R> innerQueuedSubscriber = new InnerQueuedSubscriber<>(this, this.prefetch);
                if (!this.cancelled) {
                    this.subscribers.offer(innerQueuedSubscriber);
                    if (!this.cancelled) {
                        publisher.subscribe(innerQueuedSubscriber);
                        if (this.cancelled) {
                            innerQueuedSubscriber.cancel();
                            drainAndCancel();
                        }
                    }
                }
            } catch (Throwable th) {
                ff0.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                int i = this.maxConcurrency;
                subscription.request(i == Integer.MAX_VALUE ? AbsPerformance.LONG_NIL : (long) i);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }
    }

    public FlowableConcatMapEager(b<T> bVar, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode2) {
        super(bVar);
        this.mapper = function;
        this.maxConcurrency = i;
        this.prefetch = i2;
        this.errorMode = errorMode2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber) new ConcatMapEagerDelayErrorSubscriber(subscriber, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }
}
