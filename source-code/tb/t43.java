package tb;

import android.util.Log;
import com.efs.sdk.base.a.d.a;

/* compiled from: Taobao */
public final class t43 {
    public static void a(String str, String str2) {
        if (a.a().d()) {
            Log.i(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (!a.a().d()) {
            return;
        }
        if (th == null) {
            Log.w(str, str2);
        } else {
            Log.w(str, str2, th);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (!a.a().d()) {
            return;
        }
        if (th == null) {
            Log.e(str, str2);
        } else {
            Log.e(str, str2, th);
        }
    }
}
