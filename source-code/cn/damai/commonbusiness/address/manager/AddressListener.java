package cn.damai.commonbusiness.address.manager;

import cn.damai.commonbusiness.address.bean.AddressListBean;

/* compiled from: Taobao */
public interface AddressListener {
    void onAddressListFail(String str, String str2);

    void onAddressListSuccess(AddressListBean addressListBean);
}
