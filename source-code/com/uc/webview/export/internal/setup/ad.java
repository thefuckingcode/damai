package com.uc.webview.export.internal.setup;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.extension.UCCore;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ad implements ValueCallback<l> {
    final /* synthetic */ o a;

    ad(o oVar) {
        this.a = oVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        Log.d("SdkSetupTask", "mSwitchCB " + lVar2);
        if (lVar2.getLoadedUCM() != null) {
            o.a(this.a, lVar2.getLoadedUCM());
            this.a.f();
            if (!TextUtils.isEmpty((String) this.a.getOption(UCCore.OPTION_UCM_UPD_URL))) {
                this.a.g();
            }
            ValueCallback callback = this.a.getCallback("switch");
            if (callback != null) {
                callback.onReceiveValue(this.a);
            }
        }
    }
}
