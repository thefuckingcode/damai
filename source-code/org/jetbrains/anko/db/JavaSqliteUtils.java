package org.jetbrains.anko.db;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

class JavaSqliteUtils {
    static final Map<Class<?>, Class<?>> PRIMITIVES_TO_WRAPPERS;

    private JavaSqliteUtils() {
    }

    private static <T> Class<T> wrap(Class<T> cls) {
        return cls.isPrimitive() ? (Class<T>) PRIMITIVES_TO_WRAPPERS.get(cls) : cls;
    }

    static {
        HashMap hashMap = new HashMap();
        PRIMITIVES_TO_WRAPPERS = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        hashMap.put(Byte.TYPE, Byte.class);
        hashMap.put(Character.TYPE, Character.class);
        hashMap.put(Double.TYPE, Double.class);
        hashMap.put(Float.TYPE, Float.class);
        hashMap.put(Integer.TYPE, Integer.class);
        hashMap.put(Long.TYPE, Long.class);
        hashMap.put(Short.TYPE, Short.class);
        hashMap.put(Void.TYPE, Void.class);
    }

    static <T> T newInstance(Constructor<T> constructor, Object[] objArr) throws Exception {
        return constructor.newInstance(objArr);
    }
}
