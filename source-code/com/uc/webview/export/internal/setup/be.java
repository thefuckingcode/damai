package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.setup.bb;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
final class be implements Callable<Object> {
    final /* synthetic */ Context a;
    final /* synthetic */ boolean b;
    final /* synthetic */ bb.a c;

    be(bb.a aVar, Context context, boolean z) {
        this.c = aVar;
        this.a = context;
        this.b = z;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        Context context = this.a;
        bb.a aVar = this.c;
        boolean a2 = g.a(context, aVar.e, aVar.f.mOptions);
        bb.a aVar2 = this.c;
        g.a(aVar2.e, aVar2.f.mOptions, a2, this.b, true);
        return Integer.valueOf(ae.e.c);
    }
}
