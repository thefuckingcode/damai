package com.uc.webview.export.internal.uc.wa;

import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
public final class c implements Runnable {
    final /* synthetic */ a a;

    public c(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        try {
            a aVar = this.a;
            a.b(aVar.a(aVar.k.getSharedPreferences("UC_WA_STAT", 0)));
        } catch (Throwable th) {
            Log.i("SDKWaStat", "generateUUID", th);
        }
    }
}
