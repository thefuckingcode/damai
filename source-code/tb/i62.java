package tb;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class i62 extends ba<SeatBox, j62> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static i62 d;

    private i62() {
    }

    public static synchronized i62 r() {
        synchronized (i62.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1932832123")) {
                return (i62) ipChange.ipc$dispatch("1932832123", new Object[0]);
            }
            if (d == null) {
                d = new i62();
            }
            return d;
        }
    }

    @Override // tb.ba
    public a<SeatBox, j62> e(@NonNull kl1<j62> kl1) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2105157778")) {
            return new c(kl1);
        }
        return (a) ipChange.ipc$dispatch("-2105157778", new Object[]{this, kl1});
    }
}
