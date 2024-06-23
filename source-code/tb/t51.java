package tb;

import android.content.SharedPreferences;

/* compiled from: Taobao */
public class t51 {
    private static SharedPreferences a;
    private static SharedPreferences.Editor b;

    public static SharedPreferences.Editor a() {
        b();
        return b;
    }

    private static void b() {
        if (b == null) {
            c();
            b = a.edit();
        }
    }

    private static void c() {
        if (a == null) {
            a = rs0.a.getSharedPreferences("deviceevaluator", 0);
        }
    }
}
