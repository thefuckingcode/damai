package cn.damai.projectfilter.model;

import cn.damai.projectfilter.bean.CityBean;
import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CityModel extends GetTFromModel<CityBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    public CityModel(FilterModel filterModel) {
        super(filterModel);
    }

    @Override // cn.damai.projectfilter.model.GetTFromModel
    public CityBean getT(Type type) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-655913601")) {
            return this.mModel.mCityBean;
        }
        return (CityBean) ipChange.ipc$dispatch("-655913601", new Object[]{this, type});
    }
}
