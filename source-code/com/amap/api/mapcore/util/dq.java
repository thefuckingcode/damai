package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public abstract class dq<Params, Progress, Result> {
    public static final Executor a;
    public static final Executor b;
    public static final Executor c;
    private static final ThreadFactory d;
    private static final BlockingQueue<Runnable> e;
    private static final c f = new c(Looper.getMainLooper());
    private static volatile Executor g;
    private final a<Params, Result> h;
    private final FutureTask<Result> i;
    private volatile e j = e.PENDING;
    private final AtomicBoolean k = new AtomicBoolean();
    private final AtomicBoolean l = new AtomicBoolean();

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.api.mapcore.util.dq$4  reason: invalid class name */
    /* compiled from: Taobao */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[e.values().length];
            a = iArr;
            iArr[e.RUNNING.ordinal()] = 1;
            a[e.FINISHED.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static abstract class a<Params, Result> implements Callable<Result> {
        Params[] b;

        private a() {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b<Data> {
        final dq a;
        final Data[] b;

        b(dq dqVar, Data... dataArr) {
            this.a = dqVar;
            this.b = dataArr;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Object obj = message.obj;
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                int i = message.what;
                if (i == 1) {
                    bVar.a.e(bVar.b[0]);
                } else if (i == 2) {
                    bVar.a.b((Object[]) bVar.b);
                }
            }
        }
    }

    /* compiled from: Taobao */
    private static class d implements Executor {
        final ArrayDeque<Runnable> a;
        Runnable b;

        private d() {
            this.a = new ArrayDeque<>();
        }

        /* access modifiers changed from: protected */
        public synchronized void a() {
            Runnable poll = this.a.poll();
            this.b = poll;
            if (poll != null) {
                dq.a.execute(poll);
            }
        }

        public synchronized void execute(final Runnable runnable) {
            this.a.offer(new Runnable() {
                /* class com.amap.api.mapcore.util.dq.d.AnonymousClass1 */

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        d.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }
    }

    /* compiled from: Taobao */
    public enum e {
        PENDING,
        RUNNING,
        FINISHED
    }

    static {
        AnonymousClass1 r7 = new ThreadFactory() {
            /* class com.amap.api.mapcore.util.dq.AnonymousClass1 */
            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "AbstractAsyncTask #" + this.a.getAndIncrement());
            }
        };
        d = r7;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        e = linkedBlockingQueue;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a = new ThreadPoolExecutor(5, 128, 1, timeUnit, linkedBlockingQueue, r7, new ThreadPoolExecutor.DiscardOldestPolicy());
        Executor dVar = eq.c() ? new d() : new ThreadPoolExecutor(1, 2, 1, timeUnit, new LinkedBlockingQueue(), new ed("AMapSERIAL_EXECUTOR"), new ThreadPoolExecutor.AbortPolicy());
        b = dVar;
        c = new ThreadPoolExecutor(2, 2, 1, timeUnit, new LinkedBlockingQueue(), new ed("AMapDUAL_THREAD_EXECUTOR"), new ThreadPoolExecutor.AbortPolicy());
        g = dVar;
    }

    public dq() {
        AnonymousClass2 r0 = new a<Params, Result>() {
            /* class com.amap.api.mapcore.util.dq.AnonymousClass2 */

            @Override // java.util.concurrent.Callable
            public Result call() throws Exception {
                dq.this.l.set(true);
                dq dqVar = dq.this;
                return (Result) dqVar.d(dqVar.a((Object[]) this.b));
            }
        };
        this.h = r0;
        this.i = new FutureTask<Result>(r0) {
            /* class com.amap.api.mapcore.util.dq.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void done() {
                try {
                    dq dqVar = dq.this;
                    dqVar.c((dq) dqVar.i.get());
                } catch (InterruptedException e) {
                    Log.w("AbstractAsyncTask", e);
                } catch (ExecutionException e2) {
                    throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
                } catch (CancellationException unused) {
                    dq.this.c((dq) null);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Result d(Result result) {
        f.obtainMessage(1, new b(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e(Result result) {
        if (d()) {
            b((Object) result);
        } else {
            a((Object) result);
        }
        this.j = e.FINISHED;
    }

    /* access modifiers changed from: protected */
    public abstract Result a(Params... paramsArr);

    /* access modifiers changed from: protected */
    public void a(Result result) {
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public void b(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(Result result) {
        if (!this.l.get()) {
            d(result);
        }
    }

    public final e a() {
        return this.j;
    }

    /* access modifiers changed from: protected */
    public void b(Result result) {
        c();
    }

    public final boolean d() {
        return this.k.get();
    }

    public final boolean a(boolean z) {
        this.k.set(true);
        return this.i.cancel(z);
    }

    public final dq<Params, Progress, Result> c(Params... paramsArr) {
        return a(g, paramsArr);
    }

    public final dq<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.j != e.PENDING) {
            int i2 = AnonymousClass4.a[this.j.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i2 == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.j = e.RUNNING;
        b();
        this.h.b = paramsArr;
        executor.execute(this.i);
        return this;
    }
}
