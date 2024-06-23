package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.jl1;
import tb.rk1;
import tb.wr2;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class Maps {

    /* compiled from: Taobao */
    private static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final BiMap<A, B> bimap;

        BiMapConverter(BiMap<A, B> biMap) {
            this.bimap = (BiMap) ds1.p(biMap);
        }

        private static <X, Y> Y convert(BiMap<X, Y> biMap, X x) {
            Y y = biMap.get(x);
            ds1.k(y != null, "No non-null mapping present for input: %s", x);
            return y;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public A doBackward(B b) {
            return (A) convert(this.bimap.inverse(), b);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        public B doForward(A a) {
            return (B) convert(this.bimap, a);
        }

        @Override // com.google.common.base.Function, com.google.common.base.Converter
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof BiMapConverter) {
                return this.bimap.equals(((BiMapConverter) obj).bimap);
            }
            return false;
        }

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public String toString() {
            return "Maps.asConverter(" + this.bimap + jl1.BRACKET_END_STR;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY {
            @NullableDecl
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            @NullableDecl
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        /* synthetic */ EntryFunction(c cVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(@NullableDecl K k, @NullableDecl V1 v1);
    }

    /* compiled from: Taobao */
    private static class UnmodifiableBiMap<K, V> extends q<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final BiMap<? extends K, ? extends V> delegate;
        @RetainedWith
        @MonotonicNonNullDecl
        BiMap<V, K> inverse;
        final Map<K, V> unmodifiableMap;
        @MonotonicNonNullDecl
        transient Set<V> values;

        UnmodifiableBiMap(BiMap<? extends K, ? extends V> biMap, @NullableDecl BiMap<V, K> biMap2) {
            this.unmodifiableMap = Collections.unmodifiableMap(biMap);
            this.delegate = biMap;
            this.inverse = biMap2;
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            BiMap<V, K> biMap = this.inverse;
            if (biMap != null) {
                return biMap;
            }
            UnmodifiableBiMap unmodifiableBiMap = new UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = unmodifiableBiMap;
            return unmodifiableBiMap;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
        public Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @Override // com.google.common.collect.BiMap, java.util.Map, com.google.common.collect.q
        public Set<V> values() {
            Set<V> set = this.values;
            if (set != null) {
                return set;
            }
            Set<V> unmodifiableSet = Collections.unmodifiableSet(this.delegate.values());
            this.values = unmodifiableSet;
            return unmodifiableSet;
        }
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    /* compiled from: Taobao */
    public static class UnmodifiableNavigableMap<K, V> extends w<K, V> implements NavigableMap<K, V>, Serializable {
        private final NavigableMap<K, ? extends V> delegate;
        @MonotonicNonNullDecl
        private transient UnmodifiableNavigableMap<K, V> descendingMap;

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
            this.delegate = navigableMap;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            return Maps.J(this.delegate.ceilingEntry(k));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return this.delegate.ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Sets.j(this.delegate.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap = this.descendingMap;
            if (unmodifiableNavigableMap != null) {
                return unmodifiableNavigableMap;
            }
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap2 = new UnmodifiableNavigableMap<>(this.delegate.descendingMap(), this);
            this.descendingMap = unmodifiableNavigableMap2;
            return unmodifiableNavigableMap2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return Maps.J(this.delegate.firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            return Maps.J(this.delegate.floorEntry(k));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return this.delegate.floorKey(k);
        }

        @Override // com.google.common.collect.w, java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            return Maps.J(this.delegate.higherEntry(k));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return this.delegate.higherKey(k);
        }

        @Override // java.util.Map, com.google.common.collect.q, java.util.SortedMap
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return Maps.J(this.delegate.lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            return Maps.J(this.delegate.lowerEntry(k));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return this.delegate.lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Sets.j(this.delegate.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.w, java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // com.google.common.collect.w, java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return Maps.I(this.delegate.headMap(k, z));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return Maps.I(this.delegate.subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return Maps.I(this.delegate.tailMap(k, z));
        }

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap, UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap) {
            this.delegate = navigableMap;
            this.descendingMap = unmodifiableNavigableMap;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.w, com.google.common.collect.w, com.google.common.collect.w, com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
        public SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a extends b<K, V2> {
        final /* synthetic */ Map.Entry a;
        final /* synthetic */ EntryTransformer b;

        a(Map.Entry entry, EntryTransformer entryTransformer) {
            this.a = entry;
            this.b = entryTransformer;
        }

        @Override // java.util.Map.Entry, com.google.common.collect.b
        public K getKey() {
            return (K) this.a.getKey();
        }

        @Override // java.util.Map.Entry, com.google.common.collect.b
        public V2 getValue() {
            return (V2) this.b.transformEntry(this.a.getKey(), this.a.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class b implements Function<Map.Entry<K, V1>, Map.Entry<K, V2>> {
        final /* synthetic */ EntryTransformer a;

        b(EntryTransformer entryTransformer) {
            this.a = entryTransformer;
        }

        /* renamed from: a */
        public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
            return Maps.C(this.a, entry);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class c extends j0<Map.Entry<K, V>, K> {
        c(Iterator it) {
            super(it);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class d extends j0<Map.Entry<K, V>, V> {
        d(Iterator it) {
            super(it);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* compiled from: Taobao */
    static class e extends j0<K, Map.Entry<K, V>> {
        final /* synthetic */ Function b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Iterator it, Function function) {
            super(it);
            this.b = function;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public Map.Entry<K, V> a(K k) {
            return Maps.j(k, this.b.apply(k));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class f extends b<K, V> {
        final /* synthetic */ Map.Entry a;

        f(Map.Entry entry) {
            this.a = entry;
        }

        @Override // java.util.Map.Entry, com.google.common.collect.b
        public K getKey() {
            return (K) this.a.getKey();
        }

        @Override // java.util.Map.Entry, com.google.common.collect.b
        public V getValue() {
            return (V) this.a.getValue();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class g extends wr2<Map.Entry<K, V>> {
        final /* synthetic */ Iterator a;

        g(Iterator it) {
            this.a = it;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            return Maps.F((Map.Entry) this.a.next());
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class h implements EntryTransformer<K, V1, V2> {
        final /* synthetic */ Function a;

        h(Function function) {
            this.a = function;
        }

        @Override // com.google.common.collect.Maps.EntryTransformer
        public V2 transformEntry(K k, V1 v1) {
            return (V2) this.a.apply(v1);
        }
    }

    @GwtIncompatible
    /* compiled from: Taobao */
    static abstract class i<K, V> extends q<K, V> implements NavigableMap<K, V> {
        @MonotonicNonNullDecl
        private transient Comparator<? super K> a;
        @MonotonicNonNullDecl
        private transient Set<Map.Entry<K, V>> b;
        @MonotonicNonNullDecl
        private transient NavigableSet<K> c;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a extends j<K, V> {
            a() {
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.Maps.j
            public Map<K, V> a() {
                return i.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<K, V>> iterator() {
                return i.this.b();
            }
        }

        i() {
        }

        private static <T> Ordering<T> d(Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }

        /* access modifiers changed from: package-private */
        public Set<Map.Entry<K, V>> a() {
            return new a();
        }

        /* access modifiers changed from: package-private */
        public abstract Iterator<Map.Entry<K, V>> b();

        /* access modifiers changed from: package-private */
        public abstract NavigableMap<K, V> c();

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            return c().floorEntry(k);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return c().floorKey(k);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.a;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = c().comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
            Ordering d = d(comparator2);
            this.a = d;
            return d;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return c().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return c();
        }

        @Override // java.util.Map, com.google.common.collect.q, java.util.SortedMap
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.b;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> a2 = a();
            this.b = a2;
            return a2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return c().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return c().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            return c().ceilingEntry(k);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return c().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return c().tailMap(k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            return c().lowerEntry(k);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return c().lowerKey(k);
        }

        @Override // java.util.Map, com.google.common.collect.q, java.util.SortedMap
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return c().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return c().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            return c().higherEntry(k);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return c().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.c;
            if (navigableSet != null) {
                return navigableSet;
            }
            m mVar = new m(this);
            this.c = mVar;
            return mVar;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return c().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return c().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return c().subMap(k2, z2, k, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return c().headMap(k, z).descendingMap();
        }

        @Override // com.google.common.collect.t
        public String toString() {
            return standardToString();
        }

        @Override // java.util.Map, com.google.common.collect.q, java.util.SortedMap
        public Collection<V> values() {
            return new s(this);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
        public final Map<K, V> delegate() {
            return c();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }
    }

    /* compiled from: Taobao */
    static abstract class j<K, V> extends Sets.a<Map.Entry<K, V>> {
        j() {
        }

        /* access modifiers changed from: package-private */
        public abstract Map<K, V> a();

        public void clear() {
            a().clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object x = Maps.x(a(), key);
            if (!rk1.a(x, entry.getValue())) {
                return false;
            }
            if (x != null || a().containsKey(key)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return a().isEmpty();
        }

        public boolean remove(Object obj) {
            if (contains(obj)) {
                return a().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.AbstractSet, java.util.Set, com.google.common.collect.Sets.a
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) ds1.p(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.i(this, collection.iterator());
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, com.google.common.collect.Sets.a
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) ds1.p(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet e = Sets.e(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        e.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(e);
            }
        }

        public int size() {
            return a().size();
        }
    }

    /* compiled from: Taobao */
    static abstract class k<K, V> extends AbstractMap<K, V> {

        /* compiled from: Taobao */
        class a extends j<K, V> {
            a() {
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.Maps.j
            public Map<K, V> a() {
                return k.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<K, V>> iterator() {
                return k.this.a();
            }
        }

        k() {
        }

        /* access modifiers changed from: package-private */
        public abstract Iterator<Map.Entry<K, V>> a();

        public void clear() {
            Iterators.d(a());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class l<K, V> extends Sets.a<K> {
        @Weak
        final Map<K, V> a;

        l(Map<K, V> map) {
            this.a = (Map) ds1.p(map);
        }

        /* access modifiers changed from: package-private */
        public Map<K, V> a() {
            return this.a;
        }

        public void clear() {
            a().clear();
        }

        public boolean contains(Object obj) {
            return a().containsKey(obj);
        }

        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return Maps.m(a().entrySet().iterator());
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            a().remove(obj);
            return true;
        }

        public int size() {
            return a().size();
        }
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    /* compiled from: Taobao */
    public static class m<K, V> extends n<K, V> implements NavigableSet<K> {
        m(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public NavigableMap<K, V> b() {
            return (NavigableMap) this.a;
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return b().ceilingKey(k);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return b().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return b().floorKey(k);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return b().headMap(k, z).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return b().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return b().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Maps.n(b().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Maps.n(b().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return b().subMap(k, z, k2, z2).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return b().tailMap(k, z).navigableKeySet();
        }

        @Override // java.util.SortedSet, com.google.common.collect.Maps.n, java.util.NavigableSet
        public SortedSet<K> headSet(K k) {
            return headSet(k, false);
        }

        @Override // java.util.SortedSet, com.google.common.collect.Maps.n, java.util.NavigableSet
        public SortedSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        @Override // java.util.SortedSet, com.google.common.collect.Maps.n, java.util.NavigableSet
        public SortedSet<K> tailSet(K k) {
            return tailSet(k, true);
        }
    }

    /* compiled from: Taobao */
    static class n<K, V> extends l<K, V> implements SortedSet<K> {
        n(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public SortedMap<K, V> a() {
            return (SortedMap) super.a();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return a().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return a().firstKey();
        }

        @Override // java.util.SortedSet
        public SortedSet<K> headSet(K k) {
            return new n(a().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return a().lastKey();
        }

        @Override // java.util.SortedSet
        public SortedSet<K> subSet(K k, K k2) {
            return new n(a().subMap(k, k2));
        }

        @Override // java.util.SortedSet
        public SortedSet<K> tailSet(K k) {
            return new n(a().tailMap(k));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class o<K, V1, V2> extends k<K, V2> {
        final Map<K, V1> a;
        final EntryTransformer<? super K, ? super V1, V2> b;

        o(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.a = (Map) ds1.p(map);
            this.b = (EntryTransformer) ds1.p(entryTransformer);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.k
        public Iterator<Map.Entry<K, V2>> a() {
            return Iterators.w(this.a.entrySet().iterator(), Maps.b(this.b));
        }

        @Override // com.google.common.collect.Maps.k
        public void clear() {
            this.a.clear();
        }

        public boolean containsKey(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object obj) {
            V1 v1 = this.a.get(obj);
            if (v1 != null || this.a.containsKey(obj)) {
                return this.b.transformEntry(obj, v1);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object obj) {
            if (this.a.containsKey(obj)) {
                return this.b.transformEntry(obj, this.a.remove(obj));
            }
            return null;
        }

        public int size() {
            return this.a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new s(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class p<K, V1, V2> extends o<K, V1, V2> implements SortedMap<K, V2> {
        p(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(sortedMap, entryTransformer);
        }

        /* access modifiers changed from: protected */
        public SortedMap<K, V1> b() {
            return (SortedMap) this.a;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return b().firstKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> headMap(K k) {
            return Maps.B(b().headMap(k), this.b);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return b().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> subMap(K k, K k2) {
            return Maps.B(b().subMap(k, k2), this.b);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V2> tailMap(K k) {
            return Maps.B(b().tailMap(k), this.b);
        }
    }

    /* compiled from: Taobao */
    static class q<K, V> extends o<Map.Entry<K, V>> {
        private final Collection<Map.Entry<K, V>> a;

        q(Collection<Map.Entry<K, V>> collection) {
            this.a = collection;
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return Maps.G(this.a.iterator());
        }

        @Override // com.google.common.collect.o
        public Object[] toArray() {
            return standardToArray();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t
        public Collection<Map.Entry<K, V>> delegate() {
            return this.a;
        }

        @Override // java.util.Collection, com.google.common.collect.o
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    /* compiled from: Taobao */
    static class r<K, V> extends q<K, V> implements Set<Map.Entry<K, V>> {
        r(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        public boolean equals(@NullableDecl Object obj) {
            return Sets.a(this, obj);
        }

        public int hashCode() {
            return Sets.b(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class s<K, V> extends AbstractCollection<V> {
        @Weak
        final Map<K, V> a;

        s(Map<K, V> map) {
            this.a = (Map) ds1.p(map);
        }

        /* access modifiers changed from: package-private */
        public final Map<K, V> a() {
            return this.a;
        }

        public void clear() {
            a().clear();
        }

        public boolean contains(@NullableDecl Object obj) {
            return a().containsValue(obj);
        }

        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.L(a().entrySet().iterator());
        }

        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (rk1.a(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) ds1.p(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet d = Sets.d();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        d.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(d);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) ds1.p(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet d = Sets.d();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        d.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(d);
            }
        }

        public int size() {
            return a().size();
        }
    }

    @GwtCompatible
    /* compiled from: Taobao */
    static abstract class t<K, V> extends AbstractMap<K, V> {
        @MonotonicNonNullDecl
        private transient Set<Map.Entry<K, V>> a;
        @MonotonicNonNullDecl
        private transient Set<K> b;
        @MonotonicNonNullDecl
        private transient Collection<V> c;

        t() {
        }

        /* access modifiers changed from: package-private */
        public abstract Set<Map.Entry<K, V>> a();

        /* access modifiers changed from: package-private */
        public Set<K> b() {
            return new l(this);
        }

        /* access modifiers changed from: package-private */
        public Collection<V> c() {
            return new s(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> a2 = a();
            this.a = a2;
            return a2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> set = this.b;
            if (set != null) {
                return set;
            }
            Set<K> b2 = b();
            this.b = b2;
            return b2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.c;
            if (collection != null) {
                return collection;
            }
            Collection<V> c2 = c();
            this.c = c2;
            return c2;
        }
    }

    public static <K, V1, V2> Map<K, V2> A(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new o(map, entryTransformer);
    }

    public static <K, V1, V2> SortedMap<K, V2> B(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new p(sortedMap, entryTransformer);
    }

    static <V2, K, V1> Map.Entry<K, V2> C(EntryTransformer<? super K, ? super V1, V2> entryTransformer, Map.Entry<K, V1> entry) {
        ds1.p(entryTransformer);
        ds1.p(entry);
        return new a(entry, entryTransformer);
    }

    public static <K, V1, V2> Map<K, V2> D(Map<K, V1> map, Function<? super V1, V2> function) {
        return A(map, c(function));
    }

    public static <K, V1, V2> SortedMap<K, V2> E(SortedMap<K, V1> sortedMap, Function<? super V1, V2> function) {
        return B(sortedMap, c(function));
    }

    static <K, V> Map.Entry<K, V> F(Map.Entry<? extends K, ? extends V> entry) {
        ds1.p(entry);
        return new f(entry);
    }

    static <K, V> wr2<Map.Entry<K, V>> G(Iterator<Map.Entry<K, V>> it) {
        return new g(it);
    }

    static <K, V> Set<Map.Entry<K, V>> H(Set<Map.Entry<K, V>> set) {
        return new r(Collections.unmodifiableSet(set));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.NavigableMap<K, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> I(NavigableMap<K, ? extends V> navigableMap) {
        ds1.p(navigableMap);
        if (navigableMap instanceof UnmodifiableNavigableMap) {
            return navigableMap;
        }
        return new UnmodifiableNavigableMap(navigableMap);
    }

    /* access modifiers changed from: private */
    @NullableDecl
    public static <K, V> Map.Entry<K, V> J(@NullableDecl Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return F(entry);
    }

    static <V> Function<Map.Entry<?, V>, V> K() {
        return EntryFunction.VALUE;
    }

    static <K, V> Iterator<V> L(Iterator<Map.Entry<K, V>> it) {
        return new d(it);
    }

    @NullableDecl
    static <V> V M(@NullableDecl Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    static <V> Predicate<Map.Entry<?, V>> N(Predicate<? super V> predicate) {
        return Predicates.c(predicate, K());
    }

    static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> b(EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        ds1.p(entryTransformer);
        return new b(entryTransformer);
    }

    static <K, V1, V2> EntryTransformer<K, V1, V2> c(Function<? super V1, V2> function) {
        ds1.p(function);
        return new h(function);
    }

    static <K, V> Iterator<Map.Entry<K, V>> d(Set<K> set, Function<? super K, V> function) {
        return new e(set.iterator(), function);
    }

    static int e(int i2) {
        if (i2 < 3) {
            k.b(i2, "expectedSize");
            return i2 + 1;
        } else if (i2 < 1073741824) {
            return (int) ((((float) i2) / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    static <K, V> boolean f(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return collection.contains(F((Map.Entry) obj));
    }

    static boolean g(Map<?, ?> map, @NullableDecl Object obj) {
        return Iterators.f(m(map.entrySet().iterator()), obj);
    }

    static boolean h(Map<?, ?> map, @NullableDecl Object obj) {
        return Iterators.f(L(map.entrySet().iterator()), obj);
    }

    static boolean i(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Map.Entry<K, V> j(@NullableDecl K k2, @NullableDecl V v) {
        return new ImmutableEntry(k2, v);
    }

    static <E> ImmutableMap<E, Integer> k(Collection<E> collection) {
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int i2 = 0;
        for (E e2 : collection) {
            bVar.c(e2, Integer.valueOf(i2));
            i2++;
        }
        return bVar.a();
    }

    static <K> Function<Map.Entry<K, ?>, K> l() {
        return EntryFunction.KEY;
    }

    static <K, V> Iterator<K> m(Iterator<Map.Entry<K, V>> it) {
        return new c(it);
    }

    @NullableDecl
    static <K> K n(@NullableDecl Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    static <K> Predicate<Map.Entry<K, ?>> o(Predicate<? super K> predicate) {
        return Predicates.c(predicate, l());
    }

    public static <K, V> HashMap<K, V> p() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> q(int i2) {
        return new HashMap<>(e(i2));
    }

    public static <K, V> IdentityHashMap<K, V> r() {
        return new IdentityHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> s() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> t(int i2) {
        return new LinkedHashMap<>(e(i2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> void u(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    static <K, V> boolean v(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return collection.remove(F((Map.Entry) obj));
    }

    static boolean w(Map<?, ?> map, Object obj) {
        ds1.p(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static <V> V x(Map<?, V> map, @NullableDecl Object obj) {
        ds1.p(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static <V> V y(Map<?, V> map, Object obj) {
        ds1.p(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static String z(Map<?, ?> map) {
        StringBuilder c2 = l.c(map.size());
        c2.append('{');
        boolean z = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z) {
                c2.append(AVFSCacheConstants.COMMA_SEP);
            }
            z = false;
            c2.append(entry.getKey());
            c2.append(com.alipay.sdk.m.n.a.h);
            c2.append(entry.getValue());
        }
        c2.append('}');
        return c2.toString();
    }
}
