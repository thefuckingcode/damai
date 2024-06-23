package tb;

import android.app.Application;
import com.taobao.android.dinamic.a;
import com.taobao.android.dinamic.b;
import com.taobao.android.dinamic.dinamic.DinamicAppMonitor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class q70 {
    private static Application a;

    public static synchronized Application a() {
        Application application;
        synchronized (q70.class) {
            if (a == null) {
                a = b();
            }
            application = a;
        }
        return application;
    }

    private static Application b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            return (Application) declaredField.get(declaredMethod.invoke(null, new Object[0]));
        } catch (Exception unused) {
            DinamicAppMonitor a2 = a.h().a();
            if (a2 != null) {
                a2.counter_commit(b.TAG, "getApplication", 1.0d);
            }
            return null;
        }
    }
}
