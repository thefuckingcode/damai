package cn.damai.trade.coupon.ui.orderdeatile;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class OrderDetailActivity$requestCancelOrder$listener$1 extends DMMtopRequestListener<String> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ OrderDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OrderDetailActivity$requestCancelOrder$listener$1(OrderDetailActivity orderDetailActivity, Class<String> cls) {
        super(cls);
        this.this$0 = orderDetailActivity;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1399149049")) {
            ipChange.ipc$dispatch("-1399149049", new Object[]{this, str, str2});
            return;
        }
        OrderDetailFragment access$getFragment$p = OrderDetailActivity.access$getFragment$p(this.this$0);
        if (access$getFragment$p != null) {
            access$getFragment$p.stopLoading();
        }
        this.this$0.stopProgressDialog();
        if (str != null && str2 != null) {
            this.this$0.returnOrderDetailCancelFail(str, str2);
        }
    }

    public void onSuccess(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-279358336")) {
            ipChange.ipc$dispatch("-279358336", new Object[]{this, str});
            return;
        }
        OrderDetailFragment access$getFragment$p = OrderDetailActivity.access$getFragment$p(this.this$0);
        if (access$getFragment$p != null) {
            access$getFragment$p.stopLoading();
        }
        this.this$0.stopProgressDialog();
        OrderDetailFragment access$getFragment$p2 = OrderDetailActivity.access$getFragment$p(this.this$0);
        if (access$getFragment$p2 != null) {
            access$getFragment$p2.refresh();
        }
    }
}
