package com.alibaba.gaiax;

import com.alibaba.gaiax.data.GXDataImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/alibaba/gaiax/data/GXDataImpl;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class GXTemplateEngine$data$2 extends Lambda implements Function0<GXDataImpl> {
    final /* synthetic */ GXTemplateEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GXTemplateEngine$data$2(GXTemplateEngine gXTemplateEngine) {
        super(0);
        this.this$0 = gXTemplateEngine;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final GXDataImpl invoke() {
        return new GXDataImpl(this.this$0.k());
    }
}
