package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.l;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.p;

/* compiled from: Taobao */
final class s implements ValueCallback<l> {
    final /* synthetic */ p a;

    s(p pVar) {
        this.a = pVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        String str = p.a;
        Log.d(str, "die " + lVar2);
        IWaStat.WaStat.stat(IWaStat.BUSINESS_DECOMPRESS_AND_ODEX, Long.toString(this.a.c.a), 1);
        if (p.h()) {
            IWaStat.WaStat.saveData();
            IWaStat.WaStat.upload();
        }
        p.a(this.a, lVar2);
    }
}
