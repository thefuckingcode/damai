package cn.damai.tetris.component.star.content.base.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class Button {
    private static transient /* synthetic */ IpChange $ipChange;
    private String destination;
    private String name;

    public String getDestination() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-303062110")) {
            return this.destination;
        }
        return (String) ipChange.ipc$dispatch("-303062110", new Object[]{this});
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1605281747")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-1605281747", new Object[]{this});
    }

    public void setDestination(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190025236")) {
            ipChange.ipc$dispatch("1190025236", new Object[]{this, str});
            return;
        }
        this.destination = str;
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1483116625")) {
            ipChange.ipc$dispatch("1483116625", new Object[]{this, str});
            return;
        }
        this.name = str;
    }
}
