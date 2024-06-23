package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.rk1;

@Beta
@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class ArrayTable<R, C, V> extends h<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    @MonotonicNonNullDecl
    private transient ArrayTable<R, C, V>.f columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;
    @MonotonicNonNullDecl
    private transient ArrayTable<R, C, V>.h rowMap;

    /* compiled from: Taobao */
    class a extends a<Table.Cell<R, C, V>> {
        a(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Table.Cell<R, C, V> a(int i) {
            return ArrayTable.this.getCell(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends Tables.b<R, C, V> {
        final int a;
        final int b;
        final /* synthetic */ int c;

        b(int i) {
            this.c = i;
            this.a = i / ArrayTable.this.columnList.size();
            this.b = i % ArrayTable.this.columnList.size();
        }

        @Override // com.google.common.collect.Table.Cell
        public C getColumnKey() {
            return (C) ArrayTable.this.columnList.get(this.b);
        }

        @Override // com.google.common.collect.Table.Cell
        public R getRowKey() {
            return (R) ArrayTable.this.rowList.get(this.a);
        }

        @Override // com.google.common.collect.Table.Cell
        public V getValue() {
            return (V) ArrayTable.this.at(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    class c extends a<V> {
        c(int i) {
            super(i);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.a
        public V a(int i) {
            return (V) ArrayTable.this.getValue(i);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static abstract class d<K, V> extends Maps.k<K, V> {
        private final ImmutableMap<K, Integer> a;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a extends b<K, V> {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            @Override // java.util.Map.Entry, com.google.common.collect.b
            public K getKey() {
                return (K) d.this.c(this.a);
            }

            @Override // java.util.Map.Entry, com.google.common.collect.b
            public V getValue() {
                return (V) d.this.e(this.a);
            }

            @Override // java.util.Map.Entry, com.google.common.collect.b
            public V setValue(V v) {
                return (V) d.this.f(this.a, v);
            }
        }

        /* compiled from: Taobao */
        class b extends a<Map.Entry<K, V>> {
            b(int i) {
                super(i);
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public Map.Entry<K, V> a(int i) {
                return d.this.b(i);
            }
        }

        /* synthetic */ d(ImmutableMap immutableMap, a aVar) {
            this(immutableMap);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.k
        public Iterator<Map.Entry<K, V>> a() {
            return new b(size());
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, V> b(int i) {
            ds1.n(i, size());
            return new a(i);
        }

        /* access modifiers changed from: package-private */
        public K c(int i) {
            return this.a.keySet().asList().get(i);
        }

        @Override // com.google.common.collect.Maps.k
        public void clear() {
            throw new UnsupportedOperationException();
        }

        public boolean containsKey(@NullableDecl Object obj) {
            return this.a.containsKey(obj);
        }

        /* access modifiers changed from: package-private */
        public abstract String d();

        /* access modifiers changed from: package-private */
        @NullableDecl
        public abstract V e(int i);

        /* access modifiers changed from: package-private */
        @NullableDecl
        public abstract V f(int i, V v);

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@NullableDecl Object obj) {
            Integer num = this.a.get(obj);
            if (num == null) {
                return null;
            }
            return e(num.intValue());
        }

        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            Integer num = this.a.get(k);
            if (num != null) {
                return f(num.intValue(), v);
            }
            throw new IllegalArgumentException(d() + " " + ((Object) k) + " not in " + this.a.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.a.size();
        }

        private d(ImmutableMap<K, Integer> immutableMap) {
            this.a = immutableMap;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class e extends d<R, V> {
        final int b;

        e(int i) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.b = i;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Row";
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.d
        public V e(int i) {
            return (V) ArrayTable.this.at(i, this.b);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i, V v) {
            return (V) ArrayTable.this.set(i, this.b, v);
        }
    }

    /* compiled from: Taobao */
    private class f extends d<C, Map<R, V>> {
        /* synthetic */ f(ArrayTable arrayTable, a aVar) {
            this();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Column";
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public Map<R, V> e(int i) {
            return new e(i);
        }

        /* renamed from: h */
        public Map<R, V> put(C c, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Map<R, V> f(int i, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        private f() {
            super(ArrayTable.this.columnKeyToIndex, null);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class g extends d<C, V> {
        final int b;

        g(int i) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.b = i;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Column";
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.d
        public V e(int i) {
            return (V) ArrayTable.this.at(this.b, i);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i, V v) {
            return (V) ArrayTable.this.set(this.b, i, v);
        }
    }

    /* compiled from: Taobao */
    private class h extends d<R, Map<C, V>> {
        /* synthetic */ h(ArrayTable arrayTable, a aVar) {
            this();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.d
        public String d() {
            return "Row";
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public Map<C, V> e(int i) {
            return new g(i);
        }

        /* renamed from: h */
        public Map<C, V> put(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Map<C, V> f(int i, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        private h() {
            super(ArrayTable.this.rowKeyToIndex, null);
        }
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> copyOf = ImmutableList.copyOf(iterable);
        this.rowList = copyOf;
        ImmutableList<C> copyOf2 = ImmutableList.copyOf(iterable2);
        this.columnList = copyOf2;
        ds1.d(copyOf.isEmpty() == copyOf2.isEmpty());
        this.rowKeyToIndex = Maps.k(copyOf);
        this.columnKeyToIndex = Maps.k(copyOf2);
        int size = copyOf.size();
        int[] iArr = new int[2];
        iArr[1] = copyOf2.size();
        iArr[0] = size;
        this.array = (V[][]) ((Object[][]) Array.newInstance(Object.class, iArr));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Table.Cell<R, C, V> getCell(int i) {
        return new b(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private V getValue(int i) {
        return at(i / this.columnList.size(), i % this.columnList.size());
    }

    public V at(int i, int i2) {
        ds1.n(i, this.rowList.size());
        ds1.n(i2, this.columnList.size());
        return this.array[i][i2];
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.h
    public Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new a(size());
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c2) {
        ds1.p(c2);
        Integer num = this.columnKeyToIndex.get(c2);
        return num == null ? ImmutableMap.of() : new e(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        ArrayTable<R, C, V>.f fVar2 = new f(this, null);
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public boolean containsColumn(@NullableDecl Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public boolean containsRow(@NullableDecl Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public boolean containsValue(@NullableDecl Object obj) {
        V[][] vArr = this.array;
        for (V[] vArr2 : vArr) {
            for (V v : vArr2) {
                if (rk1.a(obj, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    public V erase(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public V put(R r, C c2, @NullableDecl V v) {
        ds1.p(r);
        ds1.p(c2);
        Integer num = this.rowKeyToIndex.get(r);
        boolean z = true;
        ds1.l(num != null, "Row %s not in %s", r, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c2);
        if (num2 == null) {
            z = false;
        }
        ds1.l(z, "Column %s not in %s", c2, this.columnList);
        return set(num.intValue(), num2.intValue(), v);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    @CanIgnoreReturnValue
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r) {
        ds1.p(r);
        Integer num = this.rowKeyToIndex.get(r);
        return num == null ? ImmutableMap.of() : new g(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.h hVar = this.rowMap;
        if (hVar != null) {
            return hVar;
        }
        ArrayTable<R, C, V>.h hVar2 = new h(this, null);
        this.rowMap = hVar2;
        return hVar2;
    }

    @CanIgnoreReturnValue
    public V set(int i, int i2, @NullableDecl V v) {
        ds1.n(i, this.rowList.size());
        ds1.n(i2, this.columnList.size());
        V[][] vArr = this.array;
        V v2 = vArr[i][i2];
        vArr[i][i2] = v;
        return v2;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @GwtIncompatible
    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i = 0; i < this.rowList.size(); i++) {
            V[][] vArr2 = this.array;
            System.arraycopy(vArr2[i], 0, vArr[i], 0, vArr2[i].length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.h
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public Collection<V> values() {
        return super.values();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.h
    public Iterator<V> valuesIterator() {
        return new c(size());
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> table) {
        return table instanceof ArrayTable ? new ArrayTable<>((ArrayTable) table) : new ArrayTable<>(table);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    private ArrayTable(Table<R, C, V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.columnList;
        this.columnList = immutableList2;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        int size = immutableList.size();
        int[] iArr = new int[2];
        iArr[1] = immutableList2.size();
        iArr[0] = size;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance(Object.class, iArr));
        this.array = vArr;
        for (int i = 0; i < this.rowList.size(); i++) {
            V[][] vArr2 = arrayTable.array;
            System.arraycopy(vArr2[i], 0, vArr[i], 0, vArr2[i].length);
        }
    }
}
