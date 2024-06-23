package com.uc.webview.export;

import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: Taobao */
public class WebMessage {
    private String a;
    private WebMessagePort[] b;

    public WebMessage(String str) {
        this.a = str;
    }

    public String getData() {
        return this.a;
    }

    public WebMessagePort[] getPorts() {
        return this.b;
    }

    public WebMessage(String str, WebMessagePort[] webMessagePortArr) {
        this.a = str;
        this.b = webMessagePortArr;
    }
}
