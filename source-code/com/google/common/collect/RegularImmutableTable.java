package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

/* access modifiers changed from: package-private */
@GwtCompatible
/* compiled from: Taobao */
public abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class CellSet extends IndexedImmutableSet<Table.Cell<R, C, V>> {
        private CellSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Object obj2 = RegularImmutableTable.this.get(cell.getRowKey(), cell.getColumnKey());
            if (obj2 == null || !obj2.equals(cell.getValue())) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        public int size() {
            return RegularImmutableTable.this.size();
        }

        /* synthetic */ CellSet(RegularImmutableTable regularImmutableTable, a aVar) {
            this();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.IndexedImmutableSet
        public Table.Cell<R, C, V> get(int i) {
            return RegularImmutableTable.this.getCell(i);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public final class Values extends ImmutableList<V> {
        private Values() {
        }

        @Override // java.util.List
        public V get(int i) {
            return (V) RegularImmutableTable.this.getValue(i);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        public int size() {
            return RegularImmutableTable.this.size();
        }

        /* synthetic */ Values(RegularImmutableTable regularImmutableTable, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements Comparator<Table.Cell<R, C, V>> {
        final /* synthetic */ Comparator a;
        final /* synthetic */ Comparator b;

        a(Comparator comparator, Comparator comparator2) {
            this.a = comparator;
            this.b = comparator2;
        }

        /* renamed from: a */
        public int compare(Table.Cell<R, C, V> cell, Table.Cell<R, C, V> cell2) {
            int i;
            Comparator comparator = this.a;
            if (comparator == null) {
                i = 0;
            } else {
                i = comparator.compare(cell.getRowKey(), cell2.getRowKey());
            }
            if (i != 0) {
                return i;
            }
            Comparator comparator2 = this.b;
            if (comparator2 == null) {
                return 0;
            }
            return comparator2.compare(cell.getColumnKey(), cell2.getColumnKey());
        }
    }

    RegularImmutableTable() {
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Table.Cell<R, C, V>> list, @NullableDecl Comparator<? super R> comparator, @NullableDecl Comparator<? super C> comparator2) {
        ds1.p(list);
        if (!(comparator == null && comparator2 == null)) {
            Collections.sort(list, new a(comparator, comparator2));
        }
        return forCellsInternal(list, comparator, comparator2);
    }

    private static <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Table.Cell<R, C, V>> iterable, @NullableDecl Comparator<? super R> comparator, @NullableDecl Comparator<? super C> comparator2) {
        ImmutableSet immutableSet;
        ImmutableSet immutableSet2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ImmutableList copyOf = ImmutableList.copyOf(iterable);
        for (Table.Cell<R, C, V> cell : iterable) {
            linkedHashSet.add(cell.getRowKey());
            linkedHashSet2.add(cell.getColumnKey());
        }
        if (comparator == null) {
            immutableSet = ImmutableSet.copyOf((Collection) linkedHashSet);
        } else {
            immutableSet = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet));
        }
        if (comparator2 == null) {
            immutableSet2 = ImmutableSet.copyOf((Collection) linkedHashSet2);
        } else {
            immutableSet2 = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2));
        }
        return forOrderedComponents(copyOf, immutableSet, immutableSet2);
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new DenseImmutableTable(immutableList, immutableSet, immutableSet2) : new SparseImmutableTable(immutableList, immutableSet, immutableSet2);
    }

    /* access modifiers changed from: package-private */
    public final void checkNoDuplicate(R r, C c, V v, V v2) {
        ds1.m(v == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r, c, v2, v);
    }

    /* access modifiers changed from: package-private */
    public abstract Table.Cell<R, C, V> getCell(int i);

    /* access modifiers changed from: package-private */
    public abstract V getValue(int i);

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.h, com.google.common.collect.ImmutableTable, com.google.common.collect.ImmutableTable
    public final ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
        return isEmpty() ? ImmutableSet.of() : new CellSet(this, null);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.h, com.google.common.collect.ImmutableTable, com.google.common.collect.ImmutableTable
    public final ImmutableCollection<V> createValues() {
        return isEmpty() ? ImmutableList.of() : new Values(this, null);
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Table.Cell<R, C, V>> iterable) {
        return forCellsInternal(iterable, null, null);
    }
}
