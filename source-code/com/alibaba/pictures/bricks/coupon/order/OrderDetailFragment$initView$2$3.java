package com.alibaba.pictures.bricks.coupon.order;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.bricks.view.LinearPullToRefreshView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* compiled from: Taobao */
public final class OrderDetailFragment$initView$2$3 extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ OrderDetailFragment a;

    OrderDetailFragment$initView$2$3(OrderDetailFragment orderDetailFragment) {
        this.a = orderDetailFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-698353192")) {
            ipChange.ipc$dispatch("-698353192", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        k21.i(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        LinearPullToRefreshView refreshView = this.a.getRefreshView();
        if (refreshView != null) {
            RecyclerView irc = this.a.getIrc();
            if (irc == null || irc.canScrollVertically(-1)) {
                z = false;
            }
            refreshView.setPullToRefreshEnabled(z);
        }
    }
}
