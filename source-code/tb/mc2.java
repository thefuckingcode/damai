package tb;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class mc2 {
    private final Map<String, lc2> a;

    /* compiled from: Taobao */
    private static class b {
        private static final mc2 a = new mc2();
    }

    public static mc2 c() {
        return b.a;
    }

    public void a() {
        synchronized (this.a) {
            this.a.clear();
        }
    }

    public lc2 b(String str) {
        lc2 lc2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.a) {
            lc2 = this.a.get(str);
        }
        return lc2;
    }

    public void d(lc2 lc2) {
        if (lc2 != null) {
            synchronized (this.a) {
                for (String str : lc2.c().keySet()) {
                    lc2 lc22 = this.a.get(str);
                    if (lc22 == null) {
                        this.a.put(str, lc2);
                    } else if (lc2.e() >= lc22.e()) {
                        this.a.put(str, lc2);
                    }
                }
            }
        }
    }

    private mc2() {
        this.a = new HashMap();
    }
}
