package cn.damai.trade.newtradeorder.ui.projectdetail.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponCreditsBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class VIPCreditExchangePresenter$requestExchange$1 extends DMMtopRequestListener<CouponCreditsBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ VIPCreditExchangePresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VIPCreditExchangePresenter$requestExchange$1(VIPCreditExchangePresenter vIPCreditExchangePresenter, Class<CouponCreditsBean> cls) {
        super(cls);
        this.this$0 = vIPCreditExchangePresenter;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706854834")) {
            ipChange.ipc$dispatch("706854834", new Object[]{this, str, str2});
            return;
        }
        V v = this.this$0.mView;
        if (v != null) {
            v.exchangeFail(str, str2);
        }
    }

    public void onSuccess(@Nullable CouponCreditsBean couponCreditsBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076578303")) {
            ipChange.ipc$dispatch("1076578303", new Object[]{this, couponCreditsBean});
        } else if (couponCreditsBean == null || !couponCreditsBean.isSuccess()) {
            V v = this.this$0.mView;
            if (v != null) {
                v.exchangeFail("0", "啊哦，兑换失败了~");
            }
        } else {
            V v2 = this.this$0.mView;
            if (v2 != null) {
                v2.exchangeSuccess(couponCreditsBean);
            }
        }
    }
}
