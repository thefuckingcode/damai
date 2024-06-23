package com.alipay.sdk.m.e;

import com.alipay.sdk.m.f.a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.alipay.b;

/* compiled from: Taobao */
public final class h implements i, j {
    public static Map<Object, Object> a(Type type) {
        while (type != Properties.class) {
            if (type == Hashtable.class) {
                return new Hashtable();
            }
            if (type == IdentityHashMap.class) {
                return new IdentityHashMap();
            }
            if (type == SortedMap.class || type == TreeMap.class) {
                return new TreeMap();
            }
            if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
                return new ConcurrentHashMap();
            }
            if (type == Map.class || type == HashMap.class) {
                return new HashMap();
            }
            if (type == LinkedHashMap.class) {
                return new LinkedHashMap();
            }
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            } else {
                Class cls = (Class) type;
                if (!cls.isInterface()) {
                    try {
                        return (Map) cls.newInstance();
                    } catch (Exception e) {
                        throw new IllegalArgumentException("unsupport type " + type, e);
                    }
                } else {
                    throw new IllegalArgumentException("unsupport type " + type);
                }
            }
        }
        return new Properties();
    }

    @Override // com.alipay.sdk.m.e.j
    public final Object a(Object obj) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            if (entry.getKey() instanceof String) {
                treeMap.put((String) entry.getKey(), f.b(entry.getValue()));
            } else {
                throw new IllegalArgumentException("Map key must be String!");
            }
        }
        return treeMap;
    }

    @Override // com.alipay.sdk.m.e.i
    public final Object a(Object obj, Type type) {
        if (!obj.getClass().equals(b.class)) {
            return null;
        }
        b bVar = (b) obj;
        Map<Object, Object> a = a(type);
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (String.class == type2) {
                Iterator a2 = bVar.a();
                while (a2.hasNext()) {
                    String str = (String) a2.next();
                    a.put(str, a.a((Class) type3) ? bVar.a(str) : e.a(bVar.a(str), type3));
                }
                return a;
            }
            throw new IllegalArgumentException("Deserialize Map Key must be String.class");
        }
        throw new IllegalArgumentException("Deserialize Map must be Generics!");
    }

    @Override // com.alipay.sdk.m.e.j, com.alipay.sdk.m.e.i
    public final boolean a(Class<?> cls) {
        return Map.class.isAssignableFrom(cls);
    }
}
