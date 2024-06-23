package cn.damai.trade.newtradeorder.ui.orderlist.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.message.observer.Action;
import cn.damai.trade.newtradeorder.ui.orderlist.bean.OrderListResultBean;
import cn.damai.trade.newtradeorder.ui.orderlist.contract.OrderListContract;
import cn.damai.trade.newtradeorder.ui.orderlist.net.OrderListRequest;
import cn.damai.trade.newtradeorder.ui.orderlist.net.api.OrderListConstantsApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.um1;

/* compiled from: Taobao */
public class OrderListPresenter extends OrderListContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1223510428")) {
                ipChange.ipc$dispatch("-1223510428", new Object[]{this, str});
                return;
            }
            OrderListPresenter.this.mView.startTimerNotify();
        }
    }

    /* compiled from: Taobao */
    public class b implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-530408731")) {
                ipChange.ipc$dispatch("-530408731", new Object[]{this, str});
                return;
            }
            OrderListPresenter.this.mView.orderListRefreshNotify();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderlist.contract.OrderListContract.Presenter
    public void getOrderListData(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "307385464")) {
            ipChange.ipc$dispatch("307385464", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        OrderListRequest orderListRequest = new OrderListRequest();
        orderListRequest.pageNum = (long) i;
        orderListRequest.pageSize = i2;
        orderListRequest.queryType = i3;
        orderListRequest.request(new DMMtopRequestListener<OrderListResultBean>(OrderListResultBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderlist.presenter.OrderListPresenter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-168489391")) {
                    ipChange.ipc$dispatch("-168489391", new Object[]{this, str, str2});
                    return;
                }
                OrderListPresenter.this.mView.stopLoading();
                OrderListPresenter.this.mView.onNetError(str, str2, OrderListConstantsApi.ORDER_LIST_API);
            }

            public void onSuccess(OrderListResultBean orderListResultBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-424493138")) {
                    ipChange.ipc$dispatch("-424493138", new Object[]{this, orderListResultBean});
                    return;
                }
                OrderListPresenter.this.mView.stopLoading();
                OrderListPresenter.this.mView.onNetSuccess();
                OrderListPresenter.this.mView.returnOrderListData(orderListResultBean);
            }
        });
    }

    @Override // cn.damai.common.app.base.a
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "240709660")) {
            ipChange.ipc$dispatch("240709660", new Object[]{this});
            return;
        }
        super.onStart();
        this.mDMMessage.b(um1.NOTIFY_ORDER_LIST_SELF, new a());
        this.mDMMessage.b(um1.NOTIFY_ORDER_LIST_REFRESH, new b());
    }
}
