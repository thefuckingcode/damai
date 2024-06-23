package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.annotations.Nullable;
import io.reactivex.b;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import tb.ff0;

/* compiled from: Taobao */
public final class FlowableFromIterable<T> extends b<T> {
    final Iterable<? extends T> source;

    /* compiled from: Taobao */
    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        Iterator<? extends T> it;
        boolean once;

        BaseRangeSubscription(Iterator<? extends T> it2) {
            this.it = it2;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.it = null;
        }

        /* access modifiers changed from: package-private */
        public abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            Iterator<? extends T> it2 = this.it;
            return it2 == null || !it2.hasNext();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final T poll() {
            Iterator<? extends T> it2 = this.it;
            if (it2 == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it2.hasNext()) {
                return null;
            }
            return (T) ObjectHelper.requireNonNull(this.it.next(), "Iterator.next() returned a null value");
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == AbsPerformance.LONG_NIL) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            return i & 1;
        }

        /* access modifiers changed from: package-private */
        public abstract void slowPath(long j);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final ConditionalSubscriber<? super T> actual;

        IteratorConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<? extends T> it) {
            super(it);
            this.actual = conditionalSubscriber;
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void fastPath() {
            Iterator<? extends T> it = this.it;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            while (!this.cancelled) {
                try {
                    Object obj = (Object) it.next();
                    if (!this.cancelled) {
                        if (obj == 0) {
                            conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        conditionalSubscriber.tryOnNext(obj);
                        if (!this.cancelled) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.cancelled) {
                                        conditionalSubscriber.onComplete();
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                ff0.b(th);
                                conditionalSubscriber.onError(th);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    ff0.b(th2);
                    conditionalSubscriber.onError(th2);
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void slowPath(long j) {
            Iterator<? extends T> it = this.it;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        j = get();
                        if (j2 == j) {
                            j = addAndGet(-j2);
                        }
                    } else if (!this.cancelled) {
                        try {
                            Object obj = (Object) it.next();
                            if (!this.cancelled) {
                                if (obj == 0) {
                                    conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                boolean tryOnNext = conditionalSubscriber.tryOnNext(obj);
                                if (!this.cancelled) {
                                    try {
                                        if (!it.hasNext()) {
                                            if (!this.cancelled) {
                                                conditionalSubscriber.onComplete();
                                                return;
                                            }
                                            return;
                                        } else if (tryOnNext) {
                                            j2++;
                                        }
                                    } catch (Throwable th) {
                                        ff0.b(th);
                                        conditionalSubscriber.onError(th);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            ff0.b(th2);
                            conditionalSubscriber.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        final Subscriber<? super T> actual;

        IteratorSubscription(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            super(it);
            this.actual = subscriber;
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void fastPath() {
            Iterator<? extends T> it = this.it;
            Subscriber<? super T> subscriber = this.actual;
            while (!this.cancelled) {
                try {
                    Object obj = (Object) it.next();
                    if (!this.cancelled) {
                        if (obj == 0) {
                            subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        subscriber.onNext(obj);
                        if (!this.cancelled) {
                            try {
                                if (!it.hasNext()) {
                                    if (!this.cancelled) {
                                        subscriber.onComplete();
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                ff0.b(th);
                                subscriber.onError(th);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    ff0.b(th2);
                    subscriber.onError(th2);
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void slowPath(long j) {
            Iterator<? extends T> it = this.it;
            Subscriber<? super T> subscriber = this.actual;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        j = get();
                        if (j2 == j) {
                            j = addAndGet(-j2);
                        }
                    } else if (!this.cancelled) {
                        try {
                            Object obj = (Object) it.next();
                            if (!this.cancelled) {
                                if (obj == 0) {
                                    subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                                    return;
                                }
                                subscriber.onNext(obj);
                                if (!this.cancelled) {
                                    try {
                                        if (it.hasNext()) {
                                            j2++;
                                        } else if (!this.cancelled) {
                                            subscriber.onComplete();
                                            return;
                                        } else {
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        ff0.b(th);
                                        subscriber.onError(th);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            ff0.b(th2);
                            subscriber.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.source = iterable;
    }

    public static <T> void subscribe(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.complete(subscriber);
            } else if (subscriber instanceof ConditionalSubscriber) {
                subscriber.onSubscribe(new IteratorConditionalSubscription((ConditionalSubscriber) subscriber, it));
            } else {
                subscriber.onSubscribe(new IteratorSubscription(subscriber, it));
            }
        } catch (Throwable th) {
            ff0.b(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscribe(subscriber, this.source.iterator());
        } catch (Throwable th) {
            ff0.b(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
