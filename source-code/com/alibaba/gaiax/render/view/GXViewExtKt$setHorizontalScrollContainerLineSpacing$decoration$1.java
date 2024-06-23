package com.alibaba.gaiax.render.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/alibaba/gaiax/render/view/GXViewExtKt$setHorizontalScrollContainerLineSpacing$decoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXViewExtKt$setHorizontalScrollContainerLineSpacing$decoration$1 extends RecyclerView.ItemDecoration {
    final /* synthetic */ int a;

    GXViewExtKt$setHorizontalScrollContainerLineSpacing$decoration$1(int i) {
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        k21.i(rect, "outRect");
        k21.i(view, "view");
        k21.i(recyclerView, "parent");
        k21.i(state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getAdapter() != null) {
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            k21.f(adapter);
            if (childLayoutPosition != adapter.getItemCount() - 1) {
                rect.right = this.a;
            }
        }
    }
}
