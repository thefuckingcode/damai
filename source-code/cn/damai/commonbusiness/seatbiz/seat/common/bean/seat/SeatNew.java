package cn.damai.commonbusiness.seatbiz.seat.common.bean.seat;

import androidx.annotation.NonNull;
import cn.damai.seatdecoder.seat_vr.bean.StaticSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class SeatNew implements Comparable<SeatNew> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int LOCKED = 4;
    public static final int SALABLE = 2;
    public static final int SOLD = 8;
    public float angle;
    public int brs;
    public float currentX;
    public float currentY;
    public long floorId;
    public int floorIndex;
    public String fn;
    public int i = -1;
    public boolean isHasZH;
    public boolean isPackaged;
    public boolean isSelected;
    public String kanTaiId;
    public String kanTaiName;
    public long packageCombinedId;
    public int packagedPriceIndex;
    public long packagedPriceIndexId;
    public int priceIndex;
    public long priceLevel;
    public String rn;
    public int seatColor;
    public float seatTaoPiaoValue = -1.0f;
    public float seatValue = -1.0f;
    public long sid;
    public String sn;
    public int space;
    public int state;
    @Deprecated
    public boolean valid4TaoPiao = false;
    public StaticSeat3DVrInfo vr3DImg;
    public int x;
    public int y;

    public static List makeGroup(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1499565510")) {
            return (List) ipChange.ipc$dispatch("1499565510", new Object[]{list});
        } else if (list == null || list.size() == 0) {
            return null;
        } else {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (SeatNew seatNew : list) {
                if (seatNew.isPackaged) {
                    long j = seatNew.packageCombinedId;
                    if (!hashMap.containsKey(Long.valueOf(j))) {
                        hashMap.put(Long.valueOf(j), new ArrayList());
                    }
                    ((List) hashMap.get(Long.valueOf(j))).add(seatNew);
                }
            }
            if (hashMap.size() > 0) {
                for (SeatNew seatNew2 : list) {
                    if (seatNew2.isPackaged) {
                        List list2 = (List) hashMap.get(Long.valueOf(seatNew2.packageCombinedId));
                        if (!arrayList.contains(list2)) {
                            arrayList.add(list2);
                        }
                    } else {
                        arrayList.add(seatNew2);
                    }
                }
            } else {
                arrayList.addAll(list);
            }
            return arrayList;
        }
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-864209046")) {
            return ((Boolean) ipChange.ipc$dispatch("-864209046", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj != null && getClass() == obj.getClass() && this.sid == ((SeatNew) obj).sid) {
                return true;
            }
            return false;
        }
    }

    public int getPackAged() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1424112192")) {
            return this.isPackaged ? 1 : 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1424112192", new Object[]{this})).intValue();
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "145309473")) {
            return ((Integer) ipChange.ipc$dispatch("145309473", new Object[]{this})).intValue();
        }
        long j = this.sid;
        return (int) (j ^ (j >>> 32));
    }

    public boolean isCanMatchSeatPrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1773995328")) {
            return this.valid4TaoPiao || this.seatValue >= 0.0f;
        }
        return ((Boolean) ipChange.ipc$dispatch("1773995328", new Object[]{this})).booleanValue();
    }

    public int compareTo(@NonNull SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561640743")) {
            return ((Integer) ipChange.ipc$dispatch("1561640743", new Object[]{this, seatNew})).intValue();
        }
        int i2 = this.x;
        int i3 = seatNew.x;
        return i2 == i3 ? this.y < seatNew.y ? 1 : -1 : i2 < i3 ? 1 : -1;
    }
}
