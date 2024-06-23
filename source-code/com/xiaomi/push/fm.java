package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fp;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class fm {
    private static final boolean a = Log.isLoggable("BCompressed", 3);

    static byte[] a(fl flVar, byte[] bArr) {
        try {
            byte[] a2 = fp.a.a(bArr);
            if (a) {
                b.m183a("BCompressed", "decompress " + bArr.length + " to " + a2.length + " for " + flVar);
                if (flVar.f362a == 1) {
                    b.m183a("BCompressed", "decompress not support upStream");
                }
            }
            return a2;
        } catch (Exception e) {
            b.m183a("BCompressed", "decompress error " + e);
            return bArr;
        }
    }
}
