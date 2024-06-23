package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
final class at implements ValueCallback<l> {
    final /* synthetic */ ar a;

    at(ar arVar) {
        this.a = arVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        Log.d(ar.a(), "setup callback.");
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_DELAY_SEARE_CORE_FILE_SETUP_PV);
        lVar.stop();
    }
}
