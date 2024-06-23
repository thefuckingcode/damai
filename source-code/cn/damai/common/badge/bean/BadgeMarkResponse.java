package cn.damai.common.badge.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class BadgeMarkResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<BadgeDTO> badgeDTOList;
    private List<String> failNodes;
    private boolean status;

    public List<BadgeDTO> getBadgeDTOList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1982022519")) {
            return this.badgeDTOList;
        }
        return (List) ipChange.ipc$dispatch("-1982022519", new Object[]{this});
    }

    public List<String> getFailNodes() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1508638744")) {
            return this.failNodes;
        }
        return (List) ipChange.ipc$dispatch("-1508638744", new Object[]{this});
    }

    public boolean isStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "435974500")) {
            return this.status;
        }
        return ((Boolean) ipChange.ipc$dispatch("435974500", new Object[]{this})).booleanValue();
    }

    public void setBadgeDTOList(List<BadgeDTO> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1777474659")) {
            ipChange.ipc$dispatch("1777474659", new Object[]{this, list});
            return;
        }
        this.badgeDTOList = list;
    }

    public void setFailNodes(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-233867652")) {
            ipChange.ipc$dispatch("-233867652", new Object[]{this, list});
            return;
        }
        this.failNodes = list;
    }

    public void setStatus(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1142040154")) {
            ipChange.ipc$dispatch("1142040154", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.status = z;
    }
}
