package cn.damai.projectfiltercopy.model;

import cn.damai.projectfiltercopy.bean.CityBean;
import cn.damai.projectfiltercopy.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CityModel extends GetTFromModel<CityBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    public CityModel(FilterModel filterModel) {
        super(filterModel);
    }

    @Override // cn.damai.projectfiltercopy.model.GetTFromModel
    public CityBean getT(Type type) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1973192630")) {
            return this.mModel.mCityBean;
        }
        return (CityBean) ipChange.ipc$dispatch("-1973192630", new Object[]{this, type});
    }
}
