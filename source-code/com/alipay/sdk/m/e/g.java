package com.alipay.sdk.m.e;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.TreeMap;
import org.json.alipay.b;

/* compiled from: Taobao */
public final class g implements i, j {
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050 A[SYNTHETIC] */
    @Override // com.alipay.sdk.m.e.j
    public final Object a(Object obj) {
        Object obj2;
        TreeMap treeMap = new TreeMap();
        Class<?> cls = obj.getClass();
        while (true) {
            Field[] declaredFields = cls.getDeclaredFields();
            if (cls.equals(Object.class)) {
                return treeMap;
            }
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (field != null && !"this$0".equals(field.getName())) {
                        boolean isAccessible = field.isAccessible();
                        field.setAccessible(true);
                        Object obj3 = field.get(obj);
                        if (obj3 != null) {
                            field.setAccessible(isAccessible);
                            obj2 = f.b(obj3);
                            if (obj2 == null) {
                                treeMap.put(field.getName(), obj2);
                            }
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                    }
                }
            }
            cls = cls.getSuperclass();
        }
    }

    @Override // com.alipay.sdk.m.e.i
    public final Object a(Object obj, Type type) {
        if (!obj.getClass().equals(b.class)) {
            return null;
        }
        b bVar = (b) obj;
        Class cls = (Class) type;
        Object newInstance = cls.newInstance();
        while (!cls.equals(Object.class)) {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    String name = field.getName();
                    Type genericType = field.getGenericType();
                    if (bVar.b(name)) {
                        field.setAccessible(true);
                        field.set(newInstance, e.a(bVar.a(name), genericType));
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return newInstance;
    }

    @Override // com.alipay.sdk.m.e.j, com.alipay.sdk.m.e.i
    public final boolean a(Class<?> cls) {
        return true;
    }
}
