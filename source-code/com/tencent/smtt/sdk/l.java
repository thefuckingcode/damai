package com.tencent.smtt.sdk;

import android.os.HandlerThread;

/* access modifiers changed from: package-private */
/* compiled from: TbsHandlerThread */
public class l extends HandlerThread {
    private static l a;

    public l(String str) {
        super(str);
    }

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (a == null) {
                l lVar2 = new l("TbsHandlerThread");
                a = lVar2;
                lVar2.start();
            }
            lVar = a;
        }
        return lVar;
    }
}
