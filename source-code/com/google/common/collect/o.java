package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.rk1;

@GwtCompatible
/* compiled from: Taobao */
public abstract class o<E> extends t implements Collection<E> {
    protected o() {
    }

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    public boolean add(E e) {
        return delegate().add(e);
    }

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        return delegate().addAll(collection);
    }

    public void clear() {
        delegate().clear();
    }

    public boolean contains(Object obj) {
        return delegate().contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return delegate().containsAll(collection);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Object delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.t
    public abstract Collection<E> delegate();

    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    @CanIgnoreReturnValue
    public boolean remove(Object obj) {
        return delegate().remove(obj);
    }

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    public boolean removeAll(Collection<?> collection) {
        return delegate().removeAll(collection);
    }

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    public boolean retainAll(Collection<?> collection) {
        return delegate().retainAll(collection);
    }

    public int size() {
        return delegate().size();
    }

    /* access modifiers changed from: protected */
    public boolean standardAddAll(Collection<? extends E> collection) {
        return Iterators.a(this, collection.iterator());
    }

    /* access modifiers changed from: protected */
    public void standardClear() {
        Iterators.d(iterator());
    }

    /* access modifiers changed from: protected */
    public boolean standardContains(@NullableDecl Object obj) {
        return Iterators.f(iterator(), obj);
    }

    /* access modifiers changed from: protected */
    public boolean standardContainsAll(Collection<?> collection) {
        return l.b(this, collection);
    }

    /* access modifiers changed from: protected */
    public boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    /* access modifiers changed from: protected */
    public boolean standardRemove(@NullableDecl Object obj) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (rk1.a(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean standardRemoveAll(Collection<?> collection) {
        return Iterators.r(iterator(), collection);
    }

    /* access modifiers changed from: protected */
    public boolean standardRetainAll(Collection<?> collection) {
        return Iterators.s(iterator(), collection);
    }

    /* access modifiers changed from: protected */
    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    /* access modifiers changed from: protected */
    public String standardToString() {
        return l.f(this);
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return (T[]) delegate().toArray(tArr);
    }

    /* access modifiers changed from: protected */
    public <T> T[] standardToArray(T[] tArr) {
        return (T[]) b0.g(this, tArr);
    }
}
