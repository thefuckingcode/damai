package tb;

import android.content.Context;

/* compiled from: Taobao */
public class t30 {
    static Boolean a;

    public static boolean a(Context context) {
        if (a == null) {
            boolean z = false;
            try {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    z = true;
                }
            } catch (Exception unused) {
            }
            a = Boolean.valueOf(z);
        }
        return a.booleanValue();
    }
}
