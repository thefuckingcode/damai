package tb;

import androidx.collection.LruCache;
import com.taobao.weex.annotation.JSMethod;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* compiled from: Taobao */
public class bz1 {
    private static final LruCache<String, Method> a = new LruCache<>(8);

    private static Method a(Object obj, String str, Object... objArr) {
        Class<?> cls;
        if (obj instanceof Class) {
            cls = (Class) obj;
        } else {
            cls = obj.getClass();
        }
        String str2 = cls.getName() + JSMethod.NOT_SET + str;
        Method method = a.get(str2);
        if (method != null) {
            return method;
        }
        while (cls != null) {
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Method method2 : declaredMethods) {
                if (str.equals(method2.getName()) && c(method2.getGenericParameterTypes(), objArr)) {
                    method2.setAccessible(true);
                    a.put(str2, method2);
                    return method2;
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static Object b(Object obj, String str, Object... objArr) {
        try {
            Method a2 = a(obj, str, objArr);
            if (a2 == null) {
                return null;
            }
            if (obj instanceof Class) {
                return a2.invoke(null, objArr);
            }
            return a2.invoke(obj, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean c(Type[] typeArr, Object... objArr) {
        if (typeArr.length != objArr.length) {
            return false;
        }
        if (typeArr.length == 0) {
            return true;
        }
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            Type type = typeArr[i];
            Class cls = null;
            if (type instanceof Class) {
                cls = (Class) type;
            }
            if (cls == null) {
                return true;
            }
            obj.getClass();
        }
        return true;
    }
}
