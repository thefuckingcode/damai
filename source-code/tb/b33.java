package tb;

import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.efs.sdk.base.a.c.a.c;
import com.efs.sdk.base.a.d.a;
import io.flutter.wpkbridge.U4WPKAdapter;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/* compiled from: Taobao */
public final class b33 {
    String a;
    String b;
    String c;
    public String d;
    public int e;
    public String f;
    public byte g;
    public String h;
    String i;
    String j;
    public long k = 0;

    public static b33 a() {
        b33 b33 = new b33();
        b33.a = a.a().a;
        b33.b = a.a().b;
        b33.j = a.a().i;
        b33.c = d63.a(a.a().c);
        b33.i = String.valueOf(c.a().e.a);
        return b33;
    }

    public final String b() {
        r03.c();
        String valueOf = String.valueOf(r03.e() / 1000);
        String b2 = k23.b(s03.b(this.j + valueOf, this.b));
        TreeMap treeMap = new TreeMap();
        treeMap.put("app", this.a);
        treeMap.put("sd", b2);
        if (!TextUtils.isEmpty(this.d)) {
            treeMap.put("cp", this.d);
        }
        if (this.g != 0) {
            treeMap.put("de", String.valueOf(this.e));
            treeMap.put("type", this.h);
            String str = this.f;
            if (TextUtils.isEmpty(str)) {
                r03.c();
                long e2 = r03.e();
                str = String.format(Locale.SIMPLIFIED_CHINESE, "%d%04d", Long.valueOf(e2), Integer.valueOf(new Random(e2).nextInt(10000)));
            }
            treeMap.put("seq", str);
        }
        treeMap.put("cver", this.i);
        treeMap.put("os", "android");
        treeMap.put(IRequestConst.SVER, this.i);
        treeMap.put(U4WPKAdapter.KEY_TM, valueOf);
        treeMap.put("ver", this.c);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str2 = ((String) entry.getKey()) + "=" + ((String) entry.getValue());
            sb2.append(str2);
            sb.append(str2);
            sb.append("&");
        }
        String a2 = k23.a(sb2.toString() + this.b);
        sb.append("sign=");
        sb.append(a2);
        return k23.c(sb.toString());
    }
}
