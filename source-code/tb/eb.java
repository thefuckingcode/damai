package tb;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class eb {
    private static Map<String, Object> a = new HashMap();
    private static Map<String, Class> b = new HashMap();

    public static final <T> T getInstance(Class<T> cls) {
        return (T) getInstance(cls.getName(), cls);
    }

    public static void registerClass(Class... clsArr) {
        for (Class cls : clsArr) {
            Class<?>[] interfaces = cls.getInterfaces();
            if (interfaces == null || interfaces.length <= 0) {
                b.put(cls.getSuperclass().getName(), cls);
            } else {
                for (Class<?> cls2 : interfaces) {
                    b.put(cls2.getName(), cls);
                }
            }
        }
    }

    public static void registerInstance(Object obj) {
        Class<?> cls = obj.getClass();
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces == null || interfaces.length <= 0) {
            b.put(cls.getSuperclass().getName(), cls);
            a.put(cls.getSuperclass().getName(), obj);
            return;
        }
        for (Class<?> cls2 : interfaces) {
            b.put(cls2.getName(), cls);
            a.put(cls2.getName(), obj);
        }
    }

    public static final <T> T getInstance(String str, Class<T> cls) {
        T t = (T) a.get(str);
        if (t != null) {
            return t;
        }
        Class cls2 = b.get(str);
        if (cls2 == null) {
            return null;
        }
        try {
            return cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            Log.e("bf", "get Instance exception ", e);
            return null;
        }
    }

    public static void registerClass(String str, Class cls) {
        b.put(str, cls);
    }

    public static void registerInstance(String str, Object obj) {
        a.put(str, obj);
    }
}
