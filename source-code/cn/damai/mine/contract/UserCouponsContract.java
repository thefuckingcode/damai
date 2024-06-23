package cn.damai.mine.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.mine.bean.CouponApplyResultBean;

/* compiled from: Taobao */
public interface UserCouponsContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void addCoupon(String str, String str2);
    }

    /* compiled from: Taobao */
    public interface View extends BaseDamaiView {
        void onReturnExchangeCouponError(String str, String str2);

        void returnAddCoupon(CouponApplyResultBean.CouponApplyDataBean couponApplyDataBean);
    }
}
