package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.a;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
final class i implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ a a;

    i(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(BaseSetupTask baseSetupTask) {
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        String str = a.a;
        Log.d(str, "mSuccessCallback " + baseSetupTask2.toString() + " init type: " + baseSetupTask2.getInitType());
        this.a.h.f = String.valueOf(this.a.h.a.getMilis());
        this.a.h.g = String.valueOf(this.a.h.a.getMilisCpu());
        if (SDKFactory.e() != 2) {
            a.e(this.a).a(a.d.h);
            a.a(this.a, UCCore.EVENT_INIT_CORE_SUCCESS, baseSetupTask2);
            return;
        }
        a.e(this.a).a(a.d.i);
    }
}
