package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ac implements ValueCallback<l> {
    final ValueCallback a;
    final /* synthetic */ o b;

    ac(o oVar) {
        this.b = oVar;
        this.a = oVar.getCallback(UCCore.EVENT_DOWNLOAD_EXCEPTION);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        if (this.a != null) {
            if (lVar2.getExtraException() != null) {
                this.b.setExtraException(lVar2.getExtraException());
            }
            this.a.onReceiveValue(this.b);
        }
    }
}
