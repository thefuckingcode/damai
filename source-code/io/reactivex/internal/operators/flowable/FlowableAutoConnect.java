package io.reactivex.internal.operators.flowable;

import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import tb.im;

/* compiled from: Taobao */
public final class FlowableAutoConnect<T> extends b<T> {
    final AtomicInteger clients = new AtomicInteger();
    final Consumer<? super Disposable> connection;
    final int numberOfSubscribers;
    final im<? extends T> source;

    public FlowableAutoConnect(im<? extends T> imVar, int i, Consumer<? super Disposable> consumer) {
        this.source = imVar;
        this.numberOfSubscribers = i;
        this.connection = consumer;
    }

    @Override // io.reactivex.b
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(subscriber);
        if (this.clients.incrementAndGet() == this.numberOfSubscribers) {
            this.source.connect(this.connection);
        }
    }
}
