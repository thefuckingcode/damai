package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class bv implements ValueCallback {
    bv() {
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        SDKFactory.j = false;
        SDKFactory.g();
    }
}
