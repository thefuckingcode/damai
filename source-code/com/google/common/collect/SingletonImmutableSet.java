package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.concurrent.LazyInit;
import tb.ds1;
import tb.jl1;
import tb.wr2;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true, serializable = true)
/* compiled from: Taobao */
public final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    @LazyInit
    private transient int cachedHashCode;
    final transient E element;

    SingletonImmutableSet(E e) {
        this.element = (E) ds1.p(e);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i) {
        objArr[i] = this.element;
        return i + 1;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> createAsList() {
        return ImmutableList.of(this.element);
    }

    @Override // com.google.common.collect.ImmutableSet
    public final int hashCode() {
        int i = this.cachedHashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = this.element.hashCode();
        this.cachedHashCode = hashCode;
        return hashCode;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return this.cachedHashCode != 0;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return 1;
    }

    public String toString() {
        return jl1.ARRAY_START + this.element.toString() + jl1.ARRAY_END;
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableSet, java.util.Collection, com.google.common.collect.ImmutableCollection, com.google.common.collect.ImmutableCollection, java.util.Set, java.lang.Iterable
    public wr2<E> iterator() {
        return Iterators.t(this.element);
    }

    SingletonImmutableSet(E e, int i) {
        this.element = e;
        this.cachedHashCode = i;
    }
}
