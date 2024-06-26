package cn.damai.projectfiltercopy.model;

import cn.damai.projectfiltercopy.bean.FilterBean;
import cn.damai.projectfiltercopy.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class FilterT extends GetTFromModel<HashMap<String, List<FilterBean>>> {
    private static transient /* synthetic */ IpChange $ipChange;

    public FilterT(FilterModel filterModel) {
        super(filterModel);
    }

    @Override // cn.damai.projectfiltercopy.model.GetTFromModel
    public HashMap<String, List<FilterBean>> getT(Type type) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1691727674")) {
            return this.mModel.mFilterMap;
        }
        return (HashMap) ipChange.ipc$dispatch("-1691727674", new Object[]{this, type});
    }
}
