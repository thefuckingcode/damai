package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.b;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.em2;

/* compiled from: Taobao */
public final class FlowableTimeInterval<T> extends AbstractFlowableWithUpstream<T, em2<T>> {
    final Scheduler scheduler;
    final TimeUnit unit;

    /* compiled from: Taobao */
    static final class TimeIntervalSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super em2<T>> actual;
        long lastTime;
        Subscription s;
        final Scheduler scheduler;
        final TimeUnit unit;

        TimeIntervalSubscriber(Subscriber<? super em2<T>> subscriber, TimeUnit timeUnit, Scheduler scheduler2) {
            this.actual = subscriber;
            this.scheduler = scheduler2;
            this.unit = timeUnit;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long now = this.scheduler.now(this.unit);
            long j = this.lastTime;
            this.lastTime = now;
            this.actual.onNext(new em2(t, now - j, this.unit));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.lastTime = this.scheduler.now(this.unit);
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.s.request(j);
        }
    }

    public FlowableTimeInterval(b<T> bVar, TimeUnit timeUnit, Scheduler scheduler2) {
        super(bVar);
        this.scheduler = scheduler2;
        this.unit = timeUnit;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super em2<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber) new TimeIntervalSubscriber(subscriber, this.unit, this.scheduler));
    }
}
