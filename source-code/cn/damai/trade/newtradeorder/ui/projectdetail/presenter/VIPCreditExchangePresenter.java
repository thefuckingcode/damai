package cn.damai.trade.newtradeorder.ui.projectdetail.presenter;

import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponCreditsBean;
import cn.damai.commonbusiness.seatbiz.promotion.request.CreditsExchangeRequest;
import cn.damai.trade.newtradeorder.ui.projectdetail.contract.VIPCreditExchangeContract;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class VIPCreditExchangePresenter extends VIPCreditExchangeContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.contract.VIPCreditExchangeContract.Presenter
    public void requestExchange(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-901827072")) {
            ipChange.ipc$dispatch("-901827072", new Object[]{this, str, str2, str3, str4});
            return;
        }
        CreditsExchangeRequest creditsExchangeRequest = new CreditsExchangeRequest();
        creditsExchangeRequest.exchange4Dm = str;
        creditsExchangeRequest.lotteryMixId = str2;
        creditsExchangeRequest.platform = str3;
        creditsExchangeRequest.asac = str4;
        creditsExchangeRequest.request(new VIPCreditExchangePresenter$requestExchange$1(this, CouponCreditsBean.class));
    }
}
