package com.alibaba.gaiax.render.view;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/alibaba/gaiax/render/view/GXViewExtKt$setGridContainerDirection$target$1", "Landroidx/recyclerview/widget/GridLayoutManager;", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXViewExtKt$setGridContainerDirection$target$1 extends GridLayoutManager {
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GXViewExtKt$setGridContainerDirection$target$1(int i, boolean z, int i2, Context context) {
        super(context, i2, i, false);
        this.a = i;
        this.b = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public boolean canScrollHorizontally() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.LinearLayoutManager
    public boolean canScrollVertically() {
        return this.a == 1 && this.b;
    }
}
