package cn.damai.commonbusiness.contacts.manager;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.contacts.bean.PurchaserListBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.bw1;

/* compiled from: Taobao */
public class PurchaserManager$1 extends DMMtopRequestListener<PurchaserListBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ bw1 this$0;
    final /* synthetic */ PurchaserListener val$purchaserListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchaserManager$1(bw1 bw1, Class cls, PurchaserListener purchaserListener) {
        super(cls);
        this.val$purchaserListener = purchaserListener;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "58959666")) {
            ipChange.ipc$dispatch("58959666", new Object[]{this, str, str2});
            return;
        }
        this.val$purchaserListener.onPurchaserListFail(str, str2);
    }

    public void onSuccess(PurchaserListBean purchaserListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1710370051")) {
            ipChange.ipc$dispatch("1710370051", new Object[]{this, purchaserListBean});
            return;
        }
        this.val$purchaserListener.onPurchaserListSuccess(purchaserListBean);
    }
}
