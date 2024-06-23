package me.ele.altriax.launcher.common;

import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
public class AltriaXExecutor {
    public static final ExecutorService ALTRIAX_EXECUTOR = Executors.newSingleThreadExecutor(new ThreadFactory() {
        /* class me.ele.altriax.launcher.common.AltriaXExecutor.AnonymousClass1 */

        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "AltriaXExecutor");
        }
    });
}
