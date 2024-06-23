package com.taomai.android.h5container.webview;

import android.taobao.windvane.util.TaoLog;
import android.webkit.ValueCallback;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class TaoMaiWebChromeClient$handleOnShowFileChooser$2 implements Runnable {
    final /* synthetic */ ValueCallback $filePathCallback;

    TaoMaiWebChromeClient$handleOnShowFileChooser$2(ValueCallback valueCallback) {
        this.$filePathCallback = valueCallback;
    }

    public final void run() {
        TaoLog.d("TaoMaiWebChromeClient", " onShowFileChooser permission denied");
        this.$filePathCallback.onReceiveValue(null);
    }
}
