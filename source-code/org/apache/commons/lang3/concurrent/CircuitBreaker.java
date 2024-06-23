package org.apache.commons.lang3.concurrent;

/* compiled from: Taobao */
public interface CircuitBreaker<T> {
    boolean checkState();

    void close();

    boolean incrementAndCheckState(T t);

    boolean isClosed();

    boolean isOpen();

    void open();
}
