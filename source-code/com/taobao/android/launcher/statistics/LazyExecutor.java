package com.taobao.android.launcher.statistics;

import androidx.annotation.NonNull;
import com.alibaba.motu.crashreportadapter.MotuReportAdapteHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
class LazyExecutor {

    /* compiled from: Taobao */
    static class Motu {
        static final MotuReportAdapteHandler ADAPTER_HANDLER = new MotuReportAdapteHandler();

        Motu() {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class Startup {
        static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor(new ThreadFactory() {
            /* class com.taobao.android.launcher.statistics.LazyExecutor.Startup.AnonymousClass1 */

            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, "debug-launcher-statistics");
            }
        });

        Startup() {
        }
    }

    LazyExecutor() {
    }
}
