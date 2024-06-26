package tb;

import android.util.Log;

/* compiled from: Taobao */
public class pv1 {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static int a;

    public static void a(String str, String str2) {
        if (a <= 1) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (a <= 1) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (a <= 4) {
            Log.e(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (a <= 2) {
            Log.i(str, str2);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (a <= 2) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            Log.i(str, str2);
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (a <= 0) {
            if (objArr.length > 0) {
                str2 = String.format(str2, objArr);
            }
            Log.v(str, str2);
        }
    }
}
