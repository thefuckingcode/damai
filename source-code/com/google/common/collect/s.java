package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.rk1;

@GwtCompatible
/* compiled from: Taobao */
public abstract class s<E> extends o<E> implements Multiset<E> {
    protected s() {
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E e, int i) {
        return delegate().add(e, i);
    }

    @Override // com.google.common.collect.Multiset
    public int count(Object obj) {
        return delegate().count(obj);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t
    public abstract Multiset<E> delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Object delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // com.google.common.collect.Multiset
    public abstract Set<E> elementSet();

    @Override // com.google.common.collect.Multiset
    public abstract Set<Multiset.Entry<E>> entrySet();

    @Override // com.google.common.collect.Multiset
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(Object obj, int i) {
        return delegate().remove(obj, i);
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E e, int i) {
        return delegate().setCount(e, i);
    }

    /* access modifiers changed from: protected */
    public boolean standardAdd(E e) {
        add(e, 1);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    @Beta
    public boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    public void standardClear() {
        Iterators.d(entrySet().iterator());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    public boolean standardContains(@NullableDecl Object obj) {
        return count(obj) > 0;
    }

    /* access modifiers changed from: protected */
    @Beta
    public int standardCount(@NullableDecl Object obj) {
        for (Multiset.Entry<E> entry : entrySet()) {
            if (rk1.a(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(@NullableDecl Object obj) {
        return Multisets.f(this, obj);
    }

    /* access modifiers changed from: protected */
    public int standardHashCode() {
        return entrySet().hashCode();
    }

    /* access modifiers changed from: protected */
    public Iterator<E> standardIterator() {
        return Multisets.i(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    public boolean standardRemove(Object obj) {
        return remove(obj, 1) > 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    public boolean standardRemoveAll(Collection<?> collection) {
        return Multisets.k(this, collection);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    public boolean standardRetainAll(Collection<?> collection) {
        return Multisets.l(this, collection);
    }

    /* access modifiers changed from: protected */
    public int standardSetCount(E e, int i) {
        return Multisets.m(this, e, i);
    }

    /* access modifiers changed from: protected */
    public int standardSize() {
        return Multisets.j(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    public String standardToString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(E e, int i, int i2) {
        return delegate().setCount(e, i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean standardSetCount(E e, int i, int i2) {
        return Multisets.n(this, e, i, i2);
    }
}
