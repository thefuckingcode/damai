package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public final class l {
    public static final Executor a = c();
    private static Object b = new Object();
    private static Handler c;
    private static HandlerThread d;

    /* compiled from: Taobao */
    private static class a implements Executor {
        final Queue<Runnable> a;
        Runnable b;

        private a() {
            this.a = new LinkedList();
        }

        /* access modifiers changed from: protected */
        public synchronized void a() {
            Runnable poll = this.a.poll();
            this.b = poll;
            if (poll != null) {
                l.a.execute(poll);
            }
        }

        public synchronized void execute(final Runnable runnable) {
            this.a.offer(new Runnable() {
                /* class com.tencent.open.utils.l.a.AnonymousClass1 */

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }
    }

    public static void a(Runnable runnable) {
        try {
            a.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    public static void b(Runnable runnable) {
        a().post(runnable);
    }

    private static Executor c() {
        return new ThreadPoolExecutor(0, 3, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static Handler a() {
        if (c == null) {
            synchronized (l.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                d = handlerThread;
                handlerThread.start();
                c = new Handler(d.getLooper());
            }
        }
        return c;
    }

    public static Executor b() {
        return new a();
    }
}
