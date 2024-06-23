package cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class SkuPerformBase {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PERFORM_STATUS_NORMAL = 1;
    public static final int PERFORM_STATUS_OTHER = 0;
    public static final int PERFORM_STATUS_PERIOD = 5;
    public static final int PERFORM_STATUS_THROUGH_TICKET = 2;
    public static final int PERFORM_STATUS_TIME_SLOT = 3;
    public static final int PERFORM_STATUS_YEAR = 4;
    public static final int PERFORM_TAG_NO_PRIVILEGE = 4;
    public static final int PERFORM_TAG_NO_TICKET = 1;
    public static final int PERFORM_TAG_PACKAGE_TICKET = 5;
    public static final int PERFORM_TAG_PRE_SALE = 2;
    public static final int PERFORM_TAG_PROMOTION = 3;
    public boolean isSelected;
    public String name;
    public String performBaseTagDesc;
    public int performBaseTagValue;
    public List<SkuPerform> performs;
    public boolean permissionWithPrivilegeBuy = true;
    public int pos;
    public List<String> promotionTags;
    public long timeSpan;
    public int type;

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1100554845")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-1100554845", new Object[]{this});
    }

    public List<SkuPerform> getPerforms() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-342679439")) {
            return this.performs;
        }
        return (List) ipChange.ipc$dispatch("-342679439", new Object[]{this});
    }

    public int getPos() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2056755551")) {
            return this.pos;
        }
        return ((Integer) ipChange.ipc$dispatch("-2056755551", new Object[]{this})).intValue();
    }

    public long getTimeSpan() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1821962651")) {
            return this.timeSpan;
        }
        return ((Long) ipChange.ipc$dispatch("-1821962651", new Object[]{this})).longValue();
    }

    public int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "205471105")) {
            return this.type;
        }
        return ((Integer) ipChange.ipc$dispatch("205471105", new Object[]{this})).intValue();
    }

    public boolean isSelected() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1601142005")) {
            return this.isSelected;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1601142005", new Object[]{this})).booleanValue();
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2102122768")) {
            return this.permissionWithPrivilegeBuy && !f92.d(this.performs);
        }
        return ((Boolean) ipChange.ipc$dispatch("2102122768", new Object[]{this})).booleanValue();
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-50218597")) {
            ipChange.ipc$dispatch("-50218597", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public void setPerforms(List<SkuPerform> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1772294011")) {
            ipChange.ipc$dispatch("1772294011", new Object[]{this, list});
            return;
        }
        this.performs = list;
    }

    public void setPos(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1693044855")) {
            ipChange.ipc$dispatch("-1693044855", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.pos = i;
    }

    public void setSelected(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "405323379")) {
            ipChange.ipc$dispatch("405323379", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isSelected = z;
    }

    public void setTimeSpan(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "264515967")) {
            ipChange.ipc$dispatch("264515967", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.timeSpan = j;
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1986086977")) {
            ipChange.ipc$dispatch("1986086977", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.type = i;
    }
}
