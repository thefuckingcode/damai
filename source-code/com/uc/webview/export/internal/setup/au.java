package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.j;

/* compiled from: Taobao */
final class au implements ValueCallback<l> {
    final /* synthetic */ ar a;

    au(ar arVar) {
        this.a = arVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        String a2 = ar.a();
        Log.d(a2, "exception " + lVar);
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_DELAY_SEARE_CORE_FILE_EXCEPTION_PV);
        try {
            j.f(this.a.getContext().getApplicationContext());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
