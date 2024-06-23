package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.dn0;
import tb.ds1;
import tb.rk1;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* compiled from: Taobao */
public abstract class AbstractBiMap<K, V> extends q<K, V> implements BiMap<K, V>, Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    @MonotonicNonNullDecl
    private transient Map<K, V> delegate;
    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> entrySet;
    @RetainedWith
    @MonotonicNonNullDecl
    transient AbstractBiMap<V, K> inverse;
    @MonotonicNonNullDecl
    private transient Set<K> keySet;
    @MonotonicNonNullDecl
    private transient Set<V> valueSet;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class Inverse<K, V> extends AbstractBiMap<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;

        Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap, null);
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setInverse((AbstractBiMap) objectInputStream.readObject());
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractBiMap
        public K checkKey(K k) {
            return this.inverse.checkValue(k);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractBiMap
        public V checkValue(V v) {
            return this.inverse.checkKey(v);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.AbstractBiMap, com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
        public /* bridge */ /* synthetic */ Object delegate() {
            return AbstractBiMap.super.delegate();
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        public Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.common.collect.BiMap, com.google.common.collect.AbstractBiMap, com.google.common.collect.AbstractBiMap, java.util.Map, com.google.common.collect.q
        public /* bridge */ /* synthetic */ Collection values() {
            return AbstractBiMap.super.values();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Iterator<Map.Entry<K, V>> {
        @NullableDecl
        Map.Entry<K, V> a;
        final /* synthetic */ Iterator b;

        a(Iterator it) {
            this.b = it;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> entry = (Map.Entry) this.b.next();
            this.a = entry;
            return new b(entry);
        }

        public boolean hasNext() {
            return this.b.hasNext();
        }

        public void remove() {
            k.e(this.a != null);
            V value = this.a.getValue();
            this.b.remove();
            AbstractBiMap.this.removeFromInverseMap(value);
            this.a = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends dn0<K, V> {
        private final Map.Entry<K, V> a;

        b(Map.Entry<K, V> entry) {
            this.a = entry;
        }

        /* access modifiers changed from: protected */
        @Override // tb.dn0
        /* renamed from: a */
        public Map.Entry<K, V> delegate() {
            return this.a;
        }

        @Override // java.util.Map.Entry, tb.dn0
        public V setValue(V v) {
            AbstractBiMap.this.checkValue(v);
            ds1.x(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (rk1.a(v, getValue())) {
                return v;
            }
            ds1.k(!AbstractBiMap.this.containsValue(v), "value already present: %s", v);
            V value = this.a.setValue(v);
            ds1.x(rk1.a(v, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.updateInverseMap(getKey(), true, value, v);
            return value;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class c extends v<Map.Entry<K, V>> {
        final Set<Map.Entry<K, V>> a;

        private c() {
            this.a = AbstractBiMap.this.delegate.entrySet();
        }

        @Override // com.google.common.collect.o
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.o
        public boolean contains(Object obj) {
            return Maps.f(delegate(), obj);
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractBiMap.this.entrySetIterator();
        }

        @Override // com.google.common.collect.o
        public boolean remove(Object obj) {
            if (!this.a.contains(obj)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            ((AbstractBiMap) AbstractBiMap.this.inverse).delegate.remove(entry.getValue());
            this.a.remove(entry);
            return true;
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // com.google.common.collect.o
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        /* synthetic */ c(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t, com.google.common.collect.v, com.google.common.collect.v, com.google.common.collect.v
        public Set<Map.Entry<K, V>> delegate() {
            return this.a;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class d extends v<K> {
        private d() {
        }

        @Override // com.google.common.collect.o
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return Maps.m(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.o
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            AbstractBiMap.this.removeFromBothMaps(obj);
            return true;
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        /* synthetic */ d(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t, com.google.common.collect.v, com.google.common.collect.v, com.google.common.collect.v
        public Set<K> delegate() {
            return AbstractBiMap.this.delegate.keySet();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class e extends v<V> {
        final Set<V> a;

        private e() {
            this.a = AbstractBiMap.this.inverse.keySet();
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.L(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.o
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.t
        public String toString() {
            return standardToString();
        }

        @Override // java.util.Collection, com.google.common.collect.o, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        /* synthetic */ e(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.o, com.google.common.collect.o, com.google.common.collect.t, com.google.common.collect.v, com.google.common.collect.v, com.google.common.collect.v
        public Set<V> delegate() {
            return this.a;
        }
    }

    /* synthetic */ AbstractBiMap(Map map, AbstractBiMap abstractBiMap, a aVar) {
        this(map, abstractBiMap);
    }

    private V putInBothMaps(@NullableDecl K k, @NullableDecl V v, boolean z) {
        checkKey(k);
        checkValue(v);
        boolean containsKey = containsKey(k);
        if (containsKey && rk1.a(v, get(k))) {
            return v;
        }
        if (z) {
            inverse().remove(v);
        } else {
            ds1.k(!containsValue(v), "value already present: %s", v);
        }
        V put = this.delegate.put(k, v);
        updateInverseMap(k, containsKey, put, v);
        return put;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @CanIgnoreReturnValue
    private V removeFromBothMaps(Object obj) {
        V remove = this.delegate.remove(obj);
        removeFromInverseMap(remove);
        return remove;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeFromInverseMap(V v) {
        this.inverse.delegate.remove(v);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateInverseMap(K k, boolean z, V v, V v2) {
        if (z) {
            removeFromInverseMap(v);
        }
        this.inverse.delegate.put(v2, k);
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public K checkKey(@NullableDecl K k) {
        return k;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public V checkValue(@NullableDecl V v) {
        return v;
    }

    @Override // com.google.common.collect.q
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // com.google.common.collect.q
    public boolean containsValue(@NullableDecl Object obj) {
        return this.inverse.containsKey(obj);
    }

    @Override // java.util.Map, com.google.common.collect.q
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c(this, null);
        this.entrySet = cVar;
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new a(this.delegate.entrySet().iterator());
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    public V forcePut(@NullableDecl K k, @NullableDecl V v) {
        return putInBothMaps(k, v, true);
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        return this.inverse;
    }

    @Override // java.util.Map, com.google.common.collect.q
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        d dVar = new d(this, null);
        this.keySet = dVar;
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public AbstractBiMap<V, K> makeInverse(Map<V, K> map) {
        return new Inverse(map, this);
    }

    @Override // com.google.common.collect.BiMap, java.util.Map, com.google.common.collect.q
    @CanIgnoreReturnValue
    public V put(@NullableDecl K k, @NullableDecl V v) {
        return putInBothMaps(k, v, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.AbstractBiMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.BiMap, java.util.Map, com.google.common.collect.q
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, com.google.common.collect.q
    @CanIgnoreReturnValue
    public V remove(@NullableDecl Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        boolean z = true;
        ds1.w(this.delegate == null);
        ds1.w(this.inverse == null);
        ds1.d(map.isEmpty());
        ds1.d(map2.isEmpty());
        if (map == map2) {
            z = false;
        }
        ds1.d(z);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    /* access modifiers changed from: package-private */
    public void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
    public Map<K, V> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.BiMap, java.util.Map, com.google.common.collect.q
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        e eVar = new e(this, null);
        this.valueSet = eVar;
        return eVar;
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }
}
