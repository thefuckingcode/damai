package com.youku.gaiax.impl;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.youku.gaiax.impl.utils.ExceptionUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;
import tb.wq0;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXImpl$onViewCreateAsync$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ GaiaXContext $gaiaXContext;
    final /* synthetic */ GaiaXImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaXImpl$onViewCreateAsync$1(GaiaXContext gaiaXContext, GaiaXImpl gaiaXImpl) {
        super(0);
        this.$gaiaXContext = gaiaXContext;
        this.this$0 = gaiaXImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        if (this.$gaiaXContext.getParams().isReleased$GaiaX_Android()) {
            ExceptionUtils.INSTANCE.throwParamsReleaseAlarm();
            return;
        }
        Context context = this.$gaiaXContext.getParams().getContext();
        if (context != null) {
            GXTemplateEngine.h hVar = new GXTemplateEngine.h(context, this.$gaiaXContext.getParams().getTemplateBiz(), this.$gaiaXContext.getParams().getTemplateId());
            hVar.g(this.$gaiaXContext.getParams().getForceLocalTemplate());
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
            gaiaXMonitor.onStep1A(this.$gaiaXContext);
            GXTemplateEngine.a aVar = GXTemplateEngine.Companion;
            wq0 i = aVar.a().i(hVar, eVar, this.$gaiaXContext.getParams().getChildVisualNestTemplateNode());
            if (i != null) {
                this.$gaiaXContext.setGXTemplateContext(i);
                gaiaXMonitor.onStep1B(this.$gaiaXContext);
                gaiaXMonitor.onStep2A(this.$gaiaXContext);
                final View j = aVar.a().j(i);
                if (j != null) {
                    gaiaXMonitor.onStep2B(this.$gaiaXContext);
                    gaiaXMonitor.onStep3A(this.$gaiaXContext);
                    aVar.a().d(j, gVar, eVar);
                    gaiaXMonitor.onStep3B(this.$gaiaXContext);
                    final GaiaXContext gaiaXContext2 = this.$gaiaXContext;
                    final GaiaXImpl gaiaXImpl = this.this$0;
                    gaiaXContext2.uiTask(new Function0<ur2>() {
                        /* class com.youku.gaiax.impl.GaiaXImpl$onViewCreateAsync$1.AnonymousClass1 */

                        @Override // kotlin.jvm.functions.Function0
                        public final void invoke() {
                            GaiaXMonitor gaiaXMonitor = GaiaXMonitor.INSTANCE;
                            gaiaXMonitor.onStep4A(gaiaXContext2);
                            GXTemplateEngine.Companion.a().e(j, gVar, eVar);
                            gaiaXMonitor.onStep4B(gaiaXContext2);
                            gaiaXImpl.onViewCreateDispatcher(gaiaXContext2, j);
                            gaiaXMonitor.onCreateBAsync(gaiaXContext2);
                        }
                    });
                    return;
                }
                throw new IllegalArgumentException("GXView create fail");
            }
            throw new IllegalArgumentException("GXTemplateContext create fail");
        }
        throw new IllegalArgumentException("context null");
    }
}
