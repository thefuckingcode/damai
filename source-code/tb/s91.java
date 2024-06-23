package tb;

import android.util.Log;
import com.taobao.tao.log.TLog;

/* compiled from: Taobao */
public class s91 {
    private static boolean a = true;

    public static void a(String str, Object... objArr) {
        if (a) {
            String c = c(objArr);
            Log.d("SoPatchLogger", str + ":" + c);
        }
    }

    public static void b(String str, Object... objArr) {
        String c = c(objArr);
        Log.e("SoPatchLogger", str + ":" + c);
        try {
            TLog.loge("SoPatchLogger", c);
        } catch (Throwable unused) {
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
            Log.i("SoPatchLogger", str + ":" + c);
        }
    }

    public static void e(Throwable th) {
        if (a) {
            th.printStackTrace();
            if (th.getMessage() != null) {
                Log.e("SoPatchLogger", th.getMessage());
            }
        }
    }
}
