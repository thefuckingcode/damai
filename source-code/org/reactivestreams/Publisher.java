package org.reactivestreams;

/* compiled from: Taobao */
public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
