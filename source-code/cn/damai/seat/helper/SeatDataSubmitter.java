package cn.damai.seat.helper;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.seat.bean.biz.OrderAfterChooseSeatInfo;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class SeatDataSubmitter {
    private static transient /* synthetic */ IpChange $ipChange;
    private SeatDataRequest a;

    /* compiled from: Taobao */
    public interface OnSubmitSeatDataListener {
        void onSubmitFailed(String str, String str2, String str3);

        void onSubmitSuccess(OrderAfterChooseSeatInfo orderAfterChooseSeatInfo);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class SeatData implements Serializable {
        public List<SeatId> seats;

        /* compiled from: Taobao */
        public static class SeatId implements Serializable {
            public long seatId;
            public String standId;
        }

        private SeatData() {
        }
    }

    /* compiled from: Taobao */
    public static class SeatDataRequest extends DMBaseMtopRequest {
        private static transient /* synthetic */ IpChange $ipChange;
        public String dmChannel;
        public String orderId;
        public String seats;

        private SeatDataRequest() {
            this.dmChannel = "*@damai_android_*";
        }

        @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
        public String getApiName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "373619190")) {
                return "mtop.damai.wireless.order.orderAfterChooseSeat";
            }
            return (String) ipChange.ipc$dispatch("373619190", new Object[]{this});
        }

        @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
        public boolean getNeedEcode() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2141678345")) {
                return true;
            }
            return ((Boolean) ipChange.ipc$dispatch("-2141678345", new Object[]{this})).booleanValue();
        }

        @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
        public boolean getNeedSession() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "351337395")) {
                return true;
            }
            return ((Boolean) ipChange.ipc$dispatch("351337395", new Object[]{this})).booleanValue();
        }

        @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
        public String getVersion() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1753611383")) {
                return "2.0";
            }
            return (String) ipChange.ipc$dispatch("-1753611383", new Object[]{this});
        }
    }

    public SeatDataSubmitter(String str, List<SeatNew> list) {
        SeatDataRequest seatDataRequest = new SeatDataRequest();
        this.a = seatDataRequest;
        seatDataRequest.orderId = str;
        seatDataRequest.seats = a(list);
    }

    private String a(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1696853384")) {
            return (String) ipChange.ipc$dispatch("-1696853384", new Object[]{this, list});
        } else if (f92.d(list)) {
            return "";
        } else {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                SeatNew seatNew = list.get(i);
                SeatData seatData = new SeatData();
                seatData.seats = new ArrayList();
                SeatData.SeatId seatId = new SeatData.SeatId();
                seatId.seatId = seatNew.sid;
                seatId.standId = seatNew.kanTaiId;
                seatData.seats.add(seatId);
                arrayList.add(seatData);
            }
            return JSON.toJSONString(arrayList);
        }
    }

    public void b(final OnSubmitSeatDataListener onSubmitSeatDataListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1913997296")) {
            ipChange.ipc$dispatch("-1913997296", new Object[]{this, onSubmitSeatDataListener});
            return;
        }
        final String apiName = this.a.getApiName();
        this.a.request(new DMMtopRequestListener<OrderAfterChooseSeatInfo>(OrderAfterChooseSeatInfo.class) {
            /* class cn.damai.seat.helper.SeatDataSubmitter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "411914817")) {
                    ipChange.ipc$dispatch("411914817", new Object[]{this, str, str2});
                    return;
                }
                OnSubmitSeatDataListener onSubmitSeatDataListener = onSubmitSeatDataListener;
                if (onSubmitSeatDataListener != null) {
                    onSubmitSeatDataListener.onSubmitFailed(apiName, str, str2);
                }
            }

            public void onSuccess(OrderAfterChooseSeatInfo orderAfterChooseSeatInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "769201217")) {
                    ipChange.ipc$dispatch("769201217", new Object[]{this, orderAfterChooseSeatInfo});
                    return;
                }
                OnSubmitSeatDataListener onSubmitSeatDataListener = onSubmitSeatDataListener;
                if (onSubmitSeatDataListener != null) {
                    onSubmitSeatDataListener.onSubmitSuccess(orderAfterChooseSeatInfo);
                }
            }
        });
    }
}
