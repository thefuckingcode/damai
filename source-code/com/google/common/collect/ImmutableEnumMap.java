package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.ds1;
import tb.wr2;

@GwtCompatible(emulated = true, serializable = true)
/* compiled from: Taobao */
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
    private final transient EnumMap<K, V> delegate;

    /* compiled from: Taobao */
    private static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumMap<K, V> delegate;

        EnumSerializedForm(EnumMap<K, V> enumMap) {
            this.delegate = enumMap;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return new ImmutableEnumMap(this.delegate);
        }
    }

    static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> enumMap) {
        int size = enumMap.size();
        if (size == 0) {
            return ImmutableMap.of();
        }
        if (size != 1) {
            return new ImmutableEnumMap(enumMap);
        }
        Map.Entry entry = (Map.Entry) a0.h(enumMap.entrySet());
        return ImmutableMap.of(entry.getKey(), entry.getValue());
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean containsKey(@NullableDecl Object obj) {
        return this.delegate.containsKey(obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    public wr2<Map.Entry<K, V>> entryIterator() {
        return Maps.G(this.delegate.entrySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumMap) {
            obj = ((ImmutableEnumMap) obj).delegate;
        }
        return this.delegate.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return this.delegate.get(obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public wr2<K> keyIterator() {
        return Iterators.x(this.delegate.keySet().iterator());
    }

    public int size() {
        return this.delegate.size();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }

    private ImmutableEnumMap(EnumMap<K, V> enumMap) {
        this.delegate = enumMap;
        ds1.d(!enumMap.isEmpty());
    }
}
