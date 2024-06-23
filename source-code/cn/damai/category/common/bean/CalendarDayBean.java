package cn.damai.category.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class CalendarDayBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 6648594110345421814L;
    public String configText;
    public int day;
    public List<String> desc;
    public int hasProject;
    public int isHoliday;
    public int isWorkDay;
    public String projectId;

    public int getDay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1993935545")) {
            return this.day;
        }
        return ((Integer) ipChange.ipc$dispatch("-1993935545", new Object[]{this})).intValue();
    }

    public String getDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2086189033")) {
            return xf2.e(this.desc) > 0 ? this.desc.get(0) : "";
        }
        return (String) ipChange.ipc$dispatch("-2086189033", new Object[]{this});
    }

    public boolean hasHoliday() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1132064800")) {
            return this.isHoliday == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1132064800", new Object[]{this})).booleanValue();
    }

    public boolean hasProject() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1980274305")) {
            return this.hasProject == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1980274305", new Object[]{this})).booleanValue();
    }

    public boolean hasWorkDay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1353965427")) {
            return this.isWorkDay == 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1353965427", new Object[]{this})).booleanValue();
    }
}
