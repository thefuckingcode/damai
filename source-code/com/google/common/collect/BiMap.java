package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
/* compiled from: Taobao */
public interface BiMap<K, V> extends Map<K, V> {
    @CanIgnoreReturnValue
    @NullableDecl
    V forcePut(@NullableDecl K k, @NullableDecl V v);

    BiMap<V, K> inverse();

    @Override // java.util.Map
    @CanIgnoreReturnValue
    @NullableDecl
    V put(@NullableDecl K k, @NullableDecl V v);

    @Override // java.util.Map
    void putAll(Map<? extends K, ? extends V> map);

    @Override // java.util.Map
    Set<V> values();
}
