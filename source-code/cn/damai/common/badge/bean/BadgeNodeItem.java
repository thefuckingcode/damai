package cn.damai.common.badge.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class BadgeNodeItem implements Serializable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange;
    private int count;
    private int elimination;
    private String ext;
    private String nodeId;
    private int style;
    private String text;
    private long version;

    @Override // java.lang.Object
    public Object clone() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1396566488")) {
            return ipChange.ipc$dispatch("-1396566488", new Object[]{this});
        }
        try {
            return super.clone();
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "28780253")) {
            return this.count;
        }
        return ((Integer) ipChange.ipc$dispatch("28780253", new Object[]{this})).intValue();
    }

    public int getElimination() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-604650841")) {
            return this.elimination;
        }
        return ((Integer) ipChange.ipc$dispatch("-604650841", new Object[]{this})).intValue();
    }

    public String getExt() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-465899000")) {
            return this.ext;
        }
        return (String) ipChange.ipc$dispatch("-465899000", new Object[]{this});
    }

    public String getNodeId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1170131436")) {
            return this.nodeId;
        }
        return (String) ipChange.ipc$dispatch("1170131436", new Object[]{this});
    }

    public int getStyle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1896251653")) {
            return this.style;
        }
        return ((Integer) ipChange.ipc$dispatch("-1896251653", new Object[]{this})).intValue();
    }

    public String getText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "581853532")) {
            return this.text;
        }
        return (String) ipChange.ipc$dispatch("581853532", new Object[]{this});
    }

    public long getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1989299851")) {
            return this.version;
        }
        return ((Long) ipChange.ipc$dispatch("-1989299851", new Object[]{this})).longValue();
    }

    public void setCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1853756979")) {
            ipChange.ipc$dispatch("-1853756979", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i < 0) {
            i = 0;
        }
        this.count = i;
    }

    public void setElimination(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-644243389")) {
            ipChange.ipc$dispatch("-644243389", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.elimination = i;
    }

    public void setExt(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-139419026")) {
            ipChange.ipc$dispatch("-139419026", new Object[]{this, str});
            return;
        }
        this.ext = str;
    }

    public void setNodeId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "519244146")) {
            ipChange.ipc$dispatch("519244146", new Object[]{this, str});
            return;
        }
        this.nodeId = str;
    }

    public void setStyle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400203921")) {
            ipChange.ipc$dispatch("-1400203921", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.style = i;
    }

    public void setText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "564833538")) {
            ipChange.ipc$dispatch("564833538", new Object[]{this, str});
            return;
        }
        this.text = str;
    }

    public void setVersion(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "984508631")) {
            ipChange.ipc$dispatch("984508631", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.version = j;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086565751")) {
            return (String) ipChange.ipc$dispatch("-1086565751", new Object[]{this});
        }
        return "BadgeNodeItem{nodeId='" + this.nodeId + '\'' + ", version=" + this.version + ", count=" + this.count + ", elimination=" + this.elimination + ", style=" + this.style + ", ext='" + this.ext + '\'' + ", text='" + this.text + '\'' + '}';
    }
}
