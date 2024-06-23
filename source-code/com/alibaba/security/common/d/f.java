package com.alibaba.security.common.d;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: Taobao */
public final class f {
    private static Class a(Class cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (actualTypeArguments.length > 0 && (actualTypeArguments[0] instanceof Class)) {
            return (Class) actualTypeArguments[0];
        }
        return Object.class;
    }

    private static Class b(Class cls) throws IndexOutOfBoundsException {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (actualTypeArguments.length > 0 && (actualTypeArguments[0] instanceof Class)) {
            return (Class) actualTypeArguments[0];
        }
        return Object.class;
    }
}
