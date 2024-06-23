package tb;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class az extends lx {
    protected Map<String, String> d = null;

    public az(long j) {
        super(j);
    }

    public void f(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.d == null) {
                this.d = new HashMap();
            }
            this.d.put(str, str2);
            Map<String, ey> a = a();
            if (a == null) {
                a = new HashMap<>();
                d(a);
            }
            a.put(str, ey.N(str2));
        }
    }
}
