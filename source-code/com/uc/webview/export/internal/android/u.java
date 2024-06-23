package com.uc.webview.export.internal.android;

import com.uc.webview.export.extension.RenderProcessGoneDetail;

/* compiled from: Taobao */
final class u extends RenderProcessGoneDetail {
    final /* synthetic */ android.webkit.RenderProcessGoneDetail a;
    final /* synthetic */ t b;

    u(t tVar, android.webkit.RenderProcessGoneDetail renderProcessGoneDetail) {
        this.b = tVar;
        this.a = renderProcessGoneDetail;
    }

    @Override // com.uc.webview.export.extension.RenderProcessGoneDetail
    public final boolean didCrash() {
        return this.a.didCrash();
    }

    @Override // com.uc.webview.export.extension.RenderProcessGoneDetail
    public final int rendererPriorityAtExit() {
        return this.a.rendererPriorityAtExit();
    }
}
