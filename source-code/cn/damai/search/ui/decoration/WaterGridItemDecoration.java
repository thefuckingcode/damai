package cn.damai.search.ui.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.v50;

/* compiled from: Taobao */
public class WaterGridItemDecoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1397965886")) {
            ipChange.ipc$dispatch("-1397965886", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        super.getItemOffsets(rect, view, recyclerView, state);
        if (((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex() % 2 == 0) {
            rect.left = v50.a(recyclerView.getContext(), 21.0f);
            rect.right = v50.a(recyclerView.getContext(), 6.0f);
        } else {
            rect.left = v50.a(recyclerView.getContext(), 6.0f);
            rect.right = v50.a(recyclerView.getContext(), 21.0f);
        }
        rect.bottom = v50.a(recyclerView.getContext(), 12.0f);
    }
}
