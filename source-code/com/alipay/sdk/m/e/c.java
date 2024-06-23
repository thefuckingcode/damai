package com.alipay.sdk.m.e;

import java.lang.reflect.Type;
import java.util.Date;

/* compiled from: Taobao */
public final class c implements i, j {
    @Override // com.alipay.sdk.m.e.j
    public final Object a(Object obj) {
        return Long.valueOf(((Date) obj).getTime());
    }

    @Override // com.alipay.sdk.m.e.i
    public final Object a(Object obj, Type type) {
        return new Date(((Long) obj).longValue());
    }

    @Override // com.alipay.sdk.m.e.j, com.alipay.sdk.m.e.i
    public final boolean a(Class<?> cls) {
        return Date.class.isAssignableFrom(cls);
    }
}
