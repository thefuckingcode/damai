package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.k62;

/* compiled from: Taobao */
public class n62 extends kl1<k62.a> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final long a;
    private final boolean b;
    private final k62.a c;

    private n62(boolean z, long j, String str, RegionSeat3DVrInfo regionSeat3DVrInfo) {
        this.b = z;
        this.a = j;
        k62.a aVar = new k62.a();
        this.c = aVar;
        if (regionSeat3DVrInfo != null && regionSeat3DVrInfo.imgDecrypt != null) {
            aVar.f(String.valueOf(regionSeat3DVrInfo.venueId));
            aVar.d(str);
            aVar.g(j);
            aVar.e(regionSeat3DVrInfo.imgDecrypt.safeToken);
        }
    }

    @Nullable
    public static n62 g(boolean z, long j, String str, RegionSeat3DVrInfo regionSeat3DVrInfo) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-586130576")) {
            return new n62(z, j, str, regionSeat3DVrInfo);
        }
        return (n62) ipChange.ipc$dispatch("-586130576", new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, regionSeat3DVrInfo});
    }

    @Override // tb.kl1
    @NonNull
    public String b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "831179448")) {
            return String.valueOf(this.a);
        }
        return (String) ipChange.ipc$dispatch("831179448", new Object[]{this});
    }

    @Override // tb.kl1
    public long c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1229661308")) {
            return 0;
        }
        return ((Long) ipChange.ipc$dispatch("-1229661308", new Object[]{this})).longValue();
    }

    @Override // tb.kl1
    @NonNull
    public String d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1216399816")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("1216399816", new Object[]{this});
    }

    @Override // tb.kl1
    public boolean e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1564258509")) {
            return this.b;
        }
        return ((Boolean) ipChange.ipc$dispatch("1564258509", new Object[]{this})).booleanValue();
    }

    /* renamed from: f */
    public k62.a a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1872333252")) {
            return this.c;
        }
        return (k62.a) ipChange.ipc$dispatch("-1872333252", new Object[]{this});
    }
}
