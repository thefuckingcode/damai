package cn.damai.tetris.component.star.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class TourCityItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String cityName;
    private long itemId;
    private String showTime;
    public String tourCityPic;
    private String venueName;

    public String getCityName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1783548668")) {
            return this.cityName;
        }
        return (String) ipChange.ipc$dispatch("1783548668", new Object[]{this});
    }

    public long getItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1443905696")) {
            return this.itemId;
        }
        return ((Long) ipChange.ipc$dispatch("-1443905696", new Object[]{this})).longValue();
    }

    public String getShowTime() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1711610320")) {
            return this.showTime;
        }
        return (String) ipChange.ipc$dispatch("1711610320", new Object[]{this});
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "437352490")) {
            return this.venueName;
        }
        return (String) ipChange.ipc$dispatch("437352490", new Object[]{this});
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-426893982")) {
            ipChange.ipc$dispatch("-426893982", new Object[]{this, str});
            return;
        }
        this.cityName = str;
    }

    public void setItemId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1037241628")) {
            ipChange.ipc$dispatch("-1037241628", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.itemId = j;
    }

    public void setShowTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1637984526")) {
            ipChange.ipc$dispatch("1637984526", new Object[]{this, str});
            return;
        }
        this.showTime = str;
    }

    public void setVenueName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1292179572")) {
            ipChange.ipc$dispatch("-1292179572", new Object[]{this, str});
            return;
        }
        this.venueName = str;
    }
}
