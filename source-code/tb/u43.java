package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.efs.sdk.base.a.e.c;
import com.efs.sdk.base.a.h.b.b;
import java.util.HashMap;
import mtopsdk.network.util.Constants;
import tb.k53;

/* compiled from: Taobao */
public final class u43 implements c {
    private static void b(vy0 vy0) {
        if (vy0 != null && !TextUtils.isEmpty(vy0.c)) {
            for (String str : vy0.c.split("`")) {
                String[] split = str.split("=");
                if (split.length >= 2) {
                    if (split[0].equalsIgnoreCase("retcode")) {
                        vy0.d(split[1]);
                    } else {
                        vy0.d.put(split[0], split[1]);
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.base.a.e.c
    @NonNull
    public final vy0 a(g23 g23, boolean z) {
        vy0 vy0 = null;
        try {
            x23 x23 = k53.a.a.a;
            String valueOf = String.valueOf(System.currentTimeMillis());
            String a = k23.a(x23.b + x23.c + valueOf + "AppChk#2014");
            StringBuilder sb = new StringBuilder();
            String str = x23.a;
            if (str.startsWith("http")) {
                sb.append(str);
            } else {
                sb.append(str);
            }
            sb.append("?chk=");
            sb.append(a.substring(a.length() - 8));
            sb.append("&vno=");
            sb.append(valueOf);
            sb.append("&uuid=");
            sb.append(x23.c);
            sb.append("&app=");
            sb.append(x23.b);
            sb.append("&zip=gzip");
            String sb2 = sb.toString();
            int i = 0;
            byte[] bArr = new byte[0];
            int i2 = g23.a.c;
            if (i2 == 0) {
                bArr = g23.c;
                i = bArr.length;
            } else if (1 == i2) {
                bArr = w23.g(g23.d.getPath());
                i = bArr.length;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", IRequestConst.CONTENT_TYPE_POST);
            hashMap.put(Constants.Protocol.CONTENT_LENGTH, String.valueOf(i));
            b c = new b(sb2).c(hashMap);
            c.a.c = bArr;
            vy0 = c.a().b();
            b(vy0);
            if (vy0.a) {
                t43.a(com.efs.sdk.base.Constants.TAG, "wa upload succ, " + vy0.toString());
                w23.i(g23.d);
                return vy0;
            }
            t43.a(com.efs.sdk.base.Constants.TAG, "wa upload fail, resp is " + vy0.toString());
            return vy0;
        } catch (Throwable th) {
            if (0 == 0) {
                vy0 = new vy0();
            }
            t43.c("efs.wa.send", "get file size error", th);
        }
    }
}
