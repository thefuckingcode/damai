package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableMap;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
public final class FlowableMapPublisher<T, U> extends b<U> {
    final Function<? super T, ? extends U> mapper;
    final Publisher<T> source;

    public FlowableMapPublisher(Publisher<T> publisher, Function<? super T, ? extends U> function) {
        this.source = publisher;
        this.mapper = function;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.source.subscribe(new FlowableMap.MapSubscriber(subscriber, this.mapper));
    }
}
