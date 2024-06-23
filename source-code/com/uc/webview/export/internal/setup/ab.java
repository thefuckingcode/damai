package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class ab implements ValueCallback<l> {
    final /* synthetic */ String a;
    final /* synthetic */ o b;

    ab(o oVar, String str) {
        this.b = oVar;
        this.a = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        try {
            new aw();
            aw.a(this.b.getContext().getApplicationContext(), this.a, ((by) lVar2).c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
