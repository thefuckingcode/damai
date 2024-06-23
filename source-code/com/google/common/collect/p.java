package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
/* compiled from: Taobao */
public abstract class p<K, V> extends q<K, V> implements ConcurrentMap<K, V> {
    protected p() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Object delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
    public abstract /* bridge */ /* synthetic */ Map delegate();

    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.q, com.google.common.collect.q, com.google.common.collect.t
    public abstract ConcurrentMap<K, V> delegate();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k, V v) {
        return delegate().putIfAbsent(k, v);
    }

    @CanIgnoreReturnValue
    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k, V v) {
        return delegate().replace(k, v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k, V v, V v2) {
        return delegate().replace(k, v, v2);
    }
}
