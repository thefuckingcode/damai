package cn.damai.uikit.calendar;

import android.annotation.SuppressLint;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import cn.damai.uikit.calendar.CalendarPagerView;
import cn.damai.uikit.calendar.MaterialCalendarView;
import cn.damai.uikit.calendar.format.DayFormatter;
import cn.damai.uikit.calendar.format.WeekDayFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;
import java.util.Collection;

@Experimental
@SuppressLint({"ViewConstructor"})
/* compiled from: Taobao */
public class WeekView extends CalendarPagerView {
    private static transient /* synthetic */ IpChange $ipChange;

    public WeekView(@NonNull MaterialCalendarView materialCalendarView, CalendarDay calendarDay, int i) {
        super(materialCalendarView, calendarDay, i);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public void buildDayViews(Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2115642020")) {
            ipChange.ipc$dispatch("2115642020", new Object[]{this, calendar});
            return;
        }
        for (int i = 0; i < 7; i++) {
            addDayView(calendar);
        }
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView, cn.damai.uikit.calendar.CalendarPagerView, android.view.ViewGroup
    public /* bridge */ /* synthetic */ CalendarPagerView.a generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public int getRows() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1862799831")) {
            return 2;
        }
        return ((Integer) ipChange.ipc$dispatch("1862799831", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public boolean isDayEnabled(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1288371160")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1288371160", new Object[]{this, calendarDay})).booleanValue();
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setDateTextAppearance(int i) {
        super.setDateTextAppearance(i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setDayFormatter(DayFormatter dayFormatter) {
        super.setDayFormatter(dayFormatter);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setMaximumDate(CalendarDay calendarDay) {
        super.setMaximumDate(calendarDay);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setMinimumDate(CalendarDay calendarDay) {
        super.setMinimumDate(calendarDay);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setSelectedDates(Collection collection) {
        super.setSelectedDates(collection);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setSelectionColor(int i) {
        super.setSelectionColor(i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setSelectionEnabled(boolean z) {
        super.setSelectionEnabled(z);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setShowOtherDates(@MaterialCalendarView.ShowOtherDates int i) {
        super.setShowOtherDates(i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setWeekDayFormatter(WeekDayFormatter weekDayFormatter) {
        super.setWeekDayFormatter(weekDayFormatter);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setWeekDayTextAppearance(int i) {
        super.setWeekDayTextAppearance(i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ boolean shouldDelayChildPressedState() {
        return super.shouldDelayChildPressedState();
    }
}
