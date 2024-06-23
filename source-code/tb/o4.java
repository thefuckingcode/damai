package tb;

import com.taobao.android.AliNavServiceInterface;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class o4 {
    private static AliNavServiceInterface a;

    public static <T> T a(Class<T> cls) {
        T t = (T) a;
        if (t != null) {
            return t;
        }
        T t2 = (T) b(cls);
        if (t2 != null) {
            a = t2;
        }
        return t2;
    }

    private static <T> T b(Class<T> cls) {
        String str;
        String name = cls.getName();
        if (name.endsWith("Interface")) {
            str = name.replace("Interface", "Imp");
        } else {
            str = name + "Imp";
        }
        try {
            Class<?> cls2 = Class.forName(str);
            try {
                Method declaredMethod = cls2.getDeclaredMethod("getInstance", new Class[0]);
                if (declaredMethod != null) {
                    return (T) declaredMethod.invoke(null, new Object[0]);
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return (T) cls2.newInstance();
                } catch (Exception unused) {
                    e.printStackTrace();
                    return null;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static AliNavServiceInterface c() {
        Object a2 = a(AliNavServiceInterface.class);
        if (a2 instanceof AliNavServiceInterface) {
            return (AliNavServiceInterface) a2;
        }
        return null;
    }
}
