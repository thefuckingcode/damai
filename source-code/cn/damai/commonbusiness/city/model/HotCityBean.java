package cn.damai.commonbusiness.city.model;

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
        if (!AndroidInstantRuntime.support(ipChange, "-1948231954")) {
            return this.cityId;
        }
        return (String) ipChange.ipc$dispatch("-1948231954", new Object[]{this});
    }

    public String getCityName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "425716318")) {
            return this.cityName;
        }
        return (String) ipChange.ipc$dispatch("425716318", new Object[]{this});
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1906424477")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("1906424477", new Object[]{this});
    }

    public void setCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1660740432")) {
            ipChange.ipc$dispatch("-1660740432", new Object[]{this, str});
            return;
        }
        this.cityId = str;
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "429976128")) {
            ipChange.ipc$dispatch("429976128", new Object[]{this, str});
            return;
        }
        this.cityName = str;
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "388164729")) {
            ipChange.ipc$dispatch("388164729", new Object[]{this, str});
            return;
        }
        this.url = str;
    }
}
