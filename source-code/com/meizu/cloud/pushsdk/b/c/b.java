package com.meizu.cloud.pushsdk.b.c;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class b implements Executor {
    private final ThreadPoolExecutor a;

    /* compiled from: Taobao */
    private static class a {
        private static b a = new b();
    }

    private b() {
        this.a = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new d().a((Integer) 10).a("message-pool-%d").a());
    }

    public static b a() {
        return a.a;
    }

    public void execute(@NonNull Runnable runnable) {
        this.a.execute(runnable);
    }
}
