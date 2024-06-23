package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.internal.setup.ae;
import com.uc.webview.export.internal.setup.bb;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class bf implements Callable<Object> {
    final /* synthetic */ Context a;
    final /* synthetic */ Integer b;
    final /* synthetic */ bb.a c;

    bf(bb.a aVar, Context context, Integer num) {
        this.c = aVar;
        this.a = context;
        this.b = num;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        g.a(this.c.e, this.a, bt.class.getClassLoader(), this.b.intValue());
        return Integer.valueOf(ae.e.c);
    }
}
