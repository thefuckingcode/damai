package com.uc.sandboxExport;

import android.os.HandlerThread;
import com.uc.sandboxExport.PreStartup;

/* compiled from: Taobao */
final class g extends HandlerThread {
    final /* synthetic */ PreStartup.b a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    g(PreStartup.b bVar, String str) {
        super(str, 0);
        this.a = bVar;
    }

    /* access modifiers changed from: protected */
    public final void onLooperPrepared() {
        synchronized (this.a.a) {
            this.a.a.notify();
        }
    }
}
