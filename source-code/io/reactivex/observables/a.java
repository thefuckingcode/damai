package io.reactivex.observables;

import io.reactivex.annotations.Nullable;
import io.reactivex.d;

/* compiled from: Taobao */
public abstract class a<K, T> extends d<T> {
    final K key;

    protected a(@Nullable K k) {
        this.key = k;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}
