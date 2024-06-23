package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.a;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
final class l implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ a a;

    l(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(BaseSetupTask baseSetupTask) {
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        String str = a.a;
        Log.d(str, "mNewCoreDecompressAndODex " + baseSetupTask2.toString());
        a.a(this.a, UCCore.LEGACY_EVENT_SETUP, baseSetupTask2);
        this.a.h.d = String.valueOf(this.a.h.a.getMilis());
        this.a.h.e = String.valueOf(this.a.h.a.getMilisCpu());
        a.e(this.a).a(a.d.e);
    }
}
