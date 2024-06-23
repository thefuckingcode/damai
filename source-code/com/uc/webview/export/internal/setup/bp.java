package com.uc.webview.export.internal.setup;

import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.setup.bh;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class bp implements Callable<Object> {
    final /* synthetic */ bh.a a;

    bp(bh.a aVar) {
        this.a = aVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        bh.a aVar = this.a;
        bt btVar = aVar.e;
        g.b(btVar, af.a, btVar.mSdkShellClassLoader, aVar.a);
        return Integer.valueOf(ae.e.c);
    }
}
