package cn.damai.trade.newtradeorder.ui.orderdetail.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceApplyInfoResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn.HnInvoiceSubmitInfoResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.contract.HnOrderCreateInvoiceContract;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.HNOrderInvoiceInfoRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.HNOrderInvoiceSubmitRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class HnOrderCreateInvoicePresenter extends HnOrderCreateInvoiceContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.HnOrderCreateInvoiceContract.Presenter
    public void requestInvoiceInfo(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "82520787")) {
            ipChange.ipc$dispatch("82520787", new Object[]{this, str});
            return;
        }
        HNOrderInvoiceInfoRequest hNOrderInvoiceInfoRequest = new HNOrderInvoiceInfoRequest();
        hNOrderInvoiceInfoRequest.orderId = str;
        hNOrderInvoiceInfoRequest.request(new DMMtopRequestListener<HnInvoiceApplyInfoResult>(HnInvoiceApplyInfoResult.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.HnOrderCreateInvoicePresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2086702617")) {
                    ipChange.ipc$dispatch("2086702617", new Object[]{this, str, str2});
                    return;
                }
                HnOrderCreateInvoicePresenter.this.mView.stopLoading();
                HnOrderCreateInvoicePresenter.this.mView.returnInvoiceInfoError(str, str2, OrderDetailConstantsApi.API_HN_ORDER_APPLY_INVOICE_INFO);
            }

            public void onSuccess(HnInvoiceApplyInfoResult hnInvoiceApplyInfoResult) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1995055913")) {
                    ipChange.ipc$dispatch("-1995055913", new Object[]{this, hnInvoiceApplyInfoResult});
                    return;
                }
                HnOrderCreateInvoicePresenter.this.mView.stopLoading();
                if (hnInvoiceApplyInfoResult != null) {
                    HnOrderCreateInvoicePresenter.this.mView.returnInvoiceInfo(hnInvoiceApplyInfoResult);
                } else {
                    HnOrderCreateInvoicePresenter.this.mView.returnInvoiceInfoError(null, " 数据为空...", OrderDetailConstantsApi.API_HN_ORDER_APPLY_INVOICE_INFO);
                }
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.HnOrderCreateInvoiceContract.Presenter
    public void submitInvoiceInfo(HNOrderInvoiceSubmitRequest hNOrderInvoiceSubmitRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "226157007")) {
            ipChange.ipc$dispatch("226157007", new Object[]{this, hNOrderInvoiceSubmitRequest});
        } else if (hNOrderInvoiceSubmitRequest == null) {
            this.mView.stopLoading();
        } else {
            hNOrderInvoiceSubmitRequest.request(new DMMtopRequestListener<HnInvoiceSubmitInfoResult>(HnInvoiceSubmitInfoResult.class) {
                /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.HnOrderCreateInvoicePresenter.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2078943258")) {
                        ipChange.ipc$dispatch("2078943258", new Object[]{this, str, str2});
                        return;
                    }
                    HnOrderCreateInvoicePresenter.this.mView.stopLoading();
                    HnOrderCreateInvoicePresenter.this.mView.returnInvoiceSubmitInfoError(str, str2);
                }

                public void onSuccess(HnInvoiceSubmitInfoResult hnInvoiceSubmitInfoResult) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "72015710")) {
                        ipChange.ipc$dispatch("72015710", new Object[]{this, hnInvoiceSubmitInfoResult});
                        return;
                    }
                    HnOrderCreateInvoicePresenter.this.mView.stopLoading();
                    if (hnInvoiceSubmitInfoResult != null) {
                        HnOrderCreateInvoicePresenter.this.mView.returnInvoiceSubmitInfo(hnInvoiceSubmitInfoResult);
                    } else {
                        HnOrderCreateInvoicePresenter.this.mView.returnInvoiceSubmitInfoError(null, " 数据为空...");
                    }
                }
            });
        }
    }
}
