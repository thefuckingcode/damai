package com.uc.webview.export.internal.android;

import com.uc.webview.export.JsResult;

/* compiled from: Taobao */
final class e implements JsResult {
    private android.webkit.JsResult a;

    e(android.webkit.JsResult jsResult) {
        this.a = jsResult;
    }

    @Override // com.uc.webview.export.JsResult
    public final void cancel() {
        this.a.cancel();
    }

    @Override // com.uc.webview.export.JsResult
    public final void confirm() {
        this.a.confirm();
    }
}
