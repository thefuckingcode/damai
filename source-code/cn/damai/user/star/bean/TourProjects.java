package cn.damai.user.star.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class TourProjects implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String buttonText;
    public String cityName;
    public int index;
    public String onSaleTime;
    public String projectId;
    public String schema;
    public String showTime;
    public int status;

    public String getCityName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "73585684")) {
            return this.cityName;
        }
        return (String) ipChange.ipc$dispatch("73585684", new Object[]{this});
    }

    public String getProjectId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1621031308")) {
            return this.projectId;
        }
        return (String) ipChange.ipc$dispatch("1621031308", new Object[]{this});
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1896138934")) {
            ipChange.ipc$dispatch("-1896138934", new Object[]{this, str});
            return;
        }
        this.cityName = str;
    }

    public void setProjectId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042125418")) {
            ipChange.ipc$dispatch("1042125418", new Object[]{this, str});
            return;
        }
        this.projectId = str;
    }
}
