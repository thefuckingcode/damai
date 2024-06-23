package com.alipay.sdk.m.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import org.json.alipay.a;

/* compiled from: Taobao */
public final class k implements i {
    @Override // com.alipay.sdk.m.e.i
    public final Object a(Object obj, Type type) {
        if (!obj.getClass().equals(a.class)) {
            return null;
        }
        a aVar = (a) obj;
        HashSet hashSet = new HashSet();
        Class cls = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class;
        for (int i = 0; i < aVar.a(); i++) {
            hashSet.add(e.a(aVar.a(i), cls));
        }
        return hashSet;
    }

    @Override // com.alipay.sdk.m.e.i
    public final boolean a(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }
}
