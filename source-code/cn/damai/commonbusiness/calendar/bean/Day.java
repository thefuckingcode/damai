package cn.damai.commonbusiness.calendar.bean;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.calendar.bean.DispatchDesc;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: Taobao */
public class Day implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DAYTYPE_DEFAULT = 0;
    public static final int DAYTYPE_HOLIDAY = 2;
    public static final int DAYTYPE_WORKDAY = 1;
    public static final int SELECTTYPE_DEFAULT = 0;
    public static final int SELECTTYPE_END = 3;
    public static final int SELECTTYPE_MIDDLE = 4;
    public static final int SELECTTYPE_SINGLE = 1;
    public static final int SELECTTYPE_START = 2;
    private static final long serialVersionUID = -5927147184520542346L;
    public int day;
    public int dayType;
    public int month;
    public String project;
    public String projectId;
    public String projectName;
    public int selectType = 0;
    public int showType = 0;
    public String tag;
    public String tip;
    public DispatchDesc.TYPE tipBg;
    public int year;

    public Day() {
    }

    private String for2L(int i) {
        StringBuilder sb;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1239750334")) {
            return (String) ipChange.ipc$dispatch("-1239750334", new Object[]{this, Integer.valueOf(i)});
        }
        if ((i + "").length() == 1) {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(i);
        } else {
            sb = new StringBuilder();
            sb.append(i);
            sb.append("");
        }
        return sb.toString();
    }

    public boolean equals(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "258373123")) {
            return ((Boolean) ipChange.ipc$dispatch("258373123", new Object[]{this, obj})).booleanValue();
        } else if (!(obj instanceof Day)) {
            return super.equals(obj);
        } else {
            Day day2 = (Day) obj;
            if (this.year == day2.year && this.month == day2.month && this.day == day2.day) {
                return true;
            }
            return false;
        }
    }

    public boolean isAfterDay(Day day2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1289594616")) {
            return ((Boolean) ipChange.ipc$dispatch("-1289594616", new Object[]{this, day2})).booleanValue();
        } else if (day2 == null) {
            return false;
        } else {
            int i = this.year;
            int i2 = day2.year;
            if (i > i2) {
                return true;
            }
            if (i != i2 || this.month <= day2.month) {
                return i == i2 && this.month == day2.month && this.day > day2.day;
            }
            return true;
        }
    }

    public String toShortDateString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1646268200")) {
            return (String) ipChange.ipc$dispatch("-1646268200", new Object[]{this});
        }
        return for2L(this.month) + for2L(this.day);
    }

    public Date toSimpleDate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94684592")) {
            return (Date) ipChange.ipc$dispatch("-94684592", new Object[]{this});
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT);
        try {
            return simpleDateFormat.parse(this.year + "-" + this.month + "-" + this.day);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toSimpleDateString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-530667862")) {
            return (String) ipChange.ipc$dispatch("-530667862", new Object[]{this});
        }
        return this.year + "-" + this.month + "-" + this.day;
    }

    public Day(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.day = i3;
    }
}
