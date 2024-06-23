package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.a;
import com.uc.webview.export.internal.setup.l;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.p;

/* compiled from: Taobao */
final class r implements ValueCallback<l> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ p c;

    r(p pVar, String str, String str2) {
        this.c = pVar;
        this.a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        Log.d(p.a, "setup callback.");
        lVar2.stop();
        this.c.c.a(a.c.g);
        if (p.a((Boolean) this.c.getOption("o_flag_odex_done"))) {
            p.a(this.a, this.b);
        }
        p.a(this.c, lVar2);
    }
}
