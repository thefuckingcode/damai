package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.business.a;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
final class j implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ a a;

    j(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(BaseSetupTask baseSetupTask) {
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        String str = a.a;
        Log.d(str, "mExceptionCallback " + baseSetupTask2.getException().errCode() + ":" + baseSetupTask2.getException().getMessage());
        a.e(this.a).a(a.d.g);
        baseSetupTask2.getException().errCode();
        a.b();
        a.a(this.a, "exception", baseSetupTask2);
    }
}
