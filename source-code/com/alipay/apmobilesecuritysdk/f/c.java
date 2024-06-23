package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;

/* compiled from: Taobao */
public final class c implements Runnable {
    public final /* synthetic */ b a;

    public c(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        try {
            Process.setThreadPriority(0);
            while (!b.a(this.a).isEmpty()) {
                Runnable runnable = (Runnable) b.a(this.a).get(0);
                b.a(this.a).remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            b.b(this.a);
            throw th;
        }
        b.b(this.a);
    }
}
