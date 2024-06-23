package com.ut.mini.behavior.edgecomputing.datacollector;

import com.alibaba.analytics.utils.Logger;
import tb.nt2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class UTDataStoreHelper {
    private static final String TAG = "UTDataStoreHelper";
    private static nt2 mHandler = new nt2();

    UTDataStoreHelper() {
    }

    public static void postRunnable(final Runnable runnable) {
        mHandler.b(new Runnable() {
            /* class com.ut.mini.behavior.edgecomputing.datacollector.UTDataStoreHelper.AnonymousClass1 */

            public void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    Logger.h(UTDataStoreHelper.TAG, e, new Object[0]);
                }
            }
        });
    }
}
