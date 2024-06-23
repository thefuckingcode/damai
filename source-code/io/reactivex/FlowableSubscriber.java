package io.reactivex;

import io.reactivex.annotations.Beta;
import io.reactivex.annotations.NonNull;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Beta
/* compiled from: Taobao */
public interface FlowableSubscriber<T> extends Subscriber<T> {
    @Override // org.reactivestreams.Subscriber
    void onSubscribe(@NonNull Subscription subscription);
}
