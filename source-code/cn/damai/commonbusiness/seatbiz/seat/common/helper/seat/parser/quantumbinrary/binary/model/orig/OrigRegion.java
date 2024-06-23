package cn.damai.commonbusiness.seatbiz.seat.common.helper.seat.parser.quantumbinrary.binary.model.orig;

import cn.damai.commonbusiness.seatbiz.seat.common.helper.seat.parser.quantumbinrary.binary.model.Chair;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tb.on;

/* compiled from: Taobao */
public class OrigRegion {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<OrigChair> mChairList;
    private String mId;

    public OrigRegion() {
        this.mChairList = new ArrayList();
    }

    public int chairCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "631048951")) {
            return this.mChairList.size();
        }
        return ((Integer) ipChange.ipc$dispatch("631048951", new Object[]{this})).intValue();
    }

    public List<OrigChair> chairs() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1347364423")) {
            return this.mChairList;
        }
        return (List) ipChange.ipc$dispatch("1347364423", new Object[]{this});
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065686769")) {
            return ((Boolean) ipChange.ipc$dispatch("-2065686769", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            OrigRegion origRegion = (OrigRegion) obj;
            if (!(this.mId.equals(origRegion.mId) && origRegion.chairs().size() == chairs().size())) {
                return false;
            }
            Collections.sort(origRegion.mChairList);
            Collections.sort(this.mChairList);
            for (int i = 0; i < chairs().size(); i++) {
                OrigChair origChair = chairs().get(i);
                OrigChair origChair2 = origRegion.chairs().get(i);
                if (!origChair.equals(origChair2)) {
                    on.a("binary", "--------------------- verify: error chair -----------------------");
                    on.a("binary", "[dest] this:" + origChair.toString());
                    on.a("binary", "[ src] that:" + origChair2.toString());
                    return false;
                }
            }
            on.a("binary", "region id:" + this.mId + "--------------------- verify: OK -----------------------");
            return true;
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1699877062")) {
            return (this.mId.hashCode() * 31) + this.mChairList.hashCode();
        }
        return ((Integer) ipChange.ipc$dispatch("1699877062", new Object[]{this})).intValue();
    }

    public String id() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1521600109")) {
            return this.mId;
        }
        return (String) ipChange.ipc$dispatch("1521600109", new Object[]{this});
    }

    public void init(String str, ArrayList<Chair> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "827513890")) {
            ipChange.ipc$dispatch("827513890", new Object[]{this, str, arrayList});
            return;
        }
        this.mId = str;
        this.mChairList.clear();
        Iterator<Chair> it = arrayList.iterator();
        while (it.hasNext()) {
            Chair next = it.next();
            OrigChair origChair = new OrigChair();
            origChair.setSid(next.sid);
            origChair.setX(next.x);
            origChair.setY(next.y);
            origChair.setFloorId(next.floorId().origin);
            origChair.setRowId(next.rowId().origin);
            origChair.setChairId(next.chairId().origin);
            origChair.setPriceId(next.priceId);
            origChair.setGroupId(next.groupId);
            origChair.setGroupPriceId(next.groupPriceId);
            this.mChairList.add(origChair);
        }
    }

    public void toXml(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-56410262")) {
            ipChange.ipc$dispatch("-56410262", new Object[]{this, str});
        }
    }

    public OrigRegion(String str, List<OrigChair> list) {
        ArrayList arrayList = new ArrayList();
        this.mChairList = arrayList;
        this.mId = str;
        arrayList.clear();
        for (OrigChair origChair : list) {
            OrigChair origChair2 = new OrigChair();
            origChair2.setSid(origChair.getSid());
            origChair2.setX(origChair.getX());
            origChair2.setY(origChair.getY());
            origChair2.setFloorId(origChair.getFloorId());
            origChair2.setRowId(origChair.getRowId());
            origChair2.setChairId(origChair.getChairId());
            origChair2.setPriceId(origChair.getPriceId());
            origChair2.setGroupId(origChair.getGroupId());
            origChair2.setGroupPriceId(origChair.getGroupPriceId());
            this.mChairList.add(origChair2);
        }
    }
}
