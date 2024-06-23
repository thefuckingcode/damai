package com.alibaba.gaiax.data;

import com.alibaba.gaiax.data.GXDataImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/alibaba/gaiax/data/GXDataImpl$a;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class GXDataImpl$templateInfoSource$2 extends Lambda implements Function0<GXDataImpl.a> {
    final /* synthetic */ GXDataImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GXDataImpl$templateInfoSource$2(GXDataImpl gXDataImpl) {
        super(0);
        this.this$0 = gXDataImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final GXDataImpl.a invoke() {
        return new GXDataImpl.a(this.this$0.a());
    }
}
