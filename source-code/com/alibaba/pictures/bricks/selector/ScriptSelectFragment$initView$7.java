package com.alibaba.pictures.bricks.selector;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class ScriptSelectFragment$initView$7 extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ScriptSelectFragment a;

    ScriptSelectFragment$initView$7(ScriptSelectFragment scriptSelectFragment) {
        this.a = scriptSelectFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "360059187")) {
            ipChange.ipc$dispatch("360059187", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        k21.i(rect, "outRect");
        k21.i(view, "view");
        k21.i(recyclerView, "parent");
        k21.i(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = childAdapterPosition % 4;
        rect.left = (ScriptSelectFragment.midSpace * i) / 4;
        rect.right = ScriptSelectFragment.midSpace - (((i + 1) * ScriptSelectFragment.midSpace) / 4);
        if (childAdapterPosition == this.a.getAdapter().getItemCount() - 1) {
            rect.bottom = ScriptSelectFragment.Companion.b();
        }
    }
}
