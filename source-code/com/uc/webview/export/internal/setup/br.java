package com.uc.webview.export.internal.setup;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.extension.UCCore;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.concurrent.ConcurrentLinkedQueue;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class br extends Handler {
    final /* synthetic */ UCAsyncTask a;
    private UCAsyncTask b = null;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    br(UCAsyncTask uCAsyncTask, Looper looper) {
        super(looper);
        this.a = uCAsyncTask;
    }

    private static void a(UCAsyncTask uCAsyncTask) {
        if (uCAsyncTask != null) {
            synchronized (uCAsyncTask.d) {
                uCAsyncTask.mPercent = (int) ((((float) UCAsyncTask.e(uCAsyncTask)) * 100.0f) / ((float) UCAsyncTask.f(uCAsyncTask)));
            }
            uCAsyncTask.callback("progress");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:99:0x014e, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x016a A[Catch:{ all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a A[Catch:{ all -> 0x009d, all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00da A[SYNTHETIC] */
    public final void dispatchMessage(Message message) {
        UCElapseTime uCElapseTime;
        UCAsyncTask uCAsyncTask;
        Runnable runnable;
        Runnable callback;
        Runnable runnable2 = null;
        try {
            if (UCAsyncTask.p.booleanValue()) {
                uCElapseTime = new UCElapseTime();
                callback = message.getCallback();
                if (callback instanceof UCAsyncTask) {
                    UCAsyncTask uCAsyncTask2 = (UCAsyncTask) callback;
                    this.b = uCAsyncTask2;
                    if (uCAsyncTask2.n > 0) {
                        try {
                            Thread.sleep(this.b.n);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        this.b.n = 0;
                    }
                    this.b.callback("start");
                }
                synchronized (this.b.i) {
                    if (this.b.h) {
                        message = null;
                    }
                }
                if (message != null) {
                    UCAsyncTask uCAsyncTask3 = this.b;
                    synchronized (this.a.i) {
                        if (this.a.g) {
                            this.a.g = false;
                            uCAsyncTask3.callback("pause");
                            this.a.i.a(AbsPerformance.LONG_NIL);
                            uCAsyncTask3.callback("resume");
                        }
                    }
                }
                if (message != null && this.b.mException == null) {
                    super.dispatchMessage(message);
                    a(this.b);
                }
                try {
                    if (UCAsyncTask.p.booleanValue()) {
                        uCAsyncTask = this.b;
                        while (true) {
                            synchronized (this.b.d) {
                                UCAsyncTask uCAsyncTask4 = this.b;
                                boolean z = true;
                                boolean z2 = uCAsyncTask4.mException != null;
                                boolean z3 = uCAsyncTask4.h;
                                if (z2 || z3) {
                                    UCAsyncTask.j(this.b);
                                }
                                ConcurrentLinkedQueue concurrentLinkedQueue = this.b.b;
                                if (concurrentLinkedQueue != null) {
                                    try {
                                        runnable = (Runnable) concurrentLinkedQueue.poll();
                                        if (runnable == null) {
                                            z = z2;
                                            runnable2 = runnable;
                                        }
                                    } catch (Throwable th2) {
                                        this.b.setException(new UCSetupException(th2));
                                    }
                                } else {
                                    z = z2;
                                }
                                if (z3) {
                                    this.b.callback("stop");
                                } else {
                                    if (z) {
                                        this.b.callback("exception");
                                    } else {
                                        this.b.callback("success");
                                    }
                                    this.b.callback("gone");
                                }
                                this.b.callback(UCCore.EVENT_DIE);
                                UCAsyncTask uCAsyncTask5 = this.b.a;
                                this.b = uCAsyncTask5;
                                a(uCAsyncTask5);
                                if (this.b == null) {
                                }
                            }
                        }
                        if (runnable == null) {
                            this.a.l.post(runnable);
                        } else {
                            UCAsyncTask.n(this.a);
                        }
                        if (!UCAsyncTask.p.booleanValue()) {
                            this.a.q.add(new Pair(uCAsyncTask == null ? "null" : uCAsyncTask.getClass().getSimpleName(), new Pair(Long.valueOf(uCElapseTime.getMilis()), Long.valueOf(uCElapseTime.getMilisCpu()))));
                            this.a.callback("cost");
                            return;
                        }
                        return;
                    }
                } catch (Throwable unused) {
                }
                uCAsyncTask = null;
                while (true) {
                    synchronized (this.b.d) {
                    }
                }
                if (runnable == null) {
                }
                try {
                    if (!UCAsyncTask.p.booleanValue()) {
                    }
                } catch (Throwable unused2) {
                    return;
                }
            }
        } catch (Throwable unused3) {
        }
        uCElapseTime = null;
        try {
            callback = message.getCallback();
            if (callback instanceof UCAsyncTask) {
            }
            synchronized (this.b.i) {
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }
}
