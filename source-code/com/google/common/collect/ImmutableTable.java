package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.e;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.youku.live.dsl.danmaku.DanmakuItemBuilder;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.wr2;

@GwtCompatible
/* compiled from: Taobao */
public abstract class ImmutableTable<R, C, V> extends h<R, C, V> implements Serializable {

    /* compiled from: Taobao */
    static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final int[] cellColumnIndices;
        private final int[] cellRowIndices;
        private final Object[] cellValues;
        private final Object[] columnKeys;
        private final Object[] rowKeys;

        private SerializedForm(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
            this.rowKeys = objArr;
            this.columnKeys = objArr2;
            this.cellValues = objArr3;
            this.cellRowIndices = iArr;
            this.cellColumnIndices = iArr2;
        }

        static SerializedForm create(ImmutableTable<?, ?, ?> immutableTable, int[] iArr, int[] iArr2) {
            return new SerializedForm(immutableTable.rowKeySet().toArray(), immutableTable.columnKeySet().toArray(), immutableTable.values().toArray(), iArr, iArr2);
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            Object[] objArr = this.cellValues;
            if (objArr.length == 0) {
                return ImmutableTable.of();
            }
            int i = 0;
            if (objArr.length == 1) {
                return ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], objArr[0]);
            }
            ImmutableList.a aVar = new ImmutableList.a(objArr.length);
            while (true) {
                Object[] objArr2 = this.cellValues;
                if (i >= objArr2.length) {
                    return RegularImmutableTable.forOrderedComponents(aVar.j(), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
                }
                aVar.a(ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[i]], this.columnKeys[this.cellColumnIndices[i]], objArr2[i]));
                i++;
            }
        }
    }

    /* compiled from: Taobao */
    public static final class a<R, C, V> {
        private final List<Table.Cell<R, C, V>> a = Lists.i();
        @MonotonicNonNullDecl
        private Comparator<? super R> b;
        @MonotonicNonNullDecl
        private Comparator<? super C> c;

        public ImmutableTable<R, C, V> a() {
            int size = this.a.size();
            if (size == 0) {
                return ImmutableTable.of();
            }
            if (size != 1) {
                return RegularImmutableTable.forCells(this.a, this.b, this.c);
            }
            return new SingletonImmutableTable((Table.Cell) a0.h(this.a));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.ImmutableTable$a<R, C, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public a<R, C, V> b(Table.Cell<? extends R, ? extends C, ? extends V> cell) {
            if (cell instanceof Tables.ImmutableCell) {
                ds1.q(cell.getRowKey(), DanmakuItemBuilder.KEY_ROW);
                ds1.q(cell.getColumnKey(), "column");
                ds1.q(cell.getValue(), "value");
                this.a.add(cell);
            } else {
                c(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public a<R, C, V> c(R r, C c2, V v) {
            this.a.add(ImmutableTable.cellOf(r, c2, v));
            return this;
        }
    }

    ImmutableTable() {
    }

    public static <R, C, V> a<R, C, V> builder() {
        return new a<>();
    }

    static <R, C, V> Table.Cell<R, C, V> cellOf(R r, C c, V v) {
        return Tables.c(ds1.q(r, "rowKey"), ds1.q(c, "columnKey"), ds1.q(v, "value"));
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Table<? extends R, ? extends C, ? extends V> table) {
        if (table instanceof ImmutableTable) {
            return (ImmutableTable) table;
        }
        return copyOf(table.cellSet());
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) SparseImmutableTable.EMPTY;
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return get(obj, obj2) != null;
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(@NullableDecl Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(@NullableDecl Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.h
    public abstract ImmutableSet<Table.Cell<R, C, V>> createCellSet();

    /* access modifiers changed from: package-private */
    public abstract SerializedForm createSerializedForm();

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.h
    public abstract ImmutableCollection<V> createValues();

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Object get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @Deprecated
    public final V put(R r, C c, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    @Deprecated
    public final void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.h
    public final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    /* access modifiers changed from: package-private */
    public final Object writeReplace() {
        return createSerializedForm();
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r, C c, V v) {
        return new SingletonImmutableTable(r, c, v);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.h
    public final wr2<Table.Cell<R, C, V>> cellIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public ImmutableSet<Table.Cell<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    @Override // com.google.common.collect.Table
    public ImmutableMap<R, V> column(C c) {
        ds1.q(c, "columnKey");
        return (ImmutableMap) e.a((ImmutableMap) columnMap().get(c), ImmutableMap.of());
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public ImmutableMap<C, V> row(R r) {
        ds1.q(r, "rowKey");
        return (ImmutableMap) e.a((ImmutableMap) rowMap().get(r), ImmutableMap.of());
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    private static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends Table.Cell<? extends R, ? extends C, ? extends V>> iterable) {
        a builder = builder();
        for (Table.Cell<? extends R, ? extends C, ? extends V> cell : iterable) {
            builder.b(cell);
        }
        return builder.a();
    }
}
