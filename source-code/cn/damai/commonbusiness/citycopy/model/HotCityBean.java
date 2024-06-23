package cn.damai.commonbusiness.citycopy.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class HotCityBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -2528745449406752592L;
    private String cityId;
    private String cityName;
    private String url;

    public String getCityId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "7425827")) {
            return this.cityId;
        }
        return (String) ipChange.ipc$dispatch("7425827", new Object[]{this});
    }

    public String getCityName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1382831789")) {
            return this.cityName;
        }
        return (String) ipChange.ipc$dispatch("-1382831789", new Object[]{this});
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1924511368")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("1924511368", new Object[]{this});
    }

    public void setCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1164891365")) {
            ipChange.ipc$dispatch("-1164891365", new Object[]{this, str});
            return;
        }
        this.cityId = str;
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "199559659")) {
            ipChange.ipc$dispatch("199559659", new Object[]{this, str});
            return;
        }
        this.cityName = str;
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "948858350")) {
            ipChange.ipc$dispatch("948858350", new Object[]{this, str});
            return;
        }
        this.url = str;
    }
}
