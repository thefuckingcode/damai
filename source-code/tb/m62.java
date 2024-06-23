package tb;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a;
import cn.damai.seat.loader.request.Seat3DVrImageDowngradeRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.k62;

/* compiled from: Taobao */
public class m62 extends ba<SeatBox, k62.a> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile m62 d;

    private m62() {
    }

    public static synchronized m62 r() {
        synchronized (m62.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "255139419")) {
                return (m62) ipChange.ipc$dispatch("255139419", new Object[0]);
            }
            if (d == null) {
                d = new m62();
            }
            return d;
        }
    }

    @Override // tb.ba
    public a<SeatBox, k62.a> e(@NonNull kl1<k62.a> kl1) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "632565679")) {
            return new Seat3DVrImageDowngradeRequest(kl1);
        }
        return (a) ipChange.ipc$dispatch("632565679", new Object[]{this, kl1});
    }
}
