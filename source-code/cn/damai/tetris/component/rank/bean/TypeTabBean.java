package cn.damai.tetris.component.rank.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.rk1;

/* compiled from: Taobao */
public class TypeTabBean implements Serializable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String desc;
    public String id;
    public String name;
    public List<String> parentId;
    public int pos;
    public String type;

    @Override // java.lang.Object
    public Object clone() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1747573148")) {
            return ipChange.ipc$dispatch("-1747573148", new Object[]{this});
        }
        try {
            return super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return this;
        }
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "667179104")) {
            return ((Boolean) ipChange.ipc$dispatch("667179104", new Object[]{this, obj})).booleanValue();
        } else if (this == obj) {
            return true;
        } else {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TypeTabBean typeTabBean = (TypeTabBean) obj;
            if (!rk1.a(this.name, typeTabBean.name) || !rk1.a(this.id, typeTabBean.id)) {
                return false;
            }
            return true;
        }
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "701303831")) {
            return ((Integer) ipChange.ipc$dispatch("701303831", new Object[]{this})).intValue();
        }
        return rk1.b(this.name, this.id);
    }
}
