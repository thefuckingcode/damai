package com.ut.mini.core;

import com.alibaba.analytics.utils.Logger;
import java.util.Map;
import tb.d91;
import tb.yq2;

/* compiled from: Taobao */
public class UTLogTransferMain {
    private static UTLogTransferMain mInstance;

    private UTLogTransferMain() {
    }

    public static UTLogTransferMain getInstance() {
        if (mInstance == null) {
            synchronized (UTLogTransferMain.class) {
                if (mInstance == null) {
                    mInstance = new UTLogTransferMain();
                }
            }
        }
        return mInstance;
    }

    public void transferLog(Map<String, String> map) {
        if (map != null) {
            try {
                if (yq2.d().g(map)) {
                    d91.a(map);
                    return;
                }
                Logger.r("log discard", "aLogMap", map);
            } catch (Throwable th) {
                Logger.h(null, th, new Object[0]);
            }
        }
    }
}
