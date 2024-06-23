package cn.damai.common.badge.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class BadgeDTO implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private long badgeUpdateTime;
    private int count;
    private String elimination;
    private String ext;
    private String nodeId;
    private String style;
    private String text;

    public long getBadgeUpdateTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1335863500")) {
            return this.badgeUpdateTime;
        }
        return ((Long) ipChange.ipc$dispatch("-1335863500", new Object[]{this})).longValue();
    }

    public int getCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "962668189")) {
            return this.count;
        }
        return ((Integer) ipChange.ipc$dispatch("962668189", new Object[]{this})).intValue();
    }

    public String getElimination() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1031423828")) {
            return this.elimination;
        }
        return (String) ipChange.ipc$dispatch("-1031423828", new Object[]{this});
    }

    public String getExt() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1093043640")) {
            return this.ext;
        }
        return (String) ipChange.ipc$dispatch("-1093043640", new Object[]{this});
    }

    public String getNodeId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1011898796")) {
            return this.nodeId;
        }
        return (String) ipChange.ipc$dispatch("1011898796", new Object[]{this});
    }

    public String getStyle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1673863464")) {
            return this.style;
        }
        return (String) ipChange.ipc$dispatch("-1673863464", new Object[]{this});
    }

    public String getText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1679761124")) {
            return this.text;
        }
        return (String) ipChange.ipc$dispatch("-1679761124", new Object[]{this});
    }

    public void setBadgeUpdateTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1443903752")) {
            ipChange.ipc$dispatch("-1443903752", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.badgeUpdateTime = j;
    }

    public void setCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1326965261")) {
            ipChange.ipc$dispatch("1326965261", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.count = i;
    }

    public void setElimination(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "85648458")) {
            ipChange.ipc$dispatch("85648458", new Object[]{this, str});
            return;
        }
        this.elimination = str;
    }

    public void setExt(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1893933614")) {
            ipChange.ipc$dispatch("1893933614", new Object[]{this, str});
            return;
        }
        this.ext = str;
    }

    public void setNodeId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-91000398")) {
            ipChange.ipc$dispatch("-91000398", new Object[]{this, str});
            return;
        }
        this.nodeId = str;
    }

    public void setStyle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2141207710")) {
            ipChange.ipc$dispatch("2141207710", new Object[]{this, str});
            return;
        }
        this.style = str;
    }

    public void setText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-825744062")) {
            ipChange.ipc$dispatch("-825744062", new Object[]{this, str});
            return;
        }
        this.text = str;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1817823945")) {
            return (String) ipChange.ipc$dispatch("1817823945", new Object[]{this});
        }
        return "BadgeDTO{nodeId='" + this.nodeId + '\'' + ", badgeUpdateTime=" + this.badgeUpdateTime + ", count=" + this.count + ", elimination='" + this.elimination + '\'' + ", style='" + this.style + '\'' + ", ext='" + this.ext + '\'' + ", text='" + this.text + '\'' + '}';
    }
}
