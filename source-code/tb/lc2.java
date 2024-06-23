package tb;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class lc2 {
    private final int a;
    private final String b;
    private final Map<String, hc2> c = new HashMap();

    public lc2(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public void a(hc2 hc2) {
        if (hc2 != null) {
            this.c.put(hc2.a(), hc2);
        }
    }

    public hc2 b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.c.get(str);
        }
        return null;
    }

    public Map<String, hc2> c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.a;
    }

    public int f() {
        return this.c.size();
    }

    public String toString() {
        return this.c.keySet().toString();
    }
}
