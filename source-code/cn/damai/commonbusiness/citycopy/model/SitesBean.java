package cn.damai.commonbusiness.citycopy.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SitesBean {
    private static transient /* synthetic */ IpChange $ipChange;
    private String cityId;
    private String cityName;

    public String getCityId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1334010921")) {
            return this.cityId;
        }
        return (String) ipChange.ipc$dispatch("-1334010921", new Object[]{this});
    }

    public String getCityName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2013357817")) {
            return this.cityName;
        }
        return (String) ipChange.ipc$dispatch("-2013357817", new Object[]{this});
    }

    public void setCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "200242407")) {
            ipChange.ipc$dispatch("200242407", new Object[]{this, str});
            return;
        }
        this.cityId = str;
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2128089271")) {
            ipChange.ipc$dispatch("2128089271", new Object[]{this, str});
            return;
        }
        this.cityName = str;
    }
}
