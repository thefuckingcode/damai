package tb;

import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class lr extends lz1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public boolean e(RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-176779807")) {
            return new oa().d(regionData);
        }
        return ((Boolean) ipChange.ipc$dispatch("-176779807", new Object[]{this, regionData})).booleanValue();
    }

    public boolean f(RegionData regionData) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1339799144")) {
            return ((Boolean) ipChange.ipc$dispatch("1339799144", new Object[]{this, regionData})).booleanValue();
        }
        if (regionData == null || (regionInfo = regionData.ri) == null || regionInfo.venueScale != 1) {
            return false;
        }
        return true;
    }
}
