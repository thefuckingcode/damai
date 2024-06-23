package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.annotations.Nullable;
import io.reactivex.b;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
public final class FlowableRange extends b<Integer> {
    final int end;
    final int start;

    /* compiled from: Taobao */
    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final int end;
        int index;

        BaseRangeSubscription(int i, int i2) {
            this.index = i;
            this.end = i2;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.end;
        }

        /* access modifiers changed from: package-private */
        public abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.index == this.end;
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

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public final Integer poll() {
            int i = this.index;
            if (i == this.end) {
                return null;
            }
            this.index = i + 1;
            return Integer.valueOf(i);
        }
    }

    /* compiled from: Taobao */
    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super Integer> actual;

        RangeConditionalSubscription(ConditionalSubscriber<? super Integer> conditionalSubscriber, int i, int i2) {
            super(i, i2);
            this.actual = conditionalSubscriber;
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void fastPath() {
            int i = this.end;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.actual;
            for (int i2 = this.index; i2 != i; i2++) {
                if (!this.cancelled) {
                    conditionalSubscriber.tryOnNext(Integer.valueOf(i2));
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                conditionalSubscriber.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void slowPath(long j) {
            int i = this.end;
            int i2 = this.index;
            ConditionalSubscriber<? super Integer> conditionalSubscriber = this.actual;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j || i2 == i) {
                        if (i2 != i) {
                            j = get();
                            if (j2 == j) {
                                this.index = i2;
                                j = addAndGet(-j2);
                            }
                        } else if (!this.cancelled) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        if (conditionalSubscriber.tryOnNext(Integer.valueOf(i2))) {
                            j2++;
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    /* compiled from: Taobao */
    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super Integer> actual;

        RangeSubscription(Subscriber<? super Integer> subscriber, int i, int i2) {
            super(i, i2);
            this.actual = subscriber;
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void fastPath() {
            int i = this.end;
            Subscriber<? super Integer> subscriber = this.actual;
            for (int i2 = this.index; i2 != i; i2++) {
                if (!this.cancelled) {
                    subscriber.onNext(Integer.valueOf(i2));
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                subscriber.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void slowPath(long j) {
            int i = this.end;
            int i2 = this.index;
            Subscriber<? super Integer> subscriber = this.actual;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j || i2 == i) {
                        if (i2 != i) {
                            j = get();
                            if (j2 == j) {
                                this.index = i2;
                                j = addAndGet(-j2);
                            }
                        } else if (!this.cancelled) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        subscriber.onNext(Integer.valueOf(i2));
                        j2++;
                        i2++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    public FlowableRange(int i, int i2) {
        this.start = i;
        this.end = i + i2;
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super Integer> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.start, this.end));
        } else {
            subscriber.onSubscribe(new RangeSubscription(subscriber, this.start, this.end));
        }
    }
}
