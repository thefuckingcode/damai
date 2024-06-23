package cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model;

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
        if (!AndroidInstantRuntime.support(ipChange, "-1219212948")) {
            return this.mRegionChair.size();
        }
        return ((Integer) ipChange.ipc$dispatch("-1219212948", new Object[]{this})).intValue();
    }

    public List<Chair> chairs() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-529154894")) {
            return this.mRegionChair;
        }
        return (List) ipChange.ipc$dispatch("-529154894", new Object[]{this});
    }
}
