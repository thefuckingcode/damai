package tb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/* compiled from: Taobao */
public class nn1 {
    public static boolean a(String str) {
        return str != null && str.startsWith("com.google.");
    }

    public static boolean b(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            int i = applicationInfo != null ? applicationInfo.flags : 0;
            if ((i & 1) == 0 && (i & 128) == 0) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
