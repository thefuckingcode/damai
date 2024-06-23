package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataNew;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class lz1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private long a;
    private mz1 b = mz1.b();

    public RegionData a(long j) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "422517340")) {
            return this.b.c(j);
        }
        return (RegionData) ipChange.ipc$dispatch("422517340", new Object[]{this, Long.valueOf(j)});
    }

    public RegionData b(RegionDataNew regionDataNew, long j) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240189812")) {
            return (RegionData) ipChange.ipc$dispatch("1240189812", new Object[]{this, regionDataNew, Long.valueOf(j)});
        }
        long j2 = this.a;
        if ((j2 != 0 && j2 != j) || regionDataNew == null || regionDataNew.seatQuYu == null) {
            return null;
        }
        RegionData e = new oa().e(regionDataNew, j);
        if (!(e == null || (regionInfo = e.ri) == null || regionInfo.seatStyle == 0)) {
            i72.e().f(e.ri.seatStyle);
        }
        this.b.a(j, e);
        return e;
    }

    public oa c(RegionData regionData) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-147538221")) {
            return (oa) ipChange.ipc$dispatch("-147538221", new Object[]{this, regionData});
        }
        if (regionData == null || (regionInfo = regionData.ri) == null) {
            return new oa();
        }
        if (!regionInfo.rainbowSupport || TextUtils.isEmpty(regionInfo.seatSvgImg)) {
            RegionInfo regionInfo2 = regionData.ri;
            if (!regionInfo2.rainbowSupportII || TextUtils.isEmpty(regionInfo2.rainbowSvgImg)) {
                if (!TextUtils.isEmpty(regionData.ri.seatSvgImg)) {
                    return new n32();
                }
                return new oa();
            }
        }
        return new m32();
    }

    public void d(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-580101274")) {
            ipChange.ipc$dispatch("-580101274", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.b.d(j);
    }
}
