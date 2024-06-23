package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.wr2;

@Beta
@GwtIncompatible
/* compiled from: Taobao */
public final class ImmutableRangeSet<C extends Comparable> extends f<C> implements Serializable {
    private static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet<>(ImmutableList.of(Range.all()));
    private static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet<>(ImmutableList.of());
    @LazyInit
    private transient ImmutableRangeSet<C> complement;
    private final transient ImmutableList<Range<C>> ranges;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class AsSet extends ImmutableSortedSet<C> {
        private final DiscreteDomain<C> domain;
        @MonotonicNonNullDecl
        private transient Integer size;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a extends AbstractIterator<C> {
            final Iterator<Range<C>> c;
            Iterator<C> d = Iterators.h();

            a() {
                this.c = ImmutableRangeSet.this.ranges.iterator();
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [C extends java.lang.Comparable, java.lang.Comparable] */
            /* access modifiers changed from: protected */
            /* renamed from: d */
            public C a() {
                while (!this.d.hasNext()) {
                    if (!this.c.hasNext()) {
                        return (C) ((Comparable) b());
                    }
                    this.d = ContiguousSet.create(this.c.next(), AsSet.this.domain).iterator();
                }
                return this.d.next();
            }
        }

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class b extends AbstractIterator<C> {
            final Iterator<Range<C>> c;
            Iterator<C> d = Iterators.h();

            b() {
                this.c = ImmutableRangeSet.this.ranges.reverse().iterator();
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [C extends java.lang.Comparable, java.lang.Comparable] */
            /* access modifiers changed from: protected */
            /* renamed from: d */
            public C a() {
                while (!this.d.hasNext()) {
                    if (!this.c.hasNext()) {
                        return (C) ((Comparable) b());
                    }
                    this.d = ContiguousSet.create(this.c.next(), AsSet.this.domain).descendingIterator();
                }
                return this.d.next();
            }
        }

        AsSet(DiscreteDomain<C> discreteDomain) {
            super(Ordering.natural());
            this.domain = discreteDomain;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean contains(@NullableDecl Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        public ImmutableSortedSet<C> createDescendingSet() {
            return new DescendingImmutableSortedSet(this);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.google.common.collect.Range */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(Object obj) {
            if (!contains(obj)) {
                return -1;
            }
            Comparable comparable = (Comparable) obj;
            long j = 0;
            wr2 it = ImmutableRangeSet.this.ranges.iterator();
            while (it.hasNext()) {
                Range range = (Range) it.next();
                if (range.contains(comparable)) {
                    return Ints.j(j + ((long) ContiguousSet.create(range, this.domain).indexOf(comparable)));
                }
                j += (long) ContiguousSet.create(range, this.domain).size();
            }
            throw new AssertionError("impossible");
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableRangeSet.this.ranges.isPartialView();
        }

        public int size() {
            Integer num = this.size;
            if (num == null) {
                long j = 0;
                wr2 it = ImmutableRangeSet.this.ranges.iterator();
                while (it.hasNext()) {
                    j += (long) ContiguousSet.create((Range) it.next(), this.domain).size();
                    if (j >= 2147483647L) {
                        break;
                    }
                }
                num = Integer.valueOf(Ints.j(j));
                this.size = num;
            }
            return num.intValue();
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.google.common.collect.DiscreteDomain<C>, com.google.common.collect.DiscreteDomain<C extends java.lang.Comparable> */
        /* access modifiers changed from: package-private */
        public ImmutableSortedSet<C> subSet(Range<C> range) {
            return ImmutableRangeSet.this.subRangeSet((Range) range).asSet((DiscreteDomain<C>) this.domain);
        }

        public String toString() {
            return ImmutableRangeSet.this.ranges.toString();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.this.ranges, this.domain);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        @GwtIncompatible("NavigableSet")
        public wr2<C> descendingIterator() {
            return new b();
        }

        /* access modifiers changed from: package-private */
        public ImmutableSortedSet<C> headSetImpl(C c, boolean z) {
            return subSet(Range.upTo(c, BoundType.forBoolean(z)));
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableSet, java.util.Collection, com.google.common.collect.ImmutableCollection, com.google.common.collect.ImmutableCollection, java.util.Set, java.util.NavigableSet, java.lang.Iterable, java.util.AbstractCollection, com.google.common.collect.SortedIterable
        public wr2<C> iterator() {
            return new a();
        }

        /* access modifiers changed from: package-private */
        public ImmutableSortedSet<C> subSetImpl(C c, boolean z, C c2, boolean z2) {
            if (z || z2 || Range.compareOrThrow(c, c2) != 0) {
                return subSet(Range.range(c, BoundType.forBoolean(z), c2, BoundType.forBoolean(z2)));
            }
            return ImmutableSortedSet.of();
        }

        /* access modifiers changed from: package-private */
        public ImmutableSortedSet<C> tailSetImpl(C c, boolean z) {
            return subSet(Range.downTo(c, BoundType.forBoolean(z)));
        }
    }

    /* compiled from: Taobao */
    private static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        private final DiscreteDomain<C> domain;
        private final ImmutableList<Range<C>> ranges;

        AsSetSerializedForm(ImmutableList<Range<C>> immutableList, DiscreteDomain<C> discreteDomain) {
            this.ranges = immutableList;
            this.domain = discreteDomain;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class ComplementRanges extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;

        ComplementRanges() {
            boolean hasLowerBound = ((Range) ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
            this.positiveBoundedBelow = hasLowerBound;
            boolean hasUpperBound = ((Range) a0.f(ImmutableRangeSet.this.ranges)).hasUpperBound();
            this.positiveBoundedAbove = hasUpperBound;
            int size2 = ImmutableRangeSet.this.ranges.size() - 1;
            size2 = hasLowerBound ? size2 + 1 : size2;
            this.size = hasUpperBound ? size2 + 1 : size2;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return this.size;
        }

        @Override // java.util.List
        public Range<C> get(int i) {
            Cut<C> cut;
            Cut<C> cut2;
            ds1.n(i, this.size);
            if (this.positiveBoundedBelow) {
                cut = i == 0 ? Cut.belowAll() : ((Range) ImmutableRangeSet.this.ranges.get(i - 1)).upperBound;
            } else {
                cut = ((Range) ImmutableRangeSet.this.ranges.get(i)).upperBound;
            }
            if (!this.positiveBoundedAbove || i != this.size - 1) {
                cut2 = ((Range) ImmutableRangeSet.this.ranges.get(i + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound;
            } else {
                cut2 = Cut.aboveAll();
            }
            return Range.create(cut, cut2);
        }
    }

    /* compiled from: Taobao */
    private static final class SerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> ranges;

        SerializedForm(ImmutableList<Range<C>> immutableList) {
            this.ranges = immutableList;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            if (this.ranges.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (this.ranges.equals(ImmutableList.of(Range.all()))) {
                return ImmutableRangeSet.all();
            }
            return new ImmutableRangeSet(this.ranges);
        }
    }

    /* compiled from: Taobao */
    public static class a<C extends Comparable<?>> {
        private final List<Range<C>> a = Lists.i();

        @CanIgnoreReturnValue
        public a<C> a(Range<C> range) {
            ds1.k(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.a.add(range);
            return this;
        }

        @CanIgnoreReturnValue
        public a<C> b(Iterable<Range<C>> iterable) {
            for (Range<C> range : iterable) {
                a(range);
            }
            return this;
        }

        public ImmutableRangeSet<C> c() {
            ImmutableList.a aVar = new ImmutableList.a(this.a.size());
            Collections.sort(this.a, Range.rangeLexOrdering());
            PeekingIterator p = Iterators.p(this.a.iterator());
            while (p.hasNext()) {
                Range range = (Range) p.next();
                while (p.hasNext()) {
                    Range<C> range2 = (Range) p.peek();
                    if (!range.isConnected(range2)) {
                        break;
                    }
                    ds1.l(range.intersection(range2).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", range, range2);
                    range = range.span((Range) p.next());
                }
                aVar.a(range);
            }
            ImmutableList j = aVar.j();
            if (j.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (j.size() != 1 || !((Range) a0.h(j)).equals(Range.all())) {
                return new ImmutableRangeSet<>(j);
            }
            return ImmutableRangeSet.all();
        }
    }

    ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.ranges = immutableList;
    }

    static <C extends Comparable> ImmutableRangeSet<C> all() {
        return ALL;
    }

    public static <C extends Comparable<?>> a<C> builder() {
        return new a<>();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(RangeSet<C> rangeSet) {
        ds1.p(rangeSet);
        if (rangeSet.isEmpty()) {
            return of();
        }
        if (rangeSet.encloses(Range.all())) {
            return all();
        }
        if (rangeSet instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) rangeSet;
            if (!immutableRangeSet.isPartialView()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) rangeSet.asRanges()));
    }

    private ImmutableList<Range<C>> intersectRanges(final Range<C> range) {
        int i;
        if (this.ranges.isEmpty() || range.isEmpty()) {
            return ImmutableList.of();
        }
        if (range.encloses(span())) {
            return this.ranges;
        }
        final int a2 = range.hasLowerBound() ? SortedLists.a(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : 0;
        if (range.hasUpperBound()) {
            i = SortedLists.a(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        } else {
            i = this.ranges.size();
        }
        final int i2 = i - a2;
        if (i2 == 0) {
            return ImmutableList.of();
        }
        return new ImmutableList<Range<C>>() {
            /* class com.google.common.collect.ImmutableRangeSet.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            public int size() {
                return i2;
            }

            @Override // java.util.List
            public Range<C> get(int i) {
                ds1.n(i, i2);
                if (i == 0 || i == i2 - 1) {
                    return ((Range) ImmutableRangeSet.this.ranges.get(i + a2)).intersection(range);
                }
                return (Range) ImmutableRangeSet.this.ranges.get(i + a2);
            }
        };
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        return copyOf(TreeRangeSet.create(iterable));
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    @Deprecated
    public void addAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        ds1.p(discreteDomain);
        if (isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range<C> canonical = span().canonical(discreteDomain);
        if (canonical.hasLowerBound()) {
            if (!canonical.hasUpperBound()) {
                try {
                    discreteDomain.maxValue();
                } catch (NoSuchElementException unused) {
                    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                }
            }
            return new AsSet(discreteDomain);
        }
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    public ImmutableRangeSet<C> difference(RangeSet<C> rangeSet) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(rangeSet);
        return copyOf(create);
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public boolean encloses(Range<C> range) {
        int b = SortedLists.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        return b != -1 && this.ranges.get(b).encloses(range);
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public ImmutableRangeSet<C> intersection(RangeSet<C> rangeSet) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(rangeSet.complement());
        return copyOf(create);
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public boolean intersects(Range<C> range) {
        int b = SortedLists.b(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (b < this.ranges.size() && this.ranges.get(b).isConnected(range) && !this.ranges.get(b).intersection(range).isEmpty()) {
            return true;
        }
        if (b > 0) {
            int i = b - 1;
            if (!this.ranges.get(i).isConnected(range) || this.ranges.get(i).intersection(range).isEmpty()) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return this.ranges.isPartialView();
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public Range<C> rangeContaining(C c) {
        int b = SortedLists.b(this.ranges, Range.lowerBoundFn(), Cut.belowValue(c), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (b == -1) {
            return null;
        }
        Range<C> range = this.ranges.get(b);
        if (range.contains(c)) {
            return range;
        }
        return null;
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    @Deprecated
    public void removeAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        if (!this.ranges.isEmpty()) {
            Cut<C> cut = this.ranges.get(0).lowerBound;
            ImmutableList<Range<C>> immutableList = this.ranges;
            return Range.create(cut, immutableList.get(immutableList.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    public ImmutableRangeSet<C> union(RangeSet<C> rangeSet) {
        return unionOf(a0.c(asRanges(), rangeSet.asRanges()));
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(this.ranges);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        ds1.p(range);
        if (range.isEmpty()) {
            return of();
        }
        if (range.equals(Range.all())) {
            return all();
        }
        return new ImmutableRangeSet<>(ImmutableList.of(range));
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse());
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering());
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.complement;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.ranges.isEmpty()) {
            ImmutableRangeSet<C> all = all();
            this.complement = all;
            return all;
        } else if (this.ranges.size() != 1 || !this.ranges.get(0).equals(Range.all())) {
            ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new ComplementRanges(), this);
            this.complement = immutableRangeSet2;
            return immutableRangeSet2;
        } else {
            ImmutableRangeSet<C> of = of();
            this.complement = of;
            return of;
        }
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range<C> span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                return new ImmutableRangeSet<>(intersectRanges(range));
            }
        }
        return of();
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        return new a().b(iterable).c();
    }
}
