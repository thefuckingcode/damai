package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import org.reactivestreams.Subscription;

/* compiled from: Taobao */
final class SubscriptionDisposable extends ReferenceDisposable<Subscription> {
    private static final long serialVersionUID = -707001650852963139L;

    SubscriptionDisposable(Subscription subscription) {
        super(subscription);
    }

    /* access modifiers changed from: protected */
    public void onDisposed(@NonNull Subscription subscription) {
        subscription.cancel();
    }
}
