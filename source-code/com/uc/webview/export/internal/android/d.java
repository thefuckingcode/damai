package com.uc.webview.export.internal.android;

import com.uc.webview.export.JsPromptResult;

/* compiled from: Taobao */
final class d implements JsPromptResult {
    private android.webkit.JsPromptResult a;

    d(android.webkit.JsPromptResult jsPromptResult) {
        this.a = jsPromptResult;
    }

    @Override // com.uc.webview.export.JsResult, com.uc.webview.export.JsPromptResult
    public final void cancel() {
        this.a.cancel();
    }

    @Override // com.uc.webview.export.JsResult, com.uc.webview.export.JsPromptResult
    public final void confirm() {
        this.a.confirm();
    }

    @Override // com.uc.webview.export.JsPromptResult
    public final void confirm(String str) {
        this.a.confirm(str);
    }
}
