package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
/* compiled from: Taobao */
public abstract class y<R, C, V> extends t implements Table<R, C, V> {
    protected y() {
    }

    @Override // com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    @Override // com.google.common.collect.Table
    public abstract void clear();

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c) {
        return delegate().column(c);
    }

    @Override // com.google.common.collect.Table
    public Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    @Override // com.google.common.collect.Table
    public boolean contains(Object obj, Object obj2) {
        return delegate().contains(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(Object obj) {
        return delegate().containsColumn(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(Object obj) {
        return delegate().containsRow(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.t
    public abstract Table<R, C, V> delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // com.google.common.collect.Table
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // com.google.common.collect.Table
    public V get(Object obj, Object obj2) {
        return delegate().get(obj, obj2);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public abstract V put(R r, C c, V v);

    @Override // com.google.common.collect.Table
    public abstract void putAll(Table<? extends R, ? extends C, ? extends V> table);

    @Override // com.google.common.collect.Table
    @CanIgnoreReturnValue
    public abstract V remove(Object obj, Object obj2);

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r) {
        return delegate().row(r);
    }

    @Override // com.google.common.collect.Table
    public Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return delegate().size();
    }

    @Override // com.google.common.collect.Table
    public Collection<V> values() {
        return delegate().values();
    }
}
