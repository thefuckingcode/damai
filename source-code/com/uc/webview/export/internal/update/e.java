package com.uc.webview.export.internal.update;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.l;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class e implements ValueCallback<l> {
    final /* synthetic */ Map a;

    e(Map map) {
        this.a = map;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(l lVar) {
        b.a(this.a, "switch", null);
    }
}
