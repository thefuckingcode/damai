package tb;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class h42 {
    private final ConcurrentHashMap<String, String> a = new ConcurrentHashMap<>();
    private boolean b = true;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        static h42 a = new h42();
    }

    public static h42 a() {
        return a.a;
    }

    public String b(String str) {
        if (!this.b) {
            return null;
        }
        String str2 = this.a.get(str);
        if (str2 != null) {
            return str2;
        }
        this.a.put(str, "https");
        return "https";
    }

    public void c(String str) {
        this.a.put(str, "http");
    }

    public void d(boolean z) {
        this.b = z;
    }
}
