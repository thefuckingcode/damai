package tb;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class tx {
    private Map<String, mx> a = new HashMap();
    private Map<String, ay> b = new HashMap();

    public tx a() {
        tx txVar = new tx();
        for (Map.Entry<String, mx> entry : this.a.entrySet()) {
            txVar.e(entry.getKey(), entry.getValue().b());
        }
        txVar.b = this.b;
        return txVar;
    }

    public ay b(String str) {
        return this.b.get(str);
    }

    public mx c(String str) {
        return this.a.get(str);
    }

    public void d(Map<String, ay> map) {
        if (map != null) {
            this.b.putAll(map);
        }
    }

    public boolean e(String str, mx mxVar) {
        this.a.put(str, mxVar);
        return true;
    }
}
