package cn.damai.trade.newtradeorder.ui.orderdetail.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.address.bean.AddressListBean;
import cn.damai.message.observer.Action;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceAddInfo;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.InvoiceSubmitResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.ZLOrderInvoiceAddressRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.ZLOrderInvoiceInfoRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.ZLOrderInvoiceSubmitRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderInvoicePresenter extends OrderInvoiceContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-329619208")) {
                ipChange.ipc$dispatch("-329619208", new Object[]{this, str});
                return;
            }
            OrderInvoicePresenter.this.mView.deliveryTypeChanged(str);
        }
    }

    @Override // cn.damai.common.app.base.a
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005798136")) {
            ipChange.ipc$dispatch("-2005798136", new Object[]{this});
            return;
        }
        super.onStart();
        this.mDMMessage.b("1", new a());
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract.Presenter
    public void requestAddressList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "749415932")) {
            ipChange.ipc$dispatch("749415932", new Object[]{this});
            return;
        }
        new ZLOrderInvoiceAddressRequest().request(new DMMtopRequestListener<AddressListBean>(AddressListBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderInvoicePresenter.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1684490470")) {
                    ipChange.ipc$dispatch("1684490470", new Object[]{this, str, str2});
                    return;
                }
                OrderInvoicePresenter.this.mView.returnAddressListError(str, str2);
            }

            public void onSuccess(AddressListBean addressListBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2108113823")) {
                    ipChange.ipc$dispatch("2108113823", new Object[]{this, addressListBean});
                    return;
                }
                OrderInvoicePresenter.this.mView.onNetSuccess();
                OrderInvoicePresenter.this.mView.returnAddressList(addressListBean);
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract.Presenter
    public void requestInvoiceInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "319521181")) {
            ipChange.ipc$dispatch("319521181", new Object[]{this, str});
            return;
        }
        ZLOrderInvoiceInfoRequest zLOrderInvoiceInfoRequest = new ZLOrderInvoiceInfoRequest();
        zLOrderInvoiceInfoRequest.orderId = str;
        zLOrderInvoiceInfoRequest.request(new DMMtopResultRequestListener<InvoiceAddInfo>(InvoiceAddInfo.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderInvoicePresenter.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1700009188")) {
                    ipChange.ipc$dispatch("1700009188", new Object[]{this, str, str2});
                    return;
                }
                OrderInvoicePresenter.this.mView.returnInvoiceInfoError(str, str2);
            }

            public void onSuccess(InvoiceAddInfo invoiceAddInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-941559353")) {
                    ipChange.ipc$dispatch("-941559353", new Object[]{this, invoiceAddInfo});
                    return;
                }
                OrderInvoicePresenter.this.mView.onNetSuccess();
                OrderInvoicePresenter.this.mView.returnInvoiceInfo(invoiceAddInfo);
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderInvoiceContract.Presenter
    public void requestSubmitInvoice(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1552947059")) {
            ipChange.ipc$dispatch("1552947059", new Object[]{this, str, str2, str3, str4, str5, str6, str7, str8, str9});
            return;
        }
        ZLOrderInvoiceSubmitRequest zLOrderInvoiceSubmitRequest = new ZLOrderInvoiceSubmitRequest();
        zLOrderInvoiceSubmitRequest.orderId = str;
        zLOrderInvoiceSubmitRequest.typeId = str2;
        zLOrderInvoiceSubmitRequest.companyName = str3;
        zLOrderInvoiceSubmitRequest.companyTax = str4;
        zLOrderInvoiceSubmitRequest.transId = str5;
        zLOrderInvoiceSubmitRequest.name = str6;
        zLOrderInvoiceSubmitRequest.phone = str7;
        zLOrderInvoiceSubmitRequest.addrId = str8;
        zLOrderInvoiceSubmitRequest.payId = str9;
        zLOrderInvoiceSubmitRequest.request(new DMMtopResultRequestListener<InvoiceSubmitResult>(InvoiceSubmitResult.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderInvoicePresenter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1692249829")) {
                    ipChange.ipc$dispatch("1692249829", new Object[]{this, str, str2});
                    return;
                }
                OrderInvoicePresenter.this.mView.returnSubmitInvoiceError(str, str2);
            }

            public void onSuccess(InvoiceSubmitResult invoiceSubmitResult) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1095187100")) {
                    ipChange.ipc$dispatch("-1095187100", new Object[]{this, invoiceSubmitResult});
                    return;
                }
                OrderInvoicePresenter.this.mView.returnSubmitInvoiceInfo(invoiceSubmitResult);
            }
        });
    }
}
