package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Taobao */
public class InitReport {
    private static final int EVENT_LIMIT = 10;
    private static final String TAG = "HaReport";
    private static List<Runnable> eventsToReport = new CopyOnWriteArrayList();
    private static boolean hasConnectNet;

    public static void enableConnectNet() {
        hasConnectNet = true;
        try {
            HianalyticsHelper.getInstance().getReportExecutor().submit(new Runnable() {
                /* class com.huawei.hms.framework.common.hianalytics.InitReport.AnonymousClass1 */

                public void run() {
                    InitReport.submitAllEvents();
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.e(TAG, "the thread submit has rejectedExecutionException!");
        } catch (Throwable unused2) {
            Logger.e(TAG, "the thread submit has fatal error!");
        }
    }

    public static void reportWhenInit(Runnable runnable) {
        if (hasConnectNet) {
            try {
                HianalyticsHelper.getInstance().getReportExecutor().execute(runnable);
            } catch (RejectedExecutionException unused) {
                Logger.e(TAG, "the thread submit has rejectedExecutionException!");
            } catch (Throwable unused2) {
                Logger.e(TAG, "the thread submit has fatal error!");
            }
        } else if (eventsToReport.size() > 10) {
            Logger.e("TAG", "the event to be report when init exceed the limit!");
        } else {
            eventsToReport.add(runnable);
        }
    }

    /* access modifiers changed from: private */
    public static void submitAllEvents() {
        try {
            for (Runnable runnable : eventsToReport) {
                HianalyticsHelper.getInstance().getReportExecutor().submit(runnable);
            }
            eventsToReport.clear();
        } catch (RejectedExecutionException unused) {
            Logger.e(TAG, "submit failed of rejected execution exception");
        } catch (NullPointerException unused2) {
            Logger.e(TAG, "event is null occured");
        } catch (Exception unused3) {
            Logger.e(TAG, "submit failed because of some exception");
        }
    }
}
