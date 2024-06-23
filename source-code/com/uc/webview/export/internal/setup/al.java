package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.Log;
import tb.jl1;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class al implements ValueCallback<CALLBACK_TYPE> {
    final /* synthetic */ aj a;

    al(aj ajVar) {
        this.a = ajVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = aj.d;
        Log.d(str, ".dieCallback MCE(" + this.a.g.exists() + "," + this.a.f.exists() + "," + this.a.h.exists() + jl1.BRACKET_END_STR);
        this.a.a();
        this.a.e.clear();
    }
}
