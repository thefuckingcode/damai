package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.jb;
import com.xiaomi.push.jl;
import com.xiaomi.push.service.ax;

/* compiled from: Taobao */
public class it {
    public static short a(Context context, Cif ifVar) {
        return a(context, ifVar.f624b);
    }

    public static short a(Context context, String str) {
        int i = 0;
        int a = h.a(context, str, false).a() + 0 + (ak.b(context) ? 4 : 0) + (ak.a(context) ? 8 : 0);
        if (ax.m809a(context)) {
            i = 16;
        }
        return (short) (a + i);
    }

    public static <T extends iu<T, ?>> void a(T t, byte[] bArr) {
        if (bArr != null) {
            new iy(new jl.a(true, true, bArr.length)).a(t, bArr);
            return;
        }
        throw new iz("the message byte is empty.");
    }

    public static <T extends iu<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new ja(new jb.a()).a(t);
        } catch (iz e) {
            b.a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }
}
