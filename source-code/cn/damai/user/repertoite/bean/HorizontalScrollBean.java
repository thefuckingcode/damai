package cn.damai.user.repertoite.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class HorizontalScrollBean {
    private static transient /* synthetic */ IpChange $ipChange;
    private String des;
    private String name;
    private String url;

    public String getDes() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-850753160")) {
            return this.des;
        }
        return (String) ipChange.ipc$dispatch("-850753160", new Object[]{this});
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-901629029")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-901629029", new Object[]{this});
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "925989461")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("925989461", new Object[]{this});
    }

    public void setDes(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "815003902")) {
            ipChange.ipc$dispatch("815003902", new Object[]{this, str});
            return;
        }
        this.des = str;
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1821514403")) {
            ipChange.ipc$dispatch("1821514403", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "59450305")) {
            ipChange.ipc$dispatch("59450305", new Object[]{this, str});
            return;
        }
        this.url = str;
    }
}
