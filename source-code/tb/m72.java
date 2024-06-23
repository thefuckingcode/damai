package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;

/* compiled from: Taobao */
public class m72 extends kl1<f72> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final boolean a;
    private final String b;
    private final String c;
    private final boolean d;
    private final long e;
    private final f72 f;

    private m72(long j, long j2, boolean z, long j3, int i, boolean z2, RegionData regionData) {
        this.d = z;
        this.e = j3;
        String str = regionData.regionSeatData.resourcesPath + "seatlist.zip";
        this.c = str;
        if (TextUtils.isEmpty(regionData.regionSeatData.seatEncodingType) || TextUtils.isEmpty(regionData.regionSeatData.seatEncodeUri) || !d72.a()) {
            s72.f("直接降级！Orange 配置是否使用压缩 ：" + d72.a() + " ，seatEncodingType = " + regionData.regionSeatData.seatEncodingType + " ，seatEncodeUri = " + regionData.regionSeatData.seatEncodeUri);
            this.b = str;
            this.a = false;
        } else {
            this.b = regionData.regionSeatData.seatEncodeUri;
            this.a = true;
        }
        boolean z3 = this.a;
        RegionSeatData regionSeatData = regionData.regionSeatData;
        this.f = new f72(j, j2, z3, i, j3, z2, regionSeatData.seatEncodingType, regionSeatData.seatStaticHash);
    }

    @Nullable
    public static m72 g(long j, long j2, RegionData regionData, boolean z, long j3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786090738")) {
            return (m72) ipChange.ipc$dispatch("-1786090738", new Object[]{Long.valueOf(j), Long.valueOf(j2), regionData, Boolean.valueOf(z), Long.valueOf(j3)});
        } else if (regionData == null || regionData.regionSeatData == null) {
            return null;
        } else {
            return new m72(j, j2, z, j3, 1, s72.b(regionData), regionData);
        }
    }

    @Override // tb.kl1
    @NonNull
    public String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-57844096")) {
            return (String) ipChange.ipc$dispatch("-57844096", new Object[]{this});
        }
        return this.b + JSMethod.NOT_SET + this.e;
    }

    @Override // tb.kl1
    public long c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "762275516")) {
            return this.e;
        }
        return ((Long) ipChange.ipc$dispatch("762275516", new Object[]{this})).longValue();
    }

    @Override // tb.kl1
    @NonNull
    public String d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "327376272")) {
            return (String) ipChange.ipc$dispatch("327376272", new Object[]{this});
        } else if (!this.f.b()) {
            return this.b;
        } else {
            return this.c;
        }
    }

    @Override // tb.kl1
    public boolean e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-208946539")) {
            return this.d;
        }
        return ((Boolean) ipChange.ipc$dispatch("-208946539", new Object[]{this})).booleanValue();
    }

    /* renamed from: f */
    public f72 a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-6971873")) {
            return this.f;
        }
        return (f72) ipChange.ipc$dispatch("-6971873", new Object[]{this});
    }
}
