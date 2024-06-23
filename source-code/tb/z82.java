package tb;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class z82 {
    private static volatile z82 b;
    private final ConcurrentHashMap<String, Object> a = new ConcurrentHashMap<>();

    private z82() {
    }

    public static z82 b() {
        if (b == null) {
            synchronized (z82.class) {
                if (b == null) {
                    b = new z82();
                }
            }
        }
        return b;
    }

    public void a(List<String> list) {
        if (list != null) {
            for (String str : list) {
                this.a.remove(str);
            }
        }
    }

    public Object c(String str) {
        return this.a.get(str);
    }

    public void d(String str, Object obj) {
        this.a.putIfAbsent(str, obj);
    }
}
