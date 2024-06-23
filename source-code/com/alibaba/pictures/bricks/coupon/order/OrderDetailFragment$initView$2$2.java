package com.alibaba.pictures.bricks.coupon.order;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.u50;

/* compiled from: Taobao */
public final class OrderDetailFragment$initView$2$2 extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ FragmentActivity a;

    OrderDetailFragment$initView$2$2(FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1187009250")) {
            ipChange.ipc$dispatch("-1187009250", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        k21.i(rect, "outRect");
        k21.i(view, "view");
        k21.i(recyclerView, "parent");
        k21.i(state, "state");
        u50 u50 = u50.INSTANCE;
        FragmentActivity fragmentActivity = this.a;
        k21.h(fragmentActivity, AdvanceSetting.NETWORK_TYPE);
        rect.bottom = u50.a(fragmentActivity, 12.0f);
    }
}
