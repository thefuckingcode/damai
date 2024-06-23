package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class GaoDeCode {
    private static transient /* synthetic */ IpChange $ipChange;
    public String code;
    public String name;

    public String getCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "817907942")) {
            return this.code;
        }
        return (String) ipChange.ipc$dispatch("817907942", new Object[]{this});
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1328637308")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-1328637308", new Object[]{this});
    }

    public void setCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-707414344")) {
            ipChange.ipc$dispatch("-707414344", new Object[]{this, str});
            return;
        }
        this.code = str;
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469159642")) {
            ipChange.ipc$dispatch("1469159642", new Object[]{this, str});
            return;
        }
        this.name = str;
    }
}
