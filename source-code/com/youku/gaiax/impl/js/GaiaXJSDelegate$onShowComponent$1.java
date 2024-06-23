package com.youku.gaiax.impl.js;

import com.youku.gaiax.impl.GaiaXContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXJSDelegate$onShowComponent$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ GaiaXContext $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaXJSDelegate$onShowComponent$1(GaiaXContext gaiaXContext) {
        super(0);
        this.$context = gaiaXContext;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        GaiaXJSDelegate.INSTANCE.onShowComponentTask(this.$context);
    }
}
