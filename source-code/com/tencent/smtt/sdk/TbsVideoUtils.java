package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

public class TbsVideoUtils {
    private static q a;

    private static void a(Context context) {
        synchronized (TbsVideoUtils.class) {
            if (a == null) {
                d.a(true).a(context, false, false);
                s a2 = d.a(true).a();
                DexLoader dexLoader = null;
                if (a2 != null) {
                    dexLoader = a2.b();
                }
                if (dexLoader != null) {
                    a = new q(dexLoader);
                }
            }
        }
    }

    public static void deleteVideoCache(Context context, String str) {
        a(context);
        q qVar = a;
        if (qVar != null) {
            qVar.a(context, str);
        }
    }

    public static String getCurWDPDecodeType(Context context) {
        a(context);
        q qVar = a;
        return qVar != null ? qVar.a(context) : "";
    }
}
