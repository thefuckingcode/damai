package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.p;

/* compiled from: Taobao */
final class c implements ValueCallback<l> {
    final ValueCallback<l> a;
    final /* synthetic */ b b;

    c(b bVar) {
        this.b = bVar;
        this.a = bVar.getCallback(UCCore.LEGACY_EVENT_SETUP);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        Log.d("DecompressSetupTask", "setup callback.");
        ValueCallback<l> valueCallback = this.a;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(lVar2);
        } else if (!p.a(UCSetupTask.getTotalLoadedUCM())) {
            lVar2.stop();
        }
    }
}
