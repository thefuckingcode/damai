package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;

@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class Multimaps {

    /* compiled from: Taobao */
    private static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends List<V>> factory;

        CustomListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
            super(map);
            this.factory = (Supplier) ds1.p(supplier);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public List<V> createCollection() {
            return (List) this.factory.get();
        }
    }

    /* compiled from: Taobao */
    private static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends Collection<V>> factory;

        CustomMultimap(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> supplier) {
            super(map);
            this.factory = (Supplier) ds1.p(supplier);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> createCollection() {
            return (Collection) this.factory.get();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.j((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            if (collection instanceof Set) {
                return Collections.unmodifiableSet((Set) collection);
            }
            if (collection instanceof List) {
                return Collections.unmodifiableList((List) collection);
            }
            return Collections.unmodifiableCollection(collection);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(K k, Collection<V> collection) {
            if (collection instanceof List) {
                return wrapList(k, (List) collection, null);
            }
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.m(k, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new AbstractMapBasedMultimap.o(k, (SortedSet) collection, null);
            }
            if (collection instanceof Set) {
                return new AbstractMapBasedMultimap.n(k, (Set) collection);
            }
            return new AbstractMapBasedMultimap.k(k, collection, null);
        }
    }

    /* compiled from: Taobao */
    private static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends Set<V>> factory;

        CustomSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
            super(map);
            this.factory = (Supplier) ds1.p(supplier);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (Supplier) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.j((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            return Collections.unmodifiableSet((Set) collection);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(K k, Collection<V> collection) {
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.m(k, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new AbstractMapBasedMultimap.o(k, (SortedSet) collection, null);
            }
            return new AbstractMapBasedMultimap.n(k, (Set) collection);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Set<V> createCollection() {
            return (Set) this.factory.get();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class MapMultimap<K, V> extends c<K, V> implements SetMultimap<K, V>, Serializable {
        private static final long serialVersionUID = 7845222491160860175L;
        final Map<K, V> map;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a extends Sets.a<V> {
            final /* synthetic */ Object a;

            /* renamed from: com.google.common.collect.Multimaps$MapMultimap$a$a  reason: collision with other inner class name */
            /* compiled from: Taobao */
            class C0158a implements Iterator<V> {
                int a;

                C0158a() {
                }

                public boolean hasNext() {
                    if (this.a == 0) {
                        a aVar = a.this;
                        if (MapMultimap.this.map.containsKey(aVar.a)) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public V next() {
                    if (hasNext()) {
                        this.a++;
                        a aVar = a.this;
                        return MapMultimap.this.map.get(aVar.a);
                    }
                    throw new NoSuchElementException();
                }

                public void remove() {
                    boolean z = true;
                    if (this.a != 1) {
                        z = false;
                    }
                    k.e(z);
                    this.a = -1;
                    a aVar = a.this;
                    MapMultimap.this.map.remove(aVar.a);
                }
            }

            a(Object obj) {
                this.a = obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<V> iterator() {
                return new C0158a();
            }

            public int size() {
                return MapMultimap.this.map.containsKey(this.a) ? 1 : 0;
            }
        }

        MapMultimap(Map<K, V> map2) {
            this.map = (Map) ds1.p(map2);
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.map.clear();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.Multimap
        public boolean containsEntry(Object obj, Object obj2) {
            return this.map.entrySet().contains(Maps.j(obj, obj2));
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // com.google.common.collect.c, com.google.common.collect.Multimap
        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return new a(this);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.c
        public Collection<Map.Entry<K, V>> createEntries() {
            throw new AssertionError("unreachable");
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.c
        public Set<K> createKeySet() {
            return this.map.keySet();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.c
        public Multiset<K> createKeys() {
            return new c(this);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.c
        public Collection<V> createValues() {
            return this.map.values();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.c
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.Multimap
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.Multimap
        public boolean put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.Multimap
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            return this.map.entrySet().remove(Maps.j(obj, obj2));
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.map.size();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public Set<V> get(K k) {
            return new a(k);
        }

        @Override // com.google.common.collect.c, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public Set<V> removeAll(Object obj) {
            HashSet hashSet = new HashSet(2);
            if (!this.map.containsKey(obj)) {
                return hashSet;
            }
            hashSet.add(this.map.remove(obj));
            return hashSet;
        }

        @Override // com.google.common.collect.c, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: Taobao */
    private static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        UnmodifiableListMultimap(ListMultimap<K, V> listMultimap) {
            super(listMultimap);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ListMultimap, com.google.common.collect.r, com.google.common.collect.Multimap
        public List<V> get(K k) {
            return Collections.unmodifiableList(delegate().get((Object) k));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ListMultimap, com.google.common.collect.r, com.google.common.collect.Multimap
        public List<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ListMultimap, com.google.common.collect.r, com.google.common.collect.Multimap
        public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.r, com.google.common.collect.r, com.google.common.collect.t
        public ListMultimap<K, V> delegate() {
            return (ListMultimap) super.delegate();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class UnmodifiableMultimap<K, V> extends r<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multimap<K, V> delegate;
        @MonotonicNonNullDecl
        transient Collection<Map.Entry<K, V>> entries;
        @MonotonicNonNullDecl
        transient Set<K> keySet;
        @MonotonicNonNullDecl
        transient Multiset<K> keys;
        @MonotonicNonNullDecl
        transient Map<K, Collection<V>> map;
        @MonotonicNonNullDecl
        transient Collection<V> values;

        /* compiled from: Taobao */
        class a implements Function<Collection<V>, Collection<V>> {
            a(UnmodifiableMultimap unmodifiableMultimap) {
            }

            /* renamed from: a */
            public Collection<V> apply(Collection<V> collection) {
                return Multimaps.e(collection);
            }
        }

        UnmodifiableMultimap(Multimap<K, V> multimap) {
            this.delegate = (Multimap) ds1.p(multimap);
        }

        @Override // com.google.common.collect.r, com.google.common.collect.Multimap
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map2 = this.map;
            if (map2 != null) {
                return map2;
            }
            Map<K, Collection<V>> unmodifiableMap = Collections.unmodifiableMap(Maps.D(this.delegate.asMap(), new a(this)));
            this.map = unmodifiableMap;
            return unmodifiableMap;
        }

        @Override // com.google.common.collect.r, com.google.common.collect.Multimap
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.r, com.google.common.collect.Multimap
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection = this.entries;
            if (collection != null) {
                return collection;
            }
            Collection<Map.Entry<K, V>> d = Multimaps.d(this.delegate.entries());
            this.entries = d;
            return d;
        }

        @Override // com.google.common.collect.r, com.google.common.collect.Multimap
        public Collection<V> get(K k) {
            return Multimaps.e(this.delegate.get(k));
        }

        @Override // com.google.common.collect.r, com.google.common.collect.Multimap
        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            Set<K> unmodifiableSet = Collections.unmodifiableSet(this.delegate.keySet());
            this.keySet = unmodifiableSet;
            return unmodifiableSet;
        }

        @Override // com.google.common.collect.r, com.google.common.collect.Multimap
        public Multiset<K> keys() {
            Multiset<K> multiset = this.keys;
            if (multiset != null) {
                return multiset;
            }
            Multiset<K> o = Multisets.o(this.delegate.keys());
            this.keys = o;
            return o;
        }

        @Override // com.google.common.collect.r, com.google.common.collect.Multimap
        public boolean put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.r, com.google.common.collect.Multimap
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.r, com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.r, com.google.common.collect.Multimap
        public Collection<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.r, com.google.common.collect.Multimap
        public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.r, com.google.common.collect.Multimap
        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            Collection<V> unmodifiableCollection = Collections.unmodifiableCollection(this.delegate.values());
            this.values = unmodifiableCollection;
            return unmodifiableCollection;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.r, com.google.common.collect.r, com.google.common.collect.t
        public Multimap<K, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.r, com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        UnmodifiableSetMultimap(SetMultimap<K, V> setMultimap) {
            super(setMultimap);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.r, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public Set<Map.Entry<K, V>> entries() {
            return Maps.H(delegate().entries());
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.r, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public Set<V> get(K k) {
            return Collections.unmodifiableSet(delegate().get((Object) k));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.r, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public Set<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.r, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.r, com.google.common.collect.r, com.google.common.collect.t
        public SetMultimap<K, V> delegate() {
            return (SetMultimap) super.delegate();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class a<K, V> extends Maps.t<K, Collection<V>> {
        @Weak
        private final Multimap<K, V> d;

        /* access modifiers changed from: package-private */
        /* renamed from: com.google.common.collect.Multimaps$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0159a extends Maps.j<K, Collection<V>> {

            /* renamed from: com.google.common.collect.Multimaps$a$a$a  reason: collision with other inner class name */
            /* compiled from: Taobao */
            class C0160a implements Function<K, Collection<V>> {
                C0160a() {
                }

                /* renamed from: a */
                public Collection<V> apply(K k) {
                    return a.this.d.get(k);
                }
            }

            C0159a() {
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.Maps.j
            public Map<K, Collection<V>> a() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.d(a.this.d.keySet(), new C0160a());
            }

            @Override // com.google.common.collect.Maps.j
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                a.this.g(((Map.Entry) obj).getKey());
                return true;
            }
        }

        a(Multimap<K, V> multimap) {
            this.d = (Multimap) ds1.p(multimap);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.Maps.t
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0159a();
        }

        public void clear() {
            this.d.clear();
        }

        public boolean containsKey(Object obj) {
            return this.d.containsKey(obj);
        }

        /* renamed from: e */
        public Collection<V> get(Object obj) {
            if (containsKey(obj)) {
                return this.d.get(obj);
            }
            return null;
        }

        /* renamed from: f */
        public Collection<V> remove(Object obj) {
            if (containsKey(obj)) {
                return this.d.removeAll(obj);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void g(Object obj) {
            this.d.keySet().remove(obj);
        }

        public boolean isEmpty() {
            return this.d.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.Maps.t
        public Set<K> keySet() {
            return this.d.keySet();
        }

        public int size() {
            return this.d.keySet().size();
        }
    }

    /* compiled from: Taobao */
    static abstract class b<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        b() {
        }

        /* access modifiers changed from: package-private */
        public abstract Multimap<K, V> a();

        public void clear() {
            a().clear();
        }

        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().containsEntry(entry.getKey(), entry.getValue());
        }

        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        public int size() {
            return a().size();
        }
    }

    /* compiled from: Taobao */
    static class c<K, V> extends d<K> {
        @Weak
        final Multimap<K, V> a;

        /* compiled from: Taobao */
        class a extends j0<Map.Entry<K, Collection<V>>, Multiset.Entry<K>> {

            /* access modifiers changed from: package-private */
            /* renamed from: com.google.common.collect.Multimaps$c$a$a  reason: collision with other inner class name */
            /* compiled from: Taobao */
            public class C0161a extends Multisets.b<K> {
                final /* synthetic */ Map.Entry a;

                C0161a(a aVar, Map.Entry entry) {
                    this.a = entry;
                }

                @Override // com.google.common.collect.Multiset.Entry
                public int getCount() {
                    return ((Collection) this.a.getValue()).size();
                }

                @Override // com.google.common.collect.Multiset.Entry
                public K getElement() {
                    return (K) this.a.getKey();
                }
            }

            a(c cVar, Iterator it) {
                super(it);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public Multiset.Entry<K> a(Map.Entry<K, Collection<V>> entry) {
                return new C0161a(this, entry);
            }
        }

        c(Multimap<K, V> multimap) {
            this.a = multimap;
        }

        @Override // com.google.common.collect.d
        public void clear() {
            this.a.clear();
        }

        @Override // com.google.common.collect.Multiset, com.google.common.collect.d
        public boolean contains(@NullableDecl Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(@NullableDecl Object obj) {
            Collection collection = (Collection) Maps.x(this.a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.d
        public int distinctElements() {
            return this.a.asMap().size();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.d
        public Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.Multiset, com.google.common.collect.d
        public Set<K> elementSet() {
            return this.a.keySet();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.d
        public Iterator<Multiset.Entry<K>> entryIterator() {
            return new a(this, this.a.asMap().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, com.google.common.collect.Multiset, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return Maps.m(this.a.entries().iterator());
        }

        @Override // com.google.common.collect.Multiset, com.google.common.collect.d
        public int remove(@NullableDecl Object obj, int i) {
            k.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.x(this.a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i2 = 0; i2 < i; i2++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        @Override // com.google.common.collect.Multiset
        public int size() {
            return this.a.size();
        }
    }

    static boolean c(Multimap<?, ?> multimap, @NullableDecl Object obj) {
        if (obj == multimap) {
            return true;
        }
        if (obj instanceof Multimap) {
            return multimap.asMap().equals(((Multimap) obj).asMap());
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static <K, V> Collection<Map.Entry<K, V>> d(Collection<Map.Entry<K, V>> collection) {
        if (collection instanceof Set) {
            return Maps.H((Set) collection);
        }
        return new Maps.q(Collections.unmodifiableCollection(collection));
    }

    /* access modifiers changed from: private */
    public static <V> Collection<V> e(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    /* compiled from: Taobao */
    private static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient Supplier<? extends SortedSet<V>> factory;
        transient Comparator<? super V> valueComparator;

        CustomSortedSetMultimap(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> supplier) {
            super(map);
            this.factory = (Supplier) ds1.p(supplier);
            this.valueComparator = ((SortedSet) supplier.get()).comparator();
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            Supplier<? extends SortedSet<V>> supplier = (Supplier) objectInputStream.readObject();
            this.factory = supplier;
            this.valueComparator = ((SortedSet) supplier.get()).comparator();
            setMap((Map) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSortedSetMultimap
        public SortedSet<V> createCollection() {
            return (SortedSet) this.factory.get();
        }
    }

    /* compiled from: Taobao */
    private static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
            super(sortedSetMultimap);
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator<? super V> valueComparator() {
            return delegate().valueComparator();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.SortedSetMultimap, com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.r, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public SortedSet<V> get(K k) {
            return Collections.unmodifiableSortedSet(delegate().get((Object) k));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.SortedSetMultimap, com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.r, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public SortedSet<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.SortedSetMultimap, com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.r, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.r, com.google.common.collect.r, com.google.common.collect.t
        public SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap) super.delegate();
        }
    }
}
