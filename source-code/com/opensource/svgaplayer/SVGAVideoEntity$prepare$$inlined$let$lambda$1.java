package com.opensource.svgaplayer;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* compiled from: Taobao */
public final class SVGAVideoEntity$prepare$$inlined$let$lambda$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ Function0 $callback$inlined;
    final /* synthetic */ SVGAVideoEntity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SVGAVideoEntity$prepare$$inlined$let$lambda$1(SVGAVideoEntity sVGAVideoEntity, Function0 function0) {
        super(0);
        this.this$0 = sVGAVideoEntity;
        this.$callback$inlined = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.$callback$inlined.invoke();
    }
}
