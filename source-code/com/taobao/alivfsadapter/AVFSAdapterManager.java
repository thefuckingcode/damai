package com.taobao.alivfsadapter;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.taobao.alivfsadapter.database.alidb.a;
import com.taobao.android.alivfsdb.AliDBLogger;
import tb.e0;
import tb.f0;
import tb.j0;
import tb.k0;
import tb.l0;

/* compiled from: Taobao */
public class AVFSAdapterManager {
    private static volatile AVFSAdapterManager f;
    private boolean a = false;
    private AVFSSDKAppMonitor b;
    private final Handler c = new Handler(Looper.getMainLooper());
    private Application d;
    private final Runnable e = new Runnable() {
        /* class com.taobao.alivfsadapter.AVFSAdapterManager.AnonymousClass1 */

        public void run() {
            synchronized (AVFSAdapterManager.this.e) {
                AVFSAdapterManager.this.d(f0.a(), null, null);
                AVFSAdapterManager.this.e.notify();
            }
        }
    };

    public static synchronized AVFSAdapterManager g() {
        AVFSAdapterManager aVFSAdapterManager;
        synchronized (AVFSAdapterManager.class) {
            if (f == null && f == null) {
                f = new AVFSAdapterManager();
            }
            aVFSAdapterManager = f;
        }
        return aVFSAdapterManager;
    }

    private void h(Application application, AVFSSDKAppMonitor aVFSSDKAppMonitor, j0 j0Var) {
        this.d = application;
        if (aVFSSDKAppMonitor == null) {
            try {
                this.b = new l0();
            } catch (ClassNotFoundException unused) {
            }
        } else {
            this.b = aVFSSDKAppMonitor;
        }
        if (j0Var == null) {
            try {
                Class.forName("com.taobao.android.alivfsdb.AliDB");
                new e0();
                AliDBLogger.logger = new a();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                new k0();
            }
        }
        this.a = this.d != null;
        Log.d("AVFSAdapterManager", "- AVFSAdapterManager initialize: mInitialized=" + this.a);
    }

    public void b() {
        if (!i()) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                this.c.post(this.e);
                synchronized (this.e) {
                    try {
                        this.e.wait();
                    } catch (IllegalStateException unused) {
                        this.a = false;
                        return;
                    } catch (InterruptedException unused2) {
                        this.a = false;
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            }
            d(f0.a(), null, null);
        }
    }

    public void c(Application application) {
        d(application, null, null);
    }

    public synchronized void d(Application application, AVFSSDKAppMonitor aVFSSDKAppMonitor, j0 j0Var) {
        h(application, aVFSSDKAppMonitor, j0Var);
    }

    public Application e() {
        b();
        Application application = this.d;
        if (application != null) {
            return application;
        }
        throw new RuntimeException("AVFSAdapterManager not initialized!");
    }

    public AVFSSDKAppMonitor f() {
        b();
        return this.b;
    }

    public boolean i() {
        return this.a;
    }
}
