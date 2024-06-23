package cn.damai.trade.newtradeorder.ui.orderdetail.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.address.bean.AddressListBean;
import cn.damai.commonbusiness.base.BaseDamaiView;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceAddInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceSubmitResult;

/* compiled from: Taobao */
public interface OrderInvoiceContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void requestAddressList();

        public abstract void requestInvoiceInfo(String str);

        public abstract void requestSubmitInvoice(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9);
    }

    /* compiled from: Taobao */
    public interface View extends BaseDamaiView {
        void deliveryTypeChanged(String str);

        void returnAddressList(AddressListBean addressListBean);

        void returnAddressListError(String str, String str2);

        void returnInvoiceInfo(InvoiceAddInfo invoiceAddInfo);

        void returnInvoiceInfoError(String str, String str2);

        void returnSubmitInvoiceError(String str, String str2);

        void returnSubmitInvoiceInfo(InvoiceSubmitResult invoiceSubmitResult);
    }
}
