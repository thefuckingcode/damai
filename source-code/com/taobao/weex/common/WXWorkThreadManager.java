package com.taobao.weex.common;

import androidx.annotation.RestrictTo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: Taobao */
public class WXWorkThreadManager {
    private ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    public void destroy() {
        ExecutorService executorService = this.singleThreadExecutor;
        if (executorService != null) {
            executorService.shutdown();
        }
        this.singleThreadExecutor = null;
    }

    public void post(Runnable runnable) {
        ExecutorService executorService = this.singleThreadExecutor;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }
}
