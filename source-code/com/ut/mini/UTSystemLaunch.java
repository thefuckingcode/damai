package com.ut.mini;

import android.content.Context;
import android.os.SystemClock;
import com.alibaba.analytics.AnalyticsMgr;
import com.ut.mini.UTHitBuilders;
import tb.gj2;
import tb.t6;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class UTSystemLaunch {
    private static volatile boolean bSend;

    UTSystemLaunch() {
    }

    /* access modifiers changed from: private */
    public static void send() {
        long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder("BootTime");
        uTCustomHitBuilder.setProperty("bootTime", "" + currentTimeMillis);
        UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
    }

    static void sendBootTime(final Context context) {
        synchronized (UTSystemLaunch.class) {
            if (!bSend) {
                bSend = true;
                gj2.c().f(new Runnable() {
                    /* class com.ut.mini.UTSystemLaunch.AnonymousClass1 */

                    public void run() {
                        Context context = context;
                        if (context != null && t6.h(context)) {
                            UTSystemLaunch.send();
                            try {
                                Thread.sleep(500);
                                AnalyticsMgr.G();
                                Thread.sleep(500);
                                AnalyticsMgr.F();
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            }
        }
    }
}
