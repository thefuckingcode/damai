package com.taobao.android.launcher.statistics;

import com.taobao.monitor.adapter.TBAPMAdapterSubTaskManager;

/* compiled from: Taobao */
public class TaoApm {
    public static void endTask(String str) {
        TBAPMAdapterSubTaskManager.f(str);
    }

    public static void startTask(String str) {
        TBAPMAdapterSubTaskManager.g(str);
    }
}
