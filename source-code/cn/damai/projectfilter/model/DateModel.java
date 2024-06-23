package cn.damai.projectfilter.model;

import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.projectfilter.bean.Type;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DateModel extends GetTFromModel<CalendarBean> {
    private static transient /* synthetic */ IpChange $ipChange;

    public DateModel(FilterModel filterModel) {
        super(filterModel);
    }

    @Override // cn.damai.projectfilter.model.GetTFromModel
    public CalendarBean getT(Type type) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1690655010")) {
            return this.mModel.mCalendarBean;
        }
        return (CalendarBean) ipChange.ipc$dispatch("-1690655010", new Object[]{this, type});
    }
}
