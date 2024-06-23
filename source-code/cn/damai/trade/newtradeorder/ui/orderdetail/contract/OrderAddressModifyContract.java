package cn.damai.trade.newtradeorder.ui.orderdetail.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderAddressModifyResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderAddressSubmitResult;

/* compiled from: Taobao */
public interface OrderAddressModifyContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void requestModifyAddressInfo(String str, String str2);

        public abstract void requestNewAddressSubmit(String str, String str2);
    }

    /* compiled from: Taobao */
    public interface View extends BaseDamaiView {
        void onGetModifyAddressInfoError(String str, String str2, String str3);

        void onNewAddressSubmitError(String str, String str2);

        void returnModifyAddressInfo(OrderAddressModifyResult orderAddressModifyResult);

        void returnNewAddressSubmit(OrderAddressSubmitResult orderAddressSubmitResult);
    }
}
