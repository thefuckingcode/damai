package cn.damai.commonbusiness.contacts.manager;

import cn.damai.commonbusiness.contacts.bean.PurchaserListBean;

/* compiled from: Taobao */
public interface PurchaserListener {
    void onPurchaserListFail(String str, String str2);

    void onPurchaserListSuccess(PurchaserListBean purchaserListBean);
}
