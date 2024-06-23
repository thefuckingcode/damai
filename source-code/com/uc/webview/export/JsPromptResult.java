package com.uc.webview.export;

import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: Taobao */
public interface JsPromptResult extends JsResult {
    @Override // com.uc.webview.export.JsResult
    void cancel();

    @Override // com.uc.webview.export.JsResult
    void confirm();

    void confirm(String str);
}
