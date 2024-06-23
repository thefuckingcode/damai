package cn.damai.trade.newtradeorder.ui.orderdetail.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.message.observer.Action;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailCanResellBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailRefundCheck;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderPayDTO;
import cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract;
import cn.damai.trade.newtradeorder.ui.orderdetail.helper.OrderPayListener;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDeliveyRemindRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailCanResellRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailCancelRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailPayRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailRefundCheckRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailWolfPayRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderSeatRemindRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.model.OrderParmasResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.mm1;

/* compiled from: Taobao */
public class OrderDetailPresenter extends OrderDetailContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2012022032")) {
                ipChange.ipc$dispatch("2012022032", new Object[]{this, obj});
            } else if (obj != null) {
                try {
                    OrderDetailPresenter.this.mView.jumpTicketServicePage((ArrayList) obj);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1589843567")) {
                ipChange.ipc$dispatch("-1589843567", new Object[]{this, obj});
            } else if (obj != null) {
                try {
                    OrderDetailPresenter.this.mView.requestRefundCheckRequest((String) obj);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-896741870")) {
                ipChange.ipc$dispatch("-896741870", new Object[]{this, obj});
                return;
            }
            OrderDetailPresenter.this.mView.requestCanReSellRequest();
        }
    }

    /* compiled from: Taobao */
    public class d implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-203640173")) {
                ipChange.ipc$dispatch("-203640173", new Object[]{this, obj});
            } else if (obj != null && (obj instanceof ArrayList)) {
                OrderDetailPresenter.this.mView.openNoticePop((ArrayList) obj);
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void cancelOrderDetail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1045633578")) {
            ipChange.ipc$dispatch("1045633578", new Object[]{this, str});
            return;
        }
        OrderDetailCancelRequest orderDetailCancelRequest = new OrderDetailCancelRequest();
        orderDetailCancelRequest.orderId = str;
        orderDetailCancelRequest.request(new DMMtopRequestListener<String>(String.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.AnonymousClass8 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "485509104")) {
                    ipChange.ipc$dispatch("485509104", new Object[]{this, str, str2});
                    return;
                }
                OrderDetailPresenter.this.mView.stopLoading();
                OrderDetailPresenter.this.mView.returnOrderDetailCancelFail(str, str2);
            }

            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "188368311")) {
                    ipChange.ipc$dispatch("188368311", new Object[]{this, str});
                    return;
                }
                OrderDetailPresenter.this.mView.stopLoading();
                OrderDetailPresenter.this.mView.returnOrderDetailCancel();
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void getOrderDetailData(String str, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295516828")) {
            ipChange.ipc$dispatch("1295516828", new Object[]{this, str, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        OrderDetailRequest orderDetailRequest = new OrderDetailRequest();
        orderDetailRequest.orderId = str;
        orderDetailRequest.checkModifyResult = z;
        orderDetailRequest.checkInvoiceResult = z2;
        orderDetailRequest.request(new DMMtopRequestListener<OrderDetailBean>(OrderDetailBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "508787181")) {
                    ipChange.ipc$dispatch("508787181", new Object[]{this, str, str2});
                    return;
                }
                OrderDetailPresenter.this.mView.stopLoading();
                OrderDetailPresenter.this.mView.returnOrderDetailFail(str, str2, OrderDetailConstantsApi.API_ORDER_DETAIL);
            }

            public void onSuccess(OrderDetailBean orderDetailBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-542676017")) {
                    ipChange.ipc$dispatch("-542676017", new Object[]{this, orderDetailBean});
                    return;
                }
                OrderDetailPresenter.this.mView.stopLoading();
                OrderDetailPresenter.this.mView.onNetSuccess();
                OrderDetailPresenter.this.mView.returnOrderDetailData(orderDetailBean);
            }
        });
    }

    @Override // cn.damai.common.app.base.a
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374732866")) {
            ipChange.ipc$dispatch("374732866", new Object[]{this});
            return;
        }
        super.onStart();
        this.mDMMessage.b(mm1.NOTIFY_JUMP_TICKET_SERVICE, new a());
        this.mDMMessage.b(mm1.REFUND_CHECK_SERVICE, new b());
        this.mDMMessage.b(mm1.NOTIFY_CANCEL_SELL, new c());
        this.mDMMessage.b(mm1.NOTIFY_OPEN_NOTICE_POP, new d());
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void orderDetailCanResell(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "620928729")) {
            ipChange.ipc$dispatch("620928729", new Object[]{this, str});
            return;
        }
        OrderDetailCanResellRequest orderDetailCanResellRequest = new OrderDetailCanResellRequest();
        orderDetailCanResellRequest.orderId = str;
        orderDetailCanResellRequest.request(new DMMtopRequestListener<OrderDetailCanResellBean>(OrderDetailCanResellBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.AnonymousClass12 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "881043369")) {
                    ipChange.ipc$dispatch("881043369", new Object[]{this, str, str2});
                    return;
                }
                OrderDetailCanResellBean orderDetailCanResellBean = new OrderDetailCanResellBean();
                orderDetailCanResellBean.errorCode = str;
                orderDetailCanResellBean.errorMsg = str2;
                OrderDetailPresenter.this.mView.returnCanResellData(orderDetailCanResellBean, false);
            }

            public void onSuccess(OrderDetailCanResellBean orderDetailCanResellBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1800807752")) {
                    ipChange.ipc$dispatch("1800807752", new Object[]{this, orderDetailCanResellBean});
                    return;
                }
                OrderDetailPresenter.this.mView.returnCanResellData(orderDetailCanResellBean, true);
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void orderDetailChooseSeatRemind(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "16831279")) {
            ipChange.ipc$dispatch("16831279", new Object[]{this, str});
            return;
        }
        OrderSeatRemindRequest orderSeatRemindRequest = new OrderSeatRemindRequest();
        orderSeatRemindRequest.orderId = str;
        orderSeatRemindRequest.request(new DMMtopRequestListener<String>(String.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.AnonymousClass10 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "896562087")) {
                    ipChange.ipc$dispatch("896562087", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1029373216")) {
                    ipChange.ipc$dispatch("-1029373216", new Object[]{this, str});
                }
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void orderDetailDeliveryRemind(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-838209225")) {
            ipChange.ipc$dispatch("-838209225", new Object[]{this, str});
            return;
        }
        OrderDeliveyRemindRequest orderDeliveyRemindRequest = new OrderDeliveyRemindRequest();
        orderDeliveyRemindRequest.orderId = str;
        orderDeliveyRemindRequest.request(new DMMtopRequestListener<String>(String.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.AnonymousClass9 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "477749745")) {
                    ipChange.ipc$dispatch("477749745", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1213860310")) {
                    ipChange.ipc$dispatch("1213860310", new Object[]{this, str});
                }
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void orderDetailPay(String str, String str2, String str3, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930796265")) {
            ipChange.ipc$dispatch("1930796265", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
            return;
        }
        OrderDetailPayRequest orderDetailPayRequest = new OrderDetailPayRequest();
        orderDetailPayRequest.orderId = str;
        orderDetailPayRequest.payCode = str2;
        orderDetailPayRequest.paymentInfoExt = str3;
        orderDetailPayRequest.request(new DMMtopRequestListener<OrderPayDTO>(OrderPayDTO.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.AnonymousClass6 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "501027822")) {
                    ipChange.ipc$dispatch("501027822", new Object[]{this, str, str2});
                    return;
                }
                OrderDetailPresenter.this.mView.stopLoading();
                OrderDetailPresenter.this.mView.returnOrderDetailPayFail(str, str2);
            }

            public void onSuccess(OrderPayDTO orderPayDTO) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2021515976")) {
                    ipChange.ipc$dispatch("-2021515976", new Object[]{this, orderPayDTO});
                    return;
                }
                OrderDetailPresenter.this.mView.stopLoading();
                if (orderPayDTO != null) {
                    orderPayDTO.payTypeId = i;
                    OrderDetailPresenter.this.mView.returnOrderDetailPay(orderPayDTO);
                    return;
                }
                OrderDetailPresenter.this.mView.returnOrderDetailPayFail("success", "支付数据异常");
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void orderDetailRefundCheck(String str, final String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "980024264")) {
            ipChange.ipc$dispatch("980024264", new Object[]{this, str, str2});
            return;
        }
        OrderDetailRefundCheckRequest orderDetailRefundCheckRequest = new OrderDetailRefundCheckRequest();
        orderDetailRefundCheckRequest.orderId = str;
        orderDetailRefundCheckRequest.request(new DMMtopRequestListener<OrderDetailRefundCheck>(OrderDetailRefundCheck.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.AnonymousClass11 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "888802728")) {
                    ipChange.ipc$dispatch("888802728", new Object[]{this, str, str2});
                    return;
                }
                OrderDetailPresenter.this.mView.refundCheckResult(true, "", str2);
            }

            public void onSuccess(OrderDetailRefundCheck orderDetailRefundCheck) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-193912196")) {
                    ipChange.ipc$dispatch("-193912196", new Object[]{this, orderDetailRefundCheck});
                } else if (orderDetailRefundCheck != null) {
                    OrderDetailPresenter.this.mView.refundCheckResult(orderDetailRefundCheck.isCanApply(), orderDetailRefundCheck.failReason, str2);
                } else {
                    OrderDetailPresenter.this.mView.refundCheckResult(true, "", str2);
                }
            }
        });
    }

    @Override // cn.damai.trade.newtradeorder.ui.orderdetail.contract.OrderDetailContract.Presenter
    public void orderWolfDetailPay(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-380220670")) {
            ipChange.ipc$dispatch("-380220670", new Object[]{this, str, str2});
            return;
        }
        OrderDetailWolfPayRequest orderDetailWolfPayRequest = new OrderDetailWolfPayRequest();
        orderDetailWolfPayRequest.orderId = str;
        orderDetailWolfPayRequest.type = str2;
        orderDetailWolfPayRequest.request(new OrderPayListener<OrderParmasResult>(OrderParmasResult.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.presenter.OrderDetailPresenter.AnonymousClass7 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "493268463")) {
                    ipChange.ipc$dispatch("493268463", new Object[]{this, str, str2});
                    return;
                }
                OrderDetailPresenter.this.mView.stopLoading();
                OrderDetailPresenter.this.mView.returnOrderDetailPayFail(str, str2);
            }

            public void onSuccess(OrderParmasResult orderParmasResult) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1358328367")) {
                    ipChange.ipc$dispatch("-1358328367", new Object[]{this, orderParmasResult});
                    return;
                }
                OrderDetailPresenter.this.mView.stopLoading();
                OrderDetailPresenter.this.mView.returnOrderDetailWolfPay(orderParmasResult);
            }
        });
    }
}
