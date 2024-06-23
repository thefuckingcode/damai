package com.taobao.opentracing.impl.propagation;

import tb.qk1;

/* compiled from: Taobao */
public interface Codec<T> {
    qk1 extract(T t);

    void inject(qk1 qk1, T t);
}
