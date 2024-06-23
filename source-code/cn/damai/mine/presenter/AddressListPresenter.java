package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.address.bean.AddressListBean;
import cn.damai.commonbusiness.address.net.AddressListRequest;
import cn.damai.mine.bean.DefaultAddressBean;
import cn.damai.mine.contract.AddressListContract;
import cn.damai.mine.model.DeleteAddressRequest;
import cn.damai.mine.model.SetDefaultAddressRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class AddressListPresenter extends AddressListContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.AddressListContract.Presenter
    public void deleteAddress(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1844427512")) {
            ipChange.ipc$dispatch("1844427512", new Object[]{this, str});
            return;
        }
        DeleteAddressRequest deleteAddressRequest = new DeleteAddressRequest();
        deleteAddressRequest.addressId = str;
        deleteAddressRequest.loginKey = d20.q();
        deleteAddressRequest.request(new DMMtopRequestListener<DefaultAddressBean>(DefaultAddressBean.class) {
            /* class cn.damai.mine.presenter.AddressListPresenter.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-757484168")) {
                    ipChange.ipc$dispatch("-757484168", new Object[]{this, str, str2});
                    return;
                }
                AddressListPresenter.this.mView.deleteAddressFailed(str, str2);
            }

            public void onSuccess(DefaultAddressBean defaultAddressBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1284532197")) {
                    ipChange.ipc$dispatch("-1284532197", new Object[]{this, defaultAddressBean});
                    return;
                }
                AddressListPresenter.this.mView.deleteAddressSuccess(defaultAddressBean);
            }
        });
    }

    @Override // cn.damai.mine.contract.AddressListContract.Presenter
    public void getAddressList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1934617833")) {
            ipChange.ipc$dispatch("-1934617833", new Object[]{this});
            return;
        }
        AddressListRequest addressListRequest = new AddressListRequest();
        addressListRequest.loginKey = d20.q();
        addressListRequest.returnAll = "1";
        addressListRequest.request(new DMMtopRequestListener<AddressListBean>(AddressListBean.class) {
            /* class cn.damai.mine.presenter.AddressListPresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-749724809")) {
                    ipChange.ipc$dispatch("-749724809", new Object[]{this, str, str2});
                    return;
                }
                AddressListPresenter.this.mView.getAddressListError(str, str2);
            }

            public void onSuccess(AddressListBean addressListBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-728472146")) {
                    ipChange.ipc$dispatch("-728472146", new Object[]{this, addressListBean});
                    return;
                }
                AddressListPresenter.this.mView.returnAddressList(addressListBean);
            }
        });
    }

    @Override // cn.damai.mine.contract.AddressListContract.Presenter
    public void setDefaultAddress(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1951919564")) {
            ipChange.ipc$dispatch("1951919564", new Object[]{this, str});
            return;
        }
        SetDefaultAddressRequest setDefaultAddressRequest = new SetDefaultAddressRequest();
        setDefaultAddressRequest.addressId = str;
        setDefaultAddressRequest.loginKey = d20.q();
        setDefaultAddressRequest.request(new DMMtopRequestListener<DefaultAddressBean>(DefaultAddressBean.class) {
            /* class cn.damai.mine.presenter.AddressListPresenter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-765243527")) {
                    ipChange.ipc$dispatch("-765243527", new Object[]{this, str, str2});
                    return;
                }
                AddressListPresenter.this.mView.setDefaultAddressFailed(str, str2);
            }

            public void onSuccess(DefaultAddressBean defaultAddressBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-591139492")) {
                    ipChange.ipc$dispatch("-591139492", new Object[]{this, defaultAddressBean});
                    return;
                }
                AddressListPresenter.this.mView.setDefaultAddressSuccess(defaultAddressBean);
            }
        });
    }
}
