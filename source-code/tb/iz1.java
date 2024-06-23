package tb;

import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* compiled from: Taobao */
public final class iz1 {
    @Nullable
    public static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    public static Method b(Class<?> cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Object c(Object obj, Method method, Object... objArr) {
        if (method == null || obj == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
