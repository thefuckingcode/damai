package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.Immutable;
import java.util.LinkedHashMap;
import java.util.Map;
import tb.wr2;

/* access modifiers changed from: package-private */
@Immutable(containerOf = {"R", "C", "V"})
@GwtCompatible
/* compiled from: Taobao */
public final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    static final ImmutableTable<Object, Object, Object> EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    private final int[] cellColumnInRowIndices;
    private final int[] cellRowIndices;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.google.common.collect.SparseImmutableTable<R, C, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.LinkedHashMap */
    /* JADX DEBUG: Multi-variable search result rejected for r11v2, resolved type: java.util.LinkedHashMap */
    /* JADX DEBUG: Multi-variable search result rejected for r10v1, resolved type: com.google.common.collect.ImmutableMap$b */
    /* JADX DEBUG: Multi-variable search result rejected for r10v3, resolved type: com.google.common.collect.ImmutableMap$b */
    /* JADX WARN: Multi-variable type inference failed */
    SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        ImmutableMap k = Maps.k(immutableSet);
        LinkedHashMap s = Maps.s();
        wr2<R> it = immutableSet.iterator();
        while (it.hasNext()) {
            s.put(it.next(), new LinkedHashMap());
        }
        LinkedHashMap s2 = Maps.s();
        wr2<C> it2 = immutableSet2.iterator();
        while (it2.hasNext()) {
            s2.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            Table.Cell<R, C, V> cell = immutableList.get(i);
            R rowKey = cell.getRowKey();
            C columnKey = cell.getColumnKey();
            V value = cell.getValue();
            iArr[i] = ((Integer) k.get(rowKey)).intValue();
            Map map = (Map) s.get(rowKey);
            iArr2[i] = map.size();
            checkNoDuplicate(rowKey, columnKey, map.put(columnKey, value), value);
            ((Map) s2.get(columnKey)).put(rowKey, value);
        }
        this.cellRowIndices = iArr;
        this.cellColumnInRowIndices = iArr2;
        ImmutableMap.b bVar = new ImmutableMap.b(s.size());
        for (Map.Entry entry : s.entrySet()) {
            bVar.c(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.rowMap = bVar.a();
        ImmutableMap.b bVar2 = new ImmutableMap.b(s2.size());
        for (Map.Entry entry2 : s2.entrySet()) {
            bVar2.c(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.columnMap = bVar2.a();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        ImmutableMap k = Maps.k(columnKeySet());
        int[] iArr = new int[cellSet().size()];
        wr2<Table.Cell<R, C, V>> it = cellSet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Integer) k.get(it.next().getColumnKey())).intValue();
            i++;
        }
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, iArr);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.RegularImmutableTable
    public Table.Cell<R, C, V> getCell(int i) {
        Map.Entry<R, ImmutableMap<C, V>> entry = this.rowMap.entrySet().asList().get(this.cellRowIndices[i]);
        Map.Entry<C, V> entry2 = entry.getValue().entrySet().asList().get(this.cellColumnInRowIndices[i]);
        return ImmutableTable.cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int i) {
        int i2 = this.cellRowIndices[i];
        return this.rowMap.values().asList().get(i2).values().asList().get(this.cellColumnInRowIndices[i]);
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.cellRowIndices.length;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf(this.rowMap);
    }
}
