package com.uc.webview.export.internal;

import android.content.Context;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class b implements Runnable {
    final /* synthetic */ Context a;

    b(Context context) {
        this.a = context;
    }

    public final void run() {
        SDKFactory.f(this.a);
    }
}
