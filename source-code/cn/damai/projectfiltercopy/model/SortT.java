package cn.damai.projectfiltercopy.model;

import cn.damai.projectfiltercopy.bean.SortBean;
import cn.damai.projectfiltercopy.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SortT extends GetTFromModel<SortBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    public SortT(FilterModel filterModel) {
        super(filterModel);
    }

    @Override // cn.damai.projectfiltercopy.model.GetTFromModel
    public SortBean getT(Type type) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-843335681")) {
            return this.mModel.mSortBean;
        }
        return (SortBean) ipChange.ipc$dispatch("-843335681", new Object[]{this, type});
    }
}
