package com.uc.webview.export.internal.android;

import android.annotation.TargetApi;
import android.os.Handler;
import com.uc.webview.export.WebMessage;
import com.uc.webview.export.WebMessagePort;

@TargetApi(23)
/* compiled from: Taobao */
public final class n extends WebMessagePort {
    android.webkit.WebMessagePort a;

    n(android.webkit.WebMessagePort webMessagePort) {
        this.a = webMessagePort;
    }

    @Override // com.uc.webview.export.WebMessagePort
    public final void close() {
        this.a.close();
    }

    @Override // com.uc.webview.export.WebMessagePort
    public final void postMessage(WebMessage webMessage) {
    }

    @Override // com.uc.webview.export.WebMessagePort
    public final void setWebMessageCallback(WebMessagePort.WebMessageCallback webMessageCallback) {
        setWebMessageCallback(webMessageCallback, null);
    }

    @Override // com.uc.webview.export.WebMessagePort
    public final void setWebMessageCallback(WebMessagePort.WebMessageCallback webMessageCallback, Handler handler) {
        this.a.setWebMessageCallback(new o(this));
    }
}
