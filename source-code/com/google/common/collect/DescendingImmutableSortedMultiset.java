package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* access modifiers changed from: package-private */
@GwtIncompatible
/* compiled from: Taobao */
public final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    private final transient ImmutableSortedMultiset<E> forward;

    DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.forward = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        return this.forward.count(obj);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return this.forward.lastEntry();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMultiset
    public Multiset.Entry<E> getEntry(int i) {
        return this.forward.entrySet().asList().reverse().get(i);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.forward.isPartialView();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return this.forward.firstEntry();
    }

    @Override // com.google.common.collect.Multiset
    public int size() {
        return this.forward.size();
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultiset
    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.forward;
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultiset
    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return this.forward.tailMultiset((Object) e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultiset
    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return this.forward.headMultiset((Object) e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultisetBridge, com.google.common.collect.Multiset, com.google.common.collect.SortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultiset
    public ImmutableSortedSet<E> elementSet() {
        return this.forward.elementSet().descendingSet();
    }
}
