package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.e2;
import tb.wr2;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    private static final long serialVersionUID = 0;
    private final Range<C> range;

    @GwtIncompatible
    /* compiled from: Taobao */
    private static final class SerializedForm<C extends Comparable> implements Serializable {
        final DiscreteDomain<C> domain;
        final Range<C> range;

        /* synthetic */ SerializedForm(Range range2, DiscreteDomain discreteDomain, a aVar) {
            this(range2, discreteDomain);
        }

        private Object readResolve() {
            return new RegularContiguousSet(this.range, this.domain);
        }

        private SerializedForm(Range<C> range2, DiscreteDomain<C> discreteDomain) {
            this.range = range2;
            this.domain = discreteDomain;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends e2<C> {
        final C b;

        a(Comparable comparable) {
            super(comparable);
            this.b = (C) RegularContiguousSet.this.last();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public C a(C c2) {
            if (RegularContiguousSet.equalsOrThrow(c2, this.b)) {
                return null;
            }
            return RegularContiguousSet.this.domain.next(c2);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends e2<C> {
        final C b;

        b(Comparable comparable) {
            super(comparable);
            this.b = (C) RegularContiguousSet.this.first();
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public C a(C c2) {
            if (RegularContiguousSet.equalsOrThrow(c2, this.b)) {
                return null;
            }
            return RegularContiguousSet.this.domain.previous(c2);
        }
    }

    RegularContiguousSet(Range<C> range2, DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
        this.range = range2;
    }

    /* access modifiers changed from: private */
    public static boolean equalsOrThrow(Comparable<?> comparable, @NullableDecl Comparable<?> comparable2) {
        return comparable2 != null && Range.compareOrThrow(comparable, comparable2) == 0;
    }

    private ContiguousSet<C> intersectionInCurrentDomain(Range<C> range2) {
        return this.range.isConnected(range2) ? ContiguousSet.create(this.range.intersection(range2), this.domain) : new EmptyContiguousSet(this.domain);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean contains(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.range.contains((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set, java.util.AbstractCollection
    public boolean containsAll(Collection<?> collection) {
        return l.b(this, collection);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<C> createAsList() {
        if (this.domain.supportsFastOffset) {
            return new ImmutableAsList<C>() {
                /* class com.google.common.collect.RegularContiguousSet.AnonymousClass3 */

                /* access modifiers changed from: package-private */
                @Override // com.google.common.collect.ImmutableAsList
                public ImmutableSortedSet<C> delegateCollection() {
                    return RegularContiguousSet.this;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.List
                public C get(int i) {
                    ds1.n(i, size());
                    RegularContiguousSet regularContiguousSet = RegularContiguousSet.this;
                    return (C) regularContiguousSet.domain.offset(regularContiguousSet.first(), (long) i);
                }
            };
        }
        return super.createAsList();
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RegularContiguousSet) {
            RegularContiguousSet regularContiguousSet = (RegularContiguousSet) obj;
            if (this.domain.equals(regularContiguousSet.domain)) {
                if (!first().equals(regularContiguousSet.first()) || !last().equals(regularContiguousSet.last())) {
                    return false;
                }
                return true;
            }
        }
        return super.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet
    public int hashCode() {
        return Sets.b(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    public int indexOf(Object obj) {
        if (contains(obj)) {
            return (int) this.domain.distance(first(), (Comparable) obj);
        }
        return -1;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet) {
        ds1.p(contiguousSet);
        ds1.d(this.domain.equals(contiguousSet.domain));
        if (contiguousSet.isEmpty()) {
            return contiguousSet;
        }
        Comparable comparable = (Comparable) Ordering.natural().max(first(), contiguousSet.first());
        Comparable comparable2 = (Comparable) Ordering.natural().min(last(), contiguousSet.last());
        return comparable.compareTo(comparable2) <= 0 ? ContiguousSet.create(Range.closed(comparable, comparable2), this.domain) : new EmptyContiguousSet(this.domain);
    }

    public boolean isEmpty() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        BoundType boundType = BoundType.CLOSED;
        return range(boundType, boundType);
    }

    public int size() {
        long distance = this.domain.distance(first(), last());
        if (distance >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) distance) + 1;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new SerializedForm(this.range, this.domain, null);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public wr2<C> descendingIterator() {
        return new b(last());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C first() {
        return this.range.lowerBound.leastValueAbove(this.domain);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> headSetImpl(C c, boolean z) {
        return intersectionInCurrentDomain(Range.upTo(c, BoundType.forBoolean(z)));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableSet, java.util.Collection, com.google.common.collect.ImmutableCollection, com.google.common.collect.ImmutableCollection, java.util.Set, java.util.NavigableSet, java.lang.Iterable, java.util.AbstractCollection, com.google.common.collect.SortedIterable
    public wr2<C> iterator() {
        return new a(first());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public C last() {
        return this.range.upperBound.greatestValueBelow(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType boundType, BoundType boundType2) {
        return Range.create(this.range.lowerBound.withLowerBoundType(boundType, this.domain), this.range.upperBound.withUpperBoundType(boundType2, this.domain));
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> subSetImpl(C c, boolean z, C c2, boolean z2) {
        if (c.compareTo(c2) != 0 || z || z2) {
            return intersectionInCurrentDomain(Range.range(c, BoundType.forBoolean(z), c2, BoundType.forBoolean(z2)));
        }
        return new EmptyContiguousSet(this.domain);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> tailSetImpl(C c, boolean z) {
        return intersectionInCurrentDomain(Range.downTo(c, BoundType.forBoolean(z)));
    }
}
