package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Queue;

@GwtCompatible
/* compiled from: Taobao */
public abstract class u<E> extends o<E> implements Queue<E> {
    protected u() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Object delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Collection delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t
    public abstract Queue<E> delegate();

    @Override // java.util.Queue
    public E element() {
        return delegate().element();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public abstract boolean offer(E e);

    @Override // java.util.Queue
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E remove() {
        return delegate().remove();
    }

    /* access modifiers changed from: protected */
    public boolean standardOffer(E e) {
        try {
            return add(e);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
