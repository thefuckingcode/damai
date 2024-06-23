package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* compiled from: Taobao */
public abstract class r<K, V> extends t implements Multimap<K, V> {
    protected r() {
    }

    @Override // com.google.common.collect.Multimap
    public abstract Map<K, Collection<V>> asMap();

    @Override // com.google.common.collect.Multimap
    public abstract void clear();

    @Override // com.google.common.collect.Multimap
    public boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return delegate().containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        return delegate().containsKey(obj);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsValue(@NullableDecl Object obj) {
        return delegate().containsValue(obj);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.t
    public abstract Multimap<K, V> delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // com.google.common.collect.Multimap
    public abstract Collection<Map.Entry<K, V>> entries();

    @Override // com.google.common.collect.Multimap
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // com.google.common.collect.Multimap
    public abstract Collection<V> get(@NullableDecl K k);

    @Override // com.google.common.collect.Multimap
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // com.google.common.collect.Multimap
    public abstract Set<K> keySet();

    @Override // com.google.common.collect.Multimap
    public abstract Multiset<K> keys();

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public abstract boolean put(K k, V v);

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public abstract boolean putAll(Multimap<? extends K, ? extends V> multimap);

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public abstract boolean putAll(K k, Iterable<? extends V> iterable);

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public abstract boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2);

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public abstract Collection<V> removeAll(@NullableDecl Object obj);

    @Override // com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    public abstract Collection<V> replaceValues(K k, Iterable<? extends V> iterable);

    @Override // com.google.common.collect.Multimap
    public int size() {
        return delegate().size();
    }

    @Override // com.google.common.collect.Multimap
    public abstract Collection<V> values();
}
