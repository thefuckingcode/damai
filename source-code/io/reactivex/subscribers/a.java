package io.reactivex.subscribers;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;

/* compiled from: Taobao */
public abstract class a<T> implements FlowableSubscriber<T> {
    private Subscription s;

    /* access modifiers changed from: protected */
    public final void cancel() {
        Subscription subscription = this.s;
        this.s = SubscriptionHelper.CANCELLED;
        subscription.cancel();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        request(AbsPerformance.LONG_NIL);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.validate(this.s, subscription, getClass())) {
            this.s = subscription;
            onStart();
        }
    }

    /* access modifiers changed from: protected */
    public final void request(long j) {
        Subscription subscription = this.s;
        if (subscription != null) {
            subscription.request(j);
        }
    }
}
