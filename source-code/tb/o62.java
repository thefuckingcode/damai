package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.k62;

/* compiled from: Taobao */
public class o62 extends kl1<k62> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a;
    private final long b;
    private final boolean c;
    private final k62 d;

    private o62(boolean z, long j, String str, long j2, String str2, String str3, String str4, RegionSeat3DVrInfo regionSeat3DVrInfo, boolean z2) {
        this.c = z;
        this.b = j;
        this.a = str3;
        k62 k62 = new k62();
        this.d = k62;
        k62.i(z2);
        k62.j(regionSeat3DVrInfo);
        k62.k(j2);
        k62.h(str2);
        k62.l(str4);
        if (regionSeat3DVrInfo != null && regionSeat3DVrInfo.imgDecrypt != null) {
            k62.a aVar = new k62.a();
            aVar.f(String.valueOf(regionSeat3DVrInfo.venueId));
            aVar.d(str);
            aVar.g(j);
            aVar.e(regionSeat3DVrInfo.imgDecrypt.safeToken);
            k62.g(aVar);
        }
    }

    @Nullable
    public static o62 g(boolean z, long j, String str, long j2, String str2, String str3, String str4, RegionSeat3DVrInfo regionSeat3DVrInfo, boolean z2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "966250488")) {
            return new o62(z, j, str, j2, str2, str3, str4, regionSeat3DVrInfo, z2);
        }
        return (o62) ipChange.ipc$dispatch("966250488", new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, Long.valueOf(j2), str2, str3, str4, regionSeat3DVrInfo, Boolean.valueOf(z2)});
    }

    @Override // tb.kl1
    @NonNull
    public String b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-880364477")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("-880364477", new Object[]{this});
    }

    @Override // tb.kl1
    public long c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-410977895")) {
            return this.b;
        }
        return ((Long) ipChange.ipc$dispatch("-410977895", new Object[]{this})).longValue();
    }

    @Override // tb.kl1
    @NonNull
    public String d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-495144109")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("-495144109", new Object[]{this});
    }

    @Override // tb.kl1
    public boolean e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-157458792")) {
            return this.c;
        }
        return ((Boolean) ipChange.ipc$dispatch("-157458792", new Object[]{this})).booleanValue();
    }

    /* renamed from: f */
    public k62 a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1790454831")) {
            return this.d;
        }
        return (k62) ipChange.ipc$dispatch("1790454831", new Object[]{this});
    }
}
