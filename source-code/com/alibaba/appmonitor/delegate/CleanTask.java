package com.alibaba.appmonitor.delegate;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.event.EventRepo;
import java.util.concurrent.ScheduledFuture;
import tb.gj2;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class CleanTask implements Runnable {
    private static final String TAG = "CleanTask";
    private static CleanTask cleanTask = null;
    private static ScheduledFuture future = null;
    private static boolean init = false;
    private static final long timeout = 300000;

    private CleanTask() {
    }

    static void destroy() {
        ScheduledFuture scheduledFuture = future;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            future.cancel(true);
        }
        init = false;
        cleanTask = null;
    }

    static void init() {
        if (!init) {
            Logger.f(TAG, "init TimeoutEventManager");
            cleanTask = new CleanTask();
            future = gj2.c().e(future, cleanTask, 300000);
            init = true;
        }
    }

    public void run() {
        Logger.f(TAG, "clean TimeoutEvent");
        EventRepo.s().h();
    }
}
