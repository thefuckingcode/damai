package cn.damai.commonbusiness.city.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class ManualBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -1247499811117824269L;
    private String cityId;
    private String url;

    public String getCityId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1415670426")) {
            return this.cityId;
        }
        return (String) ipChange.ipc$dispatch("-1415670426", new Object[]{this});
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "467193637")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("467193637", new Object[]{this});
    }

    public void setCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1963765048")) {
            ipChange.ipc$dispatch("1963765048", new Object[]{this, str});
            return;
        }
        this.cityId = str;
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1278318351")) {
            ipChange.ipc$dispatch("-1278318351", new Object[]{this, str});
            return;
        }
        this.url = str;
    }
}
