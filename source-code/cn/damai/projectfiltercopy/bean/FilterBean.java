package cn.damai.projectfiltercopy.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.rk1;

/* compiled from: Taobao */
public class FilterBean implements Serializable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean isSelected;
    public String name;
    public String option;
    public String value;

    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1458983939")) {
            return super.clone();
        }
        return ipChange.ipc$dispatch("-1458983939", new Object[]{this});
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171465287")) {
            return ((Boolean) ipChange.ipc$dispatch("-1171465287", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            FilterBean filterBean = (FilterBean) obj;
            if (!rk1.a(this.value, filterBean.value) || !rk1.a(this.option, filterBean.option)) {
                return false;
            }
            return true;
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309420400")) {
            return ((Integer) ipChange.ipc$dispatch("309420400", new Object[]{this})).intValue();
        }
        return rk1.b(this.value, this.option);
    }
}
