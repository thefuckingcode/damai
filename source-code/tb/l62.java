package tb;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class l62 extends ba<ImageData, k62> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile l62 d;

    private l62() {
    }

    public static synchronized l62 r() {
        synchronized (l62.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1395363579")) {
                return (l62) ipChange.ipc$dispatch("1395363579", new Object[0]);
            }
            if (d == null) {
                d = new l62();
            }
            return d;
        }
    }

    @Override // tb.ba
    public a<ImageData, k62> e(@NonNull kl1<k62> kl1) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "565657098")) {
            return new cn.damai.seat.loader.request.a(kl1);
        }
        return (a) ipChange.ipc$dispatch("565657098", new Object[]{this, kl1});
    }
}
