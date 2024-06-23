package cn.damai.commonbusiness.seatbiz.seat.common.helper.seat.parser.quantumbinrary.binary.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class Region {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Chair> mRegionChair = new ArrayList();

    public int chairCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-687442556")) {
            return this.mRegionChair.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-687442556", new Object[]{this})).intValue();
    }

    public List<Chair> chairs() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1634233958")) {
            return this.mRegionChair;
        }
        return (List) ipChange.ipc$dispatch("-1634233958", new Object[]{this});
    }
}
