package cn.damai.tetris.component.home.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.v50;

/* compiled from: Taobao */
public class RankItemDividerDecoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;

    public RankItemDividerDecoration(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-47600397")) {
            ipChange.ipc$dispatch("-47600397", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.left = v50.a(recyclerView.getContext(), (float) this.a);
        } else {
            rect.left = v50.a(recyclerView.getContext(), (float) this.b);
        }
        if (recyclerView.getChildLayoutPosition(view) == recyclerView.getLayoutManager().getItemCount() - 1) {
            rect.right = v50.a(recyclerView.getContext(), (float) this.a);
        } else {
            rect.right = 0;
        }
    }
}
