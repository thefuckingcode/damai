package tb;

import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
public class az2 {
    private Set<String> a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b {
        private static final az2 a = new az2();
    }

    public static az2 b() {
        return b.a;
    }

    public void a(String str) {
        this.a.add(str);
    }

    private az2() {
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        hashSet.add("s.click.taobao.com");
    }
}
