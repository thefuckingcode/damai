package cn.damai.trade.newtradeorder.ui.orderdetail.model;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailAllProgressBean;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDeliveyRemindRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderDetailProgressRequest;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.OrderSeatRemindRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class OrderDetailProgressViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mImageUrl;
    private String mOrderId;
    private MutableLiveData<OrderDetailAllProgressBean> orderProgressLiveData = new MutableLiveData<>();

    public OrderDetailProgressViewModel(@NonNull Application application) {
        super(application);
    }

    public String getImageUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1013384269")) {
            return this.mImageUrl;
        }
        return (String) ipChange.ipc$dispatch("-1013384269", new Object[]{this});
    }

    public String getOrderId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1560591360")) {
            return this.mOrderId;
        }
        return (String) ipChange.ipc$dispatch("-1560591360", new Object[]{this});
    }

    public MutableLiveData<OrderDetailAllProgressBean> getOrderProgressLiveData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1618863908")) {
            return this.orderProgressLiveData;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-1618863908", new Object[]{this});
    }

    public void initParam(Intent intent) {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2039704599")) {
            ipChange.ipc$dispatch("2039704599", new Object[]{this, intent});
        } else if (intent != null && (extras = intent.getExtras()) != null) {
            if (extras.containsKey("orderId")) {
                this.mOrderId = extras.getString("orderId");
            }
            if (extras.containsKey("imageUrl")) {
                this.mImageUrl = extras.getString("imageUrl");
            }
        }
    }

    public void requestOrderChooseSeatRemind() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138047021")) {
            ipChange.ipc$dispatch("-2138047021", new Object[]{this});
            return;
        }
        OrderSeatRemindRequest orderSeatRemindRequest = new OrderSeatRemindRequest();
        orderSeatRemindRequest.orderId = this.mOrderId;
        orderSeatRemindRequest.request(new DMMtopRequestListener<String>(String.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.model.OrderDetailProgressViewModel.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1289750713")) {
                    ipChange.ipc$dispatch("1289750713", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1542181874")) {
                    ipChange.ipc$dispatch("-1542181874", new Object[]{this, str});
                }
            }
        });
    }

    public void requestOrderDeliveryRemind() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-667319973")) {
            ipChange.ipc$dispatch("-667319973", new Object[]{this});
            return;
        }
        OrderDeliveyRemindRequest orderDeliveyRemindRequest = new OrderDeliveyRemindRequest();
        orderDeliveyRemindRequest.orderId = this.mOrderId;
        orderDeliveyRemindRequest.request(new DMMtopRequestListener<String>(String.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.model.OrderDetailProgressViewModel.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1297510072")) {
                    ipChange.ipc$dispatch("1297510072", new Object[]{this, str, str2});
                }
            }

            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1727293423")) {
                    ipChange.ipc$dispatch("1727293423", new Object[]{this, str});
                }
            }
        });
    }

    public void requestOrderDetailProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-629875786")) {
            ipChange.ipc$dispatch("-629875786", new Object[]{this});
            return;
        }
        OrderDetailProgressRequest orderDetailProgressRequest = new OrderDetailProgressRequest();
        orderDetailProgressRequest.orderId = this.mOrderId;
        orderDetailProgressRequest.request(new DMMtopRequestListener<OrderDetailAllProgressBean>(OrderDetailAllProgressBean.class) {
            /* class cn.damai.trade.newtradeorder.ui.orderdetail.model.OrderDetailProgressViewModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1305269431")) {
                    ipChange.ipc$dispatch("1305269431", new Object[]{this, str, str2});
                    return;
                }
                OrderDetailAllProgressBean orderDetailAllProgressBean = new OrderDetailAllProgressBean();
                orderDetailAllProgressBean.requestState = false;
                orderDetailAllProgressBean.errorCode = str;
                orderDetailAllProgressBean.errorMsg = str2;
                OrderDetailProgressViewModel.this.orderProgressLiveData.setValue(orderDetailAllProgressBean);
            }

            public void onSuccess(OrderDetailAllProgressBean orderDetailAllProgressBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1674339069")) {
                    ipChange.ipc$dispatch("1674339069", new Object[]{this, orderDetailAllProgressBean});
                } else if (orderDetailAllProgressBean == null || OrderDetailProgressViewModel.this.orderProgressLiveData == null) {
                    onFail("success", "暂时没有订单进度");
                } else {
                    orderDetailAllProgressBean.requestState = true;
                    OrderDetailProgressViewModel.this.orderProgressLiveData.setValue(orderDetailAllProgressBean);
                }
            }
        });
    }
}
