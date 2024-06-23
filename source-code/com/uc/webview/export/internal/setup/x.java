package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.j;

/* compiled from: Taobao */
final class x implements ValueCallback<l> {
    final /* synthetic */ w a;

    x(w wVar) {
        this.a = wVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        Log.d("SdkSetupTask", "ShareCoreSdcardSetupTask exception " + lVar);
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_UPD_SC_INIT_EXCEPTION_PV);
        try {
            j.f(this.a.a.getContext().getApplicationContext());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
