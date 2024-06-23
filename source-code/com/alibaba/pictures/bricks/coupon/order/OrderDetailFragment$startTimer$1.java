package com.alibaba.pictures.bricks.coupon.order;

import com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.TimerTask;

/* compiled from: Taobao */
public final class OrderDetailFragment$startTimer$1 extends TimerTask {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $timerType;
    final /* synthetic */ OrderDetailFragment this$0;

    OrderDetailFragment$startTimer$1(OrderDetailFragment orderDetailFragment, int i) {
        this.this$0 = orderDetailFragment;
        this.$timerType = i;
    }

    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "6145111")) {
            ipChange.ipc$dispatch("6145111", new Object[]{this});
            return;
        }
        OrderDetailFragment.b bVar = this.this$0.mTimeHandler;
        if (bVar != null) {
            bVar.sendEmptyMessage(this.$timerType);
        }
    }
}
