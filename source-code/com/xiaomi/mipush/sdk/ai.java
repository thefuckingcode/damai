package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bm;
import com.xiaomi.push.hj;
import com.xiaomi.push.hy;
import com.xiaomi.push.hz;
import com.xiaomi.push.i;
import com.xiaomi.push.ia;
import com.xiaomi.push.ie;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.iq;
import com.xiaomi.push.is;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
public class ai {
    protected static <T extends iu<T, ?>> Cif a(Context context, T t, hj hjVar) {
        return a(context, t, hjVar, !hjVar.equals(hj.Registration), context.getPackageName(), b.m219a(context).m220a());
    }

    protected static <T extends iu<T, ?>> Cif a(Context context, T t, hj hjVar, boolean z, String str, String str2) {
        return a(context, t, hjVar, z, str, str2, true);
    }

    protected static <T extends iu<T, ?>> Cif a(Context context, T t, hj hjVar, boolean z, String str, String str2, boolean z2) {
        String str3;
        byte[] a = it.a(t);
        if (a == null) {
            str3 = "invoke convertThriftObjectToBytes method, return null.";
        } else {
            Cif ifVar = new Cif();
            if (z) {
                String d = b.m219a(context).d();
                if (TextUtils.isEmpty(d)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        a = i.b(bm.m290a(d), a);
                    } catch (Exception unused) {
                        b.d("encryption error. ");
                    }
                }
            }
            hy hyVar = new hy();
            hyVar.f545a = 5;
            hyVar.f546a = "fakeid";
            ifVar.a(hyVar);
            ifVar.a(ByteBuffer.wrap(a));
            ifVar.a(hjVar);
            ifVar.b(z2);
            ifVar.b(str);
            ifVar.a(z);
            ifVar.a(str2);
            return ifVar;
        }
        b.m182a(str3);
        return null;
    }

    public static iu a(Context context, Cif ifVar) {
        byte[] bArr;
        if (ifVar.m625b()) {
            byte[] a = i.a(context, ifVar, e.ASSEMBLE_PUSH_FCM);
            if (a == null) {
                a = bm.m290a(b.m219a(context).d());
            }
            try {
                bArr = i.a(a, ifVar.m623a());
            } catch (Exception e) {
                throw new u("the aes decrypt failed.", e);
            }
        } else {
            bArr = ifVar.m623a();
        }
        iu a2 = a(ifVar.a(), ifVar.f625b);
        if (a2 != null) {
            it.a(a2, bArr);
        }
        return a2;
    }

    private static iu a(hj hjVar, boolean z) {
        switch (aj.a[hjVar.ordinal()]) {
            case 1:
                return new ik();
            case 2:
                return new iq();
            case 3:
                return new io();
            case 4:
                return new is();
            case 5:
                return new im();
            case 6:
                return new hz();
            case 7:
                return new ie();
            case 8:
                return new il();
            case 9:
                if (z) {
                    return new ii();
                }
                ia iaVar = new ia();
                iaVar.a(true);
                return iaVar;
            case 10:
                return new ie();
            default:
                return null;
        }
    }

    protected static <T extends iu<T, ?>> Cif b(Context context, T t, hj hjVar, boolean z, String str, String str2) {
        return a(context, t, hjVar, z, str, str2, false);
    }
}
