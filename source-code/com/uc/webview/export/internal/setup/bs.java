package com.uc.webview.export.internal.setup;

import android.os.Handler;
import android.os.HandlerThread;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class bs extends HandlerThread {
    final /* synthetic */ UCAsyncTask a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bs(UCAsyncTask uCAsyncTask, String str, int i) {
        super(str, i);
        this.a = uCAsyncTask;
    }

    /* access modifiers changed from: protected */
    public final void onLooperPrepared() {
        Handler unused = this.a.a(getLooper());
    }
}
