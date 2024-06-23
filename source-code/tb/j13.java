package tb;

import androidx.annotation.NonNull;
import com.efs.sdk.base.a.e.c;
import com.efs.sdk.base.a.h.b.a;
import com.efs.sdk.base.a.h.b.b;
import java.util.HashMap;

/* compiled from: Taobao */
public final class j13 implements c {
    @Override // com.efs.sdk.base.a.e.c
    @NonNull
    public final vy0 a(g23 g23, boolean z) {
        vy0 vy0;
        b33 a = b33.a();
        k13 k13 = g23.a;
        a.d = k13.d;
        a.e = k13.e;
        a.g = k13.b;
        a.h = k13.a;
        a.k = g23.a();
        String b = com.efs.sdk.base.a.c.a.c.a().b(false);
        int i = g23.a.c;
        if (i == 0) {
            r03 c = r03.c();
            byte[] bArr = g23.c;
            boolean z2 = g23.b.b;
            String b2 = a.b();
            String a2 = r03.a(b, a);
            if (c.a) {
                t43.a("efs.px.api", "upload buffer file, url is ".concat(String.valueOf(a2)));
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put("wpk-header", b2);
            b c2 = new b(a2).c(hashMap);
            a aVar = c2.a;
            aVar.c = bArr;
            aVar.g = true;
            b b3 = c2.b("type", a.h);
            StringBuilder sb = new StringBuilder();
            sb.append(a.k);
            vy0 = b3.b("size", sb.toString()).b("flow_limit", Boolean.toString(z2)).d(p33.d()).a().b();
        } else {
            vy0 = 1 == i ? r03.c().b(b, a, g23.d, g23.b.b) : new vy0();
        }
        if (vy0.a && z) {
            w23.i(g23.d);
        }
        return vy0;
    }
}
