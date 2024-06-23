package cn.damai.uikit.calendar;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;

@SuppressLint({"ViewConstructor"})
/* compiled from: Taobao */
public class MonthView extends CalendarPagerView {
    private static transient /* synthetic */ IpChange $ipChange;

    public MonthView(@NonNull MaterialCalendarView materialCalendarView, CalendarDay calendarDay, int i) {
        super(materialCalendarView, calendarDay, i);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public void buildDayViews(Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1784333154")) {
            ipChange.ipc$dispatch("1784333154", new Object[]{this, calendar});
            return;
        }
        for (int i = 0; i < 6; i++) {
            for (int i2 = 0; i2 < 7; i2++) {
                addDayView(calendar);
            }
        }
    }

    public CalendarDay getMonth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1265118411")) {
            return getFirstViewDay();
        }
        return (CalendarDay) ipChange.ipc$dispatch("1265118411", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public int getRows() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1313266667")) {
            return 6;
        }
        return ((Integer) ipChange.ipc$dispatch("-1313266667", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public boolean isDayEnabled(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "675834086")) {
            return calendarDay.getMonth() == getFirstViewDay().getMonth();
        }
        return ((Boolean) ipChange.ipc$dispatch("675834086", new Object[]{this, calendarDay})).booleanValue();
    }
}
