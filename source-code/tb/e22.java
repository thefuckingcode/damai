package tb;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;

/* compiled from: Taobao */
public class e22 {
    private static Boolean a;

    static {
        Looper.getMainLooper().getThread();
    }

    public static boolean a(Context context) {
        if (a == null) {
            try {
                boolean z = false;
                if (!TextUtils.isEmpty(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).sharedUserId)) {
                    z = true;
                }
                a = Boolean.valueOf(z);
            } catch (PackageManager.NameNotFoundException unused) {
                a = Boolean.FALSE;
            }
        }
        return a.booleanValue();
    }
}
