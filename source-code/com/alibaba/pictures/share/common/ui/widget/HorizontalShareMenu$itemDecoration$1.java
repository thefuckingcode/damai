package com.alibaba.pictures.share.common.ui.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.h90;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/alibaba/pictures/share/common/ui/widget/HorizontalShareMenu$itemDecoration$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "share_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class HorizontalShareMenu$itemDecoration$1 extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;

    HorizontalShareMenu$itemDecoration$1() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "797991887")) {
            ipChange.ipc$dispatch("797991887", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        k21.i(rect, "outRect");
        k21.i(view, "view");
        k21.i(recyclerView, "parent");
        k21.i(state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.left = h90.a(8.0f);
        }
    }
}
