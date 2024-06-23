package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.h0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public abstract class m<E> extends s<E> implements SortedMultiset<E> {
    @MonotonicNonNullDecl
    private transient Comparator<? super E> a;
    @MonotonicNonNullDecl
    private transient NavigableSet<E> b;
    @MonotonicNonNullDecl
    private transient Set<Multiset.Entry<E>> c;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends Multisets.d<E> {
        a() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Multisets.d
        public Multiset<E> a() {
            return m.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Multiset.Entry<E>> iterator() {
            return m.this.b();
        }

        public int size() {
            return m.this.c().entrySet().size();
        }
    }

    m() {
    }

    /* access modifiers changed from: package-private */
    public Set<Multiset.Entry<E>> a() {
        return new a();
    }

    /* access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> b();

    /* access modifiers changed from: package-private */
    public abstract SortedMultiset<E> c();

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.a;
        if (comparator != null) {
            return comparator;
        }
        Ordering reverse = Ordering.from(c().comparator()).reverse();
        this.a = reverse;
        return reverse;
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> descendingMultiset() {
        return c();
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.Multiset, com.google.common.collect.s
    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> set = this.c;
        if (set != null) {
            return set;
        }
        Set<Multiset.Entry<E>> a2 = a();
        this.c = a2;
        return a2;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return c().lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return c().tailMultiset(e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return c().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollFirstEntry() {
        return c().pollLastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollLastEntry() {
        return c().pollFirstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return c().subMultiset(e2, boundType2, e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return c().headMultiset(e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.o
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.Multiset, com.google.common.collect.t
    public String toString() {
        return entrySet().toString();
    }

    @Override // java.util.Collection, com.google.common.collect.o
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.s, com.google.common.collect.s, com.google.common.collect.s, com.google.common.collect.t
    public Multiset<E> delegate() {
        return c();
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedMultisetBridge, com.google.common.collect.Multiset, com.google.common.collect.s
    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.b;
        if (navigableSet != null) {
            return navigableSet;
        }
        h0.b bVar = new h0.b(this);
        this.b = bVar;
        return bVar;
    }
}
