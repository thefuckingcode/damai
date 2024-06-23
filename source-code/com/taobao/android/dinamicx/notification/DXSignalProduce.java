package com.taobao.android.dinamicx.notification;

import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import tb.c00;
import tb.ft;
import tb.v00;
import tb.vx;

/* compiled from: Taobao */
public class DXSignalProduce {
    public static int f = 50;
    CopyOnWriteArrayList<WeakReference<DXNotificationCenter>> a;
    CopyOnWriteArrayList<WeakReference<ft>> b;
    CopyOnWriteArrayList<WeakReference<a>> c;
    private int d;
    int e;

    /* compiled from: Taobao */
    public interface SignalReceiver {
        void onReceiver();
    }

    /* compiled from: Taobao */
    private static final class a {
        private static final DXSignalProduce a = new DXSignalProduce();
    }

    public static DXSignalProduce e() {
        return a.a;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h() {
        int i = 0;
        while (i < this.b.size()) {
            ft ftVar = this.b.get(i).get();
            if (ftVar != null) {
                ftVar.onReceiver();
                i++;
            } else {
                this.b.remove(i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i() {
        int i = 0;
        while (i < this.a.size()) {
            DXNotificationCenter dXNotificationCenter = this.a.get(i).get();
            if (dXNotificationCenter != null) {
                dXNotificationCenter.onReceiver();
                i++;
            } else {
                this.a.remove(i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j() {
        int i = 0;
        while (i < this.c.size()) {
            a aVar = this.c.get(i).get();
            if (aVar != null) {
                aVar.onReceiver();
                i++;
            } else {
                this.c.remove(i);
            }
        }
    }

    public void f(ft ftVar) {
        if (ftVar != null) {
            this.b.add(new WeakReference<>(ftVar));
        }
    }

    public void g(DXNotificationCenter dXNotificationCenter) {
        if (dXNotificationCenter != null) {
            this.a.add(new WeakReference<>(dXNotificationCenter));
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        c00.r().scheduleAtFixedRate(new Runnable() {
            /* class com.taobao.android.dinamicx.notification.DXSignalProduce.AnonymousClass1 */

            public void run() {
                try {
                    DXSignalProduce.this.i();
                    DXSignalProduce.this.h();
                    DXSignalProduce.this.j();
                } catch (Throwable th) {
                    DXSignalProduce dXSignalProduce = DXSignalProduce.this;
                    if (dXSignalProduce.e < dXSignalProduce.d) {
                        e eVar = new e(v00.DB_NAME);
                        e.a aVar = new e.a("Signal", "Signal_Exception", e.DX_ERROR_CODE_SIGNAL_EXCEPTION_CRASH);
                        aVar.e = vx.a(th);
                        eVar.c.add(aVar);
                        DXAppMonitor.n(eVar);
                        DXSignalProduce.this.e++;
                    }
                }
            }
        }, 0, (long) f, TimeUnit.MILLISECONDS);
    }

    private DXSignalProduce() {
        this.d = 10;
        this.a = new CopyOnWriteArrayList<>();
        this.b = new CopyOnWriteArrayList<>();
        this.c = new CopyOnWriteArrayList<>();
        k();
    }
}
