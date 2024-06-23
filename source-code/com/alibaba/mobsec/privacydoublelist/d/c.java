package com.alibaba.mobsec.privacydoublelist.d;

import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.PdlEnvUtils;
import com.alibaba.mobsec.privacydoublelist.report.PrivacyDoubleListReporter;
import com.alibaba.wireless.security.aopsdk.BuildConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class c implements a {
    public void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(PrivacyDoubleListReporter.UT_KEY, str);
        if (PdlEnvUtils.a) {
            Log.d("DL-UT", "Ut report");
        }
        if (b.a() != 0) {
            try {
                Map map = (Map) b.e.invoke(b.d.newInstance("Page_PrivacyCompliance", 19999, BuildConfig.FLAVOR, "1.1.2", "", hashMap), new Object[0]);
                if (map != null) {
                    if (map.size() != 0) {
                        Object invoke = b.f.invoke(b.c, new Object[0]);
                        if (invoke != null) {
                            Object invoke2 = b.g.invoke(invoke, "DoubleList");
                            if (invoke2 != null) {
                                b.h.invoke(invoke2, map);
                                return;
                            } else if (b.i) {
                                Log.i("UTMethodJniBridge", "Fail to create call getDefaultTracker.");
                                return;
                            } else {
                                return;
                            }
                        } else if (b.i) {
                            Log.i("UTMethodJniBridge", "Fail to create call getInstance.");
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (b.i) {
                    Log.i("UTMethodJniBridge", "Fail to create call build method.");
                }
            } catch (Exception e) {
                if (b.i) {
                    Log.e("UTMethodJniBridge", e.toString(), e);
                }
            }
        } else if (b.i) {
            Log.i("UTMethodJniBridge", "UserTracke is not avaiable.");
        }
    }
}
