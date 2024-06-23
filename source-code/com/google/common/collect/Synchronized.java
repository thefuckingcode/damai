package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.dn0;
import tb.ds1;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public final class Synchronized {

    /* compiled from: Taobao */
    private static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long serialVersionUID = 0;
        @MonotonicNonNullDecl
        transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
        @MonotonicNonNullDecl
        transient Collection<Collection<V>> asMapValues;

        SynchronizedAsMap(Map<K, Collection<V>> map, @NullableDecl Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap
        public boolean containsValue(Object obj) {
            return values().contains(obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Set<Map.Entry<K, Collection<V>>> set;
            synchronized (this.mutex) {
                if (this.asMapEntrySet == null) {
                    this.asMapEntrySet = new SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);
                }
                set = this.asMapEntrySet;
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<Collection<V>> values() {
            Collection<Collection<V>> collection;
            synchronized (this.mutex) {
                if (this.asMapValues == null) {
                    this.asMapValues = new SynchronizedAsMapValues(delegate().values(), this.mutex);
                }
                collection = this.asMapValues;
            }
            return collection;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<V> get(Object obj) {
            Collection<V> collection;
            synchronized (this.mutex) {
                Collection collection2 = (Collection) super.get(obj);
                if (collection2 == null) {
                    collection = null;
                } else {
                    collection = Synchronized.q(collection2, this.mutex);
                }
            }
            return collection;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0;

        /* compiled from: Taobao */
        class a extends j0<Collection<V>, Collection<V>> {
            a(Iterator it) {
                super(it);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public Collection<V> a(Collection<V> collection) {
                return Synchronized.q(collection, SynchronizedAsMapValues.this.mutex);
            }
        }

        SynchronizedAsMapValues(Collection<Collection<V>> collection, @NullableDecl Object obj) {
            super(collection, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Collection<V>> iterator() {
            return new a(super.iterator());
        }
    }

    @VisibleForTesting
    /* compiled from: Taobao */
    static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements BiMap<K, V> {
        private static final long serialVersionUID = 0;
        @RetainedWith
        @MonotonicNonNullDecl
        private transient BiMap<V, K> inverse;
        @MonotonicNonNullDecl
        private transient Set<V> valueSet;

        @Override // com.google.common.collect.BiMap
        public V forcePut(K k, V v) {
            V forcePut;
            synchronized (this.mutex) {
                forcePut = delegate().forcePut(k, v);
            }
            return forcePut;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            BiMap<V, K> biMap;
            synchronized (this.mutex) {
                if (this.inverse == null) {
                    this.inverse = new SynchronizedBiMap(delegate().inverse(), this.mutex, this);
                }
                biMap = this.inverse;
            }
            return biMap;
        }

        private SynchronizedBiMap(BiMap<K, V> biMap, @NullableDecl Object obj, @NullableDecl BiMap<V, K> biMap2) {
            super(biMap, obj);
            this.inverse = biMap2;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.BiMap, java.util.Map
        public Set<V> values() {
            Set<V> set;
            synchronized (this.mutex) {
                if (this.valueSet == null) {
                    this.valueSet = Synchronized.n(delegate().values(), this.mutex);
                }
                set = this.valueSet;
            }
            return set;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public BiMap<K, V> delegate() {
            return (BiMap) super.delegate();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* compiled from: Taobao */
    public static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.Collection
        public boolean add(E e) {
            boolean add;
            synchronized (this.mutex) {
                add = delegate().add(e);
            }
            return add;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(collection);
            }
            return addAll;
        }

        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        public boolean contains(Object obj) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj);
            }
            return contains;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (this.mutex) {
                containsAll = delegate().containsAll(collection);
            }
            return containsAll;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return delegate().iterator();
        }

        public boolean remove(Object obj) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(collection);
            }
            return removeAll;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = delegate().retainAll(collection);
            }
            return retainAll;
        }

        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.mutex) {
                array = delegate().toArray();
            }
            return array;
        }

        private SynchronizedCollection(Collection<E> collection, @NullableDecl Object obj) {
            super(collection, obj);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Collection<E> delegate() {
            return (Collection) super.delegate();
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) delegate().toArray(tArr);
            }
            return tArr2;
        }
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    /* compiled from: Taobao */
    public static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedEntry(Map.Entry<K, V> entry, @NullableDecl Object obj) {
            super(entry, obj);
        }

        public boolean equals(Object obj) {
            boolean equals;
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            K key;
            synchronized (this.mutex) {
                key = delegate().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            V value;
            synchronized (this.mutex) {
                value = delegate().getValue();
            }
            return value;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V value;
            synchronized (this.mutex) {
                value = delegate().setValue(v);
            }
            return value;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map.Entry<K, V> delegate() {
            return (Map.Entry) super.delegate();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = 0;

        SynchronizedList(List<E> list, @NullableDecl Object obj) {
            super(list, obj);
        }

        @Override // java.util.List
        public void add(int i, E e) {
            synchronized (this.mutex) {
                delegate().add(i, e);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(i, collection);
            }
            return addAll;
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.List
        public E get(int i) {
            E e;
            synchronized (this.mutex) {
                e = delegate().get(i);
            }
            return e;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        public int indexOf(Object obj) {
            int indexOf;
            synchronized (this.mutex) {
                indexOf = delegate().indexOf(obj);
            }
            return indexOf;
        }

        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            synchronized (this.mutex) {
                lastIndexOf = delegate().lastIndexOf(obj);
            }
            return lastIndexOf;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return delegate().listIterator();
        }

        @Override // java.util.List
        public E remove(int i) {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove(i);
            }
            return remove;
        }

        @Override // java.util.List
        public E set(int i, E e) {
            E e2;
            synchronized (this.mutex) {
                e2 = delegate().set(i, e);
            }
            return e2;
        }

        @Override // java.util.List
        public List<E> subList(int i, int i2) {
            List<E> h;
            synchronized (this.mutex) {
                h = Synchronized.h(delegate().subList(i, i2), this.mutex);
            }
            return h;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int i) {
            return delegate().listIterator(i);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedCollection
        public List<E> delegate() {
            return (List) super.delegate();
        }
    }

    /* compiled from: Taobao */
    private static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedListMultimap(ListMultimap<K, V> listMultimap, @NullableDecl Object obj) {
            super(listMultimap, obj);
        }

        @Override // com.google.common.collect.ListMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> get(K k) {
            List<V> h;
            synchronized (this.mutex) {
                h = Synchronized.h(delegate().get((Object) k), this.mutex);
            }
            return h;
        }

        @Override // com.google.common.collect.ListMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> removeAll(Object obj) {
            List<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.ListMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
            List<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((Object) k, (Iterable) iterable);
            }
            return replaceValues;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap
        public ListMultimap<K, V> delegate() {
            return (ListMultimap) super.delegate();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;
        @MonotonicNonNullDecl
        transient Set<Map.Entry<K, V>> entrySet;
        @MonotonicNonNullDecl
        transient Set<K> keySet;
        @MonotonicNonNullDecl
        transient Collection<V> values;

        SynchronizedMap(Map<K, V> map, @NullableDecl Object obj) {
            super(map, obj);
        }

        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.n(delegate().entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Map
        public V get(Object obj) {
            V v;
            synchronized (this.mutex) {
                v = delegate().get(obj);
            }
            return v;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = Synchronized.n(delegate().keySet(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        @Override // java.util.Map
        public V put(K k, V v) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(k, v);
            }
            return put;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                delegate().putAll(map);
            }
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // java.util.Map
        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.values == null) {
                    this.values = Synchronized.g(delegate().values(), this.mutex);
                }
                collection = this.values;
            }
            return collection;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map<K, V> delegate() {
            return (Map) super.delegate();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SynchronizedMultimap<K, V> extends SynchronizedObject implements Multimap<K, V> {
        private static final long serialVersionUID = 0;
        @MonotonicNonNullDecl
        transient Map<K, Collection<V>> asMap;
        @MonotonicNonNullDecl
        transient Collection<Map.Entry<K, V>> entries;
        @MonotonicNonNullDecl
        transient Set<K> keySet;
        @MonotonicNonNullDecl
        transient Multiset<K> keys;
        @MonotonicNonNullDecl
        transient Collection<V> valuesCollection;

        SynchronizedMultimap(Multimap<K, V> multimap, @NullableDecl Object obj) {
            super(multimap, obj);
        }

        @Override // com.google.common.collect.Multimap
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map;
            synchronized (this.mutex) {
                if (this.asMap == null) {
                    this.asMap = new SynchronizedAsMap(delegate().asMap(), this.mutex);
                }
                map = this.asMap;
            }
            return map;
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsEntry(Object obj, Object obj2) {
            boolean containsEntry;
            synchronized (this.mutex) {
                containsEntry = delegate().containsEntry(obj, obj2);
            }
            return containsEntry;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        @Override // com.google.common.collect.Multimap
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection;
            synchronized (this.mutex) {
                if (this.entries == null) {
                    this.entries = Synchronized.q(delegate().entries(), this.mutex);
                }
                collection = this.entries;
            }
            return collection;
        }

        @Override // com.google.common.collect.Multimap
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V> get(K k) {
            Collection<V> q;
            synchronized (this.mutex) {
                q = Synchronized.q(delegate().get(k), this.mutex);
            }
            return q;
        }

        @Override // com.google.common.collect.Multimap
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Multimap
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // com.google.common.collect.Multimap
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = Synchronized.r(delegate().keySet(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        @Override // com.google.common.collect.Multimap
        public Multiset<K> keys() {
            Multiset<K> multiset;
            synchronized (this.mutex) {
                if (this.keys == null) {
                    this.keys = Synchronized.j(delegate().keys(), this.mutex);
                }
                multiset = this.keys;
            }
            return multiset;
        }

        @Override // com.google.common.collect.Multimap
        public boolean put(K k, V v) {
            boolean put;
            synchronized (this.mutex) {
                put = delegate().put(k, v);
            }
            return put;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(K k, Iterable<? extends V> iterable) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(k, iterable);
            }
            return putAll;
        }

        @Override // com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V> removeAll(Object obj) {
            Collection<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
            Collection<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues(k, iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Multimap
        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.valuesCollection == null) {
                    this.valuesCollection = Synchronized.g(delegate().values(), this.mutex);
                }
                collection = this.valuesCollection;
            }
            return collection;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Multimap<K, V> delegate() {
            return (Multimap) super.delegate();
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(multimap);
            }
            return putAll;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class SynchronizedObject implements Serializable {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        final Object delegate;
        final Object mutex;

        SynchronizedObject(Object obj, @NullableDecl Object obj2) {
            this.delegate = ds1.p(obj);
            this.mutex = obj2 == null ? this : obj2;
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        /* access modifiers changed from: package-private */
        public Object delegate() {
            return this.delegate;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.delegate.toString();
            }
            return obj;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        SynchronizedRandomAccessList(List<E> list, @NullableDecl Object obj) {
            super(list, obj);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        @MonotonicNonNullDecl
        transient Set<Map.Entry<K, V>> entrySet;

        SynchronizedSetMultimap(SetMultimap<K, V> setMultimap, @NullableDecl Object obj) {
            super(setMultimap, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public Set<Map.Entry<K, V>> entries() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.n(delegate().entries(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public Set<V> get(K k) {
            Set<V> n;
            synchronized (this.mutex) {
                n = Synchronized.n(delegate().get((Object) k), this.mutex);
            }
            return n;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public Set<V> removeAll(Object obj) {
            Set<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            Set<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((Object) k, (Iterable) iterable);
            }
            return replaceValues;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap
        public SetMultimap<K, V> delegate() {
            return (SetMultimap) super.delegate();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements Table<R, C, V> {

        /* compiled from: Taobao */
        class a implements Function<Map<C, V>, Map<C, V>> {
            a() {
            }

            /* renamed from: a */
            public Map<C, V> apply(Map<C, V> map) {
                return Synchronized.i(map, SynchronizedTable.this.mutex);
            }
        }

        /* compiled from: Taobao */
        class b implements Function<Map<R, V>, Map<R, V>> {
            b() {
            }

            /* renamed from: a */
            public Map<R, V> apply(Map<R, V> map) {
                return Synchronized.i(map, SynchronizedTable.this.mutex);
            }
        }

        SynchronizedTable(Table<R, C, V> table, Object obj) {
            super(table, obj);
        }

        @Override // com.google.common.collect.Table
        public Set<Table.Cell<R, C, V>> cellSet() {
            Set<Table.Cell<R, C, V>> n;
            synchronized (this.mutex) {
                n = Synchronized.n(delegate().cellSet(), this.mutex);
            }
            return n;
        }

        @Override // com.google.common.collect.Table
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // com.google.common.collect.Table
        public Map<R, V> column(@NullableDecl C c) {
            Map<R, V> i;
            synchronized (this.mutex) {
                i = Synchronized.i(delegate().column(c), this.mutex);
            }
            return i;
        }

        @Override // com.google.common.collect.Table
        public Set<C> columnKeySet() {
            Set<C> n;
            synchronized (this.mutex) {
                n = Synchronized.n(delegate().columnKeySet(), this.mutex);
            }
            return n;
        }

        @Override // com.google.common.collect.Table
        public Map<C, Map<R, V>> columnMap() {
            Map<C, Map<R, V>> i;
            synchronized (this.mutex) {
                i = Synchronized.i(Maps.D(delegate().columnMap(), new b()), this.mutex);
            }
            return i;
        }

        @Override // com.google.common.collect.Table
        public boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj, obj2);
            }
            return contains;
        }

        @Override // com.google.common.collect.Table
        public boolean containsColumn(@NullableDecl Object obj) {
            boolean containsColumn;
            synchronized (this.mutex) {
                containsColumn = delegate().containsColumn(obj);
            }
            return containsColumn;
        }

        @Override // com.google.common.collect.Table
        public boolean containsRow(@NullableDecl Object obj) {
            boolean containsRow;
            synchronized (this.mutex) {
                containsRow = delegate().containsRow(obj);
            }
            return containsRow;
        }

        @Override // com.google.common.collect.Table
        public boolean containsValue(@NullableDecl Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        @Override // com.google.common.collect.Table
        public boolean equals(@NullableDecl Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // com.google.common.collect.Table
        public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
            V v;
            synchronized (this.mutex) {
                v = delegate().get(obj, obj2);
            }
            return v;
        }

        @Override // com.google.common.collect.Table
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Table
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // com.google.common.collect.Table
        public V put(@NullableDecl R r, @NullableDecl C c, @NullableDecl V v) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(r, c, v);
            }
            return put;
        }

        @Override // com.google.common.collect.Table
        public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
            synchronized (this.mutex) {
                delegate().putAll(table);
            }
        }

        @Override // com.google.common.collect.Table
        public V remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        @Override // com.google.common.collect.Table
        public Map<C, V> row(@NullableDecl R r) {
            Map<C, V> i;
            synchronized (this.mutex) {
                i = Synchronized.i(delegate().row(r), this.mutex);
            }
            return i;
        }

        @Override // com.google.common.collect.Table
        public Set<R> rowKeySet() {
            Set<R> n;
            synchronized (this.mutex) {
                n = Synchronized.n(delegate().rowKeySet(), this.mutex);
            }
            return n;
        }

        @Override // com.google.common.collect.Table
        public Map<R, Map<C, V>> rowMap() {
            Map<R, Map<C, V>> i;
            synchronized (this.mutex) {
                i = Synchronized.i(Maps.D(delegate().rowMap(), new a()), this.mutex);
            }
            return i;
        }

        @Override // com.google.common.collect.Table
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Table
        public Collection<V> values() {
            Collection<V> g;
            synchronized (this.mutex) {
                g = Synchronized.g(delegate().values(), this.mutex);
            }
            return g;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Table<R, C, V> delegate() {
            return (Table) super.delegate();
        }
    }

    /* access modifiers changed from: private */
    public static <E> Collection<E> g(Collection<E> collection, @NullableDecl Object obj) {
        return new SynchronizedCollection(collection, obj);
    }

    /* access modifiers changed from: private */
    public static <E> List<E> h(List<E> list, @NullableDecl Object obj) {
        return list instanceof RandomAccess ? new SynchronizedRandomAccessList(list, obj) : new SynchronizedList(list, obj);
    }

    @VisibleForTesting
    static <K, V> Map<K, V> i(Map<K, V> map, @NullableDecl Object obj) {
        return new SynchronizedMap(map, obj);
    }

    static <E> Multiset<E> j(Multiset<E> multiset, @NullableDecl Object obj) {
        return ((multiset instanceof SynchronizedMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new SynchronizedMultiset(multiset, obj);
    }

    @GwtIncompatible
    static <K, V> NavigableMap<K, V> k(NavigableMap<K, V> navigableMap, @NullableDecl Object obj) {
        return new SynchronizedNavigableMap(navigableMap, obj);
    }

    @GwtIncompatible
    static <E> NavigableSet<E> l(NavigableSet<E> navigableSet, @NullableDecl Object obj) {
        return new SynchronizedNavigableSet(navigableSet, obj);
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    public static <K, V> Map.Entry<K, V> m(@NullableDecl Map.Entry<K, V> entry, @NullableDecl Object obj) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry(entry, obj);
    }

    @VisibleForTesting
    static <E> Set<E> n(Set<E> set, @NullableDecl Object obj) {
        return new SynchronizedSet(set, obj);
    }

    static <K, V> SortedMap<K, V> o(SortedMap<K, V> sortedMap, @NullableDecl Object obj) {
        return new SynchronizedSortedMap(sortedMap, obj);
    }

    /* access modifiers changed from: private */
    public static <E> SortedSet<E> p(SortedSet<E> sortedSet, @NullableDecl Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    /* access modifiers changed from: private */
    public static <E> Collection<E> q(Collection<E> collection, @NullableDecl Object obj) {
        if (collection instanceof SortedSet) {
            return p((SortedSet) collection, obj);
        }
        if (collection instanceof Set) {
            return n((Set) collection, obj);
        }
        if (collection instanceof List) {
            return h((List) collection, obj);
        }
        return g(collection, obj);
    }

    /* access modifiers changed from: private */
    public static <E> Set<E> r(Set<E> set, @NullableDecl Object obj) {
        if (set instanceof SortedSet) {
            return p((SortedSet) set, obj);
        }
        return n(set, obj);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements Multiset<E> {
        private static final long serialVersionUID = 0;
        @MonotonicNonNullDecl
        transient Set<E> elementSet;
        @MonotonicNonNullDecl
        transient Set<Multiset.Entry<E>> entrySet;

        SynchronizedMultiset(Multiset<E> multiset, @NullableDecl Object obj) {
            super(multiset, obj);
        }

        @Override // com.google.common.collect.Multiset
        public int add(E e, int i) {
            int add;
            synchronized (this.mutex) {
                add = delegate().add(e, i);
            }
            return add;
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            int count;
            synchronized (this.mutex) {
                count = delegate().count(obj);
            }
            return count;
        }

        @Override // com.google.common.collect.Multiset
        public Set<E> elementSet() {
            Set<E> set;
            synchronized (this.mutex) {
                if (this.elementSet == null) {
                    this.elementSet = Synchronized.r(delegate().elementSet(), this.mutex);
                }
                set = this.elementSet;
            }
            return set;
        }

        @Override // com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.r(delegate().entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        @Override // com.google.common.collect.Multiset
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // com.google.common.collect.Multiset
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.Multiset
        public int remove(Object obj, int i) {
            int remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, i);
            }
            return remove;
        }

        @Override // com.google.common.collect.Multiset
        public int setCount(E e, int i) {
            int count;
            synchronized (this.mutex) {
                count = delegate().setCount(e, i);
            }
            return count;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedCollection
        public Multiset<E> delegate() {
            return (Multiset) super.delegate();
        }

        @Override // com.google.common.collect.Multiset
        public boolean setCount(E e, int i, int i2) {
            boolean count;
            synchronized (this.mutex) {
                count = delegate().setCount(e, i, i2);
            }
            return count;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        private static final long serialVersionUID = 0;

        SynchronizedQueue(Queue<E> queue, @NullableDecl Object obj) {
            super(queue, obj);
        }

        @Override // java.util.Queue
        public E element() {
            E element;
            synchronized (this.mutex) {
                element = delegate().element();
            }
            return element;
        }

        @Override // java.util.Queue
        public boolean offer(E e) {
            boolean offer;
            synchronized (this.mutex) {
                offer = delegate().offer(e);
            }
            return offer;
        }

        @Override // java.util.Queue
        public E peek() {
            E peek;
            synchronized (this.mutex) {
                peek = delegate().peek();
            }
            return peek;
        }

        @Override // java.util.Queue
        public E poll() {
            E poll;
            synchronized (this.mutex) {
                poll = delegate().poll();
            }
            return poll;
        }

        @Override // java.util.Queue
        public E remove() {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove();
            }
            return remove;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedCollection
        public Queue<E> delegate() {
            return (Queue) super.delegate();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSet(Set<E> set, @NullableDecl Object obj) {
            super(set, obj);
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedCollection
        public Set<E> delegate() {
            return (Set) super.delegate();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedMap(SortedMap<K, V> sortedMap, @NullableDecl Object obj) {
            super(sortedMap, obj);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K firstKey;
            synchronized (this.mutex) {
                firstKey = delegate().firstKey();
            }
            return firstKey;
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            SortedMap<K, V> o;
            synchronized (this.mutex) {
                o = Synchronized.o(delegate().headMap(k), this.mutex);
            }
            return o;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K lastKey;
            synchronized (this.mutex) {
                lastKey = delegate().lastKey();
            }
            return lastKey;
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            SortedMap<K, V> o;
            synchronized (this.mutex) {
                o = Synchronized.o(delegate().subMap(k, k2), this.mutex);
            }
            return o;
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            SortedMap<K, V> o;
            synchronized (this.mutex) {
                o = Synchronized.o(delegate().tailMap(k), this.mutex);
            }
            return o;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedMap<K, V> delegate() {
            return (SortedMap) super.delegate();
        }
    }

    /* compiled from: Taobao */
    private static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap, @NullableDecl Object obj) {
            super(sortedSetMultimap, obj);
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator<? super V> valueComparator() {
            Comparator<? super V> valueComparator;
            synchronized (this.mutex) {
                valueComparator = delegate().valueComparator();
            }
            return valueComparator;
        }

        @Override // com.google.common.collect.SortedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public SortedSet<V> get(K k) {
            SortedSet<V> p;
            synchronized (this.mutex) {
                p = Synchronized.p(delegate().get((Object) k), this.mutex);
            }
            return p;
        }

        @Override // com.google.common.collect.SortedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public SortedSet<V> removeAll(Object obj) {
            SortedSet<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.SortedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Multimap, com.google.common.collect.SetMultimap
        public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
            SortedSet<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((Object) k, (Iterable) iterable);
            }
            return replaceValues;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedSetMultimap
        public SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap) super.delegate();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public class a extends j0<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>> {

            /* access modifiers changed from: package-private */
            /* renamed from: com.google.common.collect.Synchronized$SynchronizedAsMapEntries$a$a  reason: collision with other inner class name */
            /* compiled from: Taobao */
            public class C0165a extends dn0<K, Collection<V>> {
                final /* synthetic */ Map.Entry a;

                C0165a(Map.Entry entry) {
                    this.a = entry;
                }

                /* access modifiers changed from: protected */
                @Override // tb.dn0
                /* renamed from: a */
                public Map.Entry<K, Collection<V>> delegate() {
                    return this.a;
                }

                /* renamed from: b */
                public Collection<V> getValue() {
                    return Synchronized.q((Collection) this.a.getValue(), SynchronizedAsMapEntries.this.mutex);
                }
            }

            a(Iterator it) {
                super(it);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> entry) {
                return new C0165a(entry);
            }
        }

        SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> set, @NullableDecl Object obj) {
            super(set, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        public boolean contains(Object obj) {
            boolean f;
            synchronized (this.mutex) {
                f = Maps.f(delegate(), obj);
            }
            return f;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            boolean b;
            synchronized (this.mutex) {
                b = l.b(delegate(), collection);
            }
            return b;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet
        public boolean equals(Object obj) {
            boolean a2;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                a2 = Sets.a(delegate(), obj);
            }
            return a2;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            return new a(super.iterator());
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        public boolean remove(Object obj) {
            boolean v;
            synchronized (this.mutex) {
                v = Maps.v(delegate(), obj);
            }
            return v;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean r;
            synchronized (this.mutex) {
                r = Iterators.r(delegate().iterator(), collection);
            }
            return r;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean s;
            synchronized (this.mutex) {
                s = Iterators.s(delegate().iterator(), collection);
            }
            return s;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        public Object[] toArray() {
            Object[] f;
            synchronized (this.mutex) {
                f = b0.f(delegate());
            }
            return f;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) b0.g(delegate(), tArr);
            }
            return tArr2;
        }
    }

    /* compiled from: Taobao */
    private static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        private static final long serialVersionUID = 0;

        SynchronizedDeque(Deque<E> deque, @NullableDecl Object obj) {
            super(deque, obj);
        }

        @Override // java.util.Deque
        public void addFirst(E e) {
            synchronized (this.mutex) {
                delegate().addFirst(e);
            }
        }

        @Override // java.util.Deque
        public void addLast(E e) {
            synchronized (this.mutex) {
                delegate().addLast(e);
            }
        }

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            Iterator<E> descendingIterator;
            synchronized (this.mutex) {
                descendingIterator = delegate().descendingIterator();
            }
            return descendingIterator;
        }

        @Override // java.util.Deque
        public E getFirst() {
            E first;
            synchronized (this.mutex) {
                first = delegate().getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public E getLast() {
            E last;
            synchronized (this.mutex) {
                last = delegate().getLast();
            }
            return last;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E e) {
            boolean offerFirst;
            synchronized (this.mutex) {
                offerFirst = delegate().offerFirst(e);
            }
            return offerFirst;
        }

        @Override // java.util.Deque
        public boolean offerLast(E e) {
            boolean offerLast;
            synchronized (this.mutex) {
                offerLast = delegate().offerLast(e);
            }
            return offerLast;
        }

        @Override // java.util.Deque
        public E peekFirst() {
            E peekFirst;
            synchronized (this.mutex) {
                peekFirst = delegate().peekFirst();
            }
            return peekFirst;
        }

        @Override // java.util.Deque
        public E peekLast() {
            E peekLast;
            synchronized (this.mutex) {
                peekLast = delegate().peekLast();
            }
            return peekLast;
        }

        @Override // java.util.Deque
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.Deque
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.Deque
        public E pop() {
            E pop;
            synchronized (this.mutex) {
                pop = delegate().pop();
            }
            return pop;
        }

        @Override // java.util.Deque
        public void push(E e) {
            synchronized (this.mutex) {
                delegate().push(e);
            }
        }

        @Override // java.util.Deque
        public E removeFirst() {
            E removeFirst;
            synchronized (this.mutex) {
                removeFirst = delegate().removeFirst();
            }
            return removeFirst;
        }

        public boolean removeFirstOccurrence(Object obj) {
            boolean removeFirstOccurrence;
            synchronized (this.mutex) {
                removeFirstOccurrence = delegate().removeFirstOccurrence(obj);
            }
            return removeFirstOccurrence;
        }

        @Override // java.util.Deque
        public E removeLast() {
            E removeLast;
            synchronized (this.mutex) {
                removeLast = delegate().removeLast();
            }
            return removeLast;
        }

        public boolean removeLastOccurrence(Object obj) {
            boolean removeLastOccurrence;
            synchronized (this.mutex) {
                removeLastOccurrence = delegate().removeLastOccurrence(obj);
            }
            return removeLastOccurrence;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedObject, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedCollection
        public Deque<E> delegate() {
            return (Deque) super.delegate();
        }
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @VisibleForTesting
    /* compiled from: Taobao */
    public static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;
        @MonotonicNonNullDecl
        transient NavigableSet<K> descendingKeySet;
        @MonotonicNonNullDecl
        transient NavigableMap<K, V> descendingMap;
        @MonotonicNonNullDecl
        transient NavigableSet<K> navigableKeySet;

        SynchronizedNavigableMap(NavigableMap<K, V> navigableMap, @NullableDecl Object obj) {
            super(navigableMap, obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k) {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().ceilingEntry(k), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            K ceilingKey;
            synchronized (this.mutex) {
                ceilingKey = delegate().ceilingKey(k);
            }
            return ceilingKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            synchronized (this.mutex) {
                NavigableSet<K> navigableSet = this.descendingKeySet;
                if (navigableSet != null) {
                    return navigableSet;
                }
                NavigableSet<K> l = Synchronized.l(delegate().descendingKeySet(), this.mutex);
                this.descendingKeySet = l;
                return l;
            }
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            synchronized (this.mutex) {
                NavigableMap<K, V> navigableMap = this.descendingMap;
                if (navigableMap != null) {
                    return navigableMap;
                }
                NavigableMap<K, V> k = Synchronized.k(delegate().descendingMap(), this.mutex);
                this.descendingMap = k;
                return k;
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().firstEntry(), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k) {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().floorEntry(k), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            K floorKey;
            synchronized (this.mutex) {
                floorKey = delegate().floorKey(k);
            }
            return floorKey;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k, boolean z) {
            NavigableMap<K, V> k2;
            synchronized (this.mutex) {
                k2 = Synchronized.k(delegate().headMap(k, z), this.mutex);
            }
            return k2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k) {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().higherEntry(k), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            K higherKey;
            synchronized (this.mutex) {
                higherKey = delegate().higherKey(k);
            }
            return higherKey;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map, java.util.SortedMap
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().lastEntry(), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k) {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().lowerEntry(k), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            K lowerKey;
            synchronized (this.mutex) {
                lowerKey = delegate().lowerKey(k);
            }
            return lowerKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            synchronized (this.mutex) {
                NavigableSet<K> navigableSet = this.navigableKeySet;
                if (navigableSet != null) {
                    return navigableSet;
                }
                NavigableSet<K> l = Synchronized.l(delegate().navigableKeySet(), this.mutex);
                this.navigableKeySet = l;
                return l;
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().pollFirstEntry(), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> m;
            synchronized (this.mutex) {
                m = Synchronized.m(delegate().pollLastEntry(), this.mutex);
            }
            return m;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            NavigableMap<K, V> k3;
            synchronized (this.mutex) {
                k3 = Synchronized.k(delegate().subMap(k, z, k2, z2), this.mutex);
            }
            return k3;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            NavigableMap<K, V> k2;
            synchronized (this.mutex) {
                k2 = Synchronized.k(delegate().tailMap(k, z), this.mutex);
            }
            return k2;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableMap<K, V> delegate() {
            return (NavigableMap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @VisibleForTesting
    /* compiled from: Taobao */
    public static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;
        @MonotonicNonNullDecl
        transient NavigableSet<E> descendingSet;

        SynchronizedNavigableSet(NavigableSet<E> navigableSet, @NullableDecl Object obj) {
            super(navigableSet, obj);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e) {
            E ceiling;
            synchronized (this.mutex) {
                ceiling = delegate().ceiling(e);
            }
            return ceiling;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return delegate().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            synchronized (this.mutex) {
                NavigableSet<E> navigableSet = this.descendingSet;
                if (navigableSet != null) {
                    return navigableSet;
                }
                NavigableSet<E> l = Synchronized.l(delegate().descendingSet(), this.mutex);
                this.descendingSet = l;
                return l;
            }
        }

        @Override // java.util.NavigableSet
        public E floor(E e) {
            E floor;
            synchronized (this.mutex) {
                floor = delegate().floor(e);
            }
            return floor;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e, boolean z) {
            NavigableSet<E> l;
            synchronized (this.mutex) {
                l = Synchronized.l(delegate().headSet(e, z), this.mutex);
            }
            return l;
        }

        @Override // java.util.NavigableSet
        public E higher(E e) {
            E higher;
            synchronized (this.mutex) {
                higher = delegate().higher(e);
            }
            return higher;
        }

        @Override // java.util.NavigableSet
        public E lower(E e) {
            E lower;
            synchronized (this.mutex) {
                lower = delegate().lower(e);
            }
            return lower;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            NavigableSet<E> l;
            synchronized (this.mutex) {
                l = Synchronized.l(delegate().subSet(e, z, e2, z2), this.mutex);
            }
            return l;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e, boolean z) {
            NavigableSet<E> l;
            synchronized (this.mutex) {
                l = Synchronized.l(delegate().tailSet(e, z), this.mutex);
            }
            return l;
        }

        @Override // java.util.SortedSet, java.util.NavigableSet, com.google.common.collect.Synchronized.SynchronizedSortedSet
        public SortedSet<E> headSet(E e) {
            return headSet(e, false);
        }

        @Override // java.util.SortedSet, java.util.NavigableSet, com.google.common.collect.Synchronized.SynchronizedSortedSet
        public SortedSet<E> tailSet(E e) {
            return tailSet(e, true);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSortedSet
        public NavigableSet<E> delegate() {
            return (NavigableSet) super.delegate();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet, com.google.common.collect.Synchronized.SynchronizedSortedSet
        public SortedSet<E> subSet(E e, E e2) {
            return subSet(e, true, e2, false);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSet(SortedSet<E> sortedSet, @NullableDecl Object obj) {
            super(sortedSet, obj);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public E first() {
            E first;
            synchronized (this.mutex) {
                first = delegate().first();
            }
            return first;
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e) {
            SortedSet<E> p;
            synchronized (this.mutex) {
                p = Synchronized.p(delegate().headSet(e), this.mutex);
            }
            return p;
        }

        @Override // java.util.SortedSet
        public E last() {
            E last;
            synchronized (this.mutex) {
                last = delegate().last();
            }
            return last;
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e, E e2) {
            SortedSet<E> p;
            synchronized (this.mutex) {
                p = Synchronized.p(delegate().subSet(e, e2), this.mutex);
            }
            return p;
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e) {
            SortedSet<E> p;
            synchronized (this.mutex) {
                p = Synchronized.p(delegate().tailSet(e), this.mutex);
            }
            return p;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedSet
        public SortedSet<E> delegate() {
            return (SortedSet) super.delegate();
        }
    }
}
