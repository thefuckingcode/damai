package cn.damai.tetris.component.drama.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FilterDateBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public String calendarText;
    public int dateType;
    public String endDate;
    public int index;
    public String startDate;

    public FilterDateBean() {
    }

    public static FilterDateBean defaultDateBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-375369313") ? (FilterDateBean) ipChange.ipc$dispatch("-375369313", new Object[0]) : new FilterDateBean("全部时间", 0, null, null, 0);
    }

    private boolean textEquals(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-90978583")) {
            return TextUtils.equals(str, str2);
        }
        return ((Boolean) ipChange.ipc$dispatch("-90978583", new Object[]{this, str, str2})).booleanValue();
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-831501986")) {
            return ((Boolean) ipChange.ipc$dispatch("-831501986", new Object[]{this, obj})).booleanValue();
        } else if (!(obj instanceof FilterDateBean)) {
            return super.equals(obj);
        } else {
            FilterDateBean filterDateBean = (FilterDateBean) obj;
            boolean textEquals = textEquals(this.calendarText, filterDateBean.calendarText);
            boolean textEquals2 = textEquals(this.startDate, filterDateBean.startDate);
            boolean textEquals3 = textEquals(this.endDate, filterDateBean.endDate);
            boolean z = this.dateType == filterDateBean.dateType;
            if (!textEquals || !textEquals2 || !textEquals3 || !z) {
                return false;
            }
            return true;
        }
    }

    public FilterDateBean(String str, int i, String str2, String str3, int i2) {
        this.calendarText = str;
        this.dateType = i;
        this.startDate = str2;
        this.endDate = str3;
        this.index = i2;
    }
}
