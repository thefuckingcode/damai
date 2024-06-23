package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
public final class FlowableJust<T> extends b<T> implements ScalarCallable<T> {
    private final T value;

    public FlowableJust(T t) {
        this.value = t;
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return this.value;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        subscriber.onSubscribe(new ScalarSubscription(subscriber, this.value));
    }
}
