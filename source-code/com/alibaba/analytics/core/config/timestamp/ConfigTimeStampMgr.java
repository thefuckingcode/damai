package com.alibaba.analytics.core.config.timestamp;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import tb.bm2;
import tb.gj2;
import tb.xd0;

/* compiled from: Taobao */
public class ConfigTimeStampMgr {
    private static ConfigTimeStampMgr c;
    private static Map<String, String> d = Collections.synchronizedMap(new HashMap());
    private ScheduledFuture a;
    private Runnable b = new Runnable() {
        /* class com.alibaba.analytics.core.config.timestamp.ConfigTimeStampMgr.AnonymousClass1 */

        public void run() {
            if (Variables.n().j() != null) {
                ArrayList arrayList = new ArrayList(ConfigTimeStampMgr.d.size());
                for (String str : ConfigTimeStampMgr.d.keySet()) {
                    arrayList.add(new bm2(str, (String) ConfigTimeStampMgr.d.get(str)));
                }
                Variables.n().k().b(bm2.class);
                Variables.n().k().q(arrayList);
                return;
            }
            Logger.v("storeTask.run()", WPKFactory.INIT_KEY_CONTEXT, null);
        }
    };

    private ConfigTimeStampMgr() {
        List<? extends xd0> i;
        if (!(Variables.n().j() == null || (i = Variables.n().k().i(bm2.class, null, null, -1)) == null)) {
            for (int i2 = 0; i2 < i.size(); i2++) {
                d.put(((bm2) i.get(i2)).a, ((bm2) i.get(i2)).b);
            }
        }
    }

    public static synchronized ConfigTimeStampMgr c() {
        ConfigTimeStampMgr configTimeStampMgr;
        synchronized (ConfigTimeStampMgr.class) {
            if (c == null) {
                c = new ConfigTimeStampMgr();
            }
            configTimeStampMgr = c;
        }
        return configTimeStampMgr;
    }

    public String b(String str) {
        String str2 = d.get(str);
        return TextUtils.isEmpty(str2) ? "0" : str2;
    }

    public void d(String str, String str2) {
        d.put(str, str2);
        this.a = gj2.c().d(this.a, this.b, 10000);
    }
}
