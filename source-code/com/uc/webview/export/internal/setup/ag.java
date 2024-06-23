package com.uc.webview.export.internal.setup;

import com.uc.webview.export.internal.interfaces.IWaStat;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ag implements Runnable {
    final /* synthetic */ int a;

    ag(int i) {
        this.a = i;
    }

    public final void run() {
        IWaStat.WaStat.stat("core_sust", "st_" + this.a + ":1", 0);
    }
}
