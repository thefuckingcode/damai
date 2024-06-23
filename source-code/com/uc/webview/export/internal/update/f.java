package com.uc.webview.export.internal.update;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.l;
import com.uc.webview.export.internal.utility.Log;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class f implements ValueCallback<l> {
    final /* synthetic */ String a;
    final /* synthetic */ Map b;

    f(String str, Map map) {
        this.a = str;
        this.b = map;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        l lVar2 = lVar;
        Log.d("UpdateUtils", "doUpdateUCCore setuptask exception url:" + this.a, lVar2.getException());
        b.a(this.b, "failed", lVar2.getException());
    }
}
