package com.alibaba.android.umbrella.performance;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.android.umbrella.trace.UmbrellaTracker;
import com.alibaba.mtl.appmonitor.AppMonitor;
import tb.gr2;

@Keep
/* compiled from: Taobao */
public class PerformanceEngine {
    static void commitPerformancePage(PerformanceEntity performanceEntity) {
    }

    static void commitPerformancePage(ProcessEntity processEntity) {
        if (processEntity != null && !TextUtils.isEmpty(processEntity.bizName) && !gr2.z()) {
            AppMonitor.Alarm.commitSuccess("Page_Umbrella_Performance_Govern", "Monitor_Page_Load_Service", processEntity.toJsonString());
        }
    }

    static void commitPerformancePoint(PerformanceEntity performanceEntity) {
        if (!gr2.A()) {
            AppMonitor.Alarm.commitSuccess("Page_Umbrella_Performance_Govern", UmbrellaTracker.PURCHASE_POINT_PRE + performanceEntity.bizName + UmbrellaTracker.PURCHASE_POINT_POST, performanceEntity.toJsonString());
        }
    }
}
