package tb;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class ts2 {
    private Map<String, SharedPreferences> a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final ts2 a = new ts2();
    }

    public static ts2 b() {
        return b.a;
    }

    public SharedPreferences a(Context context, String str) {
        SharedPreferences sharedPreferences = this.a.get(str);
        if (sharedPreferences == null) {
            synchronized (ts2.class) {
                sharedPreferences = this.a.get(str);
                if (sharedPreferences == null) {
                    SharedPreferences sharedPreferences2 = context.getSharedPreferences(str + lg0.p, 0);
                    this.a.put(str, sharedPreferences2);
                    sharedPreferences = sharedPreferences2;
                }
            }
        }
        return sharedPreferences;
    }

    private ts2() {
        this.a = new HashMap();
    }
}
