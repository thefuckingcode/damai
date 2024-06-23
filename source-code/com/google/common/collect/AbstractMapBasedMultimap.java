package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.c;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

/* access modifiers changed from: package-private */
@GwtCompatible
/* compiled from: Taobao */
public abstract class AbstractMapBasedMultimap<K, V> extends c<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    /* compiled from: Taobao */
    class a extends AbstractMapBasedMultimap<K, V>.d {
        a(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        public V a(K k, V v) {
            return v;
        }
    }

    /* compiled from: Taobao */
    class b extends AbstractMapBasedMultimap<K, V>.d {
        b(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public Map.Entry<K, V> a(K k, V v) {
            return Maps.j(k, v);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class c extends Maps.t<K, Collection<V>> {
        final transient Map<K, Collection<V>> d;

        /* compiled from: Taobao */
        class a extends Maps.j<K, Collection<V>> {
            a() {
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.Maps.j
            public Map<K, Collection<V>> a() {
                return c.this;
            }

            @Override // com.google.common.collect.Maps.j
            public boolean contains(Object obj) {
                return l.d(c.this.d.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new b();
            }

            @Override // com.google.common.collect.Maps.j
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                AbstractMapBasedMultimap.this.removeValuesForKey(((Map.Entry) obj).getKey());
                return true;
            }
        }

        /* compiled from: Taobao */
        class b implements Iterator<Map.Entry<K, Collection<V>>> {
            final Iterator<Map.Entry<K, Collection<V>>> a;
            @NullableDecl
            Collection<V> b;

            b() {
                this.a = c.this.d.entrySet().iterator();
            }

            /* renamed from: a */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.a.next();
                this.b = next.getValue();
                return c.this.f(next);
            }

            public boolean hasNext() {
                return this.a.hasNext();
            }

            public void remove() {
                k.e(this.b != null);
                this.a.remove();
                AbstractMapBasedMultimap.this.totalSize -= this.b.size();
                this.b.clear();
                this.b = null;
            }
        }

        c(Map<K, Collection<V>> map) {
            this.d = map;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.Maps.t
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new a();
        }

        public void clear() {
            if (this.d == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.d(new b());
            }
        }

        public boolean containsKey(Object obj) {
            return Maps.w(this.d, obj);
        }

        /* renamed from: d */
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) Maps.x(this.d, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        /* renamed from: e */
        public Collection<V> remove(Object obj) {
            Collection<V> remove = this.d.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(remove);
            AbstractMapBasedMultimap.this.totalSize -= remove.size();
            remove.clear();
            return createCollection;
        }

        public boolean equals(@NullableDecl Object obj) {
            return this == obj || this.d.equals(obj);
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, Collection<V>> f(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.j(key, AbstractMapBasedMultimap.this.wrapCollection(key, entry.getValue()));
        }

        public int hashCode() {
            return this.d.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.Maps.t
        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        public int size() {
            return this.d.size();
        }

        public String toString() {
            return this.d.toString();
        }
    }

    /* compiled from: Taobao */
    private abstract class d<T> implements Iterator<T> {
        final Iterator<Map.Entry<K, Collection<V>>> a;
        @NullableDecl
        K b = null;
        @MonotonicNonNullDecl
        Collection<V> c = null;
        Iterator<V> d = Iterators.j();

        d() {
            this.a = AbstractMapBasedMultimap.this.map.entrySet().iterator();
        }

        /* access modifiers changed from: package-private */
        public abstract T a(K k, V v);

        public boolean hasNext() {
            return this.a.hasNext() || this.d.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.d.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.a.next();
                this.b = next.getKey();
                Collection<V> value = next.getValue();
                this.c = value;
                this.d = value.iterator();
            }
            return a(this.b, this.d.next());
        }

        public void remove() {
            this.d.remove();
            if (this.c.isEmpty()) {
                this.a.remove();
            }
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class e extends Maps.l<K, Collection<V>> {

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a implements Iterator<K> {
            @NullableDecl
            Map.Entry<K, Collection<V>> a;
            final /* synthetic */ Iterator b;

            a(Iterator it) {
                this.b = it;
            }

            public boolean hasNext() {
                return this.b.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.b.next();
                this.a = entry;
                return entry.getKey();
            }

            public void remove() {
                k.e(this.a != null);
                Collection<V> value = this.a.getValue();
                this.b.remove();
                AbstractMapBasedMultimap.this.totalSize -= value.size();
                value.clear();
                this.a = null;
            }
        }

        e(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.l
        public void clear() {
            Iterators.d(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return a().keySet().containsAll(collection);
        }

        public boolean equals(@NullableDecl Object obj) {
            return this == obj || a().keySet().equals(obj);
        }

        public int hashCode() {
            return a().keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, com.google.common.collect.Maps.l, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(a().entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.l
        public boolean remove(Object obj) {
            int i;
            V remove = a().remove(obj);
            if (remove != null) {
                i = remove.size();
                remove.clear();
                AbstractMapBasedMultimap.this.totalSize -= i;
            } else {
                i = 0;
            }
            if (i > 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class f extends AbstractMapBasedMultimap<K, V>.i implements NavigableMap<K, Collection<V>> {
        f(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            Map.Entry<K, Collection<V>> ceilingEntry = i().ceilingEntry(k);
            if (ceilingEntry == null) {
                return null;
            }
            return f(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return i().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new f(i().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> firstEntry = i().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return f(firstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            Map.Entry<K, Collection<V>> floorEntry = i().floorEntry(k);
            if (floorEntry == null) {
                return null;
            }
            return f(floorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return i().floorKey(k);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            Map.Entry<K, Collection<V>> higherEntry = i().higherEntry(k);
            if (higherEntry == null) {
                return null;
            }
            return f(higherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return i().higherKey(k);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public NavigableSet<K> g() {
            return new g(i());
        }

        /* renamed from: k */
        public NavigableMap<K, Collection<V>> headMap(K k) {
            return headMap(k, false);
        }

        /* renamed from: l */
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> lastEntry = i().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return f(lastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            Map.Entry<K, Collection<V>> lowerEntry = i().lowerEntry(k);
            if (lowerEntry == null) {
                return null;
            }
            return f(lowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return i().lowerKey(k);
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, Collection<V>> m(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(next.getValue());
            it.remove();
            return Maps.j(next.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(createCollection));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public NavigableMap<K, Collection<V>> i() {
            return (NavigableMap) super.i();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        /* renamed from: o */
        public NavigableMap<K, Collection<V>> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        /* renamed from: p */
        public NavigableMap<K, Collection<V>> tailMap(K k) {
            return tailMap(k, true);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.collect.AbstractMapBasedMultimap$f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return m(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return m(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            return new f(i().headMap(k, z));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new f(i().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            return new f(i().tailMap(k, z));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class g extends AbstractMapBasedMultimap<K, V>.j implements NavigableSet<K> {
        g(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        /* renamed from: c */
        public NavigableSet<K> headSet(K k) {
            return headSet(k, false);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return b().ceilingKey(k);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public NavigableMap<K, Collection<V>> b() {
            return (NavigableMap) super.b();
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new g(b().descendingMap());
        }

        /* renamed from: e */
        public NavigableSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        /* renamed from: f */
        public NavigableSet<K> tailSet(K k) {
            return tailSet(k, true);
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return b().floorKey(k);
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
            return (K) Iterators.q(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Iterators.q(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z) {
            return new g(b().headMap(k, z));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new g(b().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z) {
            return new g(b().tailMap(k, z));
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class h extends AbstractMapBasedMultimap<K, V>.l implements RandomAccess {
        h(@NullableDecl AbstractMapBasedMultimap abstractMapBasedMultimap, K k, @NullableDecl List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k, list, kVar);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class i extends AbstractMapBasedMultimap<K, V>.c implements SortedMap<K, Collection<V>> {
        @MonotonicNonNullDecl
        SortedSet<K> f;

        i(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return i().firstKey();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public SortedSet<K> b() {
            return new j(i());
        }

        /* renamed from: h */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> g2 = b();
            this.f = g2;
            return g2;
        }

        @Override // java.util.SortedMap
        public SortedMap<K, Collection<V>> headMap(K k) {
            return new i(i().headMap(k));
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, Collection<V>> i() {
            return (SortedMap) this.d;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return i().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new i(i().subMap(k, k2));
        }

        @Override // java.util.SortedMap
        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new i(i().tailMap(k));
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class j extends AbstractMapBasedMultimap<K, V>.e implements SortedSet<K> {
        j(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, Collection<V>> b() {
            return (SortedMap) super.a();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return b().firstKey();
        }

        @Override // java.util.SortedSet
        public SortedSet<K> headSet(K k) {
            return new j(b().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return b().lastKey();
        }

        @Override // java.util.SortedSet
        public SortedSet<K> subSet(K k, K k2) {
            return new j(b().subMap(k, k2));
        }

        @Override // java.util.SortedSet
        public SortedSet<K> tailSet(K k) {
            return new j(b().tailMap(k));
        }
    }

    /* compiled from: Taobao */
    class m extends AbstractMapBasedMultimap<K, V>.o implements NavigableSet<V> {
        m(@NullableDecl K k, NavigableSet<V> navigableSet, @NullableDecl AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k, navigableSet, kVar);
        }

        private NavigableSet<V> i(NavigableSet<V> navigableSet) {
            return new m(this.a, navigableSet, b() == null ? this : b());
        }

        @Override // java.util.NavigableSet
        public V ceiling(V v) {
            return g().ceiling(v);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new k.a(g().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return i(g().descendingSet());
        }

        @Override // java.util.NavigableSet
        public V floor(V v) {
            return g().floor(v);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public NavigableSet<V> g() {
            return (NavigableSet) super.g();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V v, boolean z) {
            return i(g().headSet(v, z));
        }

        @Override // java.util.NavigableSet
        public V higher(V v) {
            return g().higher(v);
        }

        @Override // java.util.NavigableSet
        public V lower(V v) {
            return g().lower(v);
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) Iterators.q(iterator());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) Iterators.q(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V v, boolean z, V v2, boolean z2) {
            return i(g().subSet(v, z, v2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V v, boolean z) {
            return i(g().tailSet(v, z));
        }
    }

    /* compiled from: Taobao */
    class n extends AbstractMapBasedMultimap<K, V>.k implements Set<V> {
        n(@NullableDecl K k, Set<V> set) {
            super(k, set, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, com.google.common.collect.AbstractMapBasedMultimap.k
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean h = Sets.h((Set) this.b, collection);
            if (h) {
                int size2 = this.b.size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                f();
            }
            return h;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class o extends AbstractMapBasedMultimap<K, V>.k implements SortedSet<V> {
        o(@NullableDecl K k, SortedSet<V> sortedSet, @NullableDecl AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k, sortedSet, kVar);
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            e();
            return g().first();
        }

        /* access modifiers changed from: package-private */
        public SortedSet<V> g() {
            return (SortedSet) c();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V v) {
            e();
            return new o(d(), g().headSet(v), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public V last() {
            e();
            return g().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V v, V v2) {
            e();
            return new o(d(), g().subSet(v, v2), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V v) {
            e();
            return new o(d(), g().tailSet(v), b() == null ? this : b());
        }
    }

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> map2) {
        ds1.d(map2.isEmpty());
        this.map = map2;
    }

    static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i2 - 1;
        return i2;
    }

    private Collection<V> getOrCreateCollection(@NullableDecl K k2) {
        Collection<V> collection = this.map.get(k2);
        if (collection != null) {
            return collection;
        }
        Collection<V> createCollection = createCollection(k2);
        this.map.put(k2, createCollection);
        return createCollection;
    }

    /* access modifiers changed from: private */
    public static <E> Iterator<E> iteratorOrListIterator(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeValuesForKey(Object obj) {
        Collection collection = (Collection) Maps.y(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        for (Collection<V> collection : this.map.values()) {
            collection.clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        return this.map.containsKey(obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public Map<K, Collection<V>> createAsMap() {
        return new c(this.map);
    }

    /* access modifiers changed from: package-private */
    public abstract Collection<V> createCollection();

    /* access modifiers changed from: package-private */
    public Collection<V> createCollection(@NullableDecl K k2) {
        return createCollection();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public Collection<Map.Entry<K, V>> createEntries() {
        if (this instanceof SetMultimap) {
            return new c.b(this);
        }
        return new c.a();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public Set<K> createKeySet() {
        return new e(this.map);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public Multiset<K> createKeys() {
        return new Multimaps.c(this);
    }

    /* access modifiers changed from: package-private */
    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> map2 = this.map;
        if (map2 instanceof NavigableMap) {
            return new f((NavigableMap) this.map);
        }
        if (map2 instanceof SortedMap) {
            return new i((SortedMap) this.map);
        }
        return new c(this.map);
    }

    /* access modifiers changed from: package-private */
    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> map2 = this.map;
        if (map2 instanceof NavigableMap) {
            return new g((NavigableMap) this.map);
        }
        if (map2 instanceof SortedMap) {
            return new j((SortedMap) this.map);
        }
        return new e(this.map);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Collection<V>, java.util.Collection<E> */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Collection<E>, java.util.Collection<V> */
    /* access modifiers changed from: package-private */
    public Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<E>) unmodifiableCollectionSubclass(createCollection());
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public Collection<V> createValues() {
        return new c.C0166c();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new b(this);
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> get(@NullableDecl K k2) {
        Collection<V> collection = this.map.get(k2);
        if (collection == null) {
            collection = createCollection(k2);
        }
        return wrapCollection(k2, collection);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    public boolean put(@NullableDecl K k2, @NullableDecl V v) {
        Collection<V> collection = this.map.get(k2);
        if (collection == null) {
            Collection<V> createCollection = createCollection(k2);
            if (createCollection.add(v)) {
                this.totalSize++;
                this.map.put(k2, createCollection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.totalSize++;
            return true;
        }
    }

    /* JADX DEBUG: Type inference failed for r4v3. Raw type applied. Possible types: java.util.Collection<E>, java.util.Collection<V> */
    @Override // com.google.common.collect.Multimap
    public Collection<V> removeAll(@NullableDecl Object obj) {
        Collection<V> remove = this.map.remove(obj);
        if (remove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection createCollection = createCollection();
        createCollection.addAll(remove);
        this.totalSize -= remove.size();
        remove.clear();
        return (Collection<E>) unmodifiableCollectionSubclass(createCollection);
    }

    /* JADX DEBUG: Type inference failed for r4v2. Raw type applied. Possible types: java.util.Collection<E>, java.util.Collection<V> */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    public Collection<V> replaceValues(@NullableDecl K k2, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k2);
        }
        Collection<V> orCreateCollection = getOrCreateCollection(k2);
        Collection createCollection = createCollection();
        createCollection.addAll(orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (it.hasNext()) {
            if (orCreateCollection.add((Object) it.next())) {
                this.totalSize++;
            }
        }
        return (Collection<E>) unmodifiableCollectionSubclass(createCollection);
    }

    /* access modifiers changed from: package-private */
    public final void setMap(Map<K, Collection<V>> map2) {
        this.map = map2;
        this.totalSize = 0;
        for (Collection<V> collection : map2.values()) {
            ds1.d(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.totalSize;
    }

    /* access modifiers changed from: package-private */
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    public Iterator<V> valueIterator() {
        return new a(this);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    /* access modifiers changed from: package-private */
    public Collection<V> wrapCollection(@NullableDecl K k2, Collection<V> collection) {
        return new k(k2, collection, null);
    }

    /* access modifiers changed from: package-private */
    public final List<V> wrapList(@NullableDecl K k2, List<V> list, @NullableDecl AbstractMapBasedMultimap<K, V>.k kVar) {
        return list instanceof RandomAccess ? new h(this, k2, list, kVar) : new l(k2, list, kVar);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class k extends AbstractCollection<V> {
        @NullableDecl
        final K a;
        Collection<V> b;
        @NullableDecl
        final AbstractMapBasedMultimap<K, V>.k c;
        @NullableDecl
        final Collection<V> d;

        k(@NullableDecl K k, Collection<V> collection, @NullableDecl AbstractMapBasedMultimap<K, V>.k kVar) {
            Collection<V> collection2;
            this.a = k;
            this.b = collection;
            this.c = kVar;
            if (kVar == null) {
                collection2 = null;
            } else {
                collection2 = kVar.c();
            }
            this.d = collection2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.Map */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public void a() {
            AbstractMapBasedMultimap<K, V>.k kVar = this.c;
            if (kVar != null) {
                kVar.a();
            } else {
                AbstractMapBasedMultimap.this.map.put(this.a, this.b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            e();
            boolean isEmpty = this.b.isEmpty();
            boolean add = this.b.add(v);
            if (add) {
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    a();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.b.addAll(collection);
            if (addAll) {
                int size2 = this.b.size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        /* access modifiers changed from: package-private */
        public AbstractMapBasedMultimap<K, V>.k b() {
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public Collection<V> c() {
            return this.b;
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.b.clear();
                AbstractMapBasedMultimap.this.totalSize -= size;
                f();
            }
        }

        public boolean contains(Object obj) {
            e();
            return this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            e();
            return this.b.containsAll(collection);
        }

        /* access modifiers changed from: package-private */
        public K d() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.k kVar = this.c;
            if (kVar != null) {
                kVar.e();
                if (this.c.c() != this.d) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.b.isEmpty() && (collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.a)) != null) {
                this.b = collection;
            }
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            e();
            return this.b.equals(obj);
        }

        /* access modifiers changed from: package-private */
        public void f() {
            AbstractMapBasedMultimap<K, V>.k kVar = this.c;
            if (kVar != null) {
                kVar.f();
            } else if (this.b.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.a);
            }
        }

        public int hashCode() {
            e();
            return this.b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            e();
            return new a();
        }

        public boolean remove(Object obj) {
            e();
            boolean remove = this.b.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                f();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.b.removeAll(collection);
            if (removeAll) {
                int size2 = this.b.size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                f();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            ds1.p(collection);
            int size = size();
            boolean retainAll = this.b.retainAll(collection);
            if (retainAll) {
                int size2 = this.b.size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                f();
            }
            return retainAll;
        }

        public int size() {
            e();
            return this.b.size();
        }

        public String toString() {
            e();
            return this.b.toString();
        }

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a implements Iterator<V> {
            final Iterator<V> a;
            final Collection<V> b;

            a() {
                Collection<V> collection = k.this.b;
                this.b = collection;
                this.a = AbstractMapBasedMultimap.iteratorOrListIterator(collection);
            }

            /* access modifiers changed from: package-private */
            public Iterator<V> a() {
                b();
                return this.a;
            }

            /* access modifiers changed from: package-private */
            public void b() {
                k.this.e();
                if (k.this.b != this.b) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                b();
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                b();
                return this.a.next();
            }

            public void remove() {
                this.a.remove();
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                k.this.f();
            }

            a(Iterator<V> it) {
                this.b = k.this.b;
                this.a = it;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class l extends AbstractMapBasedMultimap<K, V>.k implements List<V> {

        /* compiled from: Taobao */
        private class a extends AbstractMapBasedMultimap<K, V>.k.a implements ListIterator<V> {
            a() {
                super();
            }

            private ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean isEmpty = l.this.isEmpty();
                c().add(v);
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    l.this.a();
                }
            }

            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                c().set(v);
            }

            public a(int i) {
                super(l.this.g().listIterator(i));
            }
        }

        l(@NullableDecl K k, List<V> list, @NullableDecl AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k, list, kVar);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            e();
            boolean isEmpty = c().isEmpty();
            g().add(i, v);
            AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
            if (isEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = g().addAll(i, collection);
            if (addAll) {
                int size2 = c().size();
                AbstractMapBasedMultimap.this.totalSize += size2 - size;
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        /* access modifiers changed from: package-private */
        public List<V> g() {
            return (List) c();
        }

        @Override // java.util.List
        public V get(int i) {
            e();
            return g().get(i);
        }

        public int indexOf(Object obj) {
            e();
            return g().indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            e();
            return g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            e();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i) {
            e();
            V remove = g().remove(i);
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
            f();
            return remove;
        }

        @Override // java.util.List
        public V set(int i, V v) {
            e();
            return g().set(i, v);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.AbstractMapBasedMultimap */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            e();
            return AbstractMapBasedMultimap.this.wrapList(d(), g().subList(i, i2), b() == null ? this : b());
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            e();
            return new a(i);
        }
    }
}
