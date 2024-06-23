package cn.damai.uikit.calendar;

import cn.damai.uikit.calendar.MonthPagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MonthLabelPagerAdapter extends CalendarPagerAdapter<MonthLabelView> {
    private static transient /* synthetic */ IpChange $ipChange;

    MonthLabelPagerAdapter(MaterialCalendarView materialCalendarView) {
        super(materialCalendarView);
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public MonthLabelView c(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1280833411")) {
            return new MonthLabelView(this.b, f(i), this.b.getFirstDayOfWeek());
        }
        return (MonthLabelView) ipChange.ipc$dispatch("-1280833411", new Object[]{this, Integer.valueOf(i)});
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public int k(MonthLabelView monthLabelView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-462097341")) {
            return ((Integer) ipChange.ipc$dispatch("-462097341", new Object[]{this, monthLabelView})).intValue();
        }
        return g().indexOf(monthLabelView.getMonth());
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    public DateRangeIndex b(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1476387668")) {
            return new MonthPagerAdapter.a(calendarDay, calendarDay2);
        }
        return (DateRangeIndex) ipChange.ipc$dispatch("-1476387668", new Object[]{this, calendarDay, calendarDay2});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    public boolean n(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1231682749")) {
            return obj instanceof MonthLabelView;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1231682749", new Object[]{this, obj})).booleanValue();
    }
}
