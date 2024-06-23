package com.alibaba.wireless.security.aopsdk.e;

import android.util.Log;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: GaeaConfigHelper */
public class a {
    private static a f = null;
    private static final String g = "GaeaConfigHelper";
    private static final boolean h = ConfigManager.DEBUG;
    private Object a;
    private Method b;
    private Method c;
    private Method d;
    private Class<?> e;

    /* renamed from: com.alibaba.wireless.security.aopsdk.e.a$a  reason: collision with other inner class name */
    /* compiled from: GaeaConfigHelper */
    public class C0114a implements InvocationHandler {
        public final /* synthetic */ b a;

        public C0114a(b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (method.getName().equals("onChanged")) {
                if (objArr == null || objArr.length < 3) {
                    return null;
                }
                this.a.a((String) objArr[0], (String) objArr[1], (String) objArr[2]);
            }
            return null;
        }
    }

    /* compiled from: GaeaConfigHelper */
    public interface b {
        void a(String str, String str2, String str3);
    }

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f == null) {
                f = new a();
            }
            aVar = f;
        }
        return aVar;
    }

    private void b() {
        boolean z = true;
        if (h) {
            Log.d(g, "[initGaeaConfigInterfaceImpl] started");
        }
        try {
            Class<?> cls = Class.forName("com.alibaba.android.dingtalk.config.base.GaeaConfigInterface");
            this.e = Class.forName("com.alibaba.dingtalk.gaea.config.ConfigChangeListener");
            Method declaredMethod = cls.getDeclaredMethod("getInterfaceImpl", new Class[0]);
            this.b = cls.getDeclaredMethod("getStringValue", String.class, String.class, String.class);
            this.c = cls.getDeclaredMethod("getBooleanValue", String.class, String.class, Boolean.TYPE);
            this.d = cls.getDeclaredMethod("addConfigChangeListener", String.class, String.class, this.e);
            this.a = declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th) {
            if (h) {
                Log.e(g, "Init failed", th);
            }
        }
        if (h) {
            StringBuilder append = new StringBuilder().append("[initGaeaConfigInterfaceImpl] result: ");
            if (this.a == null) {
                z = false;
            }
            Log.d(g, append.append(z).toString());
        }
    }

    public boolean c() {
        if (this.a == null) {
            b();
        }
        return (this.a == null || this.c == null || this.b == null || this.d == null) ? false : true;
    }

    public String a(String str, String str2, String str3) {
        Method method;
        if (h) {
            Log.d(g, "[getStringValue] module=" + str + ", key=" + str2 + ", defaultValue=" + str3);
        }
        if (this.a == null) {
            b();
        }
        Object obj = this.a;
        if (!(obj == null || (method = this.b) == null)) {
            try {
                return (String) method.invoke(obj, str, str2, str3);
            } catch (Throwable th) {
                if (h) {
                    Log.e(g, "", th);
                }
            }
        }
        return str3;
    }

    public boolean a(String str, String str2, boolean z) {
        if (h) {
            Log.d(g, "[getBooleanValue] module=" + str + ", key=" + str2 + ", defaultValue=" + z);
        }
        if (this.a == null) {
            b();
        }
        Object obj = this.a;
        if (obj == null) {
            return z;
        }
        try {
            return ((Boolean) this.c.invoke(obj, str, str2, Boolean.valueOf(z))).booleanValue();
        } catch (Throwable th) {
            if (!h) {
                return z;
            }
            Log.e(g, "", th);
            return z;
        }
    }

    public void a(String str, String str2, b bVar) {
        if (h) {
            Log.d(g, "[getStringValue] module=" + str + ", key=" + str2);
        }
        if (this.a == null) {
            b();
        }
        if (this.a != null) {
            C0114a aVar = new C0114a(bVar);
            Object newProxyInstance = Proxy.newProxyInstance(this.e.getClassLoader(), new Class[]{this.e}, aVar);
            try {
                this.d.invoke(this.a, str, str2, newProxyInstance);
            } catch (Throwable th) {
                if (h) {
                    Log.e(g, "", th);
                }
            }
        }
    }
}
