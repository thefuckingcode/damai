package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class FlowableDoOnLifecycle<T> extends AbstractFlowableWithUpstream<T, T> {
    private final Action onCancel;
    private final LongConsumer onRequest;
    private final Consumer<? super Subscription> onSubscribe;

    /* compiled from: Taobao */
    static final class SubscriptionLambdaSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        final Action onCancel;
        final LongConsumer onRequest;
        final Consumer<? super Subscription> onSubscribe;
        Subscription s;

        SubscriptionLambdaSubscriber(Subscriber<? super T> subscriber, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
            this.actual = subscriber;
            this.onSubscribe = consumer;
            this.onCancel = action;
            this.onRequest = longConsumer;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            try {
                this.onCancel.run();
            } catch (Throwable th) {
                ff0.b(th);
                k22.u(th);
            }
            this.s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.s != SubscriptionHelper.CANCELLED) {
                this.actual.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.s != SubscriptionHelper.CANCELLED) {
                this.actual.onError(th);
            } else {
                k22.u(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            try {
                this.onSubscribe.accept(subscription);
                if (SubscriptionHelper.validate(this.s, subscription)) {
                    this.s = subscription;
                    this.actual.onSubscribe(this);
                }
            } catch (Throwable th) {
                ff0.b(th);
                subscription.cancel();
                this.s = SubscriptionHelper.CANCELLED;
                EmptySubscription.error(th, this.actual);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            try {
                this.onRequest.accept(j);
            } catch (Throwable th) {
                ff0.b(th);
                k22.u(th);
            }
            this.s.request(j);
        }
    }

    public FlowableDoOnLifecycle(b<T> bVar, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
        super(bVar);
        this.onSubscribe = consumer;
        this.onRequest = longConsumer;
        this.onCancel = action;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new SubscriptionLambdaSubscriber(subscriber, this.onSubscribe, this.onRequest, this.onCancel));
    }
}
