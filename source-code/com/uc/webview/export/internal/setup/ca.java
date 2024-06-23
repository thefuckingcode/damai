package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
final class ca implements ValueCallback<l> {
    final ValueCallback a;
    final /* synthetic */ by b;

    ca(by byVar) {
        this.b = byVar;
        this.a = byVar.getCallback("switch");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        Log.d(by.a, "switch callback.");
        ValueCallback valueCallback = this.a;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(lVar2);
        }
    }
}
