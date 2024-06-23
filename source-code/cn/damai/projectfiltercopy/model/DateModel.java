package cn.damai.projectfiltercopy.model;

import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import cn.damai.projectfiltercopy.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DateModel extends GetTFromModel<CalendarBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    public DateModel(FilterModel filterModel) {
        super(filterModel);
    }

    @Override // cn.damai.projectfiltercopy.model.GetTFromModel
    public CalendarBean getT(Type type) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "325560745")) {
            return this.mModel.mCalendarBean;
        }
        return (CalendarBean) ipChange.ipc$dispatch("325560745", new Object[]{this, type});
    }
}
