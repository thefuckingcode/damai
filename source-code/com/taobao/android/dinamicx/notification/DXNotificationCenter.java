package com.taobao.android.dinamicx.notification;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.DXEngineConfig;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.notification.DXSignalProduce;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.a;
import java.util.ArrayList;
import java.util.List;
import tb.c00;
import tb.ry;
import tb.vx;
import tb.vy;
import tb.w00;

/* compiled from: Taobao */
public class DXNotificationCenter implements DXSignalProduce.SignalReceiver {
    IDXNotificationListener a;
    boolean b = false;
    int c;
    int d;
    int e;
    List<DXTemplateItem> f;
    List<DXTemplateItem> g;
    List<w00> h;
    List<IDXNotificationListener> i = new ArrayList();

    public DXNotificationCenter(@NonNull DXEngineConfig dXEngineConfig) {
        int h2 = dXEngineConfig.h();
        this.c = h2;
        int i2 = DXSignalProduce.f;
        this.d = (h2 < i2 ? i2 : h2) / i2;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
    }

    private void a(w00 w00) {
        if (w00 != null && w00.a != null) {
            this.h.add(w00);
        }
    }

    private boolean c() {
        return this.f.size() > 0 || this.g.size() > 0 || this.h.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
    }

    public synchronized void d(a aVar) {
        if (aVar != null) {
            if (aVar.b() && aVar.a() != null) {
                this.f.add(aVar.a());
            } else if (aVar.a() != null) {
                this.g.add(aVar.a());
            }
        }
    }

    public synchronized void e(List<DXTemplateItem> list, List<DXTemplateItem> list2) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.f.addAll(list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (list2 != null && list2.size() > 0) {
            this.g.addAll(list2);
        }
    }

    public synchronized void f(w00 w00) {
        if (w00 != null) {
            if (w00.a != null) {
                a(w00);
            }
        }
    }

    public void g(IDXNotificationListener iDXNotificationListener) {
        if (iDXNotificationListener != null) {
            this.a = iDXNotificationListener;
            if (!this.b) {
                DXSignalProduce.e().g(this);
                this.b = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void h() {
        if (c()) {
            final vy vyVar = new vy(this.f, this.g, this.h);
            b();
            c00.m(new Runnable() {
                /* class com.taobao.android.dinamicx.notification.DXNotificationCenter.AnonymousClass1 */

                public void run() {
                    IDXNotificationListener iDXNotificationListener = DXNotificationCenter.this.a;
                    if (iDXNotificationListener != null) {
                        iDXNotificationListener.onNotificationListener(vyVar);
                        try {
                            List<IDXNotificationListener> list = DXNotificationCenter.this.i;
                            if (list != null && list.size() > 0) {
                                for (int i = 0; i < DXNotificationCenter.this.i.size(); i++) {
                                    DXNotificationCenter.this.i.get(i).onNotificationListener(vyVar);
                                }
                            }
                        } catch (Throwable th) {
                            vx.b(th);
                            DXAppMonitor.q(ry.TAG, null, "Signal", "Signal_Exception", e.DX_ERROR_CODE_SIGNAL_EXCEPTION_CRASH_2, vx.a(th));
                        }
                    }
                }
            });
        }
    }

    @Override // com.taobao.android.dinamicx.notification.DXSignalProduce.SignalReceiver
    public void onReceiver() {
        if (this.a == null || this.e != this.d) {
            this.e++;
            return;
        }
        h();
        this.e = 0;
    }
}
