package cn.damai.commonbusiness.address.manager;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.address.bean.AddressListBean;
import cn.damai.commonbusiness.address.net.AddressListRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AddressManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static AddressManager a;

    public static synchronized AddressManager b() {
        synchronized (AddressManager.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-380884165")) {
                return (AddressManager) ipChange.ipc$dispatch("-380884165", new Object[0]);
            }
            if (a == null) {
                a = new AddressManager();
            }
            return a;
        }
    }

    public void a(String str, final AddressListener addressListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1692567875")) {
            ipChange.ipc$dispatch("-1692567875", new Object[]{this, str, addressListener});
            return;
        }
        AddressListRequest addressListRequest = new AddressListRequest();
        addressListRequest.loginKey = str;
        addressListRequest.request(new DMMtopRequestListener<AddressListBean>(AddressListBean.class) {
            /* class cn.damai.commonbusiness.address.manager.AddressManager.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1434270280")) {
                    ipChange.ipc$dispatch("-1434270280", new Object[]{this, str, str2});
                    return;
                }
                AddressListener addressListener = addressListener;
                if (addressListener != null) {
                    addressListener.onAddressListFail(str, str2);
                }
            }

            public void onSuccess(AddressListBean addressListBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-964403699")) {
                    ipChange.ipc$dispatch("-964403699", new Object[]{this, addressListBean});
                    return;
                }
                AddressListener addressListener = addressListener;
                if (addressListener != null) {
                    addressListener.onAddressListSuccess(addressListBean);
                }
            }
        });
    }
}
