package cn.damai.commonbusiness.city.net;

import cn.damai.commonbusiness.city.model.GroupsBean;
import cn.damai.commonbusiness.city.model.HotCityBean;
import cn.damai.commonbusiness.city.model.ManualBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class CityListResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -4837290148575692679L;
    private List<GroupsBean> groups;
    private List<HotCityBean> hotCity;
    private List<ManualBean> manual;

    public List<GroupsBean> getGroups() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1141949051")) {
            return this.groups;
        }
        return (List) ipChange.ipc$dispatch("1141949051", new Object[]{this});
    }

    public List<HotCityBean> getHotCity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-498285899")) {
            return this.hotCity;
        }
        return (List) ipChange.ipc$dispatch("-498285899", new Object[]{this});
    }

    public List<ManualBean> getManual() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2044397587")) {
            return this.manual;
        }
        return (List) ipChange.ipc$dispatch("-2044397587", new Object[]{this});
    }

    public void setGroups(List<GroupsBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1653472177")) {
            ipChange.ipc$dispatch("1653472177", new Object[]{this, list});
            return;
        }
        this.groups = list;
    }

    public void setHotCity(List<HotCityBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "834953295")) {
            ipChange.ipc$dispatch("834953295", new Object[]{this, list});
            return;
        }
        this.hotCity = list;
    }

    public void setManual(List<ManualBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1660974207")) {
            ipChange.ipc$dispatch("1660974207", new Object[]{this, list});
            return;
        }
        this.manual = list;
    }
}
