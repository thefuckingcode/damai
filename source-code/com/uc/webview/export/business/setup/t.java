package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.a;
import com.uc.webview.export.internal.setup.l;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
final class t implements ValueCallback<l> {
    final /* synthetic */ p a;

    t(p pVar) {
        this.a = pVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        String str = p.a;
        Log.d(str, "exception " + lVar2);
        this.a.c.a(a.c.h);
        p.a(this.a, lVar2);
    }
}
