package cn.damai.mine.contract;

import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.BaseView;
import cn.damai.common.app.base.a;
import cn.damai.commonbusiness.address.bean.AddressListBean;
import cn.damai.mine.bean.DefaultAddressBean;

/* compiled from: Taobao */
public interface AddressListContract {

    /* compiled from: Taobao */
    public interface Model extends BaseModel {
    }

    /* compiled from: Taobao */
    public static abstract class Presenter extends a<View, Model> {
        public abstract void deleteAddress(String str);

        public abstract void getAddressList();

        public abstract void setDefaultAddress(String str);
    }

    /* compiled from: Taobao */
    public interface View extends BaseView {
        void deleteAddressFailed(String str, String str2);

        void deleteAddressSuccess(DefaultAddressBean defaultAddressBean);

        void getAddressListError(String str, String str2);

        void returnAddressList(AddressListBean addressListBean);

        void setDefaultAddressFailed(String str, String str2);

        void setDefaultAddressSuccess(DefaultAddressBean defaultAddressBean);
    }
}
