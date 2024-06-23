package com.taobao.phenix.builder;

/* compiled from: Taobao */
public interface Builder<T> {
    T build();

    Builder<T> with(T t);
}
