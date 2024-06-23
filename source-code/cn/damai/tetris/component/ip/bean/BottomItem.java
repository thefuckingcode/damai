package cn.damai.tetris.component.ip.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class BottomItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String cityName;
    private String discount;
    private long id;
    private boolean isClosest;
    public String name;
    private long nearestTime;
    private String priceLow;
    private String showTime;
    private String startDate;
    private int total;
    private int type;
    private String venueName;
    public String verticalPic;

    public String getCityName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "828587993")) {
            return this.cityName;
        }
        return (String) ipChange.ipc$dispatch("828587993", new Object[]{this});
    }

    public String getDiscount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1338234628")) {
            return this.discount;
        }
        return (String) ipChange.ipc$dispatch("1338234628", new Object[]{this});
    }

    public long getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "436052214")) {
            return this.id;
        }
        return ((Long) ipChange.ipc$dispatch("436052214", new Object[]{this})).longValue();
    }

    public boolean getIsClosest() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1924753858")) {
            return this.isClosest;
        }
        return ((Boolean) ipChange.ipc$dispatch("1924753858", new Object[]{this})).booleanValue();
    }

    public long getNearestTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2131638346")) {
            return this.nearestTime;
        }
        return ((Long) ipChange.ipc$dispatch("-2131638346", new Object[]{this})).longValue();
    }

    public String getPriceLow() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2101084686")) {
            return this.priceLow;
        }
        return (String) ipChange.ipc$dispatch("2101084686", new Object[]{this});
    }

    public String getShowTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "756649645")) {
            return this.showTime;
        }
        return (String) ipChange.ipc$dispatch("756649645", new Object[]{this});
    }

    public String getStartDate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2073990531")) {
            return this.startDate;
        }
        return (String) ipChange.ipc$dispatch("2073990531", new Object[]{this});
    }

    public int getTotal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-747294692")) {
            return this.total;
        }
        return ((Integer) ipChange.ipc$dispatch("-747294692", new Object[]{this})).intValue();
    }

    public int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-18549642")) {
            return this.type;
        }
        return ((Integer) ipChange.ipc$dispatch("-18549642", new Object[]{this})).intValue();
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "898342637")) {
            return this.venueName;
        }
        return (String) ipChange.ipc$dispatch("898342637", new Object[]{this});
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34096165")) {
            ipChange.ipc$dispatch("34096165", new Object[]{this, str});
            return;
        }
        this.cityName = str;
    }

    public void setDiscount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1346727334")) {
            ipChange.ipc$dispatch("-1346727334", new Object[]{this, str});
            return;
        }
        this.discount = str;
    }

    public void setId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "418130446")) {
            ipChange.ipc$dispatch("418130446", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.id = j;
    }

    public void setIsClosest(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2001397578")) {
            ipChange.ipc$dispatch("2001397578", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isClosest = z;
    }

    public void setNearestTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-736214858")) {
            ipChange.ipc$dispatch("-736214858", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.nearestTime = j;
    }

    public void setPriceLow(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826787984")) {
            ipChange.ipc$dispatch("826787984", new Object[]{this, str});
            return;
        }
        this.priceLow = str;
    }

    public void setShowTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2098974673")) {
            ipChange.ipc$dispatch("2098974673", new Object[]{this, str});
            return;
        }
        this.showTime = str;
    }

    public void setStartDate(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2096007853")) {
            ipChange.ipc$dispatch("-2096007853", new Object[]{this, str});
            return;
        }
        this.startDate = str;
    }

    public void setTotal(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142276498")) {
            ipChange.ipc$dispatch("-142276498", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.total = i;
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-663588884")) {
            ipChange.ipc$dispatch("-663588884", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.type = i;
    }

    public void setVenueName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "113613097")) {
            ipChange.ipc$dispatch("113613097", new Object[]{this, str});
            return;
        }
        this.venueName = str;
    }
}
