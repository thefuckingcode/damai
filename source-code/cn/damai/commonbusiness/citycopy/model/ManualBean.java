package cn.damai.commonbusiness.citycopy.model;

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
        if (!AndroidInstantRuntime.support(ipChange, "-1214037359")) {
            return this.cityId;
        }
        return (String) ipChange.ipc$dispatch("-1214037359", new Object[]{this});
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1437608410")) {
            return this.url;
        }
        return (String) ipChange.ipc$dispatch("1437608410", new Object[]{this});
    }

    public void setCityId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-375544467")) {
            ipChange.ipc$dispatch("-375544467", new Object[]{this, str});
            return;
        }
        this.cityId = str;
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1260231460")) {
            ipChange.ipc$dispatch("-1260231460", new Object[]{this, str});
            return;
        }
        this.url = str;
    }
}
