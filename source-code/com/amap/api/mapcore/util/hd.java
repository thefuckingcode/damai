package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class hd extends ha implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
    private static WeakReference<Context> g;
    private static final ThreadFactory h = new ThreadFactory() {
        /* class com.amap.api.mapcore.util.hd.AnonymousClass2 */
        private final AtomicInteger a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.a.getAndIncrement());
        }
    };
    private Context d;
    private List<a> i;

    /* compiled from: Taobao */
    public interface a {
        void a(Thread thread, Throwable th);
    }

    private hd(Context context, gm gmVar) {
        this.d = context;
        f();
    }

    public static synchronized void b() {
        ha haVar;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        synchronized (hd.class) {
            try {
                ExecutorService executorService = e;
                if (executorService != null) {
                    executorService.shutdown();
                }
                hy.a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(ha.a == null || Thread.getDefaultUncaughtExceptionHandler() != (haVar = ha.a) || (uncaughtExceptionHandler = haVar.b) == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
                ha.a = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return;
    }

    public static void c() {
        WeakReference<Context> weakReference = g;
        if (weakReference == null || weakReference.get() == null) {
            ha haVar = ha.a;
            if (haVar != null) {
                haVar.a();
                return;
            }
            return;
        }
        hb.a(g.get());
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0024 */
    public static synchronized ExecutorService d() {
        ExecutorService executorService;
        synchronized (hd.class) {
            ExecutorService executorService2 = e;
            if (executorService2 == null || executorService2.isShutdown()) {
                e = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), h);
            }
            executorService = e;
        }
        return executorService;
    }

    public static synchronized hd e() {
        hd hdVar;
        synchronized (hd.class) {
            hdVar = (hd) ha.a;
        }
        return hdVar;
    }

    private void f() {
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.b = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
                return;
            }
            String obj = defaultUncaughtExceptionHandler.toString();
            if (obj.startsWith("com.amap.apis.utils.core.dynamiccore") || (obj.indexOf("com.amap.api") == -1 && obj.indexOf("com.loc") == -1)) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.c = true;
                return;
            }
            this.c = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th);
        if (th != null) {
            a(th, 0, null, null);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
            if (uncaughtExceptionHandler != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                } catch (Throwable unused) {
                }
                this.b.uncaughtException(thread, th);
            }
        }
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                g = new WeakReference<>(context.getApplicationContext());
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized hd a(Context context, gm gmVar) throws gb {
        synchronized (hd.class) {
            if (gmVar == null) {
                throw new gb("sdk info is null");
            } else if (gmVar.a() == null || "".equals(gmVar.a())) {
                throw new gb("sdk name is invalid");
            } else {
                try {
                    if (!f.add(Integer.valueOf(gmVar.hashCode()))) {
                        return (hd) ha.a;
                    }
                    ha haVar = ha.a;
                    if (haVar == null) {
                        ha.a = new hd(context, gmVar);
                    } else {
                        haVar.c = false;
                    }
                    ha haVar2 = ha.a;
                    haVar2.a(context, gmVar, haVar2.c);
                    return (hd) ha.a;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void c(Throwable th, String str, String str2) {
        try {
            ha haVar = ha.a;
            if (haVar != null) {
                haVar.a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context, gm gmVar, String str, String str2, String str3) {
        he.a(context, gmVar, str, 1, str2, str3);
    }

    public void b(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                a(th, 1, str, str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ha
    public void a(gm gmVar, String str, String str2) {
        he.a(gmVar, this.d, str2, str);
    }

    public static void b(gm gmVar, String str, String str2) {
        try {
            ha haVar = ha.a;
            if (haVar != null) {
                haVar.a(gmVar, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ha
    public void a(Throwable th, int i2, String str, String str2) {
        he.a(this.d, th, i2, str, str2);
    }

    public static void a(Context context, gm gmVar, String str, String str2, String str3) {
        he.a(context, gmVar, str, 0, str2, str3);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ha
    public void a() {
        hb.a(this.d);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.ha
    public void a(final Context context, final gm gmVar, final boolean z) {
        try {
            ExecutorService d2 = d();
            if (d2 == null) {
                return;
            }
            if (!d2.isShutdown()) {
                d2.submit(new Runnable() {
                    /* class com.amap.api.mapcore.util.hd.AnonymousClass1 */

                    public void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                new hl(context, true).a(gmVar);
                            }
                            if (z) {
                                he.a(hd.this.d);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(gm gmVar, String str, String str2, String str3, String str4, String str5) {
        try {
            if (ha.a != null) {
                ha.a.a(gmVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(gm gmVar, String str, gb gbVar) {
        if (gbVar != null) {
            a(gmVar, str, gbVar.c(), gbVar.d(), gbVar.e(), gbVar.b());
        }
    }

    private void a(Thread thread, Throwable th) {
        int i2 = 0;
        while (i2 < this.i.size() && i2 < 10) {
            try {
                a aVar = this.i.get(i2);
                if (aVar != null) {
                    aVar.a(thread, th);
                }
                i2++;
            } catch (Throwable unused) {
                return;
            }
        }
    }
}
