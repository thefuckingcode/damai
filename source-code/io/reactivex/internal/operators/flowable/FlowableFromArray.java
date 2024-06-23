package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.annotations.Nullable;
import io.reactivex.b;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
public final class FlowableFromArray<T> extends b<T> {
    final T[] array;

    /* compiled from: Taobao */
    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super T> actual;

        ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.actual = conditionalSubscriber;
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            for (int i = this.index; i != length; i++) {
                if (!this.cancelled) {
                    T t = tArr[i];
                    if (t == null) {
                        conditionalSubscriber.onError(new NullPointerException("array element is null"));
                        return;
                    } else {
                        conditionalSubscriber.tryOnNext(t);
                    }
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                conditionalSubscriber.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void slowPath(long j) {
            T[] tArr = this.array;
            int length = tArr.length;
            int i = this.index;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j || i == length) {
                        if (i != length) {
                            j = get();
                            if (j2 == j) {
                                this.index = i;
                                j = addAndGet(-j2);
                            }
                        } else if (!this.cancelled) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        T t = tArr[i];
                        if (t == null) {
                            conditionalSubscriber.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        if (conditionalSubscriber.tryOnNext(t)) {
                            j2++;
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    /* compiled from: Taobao */
    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super T> actual;

        ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.actual = subscriber;
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.actual;
            for (int i = this.index; i != length; i++) {
                if (!this.cancelled) {
                    T t = tArr[i];
                    if (t == null) {
                        subscriber.onError(new NullPointerException("array element is null"));
                        return;
                    } else {
                        subscriber.onNext(t);
                    }
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                subscriber.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void slowPath(long j) {
            T[] tArr = this.array;
            int length = tArr.length;
            int i = this.index;
            Subscriber<? super T> subscriber = this.actual;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j || i == length) {
                        if (i != length) {
                            j = get();
                            if (j2 == j) {
                                this.index = i;
                                j = addAndGet(-j2);
                            }
                        } else if (!this.cancelled) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        T t = tArr[i];
                        if (t == null) {
                            subscriber.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        subscriber.onNext(t);
                        j2++;
                        i++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    /* compiled from: Taobao */
    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        BaseArraySubscription(T[] tArr) {
            this.array = tArr;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.array.length;
        }

        /* access modifiers changed from: package-private */
        public abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final T poll() {
            int i = this.index;
            T[] tArr = this.array;
            if (i == tArr.length) {
                return null;
            }
            this.index = i + 1;
            return (T) ObjectHelper.requireNonNull(tArr[i], "array element is null");
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

    public FlowableFromArray(T[] tArr) {
        this.array = tArr;
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, this.array));
        } else {
            subscriber.onSubscribe(new ArraySubscription(subscriber, this.array));
        }
    }
}
