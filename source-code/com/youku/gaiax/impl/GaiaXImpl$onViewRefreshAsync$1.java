package com.youku.gaiax.impl;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXImpl$onViewRefreshAsync$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ GaiaXContext $gaiaXContext;
    final /* synthetic */ GaiaXImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaXImpl$onViewRefreshAsync$1(GaiaXContext gaiaXContext, GaiaXImpl gaiaXImpl) {
        super(0);
        this.$gaiaXContext = gaiaXContext;
        this.this$0 = gaiaXImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        final View rootView = this.$gaiaXContext.getRootView();
        if (rootView != null) {
            final GXTemplateEngine.e eVar = new GXTemplateEngine.e(this.$gaiaXContext.getParams().getViewPort().b(), this.$gaiaXContext.getParams().getViewPort().a());
            JSONObject data = this.$gaiaXContext.getParams().getData();
            if (data == null) {
                data = new JSONObject();
            }
            final GXTemplateEngine.g gVar = new GXTemplateEngine.g(data);
            GaiaXContext gaiaXContext = this.$gaiaXContext;
            gVar.j(gaiaXContext.getParams());
            gVar.g(gaiaXContext.getGxDataListener());
            gVar.i(gaiaXContext.getParams().getScrollPosition$GaiaX_Android());
            gVar.h(gaiaXContext.getGxEventListener());
            gVar.k(gaiaXContext.getGxTrackListener());
            GaiaXMonitor gaiaXMonitor = GaiaXMonitor.INSTANCE;
            gaiaXMonitor.onStep3A(this.$gaiaXContext);
            GXTemplateEngine.Companion.a().d(rootView, gVar, eVar);
            gaiaXMonitor.onStep3B(this.$gaiaXContext);
            final GaiaXContext gaiaXContext2 = this.$gaiaXContext;
            final GaiaXImpl gaiaXImpl = this.this$0;
            gaiaXContext2.uiTask(new Function0<ur2>() {
                /* class com.youku.gaiax.impl.GaiaXImpl$onViewRefreshAsync$1.AnonymousClass1 */

                @Override // kotlin.jvm.functions.Function0
                public final void invoke() {
                    GaiaXMonitor gaiaXMonitor = GaiaXMonitor.INSTANCE;
                    gaiaXMonitor.onStep4A(gaiaXContext2);
                    GXTemplateEngine.Companion.a().e(rootView, gVar, eVar);
                    gaiaXMonitor.onStep4B(gaiaXContext2);
                    gaiaXImpl.onViewRefreshDispatcher(gaiaXContext2);
                    gaiaXMonitor.onRefreshBAsync(gaiaXContext2);
                }
            });
            return;
        }
        throw new IllegalArgumentException("GXRootView null");
    }
}
