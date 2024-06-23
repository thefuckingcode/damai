package cn.damai.commonbusiness.calendarcopy.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.e92;

/* compiled from: Taobao */
public class CalendarDayBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -6885182279018781882L;
    public String comboDispatchId;
    public String configText;
    public int day;
    public List<String> desc;
    public DispatchDesc dispatchDesc;
    public int hasProject;
    public int isHoliday;
    public int isWorkDay;
    public String itemId;
    public String projectId;

    public int getDay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "731257260")) {
            return this.day;
        }
        return ((Integer) ipChange.ipc$dispatch("731257260", new Object[]{this})).intValue();
    }

    public String getDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "575536444")) {
            return e92.a(this.desc) > 0 ? this.desc.get(0) : "";
        }
        return (String) ipChange.ipc$dispatch("575536444", new Object[]{this});
    }

    public boolean hasHoliday() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1873643067")) {
            return this.isHoliday == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1873643067", new Object[]{this})).booleanValue();
    }

    public boolean hasProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1573114724")) {
            return this.hasProject == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("1573114724", new Object[]{this})).booleanValue();
    }

    public boolean hasWorkDay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2095543694")) {
            return this.isWorkDay == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-2095543694", new Object[]{this})).booleanValue();
    }
}
