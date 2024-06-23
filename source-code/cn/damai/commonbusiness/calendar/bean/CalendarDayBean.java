package cn.damai.commonbusiness.calendar.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class CalendarDayBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -6885182279018781882L;
    public String configText;
    public int day;
    public List<String> desc;
    public DispatchDesc dispatchDesc;
    public int hasProject;
    public int isHoliday;
    public int isWorkDay;
    public String projectId;

    public int getDay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "152044801")) {
            return this.day;
        }
        return ((Integer) ipChange.ipc$dispatch("152044801", new Object[]{this})).intValue();
    }

    public String getDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1529504431")) {
            return xf2.e(this.desc) > 0 ? this.desc.get(0) : "";
        }
        return (String) ipChange.ipc$dispatch("-1529504431", new Object[]{this});
    }

    public boolean hasHoliday() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-41110886")) {
            return this.isHoliday == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-41110886", new Object[]{this})).booleanValue();
    }

    public boolean hasProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-889320391")) {
            return this.hasProject == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-889320391", new Object[]{this})).booleanValue();
    }

    public boolean hasWorkDay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-263011513")) {
            return this.isWorkDay == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-263011513", new Object[]{this})).booleanValue();
    }
}
