package tb;

import android.app.Activity;
import android.content.pm.PackageManager;

/* compiled from: Taobao */
public class rh {
    public static boolean a(Activity activity) {
        try {
            activity.getApplicationContext().getPackageManager().getPackageInfo("cn.cyberIdentity.certification", 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
