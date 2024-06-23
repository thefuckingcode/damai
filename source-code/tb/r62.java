package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
public class r62 extends kl1<j62> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a;
    private final boolean b;
    private final long c;
    private final j62 d;

    private r62(boolean z, long j, RegionSeat3DVrInfo regionSeat3DVrInfo) {
        this.b = z;
        this.c = j;
        this.a = regionSeat3DVrInfo.seat3dvrEncodeUri;
        j62 j62 = new j62();
        this.d = j62;
        j62.c(regionSeat3DVrInfo.seat3dvrEncodingType);
        j62.d(regionSeat3DVrInfo.seat3dvrStaticHash);
    }

    @Nullable
    public static r62 g(RegionSeat3DVrInfo regionSeat3DVrInfo, boolean z, long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-182909762")) {
            return new r62(z, j, regionSeat3DVrInfo);
        }
        return (r62) ipChange.ipc$dispatch("-182909762", new Object[]{regionSeat3DVrInfo, Boolean.valueOf(z), Long.valueOf(j)});
    }

    @Override // tb.kl1
    @NonNull
    public String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934918899")) {
            return (String) ipChange.ipc$dispatch("-934918899", new Object[]{this});
        }
        return this.a + JSMethod.NOT_SET + this.c;
    }

    @Override // tb.kl1
    public long c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1023967857")) {
            return this.c;
        }
        return ((Long) ipChange.ipc$dispatch("-1023967857", new Object[]{this})).longValue();
    }

    @Override // tb.kl1
    @NonNull
    public String d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-549698531")) {
            return this.a;
        }
        return (String) ipChange.ipc$dispatch("-549698531", new Object[]{this});
    }

    @Override // tb.kl1
    public boolean e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "459525858")) {
            return this.b;
        }
        return ((Boolean) ipChange.ipc$dispatch("459525858", new Object[]{this})).booleanValue();
    }

    /* renamed from: f */
    public j62 a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "872016633")) {
            return this.d;
        }
        return (j62) ipChange.ipc$dispatch("872016633", new Object[]{this});
    }
}
