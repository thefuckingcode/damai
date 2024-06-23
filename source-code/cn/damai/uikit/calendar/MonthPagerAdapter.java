package cn.damai.uikit.calendar;

import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class MonthPagerAdapter extends CalendarPagerAdapter<MonthView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static class a implements DateRangeIndex {
        private static transient /* synthetic */ IpChange $ipChange;
        private final CalendarDay a;
        private final int b;
        private SparseArrayCompat<CalendarDay> c = new SparseArrayCompat<>();

        public a(@NonNull CalendarDay calendarDay, @NonNull CalendarDay calendarDay2) {
            this.a = CalendarDay.from(calendarDay.getYear(), calendarDay.getMonth(), 1);
            this.b = indexOf(CalendarDay.from(calendarDay2.getYear(), calendarDay2.getMonth(), 1)) + 1;
        }

        @Override // cn.damai.uikit.calendar.DateRangeIndex
        public int getCount() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-41255869")) {
                return this.b;
            }
            return ((Integer) ipChange.ipc$dispatch("-41255869", new Object[]{this})).intValue();
        }

        @Override // cn.damai.uikit.calendar.DateRangeIndex
        public CalendarDay getItem(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1371466169")) {
                return (CalendarDay) ipChange.ipc$dispatch("-1371466169", new Object[]{this, Integer.valueOf(i)});
            }
            CalendarDay calendarDay = this.c.get(i);
            if (calendarDay != null) {
                return calendarDay;
            }
            int year = this.a.getYear() + (i / 12);
            int month = this.a.getMonth() + (i % 12);
            if (month >= 12) {
                year++;
                month -= 12;
            }
            CalendarDay from = CalendarDay.from(year, month, 1);
            this.c.put(i, from);
            return from;
        }

        @Override // cn.damai.uikit.calendar.DateRangeIndex
        public int indexOf(CalendarDay calendarDay) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1452944071")) {
                return ((Integer) ipChange.ipc$dispatch("1452944071", new Object[]{this, calendarDay})).intValue();
            }
            return ((calendarDay.getYear() - this.a.getYear()) * 12) + (calendarDay.getMonth() - this.a.getMonth());
        }
    }

    MonthPagerAdapter(MaterialCalendarView materialCalendarView) {
        super(materialCalendarView);
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public MonthView c(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1808950567")) {
            return new MonthView(this.b, f(i), this.b.getFirstDayOfWeek());
        }
        return (MonthView) ipChange.ipc$dispatch("-1808950567", new Object[]{this, Integer.valueOf(i)});
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public int k(MonthView monthView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2094850089")) {
            return ((Integer) ipChange.ipc$dispatch("-2094850089", new Object[]{this, monthView})).intValue();
        }
        return g().indexOf(monthView.getMonth());
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    public DateRangeIndex b(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2111362058")) {
            return new a(calendarDay, calendarDay2);
        }
        return (DateRangeIndex) ipChange.ipc$dispatch("2111362058", new Object[]{this, calendarDay, calendarDay2});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    public boolean n(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "71454629")) {
            return obj instanceof MonthView;
        }
        return ((Boolean) ipChange.ipc$dispatch("71454629", new Object[]{this, obj})).booleanValue();
    }
}
