package com.alibaba.pictures.bricks.util.blur;

/* compiled from: Taobao */
public interface Cache<K, V> {
    void clear();

    V get(K k);

    void save(K k, V v);
}
