package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.k22;

/* compiled from: Taobao */
public final class FlowableDelaySubscriptionOther<T, U> extends b<T> {
    final Publisher<? extends T> main;
    final Publisher<U> other;

    /* compiled from: Taobao */
    final class DelaySubscriber implements FlowableSubscriber<U> {
        final Subscriber<? super T> child;
        boolean done;
        final SubscriptionArbiter serial;

        /* compiled from: Taobao */
        final class DelaySubscription implements Subscription {
            private final Subscription s;

            DelaySubscription(Subscription subscription) {
                this.s = subscription;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                this.s.cancel();
            }

            @Override // org.reactivestreams.Subscription
            public void request(long j) {
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public final class OnCompleteSubscriber implements FlowableSubscriber<T> {
            OnCompleteSubscriber() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                DelaySubscriber.this.child.onComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                DelaySubscriber.this.child.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                DelaySubscriber.this.child.onNext(t);
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                DelaySubscriber.this.serial.setSubscription(subscription);
            }
        }

        DelaySubscriber(SubscriptionArbiter subscriptionArbiter, Subscriber<? super T> subscriber) {
            this.serial = subscriptionArbiter;
            this.child = subscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                FlowableDelaySubscriptionOther.this.main.subscribe(new OnCompleteSubscriber());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                k22.u(th);
                return;
            }
            this.done = true;
            this.child.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u) {
            onComplete();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.serial.setSubscription(new DelaySubscription(subscription));
            subscription.request(AbsPerformance.LONG_NIL);
        }
    }

    public FlowableDelaySubscriptionOther(Publisher<? extends T> publisher, Publisher<U> publisher2) {
        this.main = publisher;
        this.other = publisher2;
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        subscriber.onSubscribe(subscriptionArbiter);
        this.other.subscribe(new DelaySubscriber(subscriptionArbiter, subscriber));
    }
}
