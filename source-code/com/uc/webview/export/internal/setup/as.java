package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
final class as implements ValueCallback<l> {
    final /* synthetic */ ar a;

    as(ar arVar) {
        this.a = arVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        Log.d(ar.a(), "switch callback do nothing.");
    }
}
