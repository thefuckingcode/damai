package tb;

import android.content.Context;
import java.io.File;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class zt0 {
    private static final String a = (".UTSystemConfig" + File.separator + "Global");

    public static mp1 a(Context context) {
        if (context != null) {
            return new mp1(context, a, "Alvin3", false, true);
        }
        return null;
    }

    public static mp1 b(Context context) {
        if (context != null) {
            return new mp1(context, a, "UTCommon", false, true);
        }
        return null;
    }
}
