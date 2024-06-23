package cn.damai.projectfiltercopy.bean;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.rk1;

/* compiled from: Taobao */
public class CategoryLevelTwo implements Serializable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String name;
    public String parentValue;
    public int pos;
    public boolean select = false;
    public String value;

    @Override // java.lang.Object
    @NonNull
    public Object clone() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1064081989")) {
            return ipChange.ipc$dispatch("-1064081989", new Object[]{this});
        }
        try {
            return super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            CategoryLevelTwo categoryLevelTwo = new CategoryLevelTwo();
            categoryLevelTwo.value = this.value;
            categoryLevelTwo.parentValue = this.parentValue;
            categoryLevelTwo.name = this.name;
            categoryLevelTwo.select = this.select;
            return categoryLevelTwo;
        }
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "372186615")) {
            return ((Boolean) ipChange.ipc$dispatch("372186615", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CategoryLevelTwo categoryLevelTwo = (CategoryLevelTwo) obj;
            if (!rk1.a(this.value, categoryLevelTwo.value) || !rk1.a(this.parentValue, categoryLevelTwo.parentValue)) {
                return false;
            }
            return true;
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1106518098")) {
            return ((Integer) ipChange.ipc$dispatch("-1106518098", new Object[]{this})).intValue();
        }
        return rk1.b(this.value, this.parentValue);
    }

    public boolean isAll() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-413169311")) {
            return TextUtils.equals(this.value, this.parentValue);
        }
        return ((Boolean) ipChange.ipc$dispatch("-413169311", new Object[]{this})).booleanValue();
    }

    public boolean isAllFilter() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1052279607")) {
            return TextUtils.isEmpty(this.value) && TextUtils.isEmpty(this.parentValue);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1052279607", new Object[]{this})).booleanValue();
    }
}
