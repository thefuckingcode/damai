package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class z implements ValueCallback<l> {
    final /* synthetic */ o a;

    z(o oVar) {
        this.a = oVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        if (lVar instanceof aq) {
            Log.d("SdkSetupTask", "ShareCoreSdcardSetupTask.EVENT_DELAY_SEARCH_CORE_FILE callback");
            o oVar = this.a;
            oVar.f = o.i(oVar);
        }
    }
}
