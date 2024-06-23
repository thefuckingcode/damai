package com.uc.webview.export.business.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.l;
import com.uc.webview.export.utility.SetupTask;
import java.util.Map;

/* compiled from: Taobao */
final class q implements ValueCallback<l> {
    final ValueCallback<SetupTask> a;
    final /* synthetic */ Map.Entry b;
    final /* synthetic */ p c;

    q(p pVar, Map.Entry entry) {
        this.c = pVar;
        this.b = entry;
        this.a = (ValueCallback) entry.getValue();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* bridge */ /* synthetic */ void onReceiveValue(l lVar) {
        this.a.onReceiveValue(this.c);
    }
}
