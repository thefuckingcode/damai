package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.b;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tb.k22;
import tb.vj1;

/* compiled from: Taobao */
public final class FlowableDematerialize<T> extends AbstractFlowableWithUpstream<vj1<T>, T> {

    /* compiled from: Taobao */
    static final class DematerializeSubscriber<T> implements FlowableSubscriber<vj1<T>>, Subscription {
        final Subscriber<? super T> actual;
        boolean done;
        Subscription s;

        DematerializeSubscriber(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
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

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            onNext((vj1) ((vj1) obj));
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

        public void onNext(vj1<T> vj1) {
            if (this.done) {
                if (vj1.g()) {
                    k22.u(vj1.d());
                }
            } else if (vj1.g()) {
                this.s.cancel();
                onError(vj1.d());
            } else if (vj1.f()) {
                this.s.cancel();
                onComplete();
            } else {
                this.actual.onNext(vj1.e());
            }
        }
    }

    public FlowableDematerialize(b<vj1<T>> bVar) {
        super(bVar);
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new DematerializeSubscriber(subscriber));
    }
}
