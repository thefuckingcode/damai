package com.alibaba.wireless.security.aopsdk.e;

import android.util.Log;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/* compiled from: OrangeConfigHelper */
public class c {
    public static final String a = "secaop_orange_namespace";
    private static final String b = "AOP-OrangeConfigHelper";
    private static String[] c = {a};
    private static boolean d;
    private static Object e;
    private static Class f;
    private static Method g;
    private static Method h;

    /* compiled from: OrangeConfigHelper */
    public static class a implements InvocationHandler {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if (ConfigManager.DEBUG) {
                    Log.d(c.b, "In OrangeListener: " + method.getName() + " called");
                }
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (method.getName().equals("onConfigUpdate")) {
                    if (objArr == null || objArr.length < 2) {
                        return null;
                    }
                    this.a.a((String) objArr[0], (Map) objArr[1]);
                }
                return null;
            } catch (Throwable th) {
                Log.e(c.b, "", th);
            }
        }
    }

    /* compiled from: OrangeConfigHelper */
    public interface b {
        void a(String str, Map<String, String> map);
    }

    public static void a(b bVar) {
        if (!d) {
            b();
        }
        if (e == null || g == null || f == null) {
            com.alibaba.wireless.security.aopsdk.i.a.a(b, "Orange reflect failed");
        } else {
            try {
                Map<String, String> a2 = a(a);
                if (a2 != null) {
                    bVar.a(a, a2);
                }
            } catch (Throwable th) {
                Log.e(b, "Get config", th);
            }
            a aVar = new a(bVar);
            Object newProxyInstance = Proxy.newProxyInstance(f.getClassLoader(), new Class[]{f}, aVar);
            try {
                g.invoke(e, c, newProxyInstance, Boolean.TRUE);
                Log.i(b, "Orange listener register success");
            } catch (Throwable th2) {
                com.alibaba.wireless.security.aopsdk.i.a.a(b, "Register Method failed", th2);
            }
        }
        if (ConfigManager.DEBUG) {
            Log.e(b, "Finish registerOrangeListener!");
        }
    }

    private static void b() {
        try {
            Class<?> cls = Class.forName("com.taobao.orange.OrangeConfig");
            f = Class.forName("com.taobao.orange.OConfigListener");
            e = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            g = cls.getDeclaredMethod("registerListener", String[].class, f, Boolean.TYPE);
            h = cls.getDeclaredMethod("getConfigs", String.class);
            d = true;
        } catch (Throwable th) {
            com.alibaba.wireless.security.aopsdk.i.a.a(b, "Init orange listener failed", th);
        }
    }

    public static boolean a() {
        if (!d) {
            b();
        }
        return (e == null || g == null || f == null) ? false : true;
    }

    public static Map<String, String> a(String str) {
        Object obj;
        if (!d) {
            b();
        }
        Method method = h;
        if (!(method == null || (obj = e) == null)) {
            try {
                return (Map) method.invoke(obj, str);
            } catch (Throwable th) {
                com.alibaba.wireless.security.aopsdk.i.a.a(b, "getConfigs failed", th);
            }
        }
        return null;
    }
}
