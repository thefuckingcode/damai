package cn.damai.uikit.calendar;

import cn.damai.uikit.calendar.MonthPagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MonthCategoryPagerAdapter extends CalendarPagerAdapter<MonthCategoryView> {
    private static transient /* synthetic */ IpChange $ipChange;

    MonthCategoryPagerAdapter(MaterialCalendarView materialCalendarView) {
        super(materialCalendarView);
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public MonthCategoryView c(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1846602339")) {
            return new MonthCategoryView(this.b, f(i), this.b.getFirstDayOfWeek());
        }
        return (MonthCategoryView) ipChange.ipc$dispatch("-1846602339", new Object[]{this, Integer.valueOf(i)});
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public int k(MonthCategoryView monthCategoryView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1682520297")) {
            return ((Integer) ipChange.ipc$dispatch("-1682520297", new Object[]{this, monthCategoryView})).intValue();
        }
        return g().indexOf(monthCategoryView.getMonth());
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    public DateRangeIndex b(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1575202092")) {
            return new MonthPagerAdapter.a(calendarDay, calendarDay2);
        }
        return (DateRangeIndex) ipChange.ipc$dispatch("1575202092", new Object[]{this, calendarDay, calendarDay2});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    public boolean n(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-557940029")) {
            return obj instanceof MonthCategoryView;
        }
        return ((Boolean) ipChange.ipc$dispatch("-557940029", new Object[]{this, obj})).booleanValue();
    }
}
