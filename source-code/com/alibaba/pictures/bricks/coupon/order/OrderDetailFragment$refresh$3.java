package com.alibaba.pictures.bricks.coupon.order;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.alibaba.pictures.bricks.coupon.order.request.CouponOrderDetailRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.util.LogUtil;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.fb0;
import tb.k21;
import tb.ur2;
import tb.wz2;

/* compiled from: Taobao */
public final class OrderDetailFragment$refresh$3 extends Lambda implements Function1<fb0<OrderDetail>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ OrderDetailFragment this$0;

    /* compiled from: Taobao */
    public static final class a implements BricksBaseFragment.IClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OrderDetailFragment a;

        a(OrderDetailFragment orderDetailFragment) {
            this.a = orderDetailFragment;
        }

        @Override // com.alibaba.pictures.bricks.base.BricksBaseFragment.IClickListener
        public void handleClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-758116143")) {
                ipChange.ipc$dispatch("-758116143", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.a.refresh();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OrderDetailFragment$refresh$3(OrderDetailFragment orderDetailFragment) {
        super(1);
        this.this$0 = orderDetailFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<OrderDetail> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull fb0<OrderDetail> fb0) {
        String f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1946198330")) {
            ipChange.ipc$dispatch("1946198330", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        View rootView = this.this$0.getRootView();
        ViewGroup viewGroup = rootView != null ? (ViewGroup) rootView.findViewById(R$id.ll_page) : null;
        String str = new CouponOrderDetailRequest().API_NAME;
        String valueOf = String.valueOf(fb0.b());
        String d = fb0.d();
        wz2.a(wz2.b(str, "券订单详情接口", valueOf, d, "itemId: " + this.this$0.getItemId() + "  orderId：" + this.this$0.getOrderId()), "-4422", "券订单详情渲染错误");
        if (viewGroup != null) {
            OrderDetailFragment orderDetailFragment = this.this$0;
            String e = fb0.e();
            if (!(e == null || (f = fb0.f()) == null)) {
                orderDetailFragment.showErrorView(1, f, e, viewGroup, true, false, true, new a(orderDetailFragment));
            }
        }
        LogUtil.e(fb0.f(), new Object[0]);
    }
}
