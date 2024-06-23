package cn.damai.uikit.calendar;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Experimental
/* compiled from: Taobao */
public class WeekPagerAdapter extends CalendarPagerAdapter<WeekView> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static class a implements DateRangeIndex {
        private static transient /* synthetic */ IpChange $ipChange;
        private final CalendarDay a;
        private final int b;

        public a(@NonNull CalendarDay calendarDay, @NonNull CalendarDay calendarDay2, int i) {
            CalendarDay a2 = a(calendarDay, i);
            this.a = a2;
            this.b = b(a2, calendarDay2) + 1;
        }

        private CalendarDay a(@NonNull CalendarDay calendarDay, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-399255305")) {
                return (CalendarDay) ipChange.ipc$dispatch("-399255305", new Object[]{this, calendarDay, Integer.valueOf(i)});
            }
            Calendar instance = Calendar.getInstance();
            calendarDay.copyTo(instance);
            while (instance.get(7) != i) {
                instance.add(7, -1);
            }
            return CalendarDay.from(instance);
        }

        private int b(@NonNull CalendarDay calendarDay, @NonNull CalendarDay calendarDay2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1278524850")) {
                return ((Integer) ipChange.ipc$dispatch("1278524850", new Object[]{this, calendarDay, calendarDay2})).intValue();
            }
            return (int) (TimeUnit.DAYS.convert(((calendarDay2.getDate().getTime() - calendarDay.getDate().getTime()) + ((long) calendarDay2.getCalendar().get(16))) - ((long) calendarDay.getCalendar().get(16)), TimeUnit.MILLISECONDS) / 7);
        }

        @Override // cn.damai.uikit.calendar.DateRangeIndex
        public int getCount() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2020909235")) {
                return this.b;
            }
            return ((Integer) ipChange.ipc$dispatch("2020909235", new Object[]{this})).intValue();
        }

        @Override // cn.damai.uikit.calendar.DateRangeIndex
        public CalendarDay getItem(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1353334089")) {
                return CalendarDay.from(new Date(this.a.getDate().getTime() + TimeUnit.MILLISECONDS.convert((long) (i * 7), TimeUnit.DAYS)));
            }
            return (CalendarDay) ipChange.ipc$dispatch("-1353334089", new Object[]{this, Integer.valueOf(i)});
        }

        @Override // cn.damai.uikit.calendar.DateRangeIndex
        public int indexOf(CalendarDay calendarDay) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1471076151")) {
                return b(this.a, calendarDay);
            }
            return ((Integer) ipChange.ipc$dispatch("1471076151", new Object[]{this, calendarDay})).intValue();
        }
    }

    public WeekPagerAdapter(MaterialCalendarView materialCalendarView) {
        super(materialCalendarView);
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public WeekView c(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1876627331")) {
            return new WeekView(this.b, f(i), this.b.getFirstDayOfWeek());
        }
        return (WeekView) ipChange.ipc$dispatch("-1876627331", new Object[]{this, Integer.valueOf(i)});
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public int k(WeekView weekView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1022804477")) {
            return ((Integer) ipChange.ipc$dispatch("-1022804477", new Object[]{this, weekView})).intValue();
        }
        return g().indexOf(weekView.getFirstViewDay());
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    public DateRangeIndex b(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1829583180")) {
            return new a(calendarDay, calendarDay2, this.b.getFirstDayOfWeek());
        }
        return (DateRangeIndex) ipChange.ipc$dispatch("1829583180", new Object[]{this, calendarDay, calendarDay2});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerAdapter
    public boolean n(Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-213058909")) {
            return obj instanceof WeekView;
        }
        return ((Boolean) ipChange.ipc$dispatch("-213058909", new Object[]{this, obj})).booleanValue();
    }
}
