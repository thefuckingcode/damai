package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.internal.operators.flowable.FlowableTake;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
public final class FlowableTakePublisher<T> extends b<T> {
    final long limit;
    final Publisher<T> source;

    public FlowableTakePublisher(Publisher<T> publisher, long j) {
        this.source = publisher;
        this.limit = j;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new FlowableTake.TakeSubscriber(subscriber, this.limit));
    }
}
