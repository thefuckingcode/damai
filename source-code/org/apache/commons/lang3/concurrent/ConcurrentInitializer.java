package org.apache.commons.lang3.concurrent;

/* compiled from: Taobao */
public interface ConcurrentInitializer<T> {
    T get() throws ConcurrentException;
}
