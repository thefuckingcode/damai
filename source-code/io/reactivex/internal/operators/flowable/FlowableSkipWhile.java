package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.ff0;

/* compiled from: Taobao */
public final class FlowableSkipWhile<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    /* compiled from: Taobao */
    static final class SkipWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        boolean notSkipping;
        final Predicate<? super T> predicate;
        Subscription s;

        SkipWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate2) {
            this.actual = subscriber;
            this.predicate = predicate2;
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
            if (this.notSkipping) {
                this.actual.onNext(t);
                return;
            }
            try {
                if (this.predicate.test(t)) {
                    this.s.request(1);
                    return;
                }
                this.notSkipping = true;
                this.actual.onNext(t);
            } catch (Throwable th) {
                ff0.b(th);
                this.s.cancel();
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.s.request(j);
        }
    }

    public FlowableSkipWhile(b<T> bVar, Predicate<? super T> predicate2) {
        super(bVar);
        this.predicate = predicate2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new SkipWhileSubscriber(subscriber, this.predicate));
    }
}
