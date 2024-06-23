package tb;

import android.text.TextUtils;
import java.io.File;

/* compiled from: Taobao */
public class rc2 {
    public static boolean a(pc2 pc2) {
        File b;
        if (pc2 == null || (b = rh0.b(pc2)) == null) {
            return false;
        }
        try {
            if (!b.exists() || !b.isFile() || b.length() != pc2.d()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            s91.e(th);
            return false;
        }
    }

    public static boolean b(pc2 pc2) {
        File b;
        if (pc2 == null || (b = rh0.b(pc2)) == null) {
            return false;
        }
        return TextUtils.equals(pc2.a(), ta1.a(b));
    }

    private static boolean c(hc2 hc2) {
        if (hc2 == null) {
            return false;
        }
        return TextUtils.equals(ta1.a(new File(hc2.c())), hc2.b());
    }

    public static boolean d(hc2 hc2) {
        if (hc2 == null) {
            return false;
        }
        return c(hc2);
    }
}
