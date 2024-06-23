package tb;

import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import cn.damai.projectfiltercopy.FilterViewManager;
import cn.damai.projectfiltercopy.listener.HorDateClickResultListener;

/* compiled from: Taobao */
public final /* synthetic */ class pi0 implements HorDateClickResultListener {
    public final /* synthetic */ FilterViewManager.a a;

    public /* synthetic */ pi0(FilterViewManager.a aVar) {
        this.a = aVar;
    }

    @Override // cn.damai.projectfiltercopy.listener.HorDateClickResultListener
    public final void onProcessResult(CalendarBean calendarBean) {
        FilterViewManager.a.a(this.a, calendarBean);
    }
}
