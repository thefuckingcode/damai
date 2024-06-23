package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscription;
import tb.jl1;

/* compiled from: Taobao */
public final class BooleanSubscription extends AtomicBoolean implements Subscription {
    private static final long serialVersionUID = -8127758972444290902L;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + jl1.BRACKET_END_STR;
    }
}
