package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.BaseSetupTask;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.p;

/* compiled from: Taobao */
final class k implements ValueCallback<BaseSetupTask> {
    final /* synthetic */ a a;

    k(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(BaseSetupTask baseSetupTask) {
        BaseSetupTask baseSetupTask2 = baseSetupTask;
        String str = a.a;
        Log.d(str, "mDieDelegateCallback " + baseSetupTask2.toString() + " init type: " + baseSetupTask2.getInitType());
        a.g(this.a);
        a.a(this.a, baseSetupTask2.getInitType());
        if (p.h()) {
            IWaStat.WaStat.saveData(true);
            IWaStat.WaStat.upload();
        }
        String str2 = a.a;
        Log.d(str2, "options: " + this.a.mOptions);
    }
}
