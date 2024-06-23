package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@Beta
@GwtIncompatible
/* compiled from: Taobao */
public class TreeRangeSet<C extends Comparable<?>> extends f<C> implements Serializable {
    @MonotonicNonNullDecl
    private transient Set<Range<C>> asDescendingSetOfRanges;
    @MonotonicNonNullDecl
    private transient Set<Range<C>> asRanges;
    @MonotonicNonNullDecl
    private transient RangeSet<C> complement;
    @VisibleForTesting
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* compiled from: Taobao */
    private final class Complement extends TreeRangeSet<C> {
        Complement() {
            super(new c(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.RangeSet, com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.RangeSet, com.google.common.collect.TreeRangeSet
        public RangeSet<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.RangeSet, com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public boolean contains(C c) {
            return !TreeRangeSet.this.contains(c);
        }

        @Override // com.google.common.collect.RangeSet, com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    /* compiled from: Taobao */
    private final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> restriction;

        SubRangeSet(Range<C> range) {
            super(new e(Range.all(), range, TreeRangeSet.this.rangesByLowerBound));
            this.restriction = range;
        }

        @Override // com.google.common.collect.RangeSet, com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void add(Range<C> range) {
            ds1.l(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            TreeRangeSet.super.add(range);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.TreeRangeSet */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.RangeSet, com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.common.collect.RangeSet, com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public boolean contains(C c) {
            return this.restriction.contains(c) && TreeRangeSet.this.contains(c);
        }

        @Override // com.google.common.collect.RangeSet, com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public boolean encloses(Range<C> range) {
            Range rangeEnclosing;
            if (this.restriction.isEmpty() || !this.restriction.encloses(range) || (rangeEnclosing = TreeRangeSet.this.rangeEnclosing(range)) == null || rangeEnclosing.intersection(this.restriction).isEmpty()) {
                return false;
            }
            return true;
        }

        /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: com.google.common.collect.Range<C>, com.google.common.collect.Range<C extends java.lang.Comparable<?>> */
        @Override // com.google.common.collect.RangeSet, com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        @NullableDecl
        public Range<C> rangeContaining(C c) {
            Range<C> rangeContaining;
            if (this.restriction.contains(c) && (rangeContaining = TreeRangeSet.this.rangeContaining(c)) != null) {
                return rangeContaining.intersection((Range<C>) this.restriction);
            }
            return null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable<?>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.RangeSet, com.google.common.collect.TreeRangeSet, com.google.common.collect.f
        public void remove(Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.Range<C extends java.lang.Comparable<?>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.RangeSet, com.google.common.collect.TreeRangeSet
        public RangeSet<C> subRangeSet(Range<C> range) {
            if (range.encloses(this.restriction)) {
                return this;
            }
            if (range.isConnected(this.restriction)) {
                return new SubRangeSet(this.restriction.intersection(range));
            }
            return ImmutableRangeSet.of();
        }
    }

    /* compiled from: Taobao */
    final class b extends o<Range<C>> implements Set<Range<C>> {
        final Collection<Range<C>> a;

        b(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            this.a = collection;
        }

        public boolean equals(@NullableDecl Object obj) {
            return Sets.a(this, obj);
        }

        public int hashCode() {
            return Sets.b(this);
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Collection<com.google.common.collect.Range<C>>, java.util.Collection<com.google.common.collect.Range<C extends java.lang.Comparable<?>>> */
        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t
        public Collection<Range<C>> delegate() {
            return (Collection<Range<C>>) this.a;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class c<C extends Comparable<?>> extends e<Cut<C>, Range<C>> {
        private final NavigableMap<Cut<C>, Range<C>> a;
        private final NavigableMap<Cut<C>, Range<C>> b;
        private final Range<Cut<C>> c;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            Cut<C> c;
            final /* synthetic */ Cut d;
            final /* synthetic */ PeekingIterator e;

            a(Cut cut, PeekingIterator peekingIterator) {
                this.d = cut;
                this.e = peekingIterator;
                this.c = cut;
            }

            /* access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                Range range;
                if (c.this.c.upperBound.isLessThan(this.c) || this.c == Cut.aboveAll()) {
                    return (Map.Entry) b();
                }
                if (this.e.hasNext()) {
                    Range range2 = (Range) this.e.next();
                    range = Range.create(this.c, range2.lowerBound);
                    this.c = range2.upperBound;
                } else {
                    range = Range.create(this.c, Cut.aboveAll());
                    this.c = Cut.aboveAll();
                }
                return Maps.j(range.lowerBound, range);
            }
        }

        /* compiled from: Taobao */
        class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            Cut<C> c;
            final /* synthetic */ Cut d;
            final /* synthetic */ PeekingIterator e;

            b(Cut cut, PeekingIterator peekingIterator) {
                this.d = cut;
                this.e = peekingIterator;
                this.c = cut;
            }

            /* access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (this.c == Cut.belowAll()) {
                    return (Map.Entry) b();
                }
                if (this.e.hasNext()) {
                    Range range = (Range) this.e.next();
                    Range create = Range.create(range.upperBound, this.c);
                    this.c = range.lowerBound;
                    if (c.this.c.lowerBound.isLessThan(create.lowerBound)) {
                        return Maps.j(create.lowerBound, create);
                    }
                } else if (c.this.c.lowerBound.isLessThan(Cut.belowAll())) {
                    Range create2 = Range.create(Cut.belowAll(), this.c);
                    this.c = Cut.belowAll();
                    return Maps.j(Cut.belowAll(), create2);
                }
                return (Map.Entry) b();
            }
        }

        c(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }

        private NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            if (!this.c.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new c(this.a, range.intersection(this.c));
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.k
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Collection<Range<C>> collection;
            Cut<C> cut;
            if (this.c.hasLowerBound()) {
                collection = this.b.tailMap(this.c.lowerEndpoint(), this.c.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                collection = this.b.values();
            }
            PeekingIterator p = Iterators.p(collection.iterator());
            if (this.c.contains(Cut.belowAll()) && (!p.hasNext() || ((Range) p.peek()).lowerBound != Cut.belowAll())) {
                cut = Cut.belowAll();
            } else if (!p.hasNext()) {
                return Iterators.h();
            } else {
                cut = ((Range) p.next()).upperBound;
            }
            return new a(cut, p);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            Cut<C> cut;
            Cut<C> cut2;
            if (this.c.hasUpperBound()) {
                cut = this.c.upperEndpoint();
            } else {
                cut = Cut.aboveAll();
            }
            PeekingIterator p = Iterators.p(this.b.headMap(cut, this.c.hasUpperBound() && this.c.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (p.hasNext()) {
                if (((Range) p.peek()).upperBound == Cut.aboveAll()) {
                    cut2 = ((Range) p.next()).lowerBound;
                } else {
                    cut2 = this.a.higherKey(((Range) p.peek()).upperBound);
                }
            } else if (!this.c.contains(Cut.belowAll()) || this.a.containsKey(Cut.belowAll())) {
                return Iterators.h();
            } else {
                cut2 = this.a.higherKey(Cut.belowAll());
            }
            return new b((Cut) com.google.common.base.e.a(cut2, Cut.aboveAll()), p);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @NullableDecl
        /* renamed from: d */
        public Range<C> get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    Map.Entry<Cut<C>, Range<C>> firstEntry = tailMap(cut, true).firstEntry();
                    if (firstEntry != null && firstEntry.getKey().equals(cut)) {
                        return firstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* renamed from: e */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return g(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return g(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return g(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        public int size() {
            return Iterators.u(a());
        }

        private c(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.a = navigableMap;
            this.b = new d(navigableMap);
            this.c = range;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class e<C extends Comparable<?>> extends e<Cut<C>, Range<C>> {
        private final Range<Cut<C>> a;
        private final Range<C> b;
        private final NavigableMap<Cut<C>, Range<C>> c;
        private final NavigableMap<Cut<C>, Range<C>> d;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            final /* synthetic */ Iterator c;
            final /* synthetic */ Cut d;

            a(Iterator it, Cut cut) {
                this.c = it;
                this.d = cut;
            }

            /* access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.c.next();
                if (this.d.isLessThan(range.lowerBound)) {
                    return (Map.Entry) b();
                }
                Range intersection = range.intersection(e.this.b);
                return Maps.j(intersection.lowerBound, intersection);
            }
        }

        /* compiled from: Taobao */
        class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            final /* synthetic */ Iterator c;

            b(Iterator it) {
                this.c = it;
            }

            /* access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.c.next();
                if (e.this.b.lowerBound.compareTo((Cut) range.upperBound) >= 0) {
                    return (Map.Entry) b();
                }
                Range intersection = range.intersection(e.this.b);
                if (e.this.a.contains(intersection.lowerBound)) {
                    return Maps.j(intersection.lowerBound, intersection);
                }
                return (Map.Entry) b();
            }
        }

        private NavigableMap<Cut<C>, Range<C>> h(Range<Cut<C>> range) {
            if (!range.isConnected(this.a)) {
                return ImmutableSortedMap.of();
            }
            return new e(this.a.intersection(range), this.b, this.c);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.util.NavigableMap<com.google.common.collect.Cut<C extends java.lang.Comparable<?>>, com.google.common.collect.Range<C extends java.lang.Comparable<?>>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.k
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (this.b.isEmpty()) {
                return Iterators.h();
            }
            if (this.a.upperBound.isLessThan(this.b.lowerBound)) {
                return Iterators.h();
            }
            boolean z = false;
            if (this.a.lowerBound.isLessThan(this.b.lowerBound)) {
                it = this.d.tailMap(this.b.lowerBound, false).values().iterator();
            } else {
                NavigableMap<Cut<C>, Range<C>> navigableMap = this.c;
                C endpoint = this.a.lowerBound.endpoint();
                if (this.a.lowerBoundType() == BoundType.CLOSED) {
                    z = true;
                }
                it = navigableMap.tailMap(endpoint, z).values().iterator();
            }
            return new a(it, (Cut) Ordering.natural().min(this.a.upperBound, Cut.belowValue(this.b.upperBound)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.NavigableMap<com.google.common.collect.Cut<C extends java.lang.Comparable<?>>, com.google.common.collect.Range<C extends java.lang.Comparable<?>>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            if (this.b.isEmpty()) {
                return Iterators.h();
            }
            Cut cut = (Cut) Ordering.natural().min(this.a.upperBound, Cut.belowValue(this.b.upperBound));
            return new b(this.c.headMap(cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        public boolean containsKey(@NullableDecl Object obj) {
            return get(obj) != null;
        }

        @NullableDecl
        /* renamed from: e */
        public Range<C> get(@NullableDecl Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.a.contains(cut) && cut.compareTo(this.b.lowerBound) >= 0) {
                        if (cut.compareTo(this.b.upperBound) < 0) {
                            if (cut.equals(this.b.lowerBound)) {
                                Range range = (Range) Maps.M(this.c.floorEntry(cut));
                                if (range != null && range.upperBound.compareTo((Cut) this.b.lowerBound) > 0) {
                                    return range.intersection(this.b);
                                }
                            } else {
                                Range range2 = (Range) this.c.get(cut);
                                if (range2 != null) {
                                    return range2.intersection(this.b);
                                }
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return h(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        /* renamed from: g */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return h(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        /* renamed from: i */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return h(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        public int size() {
            return Iterators.u(a());
        }

        private e(Range<Cut<C>> range, Range<C> range2, NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.a = (Range) ds1.p(range);
            this.b = (Range) ds1.p(range2);
            this.c = (NavigableMap) ds1.p(navigableMap);
            this.d = new d(navigableMap);
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @NullableDecl
    private Range<C> rangeEnclosing(Range<C> range) {
        ds1.p(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (floorEntry == null || !floorEntry.getValue().encloses(range)) {
            return null;
        }
        return floorEntry.getValue();
    }

    private void replaceRangeWithSameLowerBound(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public void add(Range<C> range) {
        ds1.p(range);
        if (!range.isEmpty()) {
            Cut<C> cut = range.lowerBound;
            Cut<C> cut2 = range.upperBound;
            Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
            if (lowerEntry != null) {
                Range<C> value = lowerEntry.getValue();
                if (value.upperBound.compareTo((Cut) cut) >= 0) {
                    if (value.upperBound.compareTo((Cut) cut2) >= 0) {
                        cut2 = value.upperBound;
                    }
                    cut = value.lowerBound;
                }
            }
            Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(cut2);
            if (floorEntry != null) {
                Range<C> value2 = floorEntry.getValue();
                if (value2.upperBound.compareTo((Cut) cut2) >= 0) {
                    cut2 = value2.upperBound;
                }
            }
            this.rangesByLowerBound.subMap(cut, cut2).clear();
            replaceRangeWithSameLowerBound(Range.create(cut, cut2));
        }
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ void addAll(RangeSet rangeSet) {
        super.addAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.values());
        this.asRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> complement() {
        RangeSet<C> rangeSet = this.complement;
        if (rangeSet != null) {
            return rangeSet;
        }
        Complement complement2 = new Complement();
        this.complement = complement2;
        return complement2;
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public boolean encloses(Range<C> range) {
        ds1.p(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return floorEntry != null && floorEntry.getValue().encloses(range);
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public boolean intersects(Range<C> range) {
        ds1.p(range);
        Map.Entry<Cut<C>, Range<C>> ceilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (ceilingEntry != null && ceilingEntry.getValue().isConnected(range) && !ceilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry == null || !lowerEntry.getValue().isConnected(range) || lowerEntry.getValue().intersection(range).isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    @NullableDecl
    public Range<C> rangeContaining(C c2) {
        ds1.p(c2);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(c2));
        if (floorEntry == null || !floorEntry.getValue().contains(c2)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public void remove(Range<C> range) {
        ds1.p(range);
        if (!range.isEmpty()) {
            Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
            if (lowerEntry != null) {
                Range<C> value = lowerEntry.getValue();
                if (value.upperBound.compareTo((Cut) range.lowerBound) >= 0) {
                    if (range.hasUpperBound() && value.upperBound.compareTo((Cut) range.upperBound) >= 0) {
                        replaceRangeWithSameLowerBound(Range.create(range.upperBound, value.upperBound));
                    }
                    replaceRangeWithSameLowerBound(Range.create(value.lowerBound, range.lowerBound));
                }
            }
            Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
            if (floorEntry != null) {
                Range<C> value2 = floorEntry.getValue();
                if (range.hasUpperBound() && value2.upperBound.compareTo((Cut) range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(Range.create(range.upperBound, value2.upperBound));
                }
            }
            this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
        }
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ void removeAll(RangeSet rangeSet) {
        super.removeAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry != null) {
            return Range.create(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new SubRangeSet(range);
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(RangeSet<C> rangeSet) {
        TreeRangeSet<C> create = create();
        create.addAll(rangeSet);
        return create;
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.RangeSet, com.google.common.collect.f
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* compiled from: Taobao */
    public static final class d<C extends Comparable<?>> extends e<Cut<C>, Range<C>> {
        private final NavigableMap<Cut<C>, Range<C>> a;
        private final Range<Cut<C>> b;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            final /* synthetic */ Iterator c;

            a(Iterator it) {
                this.c = it;
            }

            /* access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.c.next();
                if (d.this.b.upperBound.isLessThan(range.upperBound)) {
                    return (Map.Entry) b();
                }
                return Maps.j(range.upperBound, range);
            }
        }

        /* compiled from: Taobao */
        class b extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>> {
            final /* synthetic */ PeekingIterator c;

            b(PeekingIterator peekingIterator) {
                this.c = peekingIterator;
            }

            /* access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<Cut<C>, Range<C>> a() {
                if (!this.c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.c.next();
                if (d.this.b.lowerBound.isLessThan(range.upperBound)) {
                    return Maps.j(range.upperBound, range);
                }
                return (Map.Entry) b();
            }
        }

        d(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.a = navigableMap;
            this.b = Range.all();
        }

        private NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            if (range.isConnected(this.b)) {
                return new d(this.a, range.intersection(this.b));
            }
            return ImmutableSortedMap.of();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.k
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (!this.b.hasLowerBound()) {
                it = this.a.values().iterator();
            } else {
                Map.Entry<Cut<C>, Range<C>> lowerEntry = this.a.lowerEntry(this.b.lowerEndpoint());
                if (lowerEntry == null) {
                    it = this.a.values().iterator();
                } else if (this.b.lowerBound.isLessThan(lowerEntry.getValue().upperBound)) {
                    it = this.a.tailMap(lowerEntry.getKey(), true).values().iterator();
                } else {
                    it = this.a.tailMap(this.b.lowerEndpoint(), true).values().iterator();
                }
            }
            return new a(it);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.e
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            Collection<Range<C>> collection;
            if (this.b.hasUpperBound()) {
                collection = this.a.headMap(this.b.upperEndpoint(), false).descendingMap().values();
            } else {
                collection = this.a.descendingMap().values();
            }
            PeekingIterator p = Iterators.p(collection.iterator());
            if (p.hasNext() && this.b.upperBound.isLessThan(((Range) p.peek()).upperBound)) {
                p.next();
            }
            return new b(p);
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        public boolean containsKey(@NullableDecl Object obj) {
            return get(obj) != null;
        }

        /* renamed from: d */
        public Range<C> get(@NullableDecl Object obj) {
            Map.Entry<Cut<C>, Range<C>> lowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.b.contains(cut) && (lowerEntry = this.a.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
                        return lowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* renamed from: e */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return g(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return g(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return g(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        public boolean isEmpty() {
            if (this.b.equals(Range.all())) {
                return this.a.isEmpty();
            }
            return !a().hasNext();
        }

        public int size() {
            if (this.b.equals(Range.all())) {
                return this.a.size();
            }
            return Iterators.u(a());
        }

        private d(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.a = navigableMap;
            this.b = range;
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> create = create();
        create.addAll(iterable);
        return create;
    }
}
