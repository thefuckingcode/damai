package com.alibaba.pictures.bricks.orderconfirm;

import androidx.fragment.app.FragmentActivity;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.orderconfirm.bean.CouponOrderRenderBean;
import com.alibaba.pictures.bricks.orderconfirm.request.CouponOrderRenderRequest;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.fb0;
import tb.k21;
import tb.ur2;
import tb.wz2;

/* compiled from: Taobao */
public final class CouponOrderConfirmFragment$requestOrderRender$3 extends Lambda implements Function1<fb0<CouponOrderRenderBean>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ CouponOrderConfirmFragment this$0;

    /* compiled from: Taobao */
    public static final class a implements BricksBaseFragment.IClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CouponOrderConfirmFragment a;

        a(CouponOrderConfirmFragment couponOrderConfirmFragment) {
            this.a = couponOrderConfirmFragment;
        }

        @Override // com.alibaba.pictures.bricks.base.BricksBaseFragment.IClickListener
        public void handleClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1107978594")) {
                ipChange.ipc$dispatch("1107978594", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.a.requestOrderRender();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CouponOrderConfirmFragment$requestOrderRender$3(CouponOrderConfirmFragment couponOrderConfirmFragment) {
        super(1);
        this.this$0 = couponOrderConfirmFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<CouponOrderRenderBean> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull fb0<CouponOrderRenderBean> fb0) {
        FragmentActivity activity;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "607366018")) {
            ipChange.ipc$dispatch("607366018", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        String str = "加载异常，请稍候重试";
        if (this.this$0.getRequestData() != null) {
            String e = fb0.e();
            if (e == null || !(o.J(e, "DM_", true))) {
                z = false;
            }
            if (z) {
                BricksToastUtil bricksToastUtil = BricksToastUtil.INSTANCE;
                String f = fb0.f();
                if (f != null) {
                    str = f;
                }
                bricksToastUtil.b(str);
            } else {
                BricksToastUtil.INSTANCE.b(str);
            }
        } else if (k21.d(fb0.e(), "DM_SECONDARY_ORDER_NO_STOCK")) {
            BricksToastUtil bricksToastUtil2 = BricksToastUtil.INSTANCE;
            String f2 = fb0.f();
            if (f2 == null) {
                f2 = "已经卖光啦，下次早点来哦";
            }
            bricksToastUtil2.b(f2);
            EventBus.getDefault().post(new Event("scriptCouponRefresh", this.this$0.getItemId()));
            if (this.this$0.getActivity() != null) {
                FragmentActivity activity2 = this.this$0.getActivity();
                k21.f(activity2);
                if (!activity2.isFinishing() && (activity = this.this$0.getActivity()) != null) {
                    activity.finish();
                }
            }
        } else {
            this.this$0.getErrContainer().setVisibility(0);
            CouponOrderConfirmFragment couponOrderConfirmFragment = this.this$0;
            String f3 = fb0.f();
            String str2 = f3 == null ? str : f3;
            String e2 = fb0.e();
            if (e2 == null) {
                e2 = "";
            }
            couponOrderConfirmFragment.showErrorView(1, str2, e2, this.this$0.getErrContainer(), true, false, true, new a(this.this$0));
        }
        String str3 = new CouponOrderRenderRequest().API_NAME;
        String e3 = fb0.e();
        if (e3 == null) {
            e3 = null;
        }
        String f4 = fb0.f();
        wz2.a(wz2.b(str3, "券订单渲染接口", e3, f4, "itemId: " + this.this$0.getItemId() + "  skuId：" + this.this$0.getSkuId()), "-4302", "券订单渲染错误");
    }
}
