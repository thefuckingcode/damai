package tb;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class zy extends lx {
    public zy(long j) {
        super(j);
    }

    public void f(String str, String str2) {
        Map<String, ey> a = a();
        if (a == null) {
            a = new HashMap<>();
            d(a);
        }
        a.put(str, ey.N(str2));
    }
}
