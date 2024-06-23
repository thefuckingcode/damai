package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
import tb.ds1;

@Beta
@GwtCompatible
/* compiled from: Taobao */
public final class EvictingQueue<E> extends u<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;
    @VisibleForTesting
    final int maxSize;

    private EvictingQueue(int i) {
        ds1.f(i >= 0, "maxSize (%s) must >= 0", i);
        this.delegate = new ArrayDeque(i);
        this.maxSize = i;
    }

    public static <E> EvictingQueue<E> create(int i) {
        return new EvictingQueue<>(i);
    }

    @Override // java.util.Collection, com.google.common.collect.o, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e) {
        ds1.p(e);
        if (this.maxSize == 0) {
            return true;
        }
        if (size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(e);
        return true;
    }

    @Override // java.util.Collection, com.google.common.collect.o
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size < this.maxSize) {
            return standardAddAll(collection);
        }
        clear();
        return a0.a(this, a0.j(collection, size - this.maxSize));
    }

    @Override // com.google.common.collect.o
    public boolean contains(Object obj) {
        return delegate().contains(ds1.p(obj));
    }

    @Override // java.util.Queue, com.google.common.collect.u
    @CanIgnoreReturnValue
    public boolean offer(E e) {
        return add(e);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // com.google.common.collect.o
    @CanIgnoreReturnValue
    public boolean remove(Object obj) {
        return delegate().remove(ds1.p(obj));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t, com.google.common.collect.u, com.google.common.collect.u, com.google.common.collect.u
    public Queue<E> delegate() {
        return this.delegate;
    }
}
