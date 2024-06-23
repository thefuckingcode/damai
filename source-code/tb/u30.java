package tb;

import android.app.Application;
import javax.annotation.NonNullByDefault;

@NonNullByDefault
/* compiled from: Taobao */
public class u30 {
    private static boolean a;

    public static void a(Application application) {
        try {
            a = (application.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
        }
    }

    public static boolean b() {
        return a;
    }
}
