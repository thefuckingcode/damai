package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.wr2;

@GwtCompatible(emulated = true, serializable = true)
/* compiled from: Taobao */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    @RetainedWith
    @LazyInit
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;
    @RetainedWith
    @LazyInit
    private transient ImmutableSet<K> keySet;
    @LazyInit
    private transient ImmutableSetMultimap<K, V> multimapView;
    @RetainedWith
    @LazyInit
    private transient ImmutableCollection<V> values;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        IteratorBasedImmutableMap() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() {
                /* class com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.AnonymousClass1EntrySetImpl */

                /* access modifiers changed from: package-private */
                @Override // com.google.common.collect.ImmutableMapEntrySet
                public ImmutableMap<K, V> map() {
                    return IteratorBasedImmutableMap.this;
                }

                @Override // java.util.AbstractCollection, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableSet, java.util.Collection, com.google.common.collect.ImmutableCollection, com.google.common.collect.ImmutableCollection, java.util.Set, java.lang.Iterable
                public wr2<Map.Entry<K, V>> iterator() {
                    return IteratorBasedImmutableMap.this.entryIterator();
                }
            };
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }

        /* access modifiers changed from: package-private */
        public abstract wr2<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap, com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return ImmutableMap.super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return ImmutableMap.super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return ImmutableMap.super.values();
        }
    }

    /* compiled from: Taobao */
    private final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {

        /* compiled from: Taobao */
        class a extends wr2<Map.Entry<K, ImmutableSet<V>>> {
            final /* synthetic */ Iterator a;

            /* access modifiers changed from: package-private */
            /* renamed from: com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$a$a  reason: collision with other inner class name */
            /* compiled from: Taobao */
            public class C0157a extends b<K, ImmutableSet<V>> {
                final /* synthetic */ Map.Entry a;

                C0157a(a aVar, Map.Entry entry) {
                    this.a = entry;
                }

                /* renamed from: a */
                public ImmutableSet<V> getValue() {
                    return ImmutableSet.of(this.a.getValue());
                }

                @Override // java.util.Map.Entry, com.google.common.collect.b
                public K getKey() {
                    return (K) this.a.getKey();
                }
            }

            a(MapViewOfValuesAsSingletonSets mapViewOfValuesAsSingletonSets, Iterator it) {
                this.a = it;
            }

            /* renamed from: a */
            public Map.Entry<K, ImmutableSet<V>> next() {
                return new C0157a(this, (Map.Entry) this.a.next());
            }

            public boolean hasNext() {
                return this.a.hasNext();
            }
        }

        private MapViewOfValuesAsSingletonSets() {
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean containsKey(@NullableDecl Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return ImmutableMap.this.keySet();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public wr2<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            return new a(this, ImmutableMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ImmutableMap
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public boolean isHashCodeFast() {
            return ImmutableMap.this.isHashCodeFast();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return ImmutableMap.this.isPartialView();
        }

        public int size() {
            return ImmutableMap.this.size();
        }

        /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(@NullableDecl Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }
    }

    /* compiled from: Taobao */
    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            wr2<Map.Entry<?, ?>> it = immutableMap.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                this.keys[i] = next.getKey();
                this.values[i] = next.getValue();
                i++;
            }
        }

        /* access modifiers changed from: package-private */
        public Object createMap(b<Object, Object> bVar) {
            int i = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i >= objArr.length) {
                    return bVar.a();
                }
                bVar.c(objArr[i], this.values[i]);
                i++;
            }
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return createMap(new b<>(this.keys.length));
        }
    }

    /* compiled from: Taobao */
    class a extends wr2<K> {
        final /* synthetic */ wr2 a;

        a(ImmutableMap immutableMap, wr2 wr2) {
            this.a = wr2;
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.a.next()).getKey();
        }
    }

    /* compiled from: Taobao */
    public static class b<K, V> {
        @MonotonicNonNullDecl
        Comparator<? super V> a;
        Object[] b;
        int c;
        boolean d;

        public b() {
            this(4);
        }

        private void b(int i) {
            int i2 = i * 2;
            Object[] objArr = this.b;
            if (i2 > objArr.length) {
                this.b = Arrays.copyOf(objArr, ImmutableCollection.b.e(objArr.length, i2));
                this.d = false;
            }
        }

        public ImmutableMap<K, V> a() {
            g();
            this.d = true;
            return RegularImmutableMap.create(this.c, this.b);
        }

        @CanIgnoreReturnValue
        public b<K, V> c(K k, V v) {
            b(this.c + 1);
            k.a(k, v);
            Object[] objArr = this.b;
            int i = this.c;
            objArr[i * 2] = k;
            objArr[(i * 2) + 1] = v;
            this.c = i + 1;
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.ImmutableMap$b<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public b<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            return c(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        @Beta
        public b<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                b(this.c + ((Collection) iterable).size());
            }
            for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                d(entry);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public b<K, V> f(Map<? extends K, ? extends V> map) {
            return e(map.entrySet());
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int i;
            if (this.a != null) {
                if (this.d) {
                    this.b = Arrays.copyOf(this.b, this.c * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.c];
                int i2 = 0;
                while (true) {
                    i = this.c;
                    if (i2 >= i) {
                        break;
                    }
                    Object[] objArr = this.b;
                    int i3 = i2 * 2;
                    entryArr[i2] = new AbstractMap.SimpleImmutableEntry(objArr[i3], objArr[i3 + 1]);
                    i2++;
                }
                Arrays.sort(entryArr, 0, i, Ordering.from(this.a).onResultOf(Maps.K()));
                for (int i4 = 0; i4 < this.c; i4++) {
                    int i5 = i4 * 2;
                    this.b[i5] = entryArr[i4].getKey();
                    this.b[i5 + 1] = entryArr[i4].getValue();
                }
            }
        }

        b(int i) {
            this.b = new Object[(i * 2)];
            this.c = 0;
            this.d = false;
        }
    }

    ImmutableMap() {
    }

    public static <K, V> b<K, V> builder() {
        return new b<>();
    }

    @Beta
    public static <K, V> b<K, V> builderWithExpectedSize(int i) {
        k.b(i, "expectedSize");
        return new b<>(i);
    }

    static void checkNoConflict(boolean z, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (!z) {
            throw conflictException(str, entry, entry2);
        }
    }

    static IllegalArgumentException conflictException(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    static <K, V> Map.Entry<K, V> entryOf(K k, V v) {
        k.a(k, v);
        return new AbstractMap.SimpleImmutableEntry(k, v);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) RegularImmutableMap.EMPTY;
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.multimapView = immutableSetMultimap2;
        return immutableSetMultimap2;
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    /* access modifiers changed from: package-private */
    public abstract ImmutableSet<K> createKeySet();

    /* access modifiers changed from: package-private */
    public abstract ImmutableCollection<V> createValues();

    public boolean equals(@NullableDecl Object obj) {
        return Maps.i(this, obj);
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public int hashCode() {
        return Sets.b(entrySet());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isHashCodeFast() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean isPartialView();

    /* access modifiers changed from: package-private */
    public wr2<K> keyIterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.z(this);
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v) {
        k.a(k, v);
        return RegularImmutableMap.create(1, new Object[]{k, v});
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2) {
        k.a(k, v);
        k.a(k2, v2);
        return RegularImmutableMap.create(2, new Object[]{k, v, k2, v2});
    }

    @Beta
    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        b bVar = new b(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        bVar.e(iterable);
        return bVar.a();
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        k.a(k, v);
        k.a(k2, v2);
        k.a(k3, v3);
        return RegularImmutableMap.create(3, new Object[]{k, v, k2, v2, k3, v3});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        k.a(k, v);
        k.a(k2, v2);
        k.a(k3, v3);
        k.a(k4, v4);
        return RegularImmutableMap.create(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        k.a(k, v);
        k.a(k2, v2);
        k.a(k3, v3);
        k.a(k4, v4);
        k.a(k5, v5);
        return RegularImmutableMap.create(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }
}
