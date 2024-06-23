package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.d;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.e;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class l72 extends ba<SeatBox, f72> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static l72 d;

    private l72() {
    }

    public static synchronized l72 r() {
        synchronized (l72.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1118502427")) {
                return (l72) ipChange.ipc$dispatch("1118502427", new Object[0]);
            }
            if (d == null) {
                d = new l72();
            }
            return d;
        }
    }

    @Override // tb.ba
    public a<SeatBox, f72> e(@NonNull kl1<f72> kl1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147343205")) {
            return (a) ipChange.ipc$dispatch("2147343205", new Object[]{this, kl1});
        } else if (kl1.a() == null) {
            return null;
        } else {
            if (TextUtils.isEmpty(kl1.a().e) || !kl1.a().a()) {
                return new e(kl1);
            }
            return new d(kl1);
        }
    }
}
