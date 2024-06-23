package cn.damai.homepage.ui.fragment;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cn.damai.uikit.irecycler.WrapperAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.hf1;

/* compiled from: Taobao */
public class HomeWrapperAdapter extends WrapperAdapter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.uikit.irecycler.WrapperAdapter
    public boolean b(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1675394998")) {
            return super.b(i);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1675394998", new Object[]{this, Integer.valueOf(i)})).booleanValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter, cn.damai.uikit.irecycler.WrapperAdapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1537646155")) {
            ipChange.ipc$dispatch("1537646155", new Object[]{this, viewHolder});
            return;
        }
        int layoutPosition = viewHolder.getLayoutPosition();
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            int a = hf1.a(getItemViewType(layoutPosition));
            if (a == 1) {
                layoutParams2.setFullSpan(true);
            } else if (a == 2) {
                layoutParams2.setFullSpan(false);
            } else if (a != 3) {
                layoutParams2.setFullSpan(true);
            } else {
                layoutParams2.setFullSpan(true);
            }
        }
    }
}
