package com.meizu.cloud.pushsdk.b.c;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class c implements Executor {
    private final ThreadPoolExecutor a;

    /* compiled from: Taobao */
    private static class a {
        private static c a = new c();
    }

    private c() {
        this.a = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new d().a("single-pool-%d").a());
    }

    public static c a() {
        return a.a;
    }

    public void execute(@NonNull Runnable runnable) {
        this.a.execute(runnable);
    }
}
