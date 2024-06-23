package cn.damai.trade.newtradeorder.ui.projectdetail.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponCreditsBean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface VIPCreditExchangeContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void requestExchange(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4);
    }

    /* compiled from: Taobao */
    public interface View extends BaseView {
        void exchangeFail(@Nullable String str, @Nullable String str2);

        void exchangeSuccess(@NotNull CouponCreditsBean couponCreditsBean);
    }
}
