package com.alibaba.gaiax.render.view.basic;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class GXImageView$draw$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ Canvas $canvas;
    final /* synthetic */ GXImageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GXImageView$draw$1(GXImageView gXImageView, Canvas canvas) {
        super(0);
        this.this$0 = gXImageView;
        this.$canvas = canvas;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        GXImageView.m92access$draw$s1588574979(this.this$0, this.$canvas);
    }
}
