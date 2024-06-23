package com.youku.gaiax.js;

import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.core.GaiaXEngine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/youku/gaiax/js/core/GaiaXEngine;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXJS$startEngine$1$1 extends Lambda implements Function0<GaiaXEngine> {
    final /* synthetic */ GaiaXJS this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaXJS$startEngine$1$1(GaiaXJS gaiaXJS) {
        super(0);
        this.this$0 = gaiaXJS;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final GaiaXEngine invoke() {
        return GaiaXJS.access$createEngine(this.this$0, GaiaXJS.GaiaXJSType.QuickJS);
    }
}
