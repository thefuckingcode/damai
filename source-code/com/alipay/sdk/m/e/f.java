package com.alipay.sdk.m.e;

import com.alipay.sdk.m.f.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.alipay.b;

/* compiled from: Taobao */
public final class f {
    public static List<j> a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new l());
        a.add(new d());
        a.add(new c());
        a.add(new h());
        a.add(new b());
        a.add(new a());
        a.add(new g());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object b = b(obj);
        if (a.a(b.getClass())) {
            return b.c(b.toString());
        }
        if (Collection.class.isAssignableFrom(b.getClass())) {
            return new org.json.alipay.a((Collection) ((List) b)).toString();
        }
        if (Map.class.isAssignableFrom(b.getClass())) {
            return new b((Map) b).toString();
        }
        throw new IllegalArgumentException("Unsupported Class : " + b.getClass());
    }

    public static Object b(Object obj) {
        Object a2;
        if (obj == null) {
            return null;
        }
        for (j jVar : a) {
            if (jVar.a(obj.getClass()) && (a2 = jVar.a(obj)) != null) {
                return a2;
            }
        }
        throw new IllegalArgumentException("Unsupported Class : " + obj.getClass());
    }
}
