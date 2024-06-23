package tb;

import android.text.TextUtils;

/* compiled from: Taobao */
public class t32 {
    public static long a(Object obj, long j) {
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        try {
            String b = b(obj, String.valueOf(j));
            if (!TextUtils.isEmpty(b)) {
                return Long.parseLong(b);
            }
        } catch (Exception unused) {
        }
        return j;
    }

    public static String b(Object obj, String str) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj != null ? obj.toString() : str;
    }
}
