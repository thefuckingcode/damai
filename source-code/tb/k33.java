package tb;

import android.util.Base64;
import java.nio.charset.StandardCharsets;

/* compiled from: Taobao */
public final class k33 {
    public static boolean a(byte[] bArr) {
        String str;
        if (bArr == null) {
            return false;
        }
        byte[] bArr2 = null;
        try {
            z43 z43 = new z43();
            z43.b.put("Content-Type", "application/octet-stream");
            z43.b.put("aps_c_src", Base64.encodeToString(z43.a().getBytes(), 2));
            z43.b.put("aps_c_key", Base64.encodeToString(z43.b().getBytes(), 2));
            z43.c = bArr;
            if (i33.a) {
                str = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            } else {
                str = (i33.b ? "https://" : "http://") + "cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            }
            z43.a = str;
            a53 a = n43.c().a(z43);
            if (a != null && a.a == 200) {
                bArr2 = a.c;
            }
            return bArr2 != null && "true".equals(new String(bArr2, StandardCharsets.UTF_8));
        } catch (Exception e) {
            y43.a(e);
            return false;
        }
    }
}
