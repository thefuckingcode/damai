package org.apache.commons.lang3.concurrent;

/* compiled from: Taobao */
public interface Computable<I, O> {
    O compute(I i) throws InterruptedException;
}
