package cn.damai.tetris.component.rank.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.rk1;

/* compiled from: Taobao */
public class CategoryTabBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String desc;
    public String id;
    public String name;
    public int pos;
    public List<TypeTabBean> subTypeList = new ArrayList();
    public String type;

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632245660")) {
            return ((Boolean) ipChange.ipc$dispatch("1632245660", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return rk1.a(this.id, ((CategoryTabBean) obj).id);
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1943061331")) {
            return ((Integer) ipChange.ipc$dispatch("1943061331", new Object[]{this})).intValue();
        }
        return rk1.b(this.id);
    }
}
