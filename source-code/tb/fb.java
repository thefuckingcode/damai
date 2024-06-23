package tb;

import java.lang.reflect.Constructor;

/* compiled from: Taobao */
public class fb {
    public static <T> T a(Class<T> cls, Object... objArr) {
        Constructor<T> constructor;
        try {
            if (objArr.length == 0) {
                constructor = cls.getDeclaredConstructor(new Class[0]);
            } else {
                Class<?>[] clsArr = new Class[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    clsArr[i] = objArr[i].getClass();
                }
                constructor = cls.getDeclaredConstructor(clsArr);
            }
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
