package tb;

import android.content.Context;
import android.os.Build;

/* compiled from: Taobao */
public class ip1 {
    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23 || context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
            return true;
        }
        return false;
    }
}
