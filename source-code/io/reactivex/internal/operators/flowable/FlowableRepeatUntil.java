package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.ff0;

/* compiled from: Taobao */
public final class FlowableRepeatUntil<T> extends AbstractFlowableWithUpstream<T, T> {
    final BooleanSupplier until;

    /* compiled from: Taobao */
    static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Subscriber<? super T> actual;
        long produced;
        final SubscriptionArbiter sa;
        final Publisher<? extends T> source;
        final BooleanSupplier stop;

        RepeatSubscriber(Subscriber<? super T> subscriber, BooleanSupplier booleanSupplier, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.actual = subscriber;
            this.sa = subscriptionArbiter;
            this.source = publisher;
            this.stop = booleanSupplier;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            try {
                if (this.stop.getAsBoolean()) {
                    this.actual.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (Throwable th) {
                ff0.b(th);
                this.actual.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.sa.setSubscription(subscription);
        }

        /* access modifiers changed from: package-private */
        public void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.sa.isCancelled()) {
                    long j = this.produced;
                    if (j != 0) {
                        this.produced = 0;
                        this.sa.produced(j);
                    }
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    public FlowableRepeatUntil(b<T> bVar, BooleanSupplier booleanSupplier) {
        super(bVar);
        this.until = booleanSupplier;
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        subscriber.onSubscribe(subscriptionArbiter);
        new RepeatSubscriber(subscriber, this.until, subscriptionArbiter, this.source).subscribeNext();
    }
}
