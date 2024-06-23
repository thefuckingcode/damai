package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.internal.interfaces.IWaStat;

/* compiled from: Taobao */
final class y implements ValueCallback<l> {
    final /* synthetic */ w a;

    y(w wVar) {
        this.a = wVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        Log.d("SdkSetupTask", "ShareCoreSdcardSetupTask success " + lVar);
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_UPD_SC_INIT_SUCCESS_PV);
    }
}
