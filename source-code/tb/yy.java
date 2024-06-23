package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.math.BigDecimal;

/* compiled from: Taobao */
public class yy {
    public static boolean a(Number number, Number number2) {
        return number.doubleValue() == number2.doubleValue();
    }

    public static boolean b(String str) {
        if (!TextUtils.isEmpty(str) && str.indexOf(".") != -1) {
            return true;
        }
        return false;
    }

    public static boolean c(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || (obj instanceof BigDecimal);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        if (((com.alibaba.fastjson.JSONArray) r3).size() > 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (((com.alibaba.fastjson.JSONObject) r3).size() > 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        if (((java.lang.Number) r3).intValue() != 0) goto L_0x0027;
     */
    public static boolean d(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            return i((String) obj);
        }
        if (!(obj instanceof JSONArray)) {
            if (!(obj instanceof JSONObject)) {
                if (!(obj instanceof Number)) {
                    return true;
                }
            }
        }
        z = true;
        return z;
    }

    public static double e(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int f(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static long g(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static Number h(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (b(str)) {
                return Double.valueOf(e(str));
            }
            return Long.valueOf(g(str));
        } else if (c(obj)) {
            return Double.valueOf(((Number) obj).doubleValue());
        } else {
            if ((obj instanceof Integer) || (obj instanceof Long)) {
                return Long.valueOf(((Number) obj).longValue());
            }
            return 0L;
        }
    }

    private static boolean i(String str) {
        return str != null && !str.equals("false") && !str.equalsIgnoreCase("0") && !str.isEmpty();
    }
}
