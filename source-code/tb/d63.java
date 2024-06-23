package tb;

import android.content.Context;

/* compiled from: Taobao */
public final class d63 {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            t43.b("efs.util.pkg", "get version name error", th);
            return "unknown";
        }
    }

    public static String b(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
        } catch (Throwable th) {
            t43.b("efs.util.pkg", "get version name error", th);
            return "unknown";
        }
    }
}
