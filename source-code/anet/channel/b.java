package anet.channel;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import tb.a92;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class b {
    Map<String, Integer> a = new HashMap();
    Map<String, a92> b = new ConcurrentHashMap();

    b() {
    }

    public int a(String str) {
        Integer num;
        synchronized (this.a) {
            num = this.a.get(str);
        }
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public a92 b(String str) {
        return this.b.get(str);
    }

    /* access modifiers changed from: package-private */
    public Collection<a92> c() {
        return this.b.values();
    }

    /* access modifiers changed from: package-private */
    public void d(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.a) {
                this.a.put(str, Integer.valueOf(i));
            }
            return;
        }
        throw new IllegalArgumentException("host cannot be null or empty");
    }

    /* access modifiers changed from: package-private */
    public void e(a92 a92) {
        Objects.requireNonNull(a92, "info is null");
        if (!TextUtils.isEmpty(a92.a)) {
            this.b.put(a92.a, a92);
            return;
        }
        throw new IllegalArgumentException("host cannot be null or empty");
    }

    /* access modifiers changed from: package-private */
    public a92 f(String str) {
        return this.b.remove(str);
    }
}
