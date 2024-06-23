package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.rk1;

@GwtCompatible
/* compiled from: Taobao */
public abstract class q<K, V> extends t implements Map<K, V> {
    protected q() {
    }

    public void clear() {
        delegate().clear();
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return delegate().containsKey(obj);
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return delegate().containsValue(obj);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Object delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.t
    public abstract Map<K, V> delegate();

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    public boolean equals(@NullableDecl Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Map
    public V get(@NullableDecl Object obj) {
        return delegate().get(obj);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return delegate().keySet();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public V put(K k, V v) {
        return delegate().put(k, v);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public V remove(Object obj) {
        return delegate().remove(obj);
    }

    public int size() {
        return delegate().size();
    }

    /* access modifiers changed from: protected */
    public void standardClear() {
        Iterators.d(entrySet().iterator());
    }

    /* access modifiers changed from: protected */
    @Beta
    public boolean standardContainsKey(@NullableDecl Object obj) {
        return Maps.g(this, obj);
    }

    /* access modifiers changed from: protected */
    public boolean standardContainsValue(@NullableDecl Object obj) {
        return Maps.h(this, obj);
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(@NullableDecl Object obj) {
        return Maps.i(this, obj);
    }

    /* access modifiers changed from: protected */
    public int standardHashCode() {
        return Sets.b(entrySet());
    }

    /* access modifiers changed from: protected */
    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    /* access modifiers changed from: protected */
    public void standardPutAll(Map<? extends K, ? extends V> map) {
        Maps.u(this, map);
    }

    /* access modifiers changed from: protected */
    @Beta
    public V standardRemove(@NullableDecl Object obj) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (rk1.a(next.getKey(), obj)) {
                V value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String standardToString() {
        return Maps.z(this);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return delegate().values();
    }
}
