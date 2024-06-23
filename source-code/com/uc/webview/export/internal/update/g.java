package com.uc.webview.export.internal.update;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class g implements ValueCallback<Object[]> {
    g() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(Object[] objArr) {
        Object[] objArr2 = objArr;
        if (((Integer) objArr2[0]).intValue() == 8) {
            SDKFactory.p.put(IWaStat.VIDEO_ERROR_CODE_VERIFY, (Integer) objArr2[1]);
        }
    }
}
