package com.loc;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import tb.v13;

/* compiled from: Taobao */
public final class an extends v13 implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
    private static WeakReference<Context> g;
    private Context d;

    static {
        new ThreadFactory() {
            /* class com.loc.an.AnonymousClass2 */
            private final AtomicInteger a = new AtomicInteger(1);

            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "pama#" + this.a.getAndIncrement()) {
                    /* class com.loc.an.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        try {
                            super.run();
                        } catch (Throwable unused) {
                        }
                    }
                };
            }
        };
    }

    private an(Context context) {
        this.d = context;
        try {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            this.a = defaultUncaughtExceptionHandler;
            if (defaultUncaughtExceptionHandler == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.b = true;
                return;
            }
            String obj = defaultUncaughtExceptionHandler.toString();
            if (obj.startsWith("com.amap.apis.utils.core.dynamiccore") || (obj.indexOf("com.amap.api") == -1 && obj.indexOf("com.loc") == -1)) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.b = true;
                return;
            }
            this.b = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized an g(Context context, u1 u1Var) throws k {
        synchronized (an.class) {
            if (u1Var == null) {
                throw new k("sdk info is null");
            } else if (u1Var.a() == null || "".equals(u1Var.a())) {
                throw new k("sdk name is invalid");
            } else {
                try {
                    if (!f.add(Integer.valueOf(u1Var.hashCode()))) {
                        return (an) v13.c;
                    }
                    v13 v13 = v13.c;
                    if (v13 == null) {
                        v13.c = new an(context);
                    } else {
                        v13.b = false;
                    }
                    v13 v132 = v13.c;
                    v132.c(u1Var, v132.b);
                    return (an) v13.c;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void h(u1 u1Var, String str, k kVar) {
        if (kVar != null) {
            j(u1Var, str, kVar.c(), kVar.d(), kVar.e(), kVar.b());
        }
    }

    public static void i(u1 u1Var, String str, String str2, String str3, String str4) {
        j(u1Var, str, str2, str3, "", str4);
    }

    public static void j(u1 u1Var, String str, String str2, String str3, String str4, String str5) {
        try {
            if (v13.c != null) {
                v13.c.b(u1Var, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void k() {
        v13 v13;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        synchronized (an.class) {
            try {
                ExecutorService executorService = e;
                if (executorService != null) {
                    executorService.shutdown();
                }
                v.e();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(v13.c == null || Thread.getDefaultUncaughtExceptionHandler() != (v13 = v13.c) || (uncaughtExceptionHandler = v13.a) == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
                v13.c = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        return;
    }

    public static void l(u1 u1Var, String str, String str2) {
        try {
            v13 v13 = v13.c;
            if (v13 != null) {
                v13.b(u1Var, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void m(Throwable th, String str, String str2) {
        try {
            v13 v13 = v13.c;
            if (v13 != null) {
                v13.d(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void n() {
        WeakReference<Context> weakReference = g;
        if (weakReference == null || weakReference.get() == null) {
            v13 v13 = v13.c;
            if (v13 != null) {
                v13.a();
                return;
            }
            return;
        }
        al.c(g.get());
    }

    /* access modifiers changed from: protected */
    @Override // tb.v13
    public final void a() {
        al.c(this.d);
    }

    /* access modifiers changed from: protected */
    @Override // tb.v13
    public final void b(u1 u1Var, String str, String str2) {
        ao.h(u1Var, this.d, str2, str);
    }

    /* access modifiers changed from: protected */
    @Override // tb.v13
    public final void c(final u1 u1Var, final boolean z) {
        try {
            o0.f().d(new ck() {
                /* class com.loc.an.AnonymousClass1 */

                @Override // com.loc.ck
                public final void a() {
                    try {
                        synchronized (Looper.getMainLooper()) {
                            al.e(u1Var);
                        }
                        if (z) {
                            ao.d(an.this.d);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.v13
    public final void d(Throwable th, int i, String str, String str2) {
        ao.f(this.d, th, i, str, str2);
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            d(th, 0, null, null);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
            if (uncaughtExceptionHandler != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                } catch (Throwable unused) {
                }
                this.a.uncaughtException(thread, th);
            }
        }
    }
}
