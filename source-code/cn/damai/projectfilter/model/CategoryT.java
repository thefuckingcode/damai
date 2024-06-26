package cn.damai.projectfilter.model;

import cn.damai.projectfilter.bean.CategoryBean;
import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class CategoryT extends GetTFromModel<List<CategoryBean>> {
    private static transient /* synthetic */ IpChange $ipChange;

    public CategoryT(FilterModel filterModel) {
        super(filterModel);
    }

    @Override // cn.damai.projectfilter.model.GetTFromModel
    public List<CategoryBean> getT(Type type) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1653048682")) {
            return this.mModel.mSelectedCategoryList;
        }
        return (List) ipChange.ipc$dispatch("1653048682", new Object[]{this, type});
    }
}
