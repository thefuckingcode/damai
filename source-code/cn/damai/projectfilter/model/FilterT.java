package cn.damai.projectfilter.model;

import cn.damai.projectfilter.bean.FilterBean;
import cn.damai.projectfilter.bean.Type;
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

    @Override // cn.damai.projectfilter.model.GetTFromModel
    public HashMap<String, List<FilterBean>> getT(Type type) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1736477466")) {
            return this.mModel.mFilterMap;
        }
        return (HashMap) ipChange.ipc$dispatch("-1736477466", new Object[]{this, type});
    }
}
