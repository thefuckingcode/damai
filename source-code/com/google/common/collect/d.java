package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* access modifiers changed from: package-private */
@GwtCompatible
/* compiled from: Taobao */
public abstract class d<E> extends AbstractCollection<E> implements Multiset<E> {
    @MonotonicNonNullDecl
    private transient Set<E> elementSet;
    @MonotonicNonNullDecl
    private transient Set<Multiset.Entry<E>> entrySet;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends Multisets.c<E> {
        a() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Multisets.c
        public Multiset<E> a() {
            return d.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<E> iterator() {
            return d.this.elementIterator();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends Multisets.d<E> {
        b() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Multisets.d
        public Multiset<E> a() {
            return d.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Multiset.Entry<E>> iterator() {
            return d.this.entryIterator();
        }

        public int size() {
            return d.this.distinctElements();
        }
    }

    d() {
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean add(@NullableDecl E e) {
        add(e, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean addAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    public abstract void clear();

    @Override // com.google.common.collect.Multiset
    public boolean contains(@NullableDecl Object obj) {
        return count(obj) > 0;
    }

    /* access modifiers changed from: package-private */
    public Set<E> createElementSet() {
        return new a();
    }

    /* access modifiers changed from: package-private */
    public Set<Multiset.Entry<E>> createEntrySet() {
        return new b();
    }

    /* access modifiers changed from: package-private */
    public abstract int distinctElements();

    /* access modifiers changed from: package-private */
    public abstract Iterator<E> elementIterator();

    @Override // com.google.common.collect.Multiset
    public Set<E> elementSet() {
        Set<E> set = this.elementSet;
        if (set != null) {
            return set;
        }
        Set<E> createElementSet = createElementSet();
        this.elementSet = createElementSet;
        return createElementSet;
    }

    /* access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> entryIterator();

    @Override // com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        Set<Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // com.google.common.collect.Multiset
    public final boolean equals(@NullableDecl Object obj) {
        return Multisets.f(this, obj);
    }

    @Override // com.google.common.collect.Multiset
    public final int hashCode() {
        return entrySet().hashCode();
    }

    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final boolean remove(@NullableDecl Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean removeAll(Collection<?> collection) {
        return Multisets.k(this, collection);
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean retainAll(Collection<?> collection) {
        return Multisets.l(this, collection);
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(@NullableDecl E e, int i) {
        return Multisets.m(this, e, i);
    }

    @Override // com.google.common.collect.Multiset
    public final String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(@NullableDecl E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(@NullableDecl E e, int i, int i2) {
        return Multisets.n(this, e, i, i2);
    }
}
