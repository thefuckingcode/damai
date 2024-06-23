package com.alipay.sdk.m.n0;

import android.content.Context;
import com.alipay.sdk.m.l0.d;
import com.alipay.sdk.m.l0.f;
import java.util.zip.Adler32;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class c {
    public static b a;
    public static final Object b = new Object();

    public static long a(b bVar) {
        if (bVar == null) {
            return 0;
        }
        String format = String.format("%s%s%s%s%s", bVar.c(), bVar.d(), Long.valueOf(bVar.a()), bVar.e(), bVar.b());
        if (f.m180a(format)) {
            return 0;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(format.getBytes());
        return adler32.getValue();
    }

    public static synchronized b b(Context context) {
        synchronized (c.class) {
            b bVar = a;
            if (bVar != null) {
                return bVar;
            }
            if (context == null) {
                return null;
            }
            b a2 = a(context);
            a = a2;
            return a2;
        }
    }

    public static b a(Context context) {
        if (context == null) {
            return null;
        }
        synchronized (b) {
            String b2 = d.a(context).b();
            if (f.m180a(b2)) {
                return null;
            }
            if (b2.endsWith(StringUtils.LF)) {
                b2 = b2.substring(0, b2.length() - 1);
            }
            b bVar = new b();
            long currentTimeMillis = System.currentTimeMillis();
            String a2 = d.a(context);
            String b3 = d.b(context);
            bVar.c(a2);
            bVar.a(a2);
            bVar.b(currentTimeMillis);
            bVar.b(b3);
            bVar.d(b2);
            bVar.a(a(bVar));
            return bVar;
        }
    }
}
