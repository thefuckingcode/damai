package com.ut.mini.behavior.edgecomputing.datacollector;

import com.alibaba.analytics.AnalyticsMgr;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class GlobalData {
    public static String cold_start_id;
    public static String session_id;

    GlobalData() {
    }

    public static String getUserid() {
        return AnalyticsMgr.J();
    }
}
