package cn.damai.seat.listener.net;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.seat.bean.biz.SeatDynamic;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kf1;
import tb.oz0;
import tb.u62;

/* compiled from: Taobao */
public abstract class MtopSeatDynamicListener extends DMMtopRequestListener<SeatDynamic> implements OnNetBizListener<SeatDynamic> {
    private static transient /* synthetic */ IpChange $ipChange;
    private long itemId;
    private kf1 mMonitor = new kf1(true);
    private long performId;

    public MtopSeatDynamicListener(long j, long j2) {
        super(SeatDynamic.class);
        this.itemId = j;
        this.performId = j2;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-53715212")) {
            ipChange.ipc$dispatch("-53715212", new Object[]{this, str, str2});
            return;
        }
        kf1.e("mtop.damai.wireless.seat.dynamicInfo", str, str2);
        onNetFail(str, str2);
        if (!oz0.b().c(str)) {
            u62.m(this.itemId + "", this.performId + "", str, str2);
        }
    }

    public void onSuccess(SeatDynamic seatDynamic) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2065395210")) {
            ipChange.ipc$dispatch("2065395210", new Object[]{this, seatDynamic});
        } else if (seatDynamic == null) {
            onFail("", "麦麦开小差了，请稍后重试哦");
        } else {
            this.mMonitor.a("mtop.damai.wireless.seat.dynamicInfo");
            kf1.f("mtop.damai.wireless.seat.dynamicInfo");
            onNetSuccess(seatDynamic);
        }
    }
}
