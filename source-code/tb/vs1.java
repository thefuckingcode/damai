package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.android.tlog.protocol.Constants;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: Taobao */
public class vs1 {
    private static boolean a;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0041  */
    private static void a() {
        String str;
        Exception e;
        String str2 = null;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class);
            str = (String) method.invoke(null, "ro.yunos.version");
            try {
                str2 = (String) method.invoke(null, "java.vm.name");
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                if (!TextUtils.isEmpty(str)) {
                }
            }
        } catch (Exception e3) {
            e = e3;
            str = null;
            e.printStackTrace();
            if (!TextUtils.isEmpty(str)) {
            }
        }
        if (!TextUtils.isEmpty(str)) {
            uu0.l = str;
            uu0.k = str2;
            return;
        }
        uu0.k = d() ? "harmony" : "android";
        uu0.l = Build.VERSION.getRELEASE();
    }

    public static void b(Context context, Map<String, Object> map) {
        if (!a) {
            a = true;
            us1.d().e(context);
            c(context, map);
            ws1 ws1 = ws1.b;
            co1 co1 = us1.PROCEDURE_MANAGER;
            ws1.a(co1);
            zn1.a.a(co1);
            ts1.b.a(us1.PROCEDURE_FACTORY);
        }
    }

    private static void c(Context context, Map<String, Object> map) {
        uu0.b = context.getPackageName();
        uu0.c = g(map.get("onlineAppKey"), "12278902");
        uu0.d = g(map.get(Constants.KEY_APP_BUILD), "");
        uu0.e = e(map);
        uu0.f = g(map.get("appPatch"), "");
        uu0.g = g(map.get("channel"), "");
        uu0.h = g(map.get("deviceId"), "");
        uu0.i = Build.getBRAND();
        uu0.j = Build.getMODEL();
        a();
        uu0.p = f(map);
        uu0.o = String.valueOf(System.currentTimeMillis());
        uu0.q = g(map.get("ttid"), "");
    }

    public static boolean d() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Method method = cls.getMethod("getOsBrand", new Class[0]);
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null || classLoader.getParent() != null) {
                return false;
            }
            return "harmony".equals(method.invoke(cls, new Object[0]));
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    private static String e(Map<String, Object> map) {
        Object obj = map.get("appVersion");
        if (obj instanceof String) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        Context a2 = us1.d().a();
        try {
            return a2.getPackageManager().getPackageInfo(a2.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "unknown";
        }
    }

    private static String f(Map<String, Object> map) {
        Object obj = map.get("process");
        if (obj instanceof String) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return at1.a();
    }

    private static String g(Object obj, String str) {
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return str;
    }
}
