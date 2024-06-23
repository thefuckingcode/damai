package com.meizu.cloud.pushsdk.b.c;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class a implements Executor {
    private final ThreadPoolExecutor a;

    /* renamed from: com.meizu.cloud.pushsdk.b.c.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    private static class C0184a {
        private static a a = new a();
    }

    private a() {
        this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new d().a("io-pool-%d").a());
    }

    public static a a() {
        return C0184a.a;
    }

    public void execute(@NonNull Runnable runnable) {
        this.a.execute(runnable);
    }
}
