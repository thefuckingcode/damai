package tb;

import android.util.Log;

/* compiled from: Taobao */
public class p91 {
    private static boolean a = true;

    public static void a(String str, Object... objArr) {
        if (a) {
            String c = c(objArr);
            Log.d("FTLogger", str + ":" + c);
        }
    }

    public static void b(String str, Object... objArr) {
        if (a) {
            String c = c(objArr);
            Log.e("FTLogger", str + ":" + c);
        }
    }

    private static String c(Object... objArr) {
        if (objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append("->");
                sb.append(obj.toString());
            }
        }
        return sb.toString();
    }

    public static void d(String str, Object... objArr) {
        if (a) {
            String c = c(objArr);
            Log.i("FTLogger", str + ":" + c);
        }
    }

    public static void e(boolean z) {
        a = z;
    }

    public static void f(Throwable th) {
    }

    public static void g(String str, Object... objArr) {
        if (a) {
            String c = c(objArr);
            Log.w("FTLogger", str + ":" + c);
        }
    }
}
