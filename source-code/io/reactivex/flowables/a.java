package io.reactivex.flowables;

import io.reactivex.annotations.Nullable;
import io.reactivex.b;

/* compiled from: Taobao */
public abstract class a<K, T> extends b<T> {
    final K key;

    protected a(@Nullable K k) {
        this.key = k;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}
