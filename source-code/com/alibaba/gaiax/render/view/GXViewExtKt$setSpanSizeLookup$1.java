package com.alibaba.gaiax.render.view;

import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/alibaba/gaiax/render/view/GXViewExtKt$setSpanSizeLookup$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXViewExtKt$setSpanSizeLookup$1 extends GridLayoutManager.SpanSizeLookup {
    final /* synthetic */ int a;
    final /* synthetic */ int b;

    GXViewExtKt$setSpanSizeLookup$1(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int i) {
        if (this.a - 1 == i) {
            return this.b;
        }
        return 1;
    }
}
