package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtCompatible(serializable = true)
/* compiled from: Taobao */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    /* compiled from: Taobao */
    private static class Factory<C, V> implements Supplier<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super C> comparator;

        Factory(Comparator<? super C> comparator2) {
            this.comparator = comparator2;
        }

        @Override // com.google.common.base.Supplier
        public TreeMap<C, V> get() {
            return new TreeMap<>(this.comparator);
        }
    }

    /* compiled from: Taobao */
    class a implements Function<Map<C, V>, Iterator<C>> {
        a(TreeBasedTable treeBasedTable) {
        }

        /* renamed from: a */
        public Iterator<C> apply(Map<C, V> map) {
            return map.keySet().iterator();
        }
    }

    /* compiled from: Taobao */
    class b extends AbstractIterator<C> {
        @NullableDecl
        C c;
        final /* synthetic */ Iterator d;
        final /* synthetic */ Comparator e;

        b(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
            this.d = it;
            this.e = comparator;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public C a() {
            boolean z;
            while (this.d.hasNext()) {
                C c2 = (C) this.d.next();
                C c3 = this.c;
                if (c3 == null || this.e.compare(c2, c3) != 0) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (!z) {
                    this.c = c2;
                    return c2;
                }
            }
            this.c = null;
            return (C) b();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class c extends StandardTable<R, C, V>.g implements SortedMap<C, V> {
        @NullableDecl
        final C d;
        @NullableDecl
        final C e;
        @NullableDecl
        transient SortedMap<C, V> f;

        c(TreeBasedTable treeBasedTable, R r) {
            this(r, null, null);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        @Override // com.google.common.collect.StandardTable.g
        public boolean containsKey(Object obj) {
            return j(obj) && super.containsKey(obj);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.StandardTable.g
        public void d() {
            if (k() != null && this.f.isEmpty()) {
                TreeBasedTable.this.backingMap.remove(this.a);
                this.f = null;
                this.b = null;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public SortedMap<C, V> b() {
            return (SortedMap) super.b();
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            if (b() != null) {
                return b().firstKey();
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: package-private */
        public int g(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public SortedMap<C, V> c() {
            SortedMap<C, V> k = k();
            if (k == null) {
                return null;
            }
            C c = this.d;
            if (c != null) {
                k = k.tailMap(c);
            }
            C c2 = this.e;
            return c2 != null ? k.headMap(c2) : k;
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c) {
            ds1.d(j(ds1.p(c)));
            return new c(this.a, this.d, c);
        }

        /* renamed from: i */
        public SortedSet<C> keySet() {
            return new Maps.n(this);
        }

        /* access modifiers changed from: package-private */
        public boolean j(@NullableDecl Object obj) {
            C c;
            C c2;
            return obj != null && ((c = this.d) == null || g(c, obj) <= 0) && ((c2 = this.e) == null || g(c2, obj) > 0);
        }

        /* access modifiers changed from: package-private */
        public SortedMap<C, V> k() {
            SortedMap<C, V> sortedMap = this.f;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.a))) {
                this.f = (SortedMap) TreeBasedTable.this.backingMap.get(this.a);
            }
            return this.f;
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            if (b() != null) {
                return b().lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.StandardTable.g
        public V put(C c, V v) {
            ds1.d(j(ds1.p(c)));
            return (V) super.put(c, v);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c, C c2) {
            ds1.d(j(ds1.p(c)) && j(ds1.p(c2)));
            return new c(this.a, c, c2);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c) {
            ds1.d(j(ds1.p(c)));
            return new c(this.a, c, this.e);
        }

        c(R r, @NullableDecl C c, @NullableDecl C c2) {
            super(r);
            this.d = c;
            this.e = c2;
            ds1.d(c == null || c2 == null || g(c, c2) <= 0);
        }
    }

    TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    @Override // com.google.common.collect.h, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.h, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@NullableDecl Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@NullableDecl Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object obj) {
        return super.containsValue(obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.StandardTable
    public Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> columnComparator2 = columnComparator();
        return new b(this, Iterators.o(a0.n(this.backingMap.values(), new a(this)), columnComparator2), columnComparator2);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Object get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.h, com.google.common.collect.StandardTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void putAll(Table table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.StandardTable, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        return rowKeySet().comparator();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        ds1.p(comparator);
        ds1.p(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedMap<C, V> row(R r) {
        return new c(this, r);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.RowSortedTable, com.google.common.collect.Table
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.RowSortedTable, com.google.common.collect.Table
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
}
