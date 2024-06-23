package com.youku.gaiax.provider.module.js;

import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.impl.GaiaXContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class JSDelegate$refreshPage$1$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ GaiaXContext $context;
    final /* synthetic */ boolean $noRequest;
    final /* synthetic */ boolean $resetOffset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JSDelegate$refreshPage$1$1(GaiaXContext gaiaXContext, boolean z, boolean z2) {
        super(0);
        this.$context = gaiaXContext;
        this.$resetOffset = z;
        this.$noRequest = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        GaiaX.IHostMessage message = this.$context.getParams().getMessage();
        if (message != null) {
            JSONObject jSONObject = new JSONObject();
            boolean z = this.$resetOffset;
            boolean z2 = this.$noRequest;
            jSONObject.put((Object) "resetOffset", (Object) Boolean.valueOf(z));
            jSONObject.put((Object) "noRequest", (Object) Boolean.valueOf(z2));
            ur2 ur2 = ur2.INSTANCE;
            message.onMessage("GAIAX_JS_REFRESH_PAGE", jSONObject);
        }
    }
}
