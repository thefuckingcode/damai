package cn.damai.mine.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.mine.bean.CouponData;

/* compiled from: Taobao */
public interface CouponsListContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void loadCouponsList(String str, int i, boolean z, int i2, int i3);
    }

    /* compiled from: Taobao */
    public interface View extends BaseDamaiView {
        void returnLoadCouponsList(CouponData.DiscountContainer discountContainer);
    }
}
