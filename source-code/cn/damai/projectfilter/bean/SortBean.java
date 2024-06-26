package cn.damai.projectfilter.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.rk1;

/* compiled from: Taobao */
public class SortBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SORT_DISTANCE = "4";
    public static final String SORT_HOT = "10";
    public static final String SORT_NEW = "1";
    public static final String SORT_REC = "3";
    public static final String SORT_RECENT = "2";
    public int index;
    public String name;
    public String value;

    public SortBean(String str, String str2) {
        this.value = str;
        this.name = str2;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-776300758")) {
            return ((Boolean) ipChange.ipc$dispatch("-776300758", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return rk1.a(this.value, ((SortBean) obj).value);
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-31580447")) {
            return ((Integer) ipChange.ipc$dispatch("-31580447", new Object[]{this})).intValue();
        }
        return rk1.b(this.value);
    }

    public boolean isLocationSort() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "170074000")) {
            return TextUtils.equals("4", this.value);
        }
        return ((Boolean) ipChange.ipc$dispatch("170074000", new Object[]{this})).booleanValue();
    }

    public SortBean() {
    }
}
