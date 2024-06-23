package com.ut.mini.extend;

import com.alibaba.analytics.utils.Logger;
import com.ut.mini.internal.LogAdapter;

/* compiled from: Taobao */
public class TLogExtend {
    public static void registerTLog() {
        if (UTExtendSwitch.bTlogExtend) {
            Logger.t(new LogAdapter());
        }
    }
}
