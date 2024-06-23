package com.taobao.android.ultron.expr;

import android.util.LruCache;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import tb.gl1;
import tb.tr2;

/* compiled from: Taobao */
class b implements ValueResolver {
    private static final LruCache<String, Method> a = new LruCache<>(64);
    private static final LruCache<String, String> b = new LruCache<>(16);
    private static final LruCache<String, Field> c = new LruCache<>(32);
    private static final LruCache<String, String> d = new LruCache<>(16);

    b() {
    }

    @Override // com.taobao.android.ultron.expr.ValueResolver
    public boolean canResolve(Object obj, Class<?> cls, String str) {
        return true;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0096 */
    @Override // com.taobao.android.ultron.expr.ValueResolver
    public Object resolve(Object obj, Class<?> cls, String str) {
        String str2;
        str2 = cls.getName() + "[]" + str;
        LruCache<String, Method> lruCache = a;
        Method method = lruCache.get(str2);
        if (method != null) {
            try {
                return method.invoke(obj, new Object[0]);
            } catch (Exception e) {
                tr2.g(e.getMessage(), new String[0]);
                return null;
            }
        } else {
            Field field = c.get(str2);
            if (field != null) {
                try {
                    return field.get(obj);
                } catch (Exception e2) {
                    tr2.g(e2.getMessage(), new String[0]);
                    return null;
                }
            } else {
                if (b.get(str2) != "") {
                    try {
                        Method method2 = cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET + Character.toUpperCase(str.charAt(0)) + str.substring(1), new Class[0]);
                        lruCache.put(str2, method2);
                        obj = method2.invoke(obj, new Object[0]);
                        return obj;
                    } catch (NoSuchMethodException unknown) {
                        try {
                            Method method3 = cls.getMethod("is" + Character.toUpperCase(str.charAt(0)) + str.substring(1), new Class[0]);
                            a.put(str2, method3);
                            return method3.invoke(obj, new Object[0]);
                        } catch (NoSuchMethodException unused) {
                            b.put(str2, "");
                        } catch (Exception e3) {
                            tr2.g(e3.getMessage(), new String[0]);
                            return null;
                        }
                    } catch (Exception e4) {
                        tr2.g(e4.getMessage(), new String[0]);
                        return null;
                    }
                }
                if (d.get(str2) != "") {
                    try {
                        Field field2 = cls.getField(str);
                        c.put(str2, field2);
                        return field2.get(obj);
                    } catch (NoSuchFieldException unused2) {
                        d.put(str2, "");
                    } catch (Exception e5) {
                        tr2.g(e5.getMessage(), new String[0]);
                        return null;
                    }
                }
                return null;
            }
        }
    }
}
