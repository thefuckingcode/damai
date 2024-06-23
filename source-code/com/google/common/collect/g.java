package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.h0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
abstract class g<E> extends d<E> implements SortedMultiset<E> {
    @GwtTransient
    final Comparator<? super E> comparator;
    @MonotonicNonNullDecl
    private transient SortedMultiset<E> descendingMultiset;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends m<E> {
        a() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.m
        public Iterator<Multiset.Entry<E>> b() {
            return g.this.descendingEntryIterator();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.m
        public SortedMultiset<E> c() {
            return g.this;
        }

        @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable, com.google.common.collect.Multiset, java.util.Collection, com.google.common.collect.o, java.lang.Iterable
        public Iterator<E> iterator() {
            return g.this.descendingIterator();
        }
    }

    g() {
        this(Ordering.natural());
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    /* access modifiers changed from: package-private */
    public SortedMultiset<E> createDescendingMultiset() {
        return new a();
    }

    /* access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> descendingEntryIterator();

    /* access modifiers changed from: package-private */
    public Iterator<E> descendingIterator() {
        return Multisets.i(descendingMultiset());
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> descendingMultiset() {
        SortedMultiset<E> sortedMultiset = this.descendingMultiset;
        if (sortedMultiset != null) {
            return sortedMultiset;
        }
        SortedMultiset<E> createDescendingMultiset = createDescendingMultiset();
        this.descendingMultiset = createDescendingMultiset;
        return createDescendingMultiset;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        Iterator<Multiset.Entry<E>> entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            return entryIterator.next();
        }
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        Iterator<Multiset.Entry<E>> descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            return descendingEntryIterator.next();
        }
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollFirstEntry() {
        Iterator<Multiset.Entry<E>> entryIterator = entryIterator();
        if (!entryIterator.hasNext()) {
            return null;
        }
        Multiset.Entry<E> next = entryIterator.next();
        Multiset.Entry<E> g = Multisets.g(next.getElement(), next.getCount());
        entryIterator.remove();
        return g;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollLastEntry() {
        Iterator<Multiset.Entry<E>> descendingEntryIterator = descendingEntryIterator();
        if (!descendingEntryIterator.hasNext()) {
            return null;
        }
        Multiset.Entry<E> next = descendingEntryIterator.next();
        Multiset.Entry<E> g = Multisets.g(next.getElement(), next.getCount());
        descendingEntryIterator.remove();
        return g;
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(@NullableDecl E e, BoundType boundType, @NullableDecl E e2, BoundType boundType2) {
        ds1.p(boundType);
        ds1.p(boundType2);
        return tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }

    g(Comparator<? super E> comparator2) {
        this.comparator = (Comparator) ds1.p(comparator2);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public NavigableSet<E> createElementSet() {
        return new h0.b(this);
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedMultisetBridge, com.google.common.collect.Multiset, com.google.common.collect.d
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
