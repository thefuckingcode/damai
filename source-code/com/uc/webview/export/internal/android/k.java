package com.uc.webview.export.internal.android;

import android.net.Uri;
import android.webkit.ValueCallback;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class k implements ValueCallback<Uri[]> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ i b;

    k(i iVar, ValueCallback valueCallback) {
        this.b = iVar;
        this.a = valueCallback;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* bridge */ /* synthetic */ void onReceiveValue(Uri[] uriArr) {
        Uri[] uriArr2 = uriArr;
        this.a.onReceiveValue(uriArr2 == null ? null : uriArr2[0]);
    }
}
