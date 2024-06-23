package com.uc.webview.export.internal.setup;

import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.setup.bh;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class bl implements Callable<Object> {
    final /* synthetic */ bh.a a;

    bl(bh.a aVar) {
        this.a = aVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        h.a(af.a, Integer.valueOf(this.a.a), (String) this.a.e.sdkShellModule.first);
        return Integer.valueOf(ae.e.c);
    }
}
