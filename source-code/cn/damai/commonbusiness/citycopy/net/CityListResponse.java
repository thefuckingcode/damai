package cn.damai.commonbusiness.citycopy.net;

import cn.damai.commonbusiness.citycopy.model.GroupsBean;
import cn.damai.commonbusiness.citycopy.model.HotCityBean;
import cn.damai.commonbusiness.citycopy.model.ManualBean;
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
        if (!AndroidInstantRuntime.support(ipChange, "1637798118")) {
            return this.groups;
        }
        return (List) ipChange.ipc$dispatch("1637798118", new Object[]{this});
    }

    public List<HotCityBean> getHotCity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1988133290")) {
            return this.hotCity;
        }
        return (List) ipChange.ipc$dispatch("1988133290", new Object[]{this});
    }

    public List<ManualBean> getManual() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1548548520")) {
            return this.manual;
        }
        return (List) ipChange.ipc$dispatch("-1548548520", new Object[]{this});
    }

    public void setGroups(List<GroupsBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-155075930")) {
            ipChange.ipc$dispatch("-155075930", new Object[]{this, list});
            return;
        }
        this.groups = list;
    }

    public void setHotCity(List<HotCityBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "604536826")) {
            ipChange.ipc$dispatch("604536826", new Object[]{this, list});
            return;
        }
        this.hotCity = list;
    }

    public void setManual(List<ManualBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-147573900")) {
            ipChange.ipc$dispatch("-147573900", new Object[]{this, list});
            return;
        }
        this.manual = list;
    }
}
