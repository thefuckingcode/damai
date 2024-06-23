package com.taobao.monitor.adapter;

import android.app.Application;
import java.io.Serializable;
import java.util.HashMap;
import tb.uk2;

/* compiled from: Taobao */
public class TMAPMAdapterLauncher implements Serializable {
    public void init(final Application application, final HashMap<String, Object> hashMap) {
        new TMAPMInitiator().init(application, hashMap);
        uk2.d(new Runnable() {
            /* class com.taobao.monitor.adapter.TMAPMAdapterLauncher.AnonymousClass1 */

            public void run() {
                new TBAPMAdapterLauncherPart2().init(application, hashMap);
            }
        });
    }
}
