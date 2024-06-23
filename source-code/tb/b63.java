package tb;

import com.taobao.weex.annotation.JSMethod;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tb.k53;

/* compiled from: Taobao */
public final class b63 extends t03 {
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>(10);

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        String a;
        String b;
        String c;
        AtomicInteger d = new AtomicInteger(0);

        a(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    @Override // tb.t03
    public final void a() {
        try {
            if (this.a != null) {
                for (Map.Entry<String, a> entry : this.b.entrySet()) {
                    a value = entry.getValue();
                    int i = value.d.get();
                    if (i > 0) {
                        com.efs.sdk.base.a.d.a aVar = this.a;
                        String str = value.a;
                        String str2 = value.b;
                        String str3 = value.c;
                        l23 l23 = new l23("efs_core", "req_succ_rate", k53.a.a.a.c);
                        l23.a("rep_code", str);
                        l23.a("px_code", str2);
                        l23.a(com.alibaba.security.realidentity.jsbridge.a.V, str3);
                        l23.a("cnt", Integer.valueOf(i));
                        aVar.b(l23);
                        value.d.addAndGet(i * -1);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(String str, String str2, String str3) {
        String str4 = str + JSMethod.NOT_SET + str2 + JSMethod.NOT_SET + str3.trim();
        if (!this.b.containsKey(str4) || this.b.get(str4) == null) {
            this.b.putIfAbsent(str4, new a(str, str2, str3));
        }
        this.b.get(str4).d.incrementAndGet();
    }
}
