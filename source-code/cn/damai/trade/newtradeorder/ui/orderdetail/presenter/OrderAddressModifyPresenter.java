package cn.damai.trade.newtradeorder.ui.orderdetail.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderAddressModifyResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderAddressSubmitResult;
import cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderModifyAddressInfoRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderModiyAddressSubmitRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class OrderAddressModifyPresenter extends OrderAddressModifyContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract.Presenter
    public void requestModifyAddressInfo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741517543")) {
            ipChange.ipc$dispatch("-1741517543", new Object[]{this, str, str2});
            return;
        }
        OrderModifyAddressInfoRequest orderModifyAddressInfoRequest = new OrderModifyAddressInfoRequest();
        orderModifyAddressInfoRequest.orderId = str;
        orderModifyAddressInfoRequest.addressId = str2;
        orderModifyAddressInfoRequest.request(new DMMtopRequestListener<OrderAddressModifyResult>(OrderAddressModifyResult.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderAddressModifyPresenter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1587166366")) {
                    ipChange.ipc$dispatch("-1587166366", new Object[]{this, str, str2});
                    return;
                }
                OrderAddressModifyPresenter.this.mView.stopLoading();
                OrderAddressModifyPresenter.this.mView.onGetModifyAddressInfoError(str, str2, OrderDetailConstantsApi.API_ORDER_DETAIL_MODIFY_ADDRESS);
            }

            public void onSuccess(OrderAddressModifyResult orderAddressModifyResult) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-920189110")) {
                    ipChange.ipc$dispatch("-920189110", new Object[]{this, orderAddressModifyResult});
                    return;
                }
                OrderAddressModifyPresenter.this.mView.stopLoading();
                if (orderAddressModifyResult != null) {
                    OrderAddressModifyPresenter.this.mView.returnModifyAddressInfo(orderAddressModifyResult);
                    OrderAddressModifyPresenter.this.mView.onNetSuccess();
                    return;
                }
                OrderAddressModifyPresenter.this.mView.onGetModifyAddressInfoError("SUCCESS", "Bean NULL", OrderDetailConstantsApi.API_ORDER_DETAIL_MODIFY_ADDRESS);
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderAddressModifyContract.Presenter
    public void requestNewAddressSubmit(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1162042267")) {
            ipChange.ipc$dispatch("-1162042267", new Object[]{this, str, str2});
            return;
        }
        OrderModiyAddressSubmitRequest orderModiyAddressSubmitRequest = new OrderModiyAddressSubmitRequest();
        orderModiyAddressSubmitRequest.orderId = str;
        orderModiyAddressSubmitRequest.addressId = str2;
        orderModiyAddressSubmitRequest.request(new DMMtopRequestListener<OrderAddressSubmitResult>(OrderAddressSubmitResult.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderAddressModifyPresenter.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1594925725")) {
                    ipChange.ipc$dispatch("-1594925725", new Object[]{this, str, str2});
                    return;
                }
                OrderAddressModifyPresenter.this.mView.stopLoading();
                OrderAddressModifyPresenter.this.mView.onNewAddressSubmitError(str, str2);
            }

            public void onSuccess(OrderAddressSubmitResult orderAddressSubmitResult) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "816329325")) {
                    ipChange.ipc$dispatch("816329325", new Object[]{this, orderAddressSubmitResult});
                    return;
                }
                OrderAddressModifyPresenter.this.mView.stopLoading();
                if (orderAddressSubmitResult != null) {
                    OrderAddressModifyPresenter.this.mView.returnNewAddressSubmit(orderAddressSubmitResult);
                    OrderAddressModifyPresenter.this.mView.onNetSuccess();
                    return;
                }
                OrderAddressModifyPresenter.this.mView.onNewAddressSubmitError("SUCCESS", "Bean is NULL");
            }
        });
    }
}
