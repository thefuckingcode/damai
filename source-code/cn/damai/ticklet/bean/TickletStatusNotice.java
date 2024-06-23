package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class TickletStatusNotice implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String announcementSkipURL;
    public String imageUrl;
    private String notice;
    private String popupContent;
    private String popupTitle;

    public String getAnnouncementSkipURL() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-929533247")) {
            return this.announcementSkipURL;
        }
        return (String) ipChange.ipc$dispatch("-929533247", new Object[]{this});
    }

    public String getNotice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-816414666")) {
            return this.notice;
        }
        return (String) ipChange.ipc$dispatch("-816414666", new Object[]{this});
    }

    public String getPopupContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "101987531")) {
            return this.popupContent;
        }
        return (String) ipChange.ipc$dispatch("101987531", new Object[]{this});
    }

    public String getPopupTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1167453462")) {
            return this.popupTitle;
        }
        return (String) ipChange.ipc$dispatch("-1167453462", new Object[]{this});
    }

    public void setAnnouncementSkipURL(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371037483")) {
            ipChange.ipc$dispatch("-1371037483", new Object[]{this, str});
            return;
        }
        this.announcementSkipURL = str;
    }

    public void setNotice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934142872")) {
            ipChange.ipc$dispatch("-934142872", new Object[]{this, str});
            return;
        }
        this.notice = str;
    }

    public void setPopupContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-735472781")) {
            ipChange.ipc$dispatch("-735472781", new Object[]{this, str});
            return;
        }
        this.popupContent = str;
    }

    public void setPopupTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "353764916")) {
            ipChange.ipc$dispatch("353764916", new Object[]{this, str});
            return;
        }
        this.popupTitle = str;
    }
}
