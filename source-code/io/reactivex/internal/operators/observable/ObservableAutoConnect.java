package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.d;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import tb.jm;

/* compiled from: Taobao */
public final class ObservableAutoConnect<T> extends d<T> {
    final AtomicInteger clients = new AtomicInteger();
    final Consumer<? super Disposable> connection;
    final int numberOfObservers;
    final jm<? extends T> source;

    public ObservableAutoConnect(jm<? extends T> jmVar, int i, Consumer<? super Disposable> consumer) {
        this.source = jmVar;
        this.numberOfObservers = i;
        this.connection = consumer;
    }

    @Override // io.reactivex.d
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(observer);
        if (this.clients.incrementAndGet() == this.numberOfObservers) {
            this.source.connect(this.connection);
        }
    }
}
