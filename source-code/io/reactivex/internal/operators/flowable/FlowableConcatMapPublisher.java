package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: Taobao */
public final class FlowableConcatMapPublisher<T, R> extends b<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int prefetch;
    final Publisher<T> source;

    public FlowableConcatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode2) {
        this.source = publisher;
        this.mapper = function;
        this.prefetch = i;
        this.errorMode = errorMode2;
    }

    /* access modifiers changed from: protected */
    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.source, subscriber, this.mapper)) {
            this.source.subscribe(FlowableConcatMap.subscribe(subscriber, this.mapper, this.prefetch, this.errorMode));
        }
    }
}
