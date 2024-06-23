package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.uc.startup.b;
import com.uc.webview.export.internal.utility.n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
public abstract class bu {
    static final Object g = new Object();
    protected bt e;
    protected UCSubSetupTask f;
    HashSet<ae.b> h = new HashSet<>();

    public bu(UCSubSetupTask uCSubSetupTask, bt btVar) {
        this.e = btVar;
        this.f = uCSubSetupTask;
    }

    protected static int d() {
        return ae.d.b;
    }

    public final void a(int i, ae.b bVar, Callable<?> callable, ValueCallback<Object> valueCallback) {
        if (ae.a().a(i, bVar, callable, valueCallback) != null && i != ae.d.b) {
            synchronized (g) {
                this.h.add(bVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    public final void c() {
        b.a(298);
        n.a();
        if (!a()) {
            b();
        }
    }

    public final void e() {
        synchronized (g) {
            if (!this.h.isEmpty()) {
                Iterator<ae.b> it = this.h.iterator();
                while (it.hasNext()) {
                    ae.a().a(it.next());
                }
                this.h.clear();
            }
        }
    }
}
