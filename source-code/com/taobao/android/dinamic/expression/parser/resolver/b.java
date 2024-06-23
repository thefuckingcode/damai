package com.taobao.android.dinamic.expression.parser.resolver;

import android.util.LruCache;
import com.taobao.android.dinamic.log.DinamicLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import tb.gl1;

/* compiled from: Taobao */
class b implements ValueResolver {
    private static final LruCache<String, Method> a = new LruCache<>(64);
    private static final LruCache<String, String> b = new LruCache<>(16);
    private static final LruCache<String, Field> c = new LruCache<>(32);
    private static final LruCache<String, String> d = new LruCache<>(16);

    b() {
    }

    @Override // com.taobao.android.dinamic.expression.parser.resolver.ValueResolver
    public boolean canResolve(Object obj, Class<?> cls, String str) {
        return true;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0098 */
    @Override // com.taobao.android.dinamic.expression.parser.resolver.ValueResolver
    public Object resolve(Object obj, Class<?> cls, String str) {
        String str2;
        str2 = cls.getName() + "[]" + str;
        LruCache<String, Method> lruCache = a;
        Method method = lruCache.get(str2);
        if (method != null) {
            try {
                return method.invoke(obj, new Object[0]);
            } catch (Exception e) {
                DinamicLog.i("DinamicLog", e, new String[0]);
                return null;
            }
        } else {
            Field field = c.get(str2);
            if (field != null) {
                try {
                    return field.get(obj);
                } catch (Exception e2) {
                    DinamicLog.j("DinamicLog", e2.getMessage());
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
                            DinamicLog.j(e3.getMessage(), new String[0]);
                            return null;
                        }
                    } catch (Exception e4) {
                        DinamicLog.j("DinamicLog", e4.getMessage());
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
                        DinamicLog.j("DinamicLog", e5.getMessage());
                        return null;
                    }
                }
                return null;
            }
        }
    }
}
