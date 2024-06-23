package cn.damai.tetris.component.brand.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class ProjectDO implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String id;
    private String name;
    private String priceStr;
    private String showTime;
    private String subTitle;
    private String venueCity;
    private String venueName;
    private String verticalPic;

    public String getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "230626294")) {
            return this.id;
        }
        return (String) ipChange.ipc$dispatch("230626294", new Object[]{this});
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1635547802")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-1635547802", new Object[]{this});
    }

    public String getPriceStr() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "759199363")) {
            return this.priceStr;
        }
        return (String) ipChange.ipc$dispatch("759199363", new Object[]{this});
    }

    public String getShowTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1948448965")) {
            return this.showTime;
        }
        return (String) ipChange.ipc$dispatch("1948448965", new Object[]{this});
    }

    public String getSubTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2007390637")) {
            return this.subTitle;
        }
        return (String) ipChange.ipc$dispatch("-2007390637", new Object[]{this});
    }

    public String getVenueCity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-154769739")) {
            return this.venueCity;
        }
        return (String) ipChange.ipc$dispatch("-154769739", new Object[]{this});
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-810584107")) {
            return this.venueName;
        }
        return (String) ipChange.ipc$dispatch("-810584107", new Object[]{this});
    }

    public String getVerticalPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "329389935")) {
            return this.verticalPic;
        }
        return (String) ipChange.ipc$dispatch("329389935", new Object[]{this});
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695799976")) {
            ipChange.ipc$dispatch("1695799976", new Object[]{this, str});
            return;
        }
        this.id = str;
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544868920")) {
            ipChange.ipc$dispatch("544868920", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public void setPriceStr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2116951365")) {
            ipChange.ipc$dispatch("-2116951365", new Object[]{this, str});
            return;
        }
        this.priceStr = str;
    }

    public void setShowTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "390047929")) {
            ipChange.ipc$dispatch("390047929", new Object[]{this, str});
            return;
        }
        this.showTime = str;
    }

    public void setSubTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1981895445")) {
            ipChange.ipc$dispatch("-1981895445", new Object[]{this, str});
            return;
        }
        this.subTitle = str;
    }

    public void setVenueCity(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1826867809")) {
            ipChange.ipc$dispatch("1826867809", new Object[]{this, str});
            return;
        }
        this.venueCity = str;
    }

    public void setVenueName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1323508415")) {
            ipChange.ipc$dispatch("-1323508415", new Object[]{this, str});
            return;
        }
        this.venueName = str;
    }

    public void setVerticalPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678797849")) {
            ipChange.ipc$dispatch("-678797849", new Object[]{this, str});
            return;
        }
        this.verticalPic = str;
    }
}
