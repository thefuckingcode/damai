package com.google.common.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import tb.ds1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public abstract class c<T> {
    c() {
    }

    /* access modifiers changed from: package-private */
    public final Type capture() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        ds1.k(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
