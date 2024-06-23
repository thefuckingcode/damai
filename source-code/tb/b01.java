package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionInfo;
import cn.damai.commonbusiness.seatbiz.seat.wolf.newtradeorder.model.region.image.RegionImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
public class b01 extends kl1<vz0> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final boolean a;
    private final String b;
    private long c;
    private final boolean d;
    private final boolean e;
    private l32 f;

    public b01(boolean z, String str, long j, boolean z2, boolean z3, l32 l32) {
        this.a = z;
        this.b = str;
        this.c = j;
        this.d = z2;
        this.e = z3;
        this.f = l32;
    }

    @Nullable
    public static b01[] f(RegionData regionData, boolean z, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692437124")) {
            return (b01[]) ipChange.ipc$dispatch("1692437124", new Object[]{regionData, Boolean.valueOf(z), Long.valueOf(j)});
        } else if (regionData == null || regionData.ri == null) {
            return null;
        } else {
            l32 makeDegradeAssist = regionData.makeDegradeAssist();
            if (RegionImageLoader.getInstance().isSVGRegion(regionData)) {
                b01 b01 = new b01(z, regionData.ri.seatSvgImg, j, true, false, makeDegradeAssist);
                RegionInfo regionInfo = regionData.ri;
                if (regionInfo.rainbowSupportII) {
                    return new b01[]{b01, new b01(z, regionInfo.rainbowSvgImg, j, true, true, makeDegradeAssist)};
                }
                return new b01[]{b01};
            }
            return new b01[]{h(z, regionData.ri.seatImg, j)};
        }
    }

    public static b01 h(boolean z, String str, long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2030911968")) {
            return new b01(z, str, j, false, false, null);
        }
        return (b01) ipChange.ipc$dispatch("2030911968", new Object[]{Boolean.valueOf(z), str, Long.valueOf(j)});
    }

    @Override // tb.kl1
    @NonNull
    public String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1430614662")) {
            return (String) ipChange.ipc$dispatch("1430614662", new Object[]{this});
        }
        return this.b + JSMethod.NOT_SET + this.c;
    }

    @Override // tb.kl1
    public long c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-704801802")) {
            return this.c;
        }
        return ((Long) ipChange.ipc$dispatch("-704801802", new Object[]{this})).longValue();
    }

    @Override // tb.kl1
    @NonNull
    public String d() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1815835030")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("1815835030", new Object[]{this});
    }

    @Override // tb.kl1
    public boolean e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-322122981")) {
            return this.a;
        }
        return ((Boolean) ipChange.ipc$dispatch("-322122981", new Object[]{this})).booleanValue();
    }

    /* renamed from: g */
    public vz0 a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "819370865")) {
            return new vz0(this.d, this.e, this.f);
        }
        return (vz0) ipChange.ipc$dispatch("819370865", new Object[]{this});
    }
}
