package cn.damai.tetris.component.star.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class TourInfoItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String tourDesc;
    private String tourName;
    private String tourPic;
    private String tourPriceLow;
    private List<String> tourTags;

    public String getTourDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-786928910")) {
            return this.tourDesc;
        }
        return (String) ipChange.ipc$dispatch("-786928910", new Object[]{this});
    }

    public String getTourName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1920017900")) {
            return this.tourName;
        }
        return (String) ipChange.ipc$dispatch("1920017900", new Object[]{this});
    }

    public String getTourPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "842486399")) {
            return this.tourPic;
        }
        return (String) ipChange.ipc$dispatch("842486399", new Object[]{this});
    }

    public String getTourPriceLow() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1346152020")) {
            return this.tourPriceLow;
        }
        return (String) ipChange.ipc$dispatch("-1346152020", new Object[]{this});
    }

    public List<String> getTourTags() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1596352351")) {
            return this.tourTags;
        }
        return (List) ipChange.ipc$dispatch("-1596352351", new Object[]{this});
    }

    public void setTourDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1492679724")) {
            ipChange.ipc$dispatch("1492679724", new Object[]{this, str});
            return;
        }
        this.tourDesc = str;
    }

    public void setTourName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491315086")) {
            ipChange.ipc$dispatch("-491315086", new Object[]{this, str});
            return;
        }
        this.tourName = str;
    }

    public void setTourPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1268978985")) {
            ipChange.ipc$dispatch("-1268978985", new Object[]{this, str});
            return;
        }
        this.tourPic = str;
    }

    public void setTourPriceLow(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1616841394")) {
            ipChange.ipc$dispatch("1616841394", new Object[]{this, str});
            return;
        }
        this.tourPriceLow = str;
    }

    public void setTourTags(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1563139403")) {
            ipChange.ipc$dispatch("1563139403", new Object[]{this, list});
            return;
        }
        this.tourTags = list;
    }
}
