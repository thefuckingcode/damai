package com.taobao.opentracing.api.tag;

import com.taobao.opentracing.api.Span;

/* compiled from: Taobao */
public interface Tag<T> {
    String getKey();

    void set(Span span, T t);
}
