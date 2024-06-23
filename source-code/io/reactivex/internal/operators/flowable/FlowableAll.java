package io.reactivex.internal.operators.flowable;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.ff0;
import tb.k22;

/* compiled from: Taobao */
public final class FlowableAll<T> extends AbstractFlowableWithUpstream<T, Boolean> {
    final Predicate<? super T> predicate;

    /* compiled from: Taobao */
    static final class AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3521127104134758517L;
        boolean done;
        final Predicate<? super T> predicate;
        Subscription s;

        AllSubscriber(Subscriber<? super Boolean> subscriber, Predicate<? super T> predicate2) {
            super(subscriber);
            this.predicate = predicate2;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.s.cancel();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: io.reactivex.internal.operators.flowable.FlowableAll$AllSubscriber<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                complete(Boolean.TRUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                k22.u(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: io.reactivex.internal.operators.flowable.FlowableAll$AllSubscriber<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.done) {
                try {
                    if (!this.predicate.test(t)) {
                        this.done = true;
                        this.s.cancel();
                        complete(Boolean.FALSE);
                    }
                } catch (Throwable th) {
                    ff0.b(th);
                    this.s.cancel();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(AbsPerformance.LONG_NIL);
            }
        }
    }

    public FlowableAll(b<T> bVar, Predicate<? super T> predicate2) {
        super(bVar);
        this.predicate = predicate2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        this.source.subscribe((FlowableSubscriber) new AllSubscriber(subscriber, this.predicate));
    }
}
