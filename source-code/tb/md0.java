package tb;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class md0 implements RequestListener<SeatBox, f72> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* renamed from: a */
    public void onSuccess(kl1<f72> kl1, SeatBox seatBox) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1039735911")) {
            ipChange.ipc$dispatch("-1039735911", new Object[]{this, kl1, seatBox});
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onFail(kl1<f72> kl1, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-772868816")) {
            ipChange.ipc$dispatch("-772868816", new Object[]{this, kl1, str, str2});
        }
    }
}
