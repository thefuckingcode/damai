package cn.damai.commonbusiness.seatbiz.seat.common.helper.seat.parser.quantumbinrary.binary.model.orig;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.sf2;

/* compiled from: Taobao */
public class OrigChair implements Comparable<OrigChair> {
    private static transient /* synthetic */ IpChange $ipChange;
    private String chairId;
    private String floorId;
    private long groupId;
    private long groupPriceId;
    private long priceId;
    private String rowId;
    private long sid;
    private int x;
    private int y;

    public OrigChair() {
    }

    private int compareImpl(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1644335729")) {
            return ((Integer) ipChange.ipc$dispatch("-1644335729", new Object[]{this, str, str2})).intValue();
        }
        int b = sf2.b(str);
        int b2 = sf2.b(str2);
        if (str != str2) {
            return b - b2;
        }
        return str.compareTo(str2);
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393212638")) {
            return ((Boolean) ipChange.ipc$dispatch("1393212638", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            OrigChair origChair = (OrigChair) obj;
            if (this.sid == origChair.sid && this.x == origChair.x && this.y == origChair.y && this.priceId == origChair.priceId && this.groupId == origChair.groupId && this.groupPriceId == origChair.groupPriceId && this.floorId.equals(origChair.floorId) && this.rowId.equals(origChair.rowId)) {
                return this.chairId.equals(origChair.chairId);
            }
            return false;
        }
    }

    public String getChairId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-411660499")) {
            return this.chairId;
        }
        return (String) ipChange.ipc$dispatch("-411660499", new Object[]{this});
    }

    public String getFloorId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1115906764")) {
            return this.floorId;
        }
        return (String) ipChange.ipc$dispatch("-1115906764", new Object[]{this});
    }

    public long getGroupId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1499788723")) {
            return this.groupId;
        }
        return ((Long) ipChange.ipc$dispatch("-1499788723", new Object[]{this})).longValue();
    }

    public long getGroupPriceId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "779875878")) {
            return this.groupPriceId;
        }
        return ((Long) ipChange.ipc$dispatch("779875878", new Object[]{this})).longValue();
    }

    public long getPriceId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "49511875")) {
            return this.priceId;
        }
        return ((Long) ipChange.ipc$dispatch("49511875", new Object[]{this})).longValue();
    }

    public String getRowId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "183764226")) {
            return this.rowId;
        }
        return (String) ipChange.ipc$dispatch("183764226", new Object[]{this});
    }

    public long getSid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1623832583")) {
            return this.sid;
        }
        return ((Long) ipChange.ipc$dispatch("-1623832583", new Object[]{this})).longValue();
    }

    public int getX() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-153560178")) {
            return this.x;
        }
        return ((Integer) ipChange.ipc$dispatch("-153560178", new Object[]{this})).intValue();
    }

    public int getY() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-153530387")) {
            return this.y;
        }
        return ((Integer) ipChange.ipc$dispatch("-153530387", new Object[]{this})).intValue();
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1682428779")) {
            return ((Integer) ipChange.ipc$dispatch("-1682428779", new Object[]{this})).intValue();
        }
        long j = this.sid;
        long j2 = this.priceId;
        long j3 = this.groupId;
        long j4 = this.groupPriceId;
        return (((((((((((((((((int) (j ^ (j >>> 32))) * 31) + this.floorId.hashCode()) * 31) + this.rowId.hashCode()) * 31) + this.chairId.hashCode()) * 31) + this.x) * 31) + this.y) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public void setChairId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1492827159")) {
            ipChange.ipc$dispatch("-1492827159", new Object[]{this, str});
            return;
        }
        this.chairId = str;
    }

    public void setFloorId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849624894")) {
            ipChange.ipc$dispatch("-1849624894", new Object[]{this, str});
            return;
        }
        this.floorId = str;
    }

    public void setGroupId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1020515585")) {
            ipChange.ipc$dispatch("-1020515585", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.groupId = j;
    }

    public void setGroupPriceId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1157618654")) {
            ipChange.ipc$dispatch("1157618654", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.groupPriceId = j;
    }

    public void setPriceId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-236837303")) {
            ipChange.ipc$dispatch("-236837303", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.priceId = j;
    }

    public void setRowId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401876044")) {
            ipChange.ipc$dispatch("-401876044", new Object[]{this, str});
            return;
        }
        this.rowId = str;
    }

    public void setSid(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1157333805")) {
            ipChange.ipc$dispatch("-1157333805", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.sid = j;
    }

    public void setX(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026480836")) {
            ipChange.ipc$dispatch("-1026480836", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.x = i;
    }

    public void setY(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1025557315")) {
            ipChange.ipc$dispatch("-1025557315", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.y = i;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1351595023")) {
            return (String) ipChange.ipc$dispatch("1351595023", new Object[]{this});
        }
        return "OrigChair{sid=" + this.sid + ", floorId='" + this.floorId + '\'' + ", rowId='" + this.rowId + '\'' + ", chairId='" + this.chairId + '\'' + ", x=" + this.x + ", y=" + this.y + ", priceId=" + this.priceId + ", groupId=" + this.groupId + ", groupPriceId=" + this.groupPriceId + '}';
    }

    public OrigChair(OrigChair origChair) {
        this.sid = origChair.getSid();
        this.floorId = origChair.getFloorId();
        this.rowId = origChair.getRowId();
        this.chairId = origChair.getChairId();
        this.x = origChair.getX();
        this.y = origChair.getY();
        this.priceId = origChair.getPriceId();
        this.groupId = origChair.getGroupId();
        this.groupPriceId = origChair.getGroupPriceId();
    }

    public int compareTo(OrigChair origChair) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070896729")) {
            return ((Integer) ipChange.ipc$dispatch("-2070896729", new Object[]{this, origChair})).intValue();
        }
        if (!this.floorId.equalsIgnoreCase(origChair.floorId)) {
            compareImpl(this.floorId, origChair.floorId);
        }
        if (!this.rowId.equalsIgnoreCase(origChair.rowId)) {
            return compareImpl(this.rowId, origChair.rowId);
        }
        if (!this.chairId.equalsIgnoreCase(origChair.chairId)) {
            return compareImpl(this.chairId, origChair.chairId);
        }
        return 0;
    }
}
