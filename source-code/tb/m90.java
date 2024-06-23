package tb;

import android.util.Log;
import com.taobao.downloader.adpater.Logger;

/* compiled from: Taobao */
public class m90 {
    private static String a = "DLoader.";

    private static String a(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        if (objArr != null) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(" ");
                sb.append(f(objArr[i], objArr[i2]));
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                sb.append(" ");
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }

    private static String b(String str) {
        return a + str;
    }

    public static void c(String str, String str2, Object... objArr) {
        if (cm.k) {
            Logger logger = cm.b;
            if (logger != null) {
                logger.debug(b(str), a(str2, objArr));
            } else {
                Log.d(b(str), a(str2, objArr));
            }
        }
    }

    public static void d(String str, String str2, Throwable th, Object... objArr) {
        Logger logger = cm.b;
        if (logger != null) {
            logger.error(b(str), a(str2, objArr), th);
        } else {
            Log.e(b(str), str2, th);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        Logger logger = cm.b;
        if (logger != null) {
            logger.error(b(str), a(str2, objArr));
        } else {
            Log.e(b(str), a(str2, objArr));
        }
    }

    private static String f(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        if (obj == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(":");
        if (obj2 == null) {
            obj2 = "";
        }
        sb.append(obj2);
        return sb.toString();
    }

    public static void g(String str, String str2, Object... objArr) {
        if (cm.k) {
            Logger logger = cm.b;
            if (logger != null) {
                logger.info(b(str), a(str2, objArr));
            } else {
                Log.i(b(str), a(str2, objArr));
            }
        }
    }

    public static void h(String str, String str2, Object... objArr) {
        Logger logger = cm.b;
        if (logger != null) {
            logger.warn(b(str), a(str2, objArr));
        } else {
            Log.w(b(str), a(str2, objArr));
        }
    }
}
