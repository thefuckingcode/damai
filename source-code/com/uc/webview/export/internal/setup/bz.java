package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.p;

/* compiled from: Taobao */
final class bz implements ValueCallback<l> {
    final /* synthetic */ by a;

    bz(by byVar) {
        this.a = byVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        Log.d(by.a, "setup callback.");
        if (!p.a(UCSetupTask.getTotalLoadedUCM())) {
            lVar2.stop();
        }
    }
}
