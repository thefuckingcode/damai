package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class Tips implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public String link;
    public String linkText;
    public String text;

    public String getLink() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-651267258")) {
            return this.link;
        }
        return (String) ipChange.ipc$dispatch("-651267258", new Object[]{this});
    }

    public String getLinkText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "695094931")) {
            return this.linkText;
        }
        return (String) ipChange.ipc$dispatch("695094931", new Object[]{this});
    }

    public String getText() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1125019897")) {
            return this.text;
        }
        return (String) ipChange.ipc$dispatch("1125019897", new Object[]{this});
    }

    public void setLink(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "992794712")) {
            ipChange.ipc$dispatch("992794712", new Object[]{this, str});
            return;
        }
        this.link = str;
    }

    public void setLinkText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "190778539")) {
            ipChange.ipc$dispatch("190778539", new Object[]{this, str});
            return;
        }
        this.linkText = str;
    }

    public void setText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "223121669")) {
            ipChange.ipc$dispatch("223121669", new Object[]{this, str});
            return;
        }
        this.text = str;
    }
}
