package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
final class d implements ValueCallback<l> {
    final ValueCallback a;
    final /* synthetic */ b b;

    d(b bVar) {
        this.b = bVar;
        this.a = bVar.getCallback("switch");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        Log.d("DecompressSetupTask", "switch callback.");
        ValueCallback valueCallback = this.a;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(lVar2);
        }
    }
}
