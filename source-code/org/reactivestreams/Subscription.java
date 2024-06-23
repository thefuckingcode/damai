package org.reactivestreams;

/* compiled from: Taobao */
public interface Subscription {
    void cancel();

    void request(long j);
}
