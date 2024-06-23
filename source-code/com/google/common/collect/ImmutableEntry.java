package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
/* compiled from: Taobao */
public class ImmutableEntry<K, V> extends b<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    @NullableDecl
    final K key;
    @NullableDecl
    final V value;

    ImmutableEntry(@NullableDecl K k, @NullableDecl V v) {
        this.key = k;
        this.value = v;
    }

    @Override // java.util.Map.Entry, com.google.common.collect.b
    @NullableDecl
    public final K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry, com.google.common.collect.b
    @NullableDecl
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry, com.google.common.collect.b
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
