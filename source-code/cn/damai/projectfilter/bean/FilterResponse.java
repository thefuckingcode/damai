package cn.damai.projectfilter.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class FilterResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public FilterPrimaryBean primary;
    public List<FilterGroupBean> secondary;

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1255583560")) {
            return this.primary != null;
        }
        return ((Boolean) ipChange.ipc$dispatch("1255583560", new Object[]{this})).booleanValue();
    }
}
