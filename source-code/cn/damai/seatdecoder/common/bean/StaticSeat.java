package cn.damai.seatdecoder.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class StaticSeat implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public double angle;
    public String chint;
    public String fn;
    public long groupId;
    public long groupPriceId;
    public int i = -1;
    public long plid;
    public String rhint;
    public long sid;
    public int x;
    public int y;

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-36250601")) {
            return ((Boolean) ipChange.ipc$dispatch("-36250601", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj != null && getClass() == obj.getClass() && this.sid == ((StaticSeat) obj).sid) {
                return true;
            }
            return false;
        }
    }

    public double getAngle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "115438471")) {
            return this.angle;
        }
        return ((Double) ipChange.ipc$dispatch("115438471", new Object[]{this})).doubleValue();
    }

    public String getChint() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1123635518")) {
            return this.chint;
        }
        return (String) ipChange.ipc$dispatch("1123635518", new Object[]{this});
    }

    public String getFn() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-733950934")) {
            return this.fn;
        }
        return (String) ipChange.ipc$dispatch("-733950934", new Object[]{this});
    }

    public long getGroupId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "250564934")) {
            return this.groupId;
        }
        return ((Long) ipChange.ipc$dispatch("250564934", new Object[]{this})).longValue();
    }

    public long getGroupPriceId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-154524979")) {
            return this.groupPriceId;
        }
        return ((Long) ipChange.ipc$dispatch("-154524979", new Object[]{this})).longValue();
    }

    public int getI() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1446953034")) {
            return this.i;
        }
        return ((Integer) ipChange.ipc$dispatch("-1446953034", new Object[]{this})).intValue();
    }

    public long getPlid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2038236987")) {
            return this.plid;
        }
        return ((Long) ipChange.ipc$dispatch("2038236987", new Object[]{this})).longValue();
    }

    public String getRhint() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "30266445")) {
            return this.rhint;
        }
        return (String) ipChange.ipc$dispatch("30266445", new Object[]{this});
    }

    public long getSid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1395585906")) {
            return this.sid;
        }
        return ((Long) ipChange.ipc$dispatch("1395585906", new Object[]{this})).longValue();
    }

    public int getX() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1446506169")) {
            return this.x;
        }
        return ((Integer) ipChange.ipc$dispatch("-1446506169", new Object[]{this})).intValue();
    }

    public int getY() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1446476378")) {
            return this.y;
        }
        return ((Integer) ipChange.ipc$dispatch("-1446476378", new Object[]{this})).intValue();
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "875814350")) {
            return ((Integer) ipChange.ipc$dispatch("875814350", new Object[]{this})).intValue();
        }
        long j = this.sid;
        return (int) (j ^ (j >>> 32));
    }

    public void setAngle(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "832643129")) {
            ipChange.ipc$dispatch("832643129", new Object[]{this, Double.valueOf(d)});
            return;
        }
        this.angle = d;
    }

    public void setChint(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330637064")) {
            ipChange.ipc$dispatch("-1330637064", new Object[]{this, str});
            return;
        }
        this.chint = str;
    }

    public void setFn(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1858676980")) {
            ipChange.ipc$dispatch("1858676980", new Object[]{this, str});
            return;
        }
        this.fn = str;
    }

    public void setGroupId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1700840230")) {
            ipChange.ipc$dispatch("1700840230", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.groupId = j;
    }

    public void setGroupPriceId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2039004137")) {
            ipChange.ipc$dispatch("-2039004137", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.groupPriceId = j;
    }

    public void setI(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1828013588")) {
            ipChange.ipc$dispatch("1828013588", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.i = i2;
    }

    public void setPlid(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1327711895")) {
            ipChange.ipc$dispatch("-1327711895", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.plid = j;
    }

    public void setRhint(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865339959")) {
            ipChange.ipc$dispatch("-865339959", new Object[]{this, str});
            return;
        }
        this.rhint = str;
    }

    public void setSid(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2044641158")) {
            ipChange.ipc$dispatch("-2044641158", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.sid = j;
    }

    public void setX(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1841866403")) {
            ipChange.ipc$dispatch("1841866403", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.x = i2;
    }

    public void setY(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1842789924")) {
            ipChange.ipc$dispatch("1842789924", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.y = i2;
    }
}
