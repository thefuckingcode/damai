package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class ax {
    private static volatile boolean a;

    private static void a(Class<?> cls, Context context) {
        if (!a) {
            try {
                a = true;
                cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
            } catch (Throwable th) {
                b.m182a("mdid:load lib error " + th);
            }
        }
    }

    public static boolean a(Context context) {
        try {
            Class<?> a2 = v.a(context, "com.bun.miitmdid.core.JLibrary");
            if (a2 == null) {
                return false;
            }
            a(a2, context);
            return true;
        } catch (Throwable th) {
            b.m182a("mdid:check error " + th);
            return false;
        }
    }
}
