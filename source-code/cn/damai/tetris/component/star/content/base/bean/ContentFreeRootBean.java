package cn.damai.tetris.component.star.content.base.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class ContentFreeRootBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean artistVip;
    private Button button;
    private List<ContentItemBean> contents;
    private boolean hasNext;
    private String subPageUrl;
    private int type;

    public boolean getArtistVip() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1788398153")) {
            return this.artistVip;
        }
        return ((Boolean) ipChange.ipc$dispatch("1788398153", new Object[]{this})).booleanValue();
    }

    public Button getButton() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-250203627")) {
            return this.button;
        }
        return (Button) ipChange.ipc$dispatch("-250203627", new Object[]{this});
    }

    public List<ContentItemBean> getContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1604078130")) {
            return this.contents;
        }
        return (List) ipChange.ipc$dispatch("1604078130", new Object[]{this});
    }

    public boolean getHasNext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1289479406")) {
            return this.hasNext;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1289479406", new Object[]{this})).booleanValue();
    }

    public String getSubPageUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1628671951")) {
            return this.subPageUrl;
        }
        return (String) ipChange.ipc$dispatch("-1628671951", new Object[]{this});
    }

    public int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "935830600")) {
            return this.type;
        }
        return ((Integer) ipChange.ipc$dispatch("935830600", new Object[]{this})).intValue();
    }

    public void setArtistVip(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2069338019")) {
            ipChange.ipc$dispatch("2069338019", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.artistVip = z;
    }

    public void setButton(Button button2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471828265")) {
            ipChange.ipc$dispatch("-471828265", new Object[]{this, button2});
            return;
        }
        this.button = button2;
    }

    public void setContents(List<ContentItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1992236506")) {
            ipChange.ipc$dispatch("1992236506", new Object[]{this, list});
            return;
        }
        this.contents = list;
    }

    public void setHasNext(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1204120826")) {
            ipChange.ipc$dispatch("1204120826", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.hasNext = z;
    }

    public void setSubPageUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1059106355")) {
            ipChange.ipc$dispatch("-1059106355", new Object[]{this, str});
            return;
        }
        this.subPageUrl = str;
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1142572454")) {
            ipChange.ipc$dispatch("-1142572454", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.type = i;
    }
}
