package cn.damai.common.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.z20;

/* compiled from: Taobao */
public class CustomDate implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public int day;
    public int month;
    public int week;
    public int year;

    public CustomDate(int i, int i2, int i3) {
        if (i2 > 12) {
            i++;
            i2 = 1;
        } else if (i2 < 1) {
            i--;
            i2 = 12;
        }
        this.year = i;
        this.month = i2;
        this.day = i3;
    }

    public static CustomDate modifiDayForObject(CustomDate customDate, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1121999934")) {
            return new CustomDate(customDate.year, customDate.month, i);
        }
        return (CustomDate) ipChange.ipc$dispatch("-1121999934", new Object[]{customDate, Integer.valueOf(i)});
    }

    public int getDay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1413465616")) {
            return this.day;
        }
        return ((Integer) ipChange.ipc$dispatch("1413465616", new Object[]{this})).intValue();
    }

    public int getMonth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1066521684")) {
            return this.month;
        }
        return ((Integer) ipChange.ipc$dispatch("-1066521684", new Object[]{this})).intValue();
    }

    public int getWeek() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "648502192")) {
            return this.week;
        }
        return ((Integer) ipChange.ipc$dispatch("648502192", new Object[]{this})).intValue();
    }

    public int getYear() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1874943289")) {
            return this.year;
        }
        return ((Integer) ipChange.ipc$dispatch("-1874943289", new Object[]{this})).intValue();
    }

    public void setDay(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1490371078")) {
            ipChange.ipc$dispatch("-1490371078", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.day = i;
    }

    public void setMonth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1448378658")) {
            ipChange.ipc$dispatch("-1448378658", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.month = i;
    }

    public void setWeek(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1459818510")) {
            ipChange.ipc$dispatch("-1459818510", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.week = i;
    }

    public void setYear(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917750203")) {
            ipChange.ipc$dispatch("1917750203", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.year = i;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328927575")) {
            return (String) ipChange.ipc$dispatch("-328927575", new Object[]{this});
        }
        return this.year + "-" + this.month + "-" + this.day;
    }

    public CustomDate() {
        this.year = z20.c();
        this.month = z20.b();
        this.day = z20.a();
    }
}
