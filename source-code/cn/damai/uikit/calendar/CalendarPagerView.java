package cn.damai.uikit.calendar;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import cn.damai.uikit.calendar.MaterialCalendarView;
import cn.damai.uikit.calendar.format.DayFormatter;
import cn.damai.uikit.calendar.format.WeekDayFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import tb.ye;

/* compiled from: Taobao */
public abstract class CalendarPagerView extends ViewGroup implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    protected static final int DAY_NAMES_ROW = 1;
    protected static final int DEFAULT_DAYS_IN_WEEK = 7;
    protected static final int DEFAULT_MAX_WEEKS = 6;
    private static final Calendar tempWorkingCalendar = ye.d();
    protected final Collection<DayCategoryView> dayCategoryViews = new ArrayList();
    protected final Collection<DayLabelView> dayLabelViews = new ArrayList();
    protected final Collection<DayView> dayViews = new ArrayList();
    protected final ArrayList<b> decoratorResults = new ArrayList<>();
    private int firstDayOfWeek;
    private CalendarDay firstViewDay;
    private CalendarDay maxDate = null;
    private MaterialCalendarView mcv;
    private CalendarDay minDate = null;
    @MaterialCalendarView.ShowOtherDates
    protected int showOtherDates = 4;
    private final ArrayList<WeekDayView> weekDayViews = new ArrayList<>();

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public static class a extends ViewGroup.MarginLayoutParams {
        public a() {
            super(-2, -2);
        }
    }

    public CalendarPagerView(@NonNull MaterialCalendarView materialCalendarView, CalendarDay calendarDay, int i) {
        super(materialCalendarView.getContext());
        this.mcv = materialCalendarView;
        this.firstViewDay = calendarDay;
        this.firstDayOfWeek = i;
        setClipChildren(false);
        setClipToPadding(false);
        buildWeekDays(resetAndGetWorkingCalendar());
        buildDayViews(resetAndGetWorkingCalendar());
    }

    private void buildWeekDays(Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1195327932")) {
            ipChange.ipc$dispatch("-1195327932", new Object[]{this, calendar});
        }
    }

    /* access modifiers changed from: protected */
    public void addDayCategoryView(Calendar calendar, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751198659")) {
            ipChange.ipc$dispatch("751198659", new Object[]{this, calendar, Boolean.valueOf(z)});
            return;
        }
        CalendarDay from = CalendarDay.from(calendar);
        from.setWeekEnd(z);
        DayCategoryView dayCategoryView = new DayCategoryView(getContext(), from);
        dayCategoryView.getDayView().setOnClickListener(this);
        this.dayCategoryViews.add(dayCategoryView);
        this.dayViews.add(dayCategoryView.getDayView());
        addView(dayCategoryView);
        calendar.add(5, 1);
    }

    /* access modifiers changed from: protected */
    public void addDayLabelView(Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "356985631")) {
            ipChange.ipc$dispatch("356985631", new Object[]{this, calendar});
            return;
        }
        DayLabelView dayLabelView = new DayLabelView(getContext(), CalendarDay.from(calendar));
        dayLabelView.getDayView().setOnClickListener(this);
        this.dayLabelViews.add(dayLabelView);
        this.dayViews.add(dayLabelView.getDayView());
        addView(dayLabelView);
        calendar.add(5, 1);
    }

    /* access modifiers changed from: protected */
    public void addDayView(Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1957975793")) {
            ipChange.ipc$dispatch("-1957975793", new Object[]{this, calendar});
            return;
        }
        CalendarDay from = CalendarDay.from(calendar);
        DayView dayView = new DayView(getContext());
        dayView.setDay(from);
        dayView.setOnClickListener(this);
        this.dayViews.add(dayView);
        dayView.setMaxHeight(10);
        addView(dayView);
        calendar.add(5, 1);
    }

    /* access modifiers changed from: protected */
    public abstract void buildDayViews(Calendar calendar);

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1748982899")) {
            return layoutParams instanceof a;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1748982899", new Object[]{this, layoutParams})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public int getFirstDayOfWeek() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1198300306")) {
            return this.firstDayOfWeek;
        }
        return ((Integer) ipChange.ipc$dispatch("1198300306", new Object[]{this})).intValue();
    }

    /* access modifiers changed from: protected */
    public CalendarDay getFirstViewDay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "883131787")) {
            return this.firstViewDay;
        }
        return (CalendarDay) ipChange.ipc$dispatch("883131787", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public abstract int getRows();

    /* access modifiers changed from: protected */
    public void invalidateDecorators() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1460521365")) {
            ipChange.ipc$dispatch("-1460521365", new Object[]{this});
            return;
        }
        a aVar = new a();
        for (DayView dayView : this.dayViews) {
            aVar.q();
            Iterator<b> it = this.decoratorResults.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next.a.shouldDecorate(dayView.getDate())) {
                    next.b.a(aVar);
                }
            }
            dayView.applyFacade(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean isDayEnabled(CalendarDay calendarDay);

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1876311471")) {
            ipChange.ipc$dispatch("1876311471", new Object[]{this, view});
        } else if (view instanceof DayView) {
            this.mcv.onDateClicked((DayView) view);
        }
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1128678663")) {
            ipChange.ipc$dispatch("1128678663", new Object[]{this, accessibilityEvent});
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(CalendarPagerView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-343196807")) {
            ipChange.ipc$dispatch("-343196807", new Object[]{this, accessibilityNodeInfo});
            return;
        }
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CalendarPagerView.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "138296639")) {
            ipChange.ipc$dispatch("138296639", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int measuredWidth = childAt.getMeasuredWidth() + i5;
            int measuredHeight = childAt.getMeasuredHeight() + i6;
            childAt.layout(i5, i6, measuredWidth, measuredHeight);
            if (i7 % 7 == 6) {
                i6 = measuredHeight;
                i5 = 0;
            } else {
                i5 = measuredWidth;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2031244723")) {
            ipChange.ipc$dispatch("-2031244723", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) == 0 || mode == 0) {
            throw new IllegalStateException("CalendarPagerView should never be left to decide it's size");
        }
        int i3 = size / 7;
        int rows = size2 / getRows();
        setMeasuredDimension(size, size2);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(rows, 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public Calendar resetAndGetWorkingCalendar() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1784681194")) {
            return (Calendar) ipChange.ipc$dispatch("1784681194", new Object[]{this});
        }
        CalendarDay firstViewDay2 = getFirstViewDay();
        Calendar calendar = tempWorkingCalendar;
        firstViewDay2.copyTo(calendar);
        calendar.setFirstDayOfWeek(getFirstDayOfWeek());
        int firstDayOfWeek2 = getFirstDayOfWeek() - ye.c(calendar);
        if (!MaterialCalendarView.showOtherMonths(this.showOtherDates) ? firstDayOfWeek2 > 0 : firstDayOfWeek2 >= 0) {
            z = true;
        }
        if (z) {
            firstDayOfWeek2 -= 7;
        }
        calendar.add(5, firstDayOfWeek2);
        return calendar;
    }

    public void setDateTextAppearance(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648570056")) {
            ipChange.ipc$dispatch("-648570056", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        for (DayView dayView : this.dayViews) {
            dayView.setTextAppearance(getContext(), i);
        }
    }

    public void setDayFormatter(DayFormatter dayFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "523566696")) {
            ipChange.ipc$dispatch("523566696", new Object[]{this, dayFormatter});
            return;
        }
        for (DayView dayView : this.dayViews) {
            dayView.setDayFormatter(dayFormatter);
        }
    }

    /* access modifiers changed from: package-private */
    public void setDayViewDecorators(List<b> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1883224952")) {
            ipChange.ipc$dispatch("1883224952", new Object[]{this, list});
            return;
        }
        this.decoratorResults.clear();
        if (list != null) {
            this.decoratorResults.addAll(list);
        }
        invalidateDecorators();
    }

    public void setMaximumDate(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1361369926")) {
            ipChange.ipc$dispatch("-1361369926", new Object[]{this, calendarDay});
            return;
        }
        this.maxDate = calendarDay;
        updateUi();
    }

    public void setMinimumDate(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086869928")) {
            ipChange.ipc$dispatch("1086869928", new Object[]{this, calendarDay});
            return;
        }
        this.minDate = calendarDay;
        updateUi();
    }

    public void setSelectedDates(Collection<CalendarDay> collection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1352889287")) {
            ipChange.ipc$dispatch("1352889287", new Object[]{this, collection});
            return;
        }
        for (DayView dayView : this.dayViews) {
            dayView.setChecked(collection != null && collection.contains(dayView.getDate()));
        }
        postInvalidate();
    }

    public void setSelectionColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2021811504")) {
            ipChange.ipc$dispatch("2021811504", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        for (DayView dayView : this.dayViews) {
            dayView.setSelectionColor(i);
        }
    }

    public void setSelectionEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "499914271")) {
            ipChange.ipc$dispatch("499914271", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        for (DayView dayView : this.dayViews) {
            dayView.setOnClickListener(z ? this : null);
            dayView.setClickable(z);
        }
    }

    public void setShowOtherDates(@MaterialCalendarView.ShowOtherDates int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "804776619")) {
            ipChange.ipc$dispatch("804776619", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.showOtherDates = i;
        updateUi();
    }

    public void setWeekDayFormatter(WeekDayFormatter weekDayFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2064781160")) {
            ipChange.ipc$dispatch("2064781160", new Object[]{this, weekDayFormatter});
            return;
        }
        Iterator<WeekDayView> it = this.weekDayViews.iterator();
        while (it.hasNext()) {
            it.next().setWeekDayFormatter(weekDayFormatter);
        }
    }

    public void setWeekDayTextAppearance(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1356925084")) {
            ipChange.ipc$dispatch("1356925084", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Iterator<WeekDayView> it = this.weekDayViews.iterator();
        while (it.hasNext()) {
            it.next().setTextAppearance(getContext(), i);
        }
    }

    public boolean shouldDelayChildPressedState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1500966777")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1500966777", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public void updateUi() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1915560353")) {
            ipChange.ipc$dispatch("1915560353", new Object[]{this});
            return;
        }
        for (DayView dayView : this.dayViews) {
            CalendarDay date = dayView.getDate();
            dayView.setupSelection(this.showOtherDates, date.isInRange(this.minDate, this.maxDate), isDayEnabled(date));
        }
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public a generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-425442014")) {
            return new a();
        }
        return (a) ipChange.ipc$dispatch("-425442014", new Object[]{this});
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1176140707")) {
            return new a();
        }
        return (a) ipChange.ipc$dispatch("-1176140707", new Object[]{this, attributeSet});
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-99690799")) {
            return new a();
        }
        return (ViewGroup.LayoutParams) ipChange.ipc$dispatch("-99690799", new Object[]{this, layoutParams});
    }
}
