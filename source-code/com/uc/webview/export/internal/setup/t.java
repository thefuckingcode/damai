package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class t implements ValueCallback<f> {
    final /* synthetic */ o a;

    t(o oVar) {
        this.a = oVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(f fVar) {
        ValueCallback callback = this.a.getCallback(UCCore.EVENT_DELETE_FILE_FINISH);
        if (callback != null) {
            callback.onReceiveValue(this.a);
        }
    }
}
