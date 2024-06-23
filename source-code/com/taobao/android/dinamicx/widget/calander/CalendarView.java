package com.taobao.android.dinamicx.widget.calander;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$layout;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class CalendarView extends FrameLayout {
    private final b mDelegate;
    private MonthViewPager mMonthPager;
    private WeekBar mWeekBar;
    private View mWeekLine;

    /* compiled from: Taobao */
    public interface OnCalendarInterceptListener {
        boolean onCalendarIntercept(Calendar calendar);

        void onCalendarInterceptClick(Calendar calendar, boolean z);
    }

    /* compiled from: Taobao */
    public interface OnCalendarLongClickListener {
        void onCalendarLongClick(Calendar calendar);

        void onCalendarLongClickOutOfRange(Calendar calendar);
    }

    /* compiled from: Taobao */
    public interface OnCalendarSelectListener {
        void onCalendarOutOfRange(Calendar calendar);

        void onCalendarSelect(@NonNull Calendar calendar, boolean z);
    }

    /* compiled from: Taobao */
    public interface OnClickCalendarPaddingListener {
        void onClickCalendarPadding(float f, float f2, boolean z, Calendar calendar, Object obj);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public interface OnInnerDateSelectedListener {
        void onMonthDateSelected(Calendar calendar, boolean z);
    }

    /* compiled from: Taobao */
    public interface OnMonthChangeListener {
        void onMonthChange(int i, int i2);
    }

    /* compiled from: Taobao */
    public interface OnMonthUIRangeChangeListener {
        void onMonthUIRangeChange(Calendar calendar, String str, Pair<String, String> pair);
    }

    /* compiled from: Taobao */
    public interface OnYearChangeListener {
        void onYearChange(int i);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements OnInnerDateSelectedListener {
        a() {
        }

        @Override // com.taobao.android.dinamicx.widget.calander.CalendarView.OnInnerDateSelectedListener
        public void onMonthDateSelected(Calendar calendar, boolean z) {
            if (calendar.getYear() != CalendarView.this.mDelegate.g().getYear() || calendar.getMonth() != CalendarView.this.mDelegate.g().getMonth() || CalendarView.this.mMonthPager.getCurrentItem() == CalendarView.this.mDelegate.B) {
                CalendarView.this.mDelegate.M = calendar;
                if (CalendarView.this.mDelegate.y() == 0 || z) {
                    CalendarView.this.mDelegate.L = calendar;
                }
                CalendarView.this.mMonthPager.updateSelected();
                if (CalendarView.this.mWeekBar == null) {
                    return;
                }
                if (CalendarView.this.mDelegate.y() == 0 || z) {
                    CalendarView.this.mWeekBar.onDateSelected(calendar, CalendarView.this.mDelegate.E(), z);
                }
            }
        }
    }

    public CalendarView(@NonNull Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R$layout.datepicker_layout_calendar_view, (ViewGroup) this, true);
        WeekBar weekBar = new WeekBar(context);
        this.mWeekBar = weekBar;
        ((FrameLayout) findViewById(R$id.frameContent)).addView(weekBar, 2);
        this.mWeekBar.setup(this.mDelegate);
        this.mWeekBar.onWeekStartChange(this.mDelegate.E());
        View findViewById = findViewById(R$id.line);
        this.mWeekLine = findViewById;
        findViewById.setBackgroundColor(this.mDelegate.C());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mWeekLine.getLayoutParams();
        layoutParams.setMargins(this.mDelegate.D(), this.mDelegate.B(), this.mDelegate.D(), 0);
        this.mWeekLine.setLayoutParams(layoutParams);
        MonthViewPager monthViewPager = (MonthViewPager) findViewById(R$id.vp_month);
        this.mMonthPager = monthViewPager;
        monthViewPager.mWeekBar = this.mWeekBar;
        this.mDelegate.G = new a();
        WeekBar weekBar2 = this.mWeekBar;
        b bVar = this.mDelegate;
        weekBar2.onDateSelected(bVar.L, bVar.E(), false);
        this.mMonthPager.setup(this.mDelegate);
        this.mMonthPager.setCurrentItem(this.mDelegate.B);
    }

    public final boolean isInRange(Calendar calendar) {
        b bVar = this.mDelegate;
        return bVar != null && a.q(calendar, bVar);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        b bVar = this.mDelegate;
        if (bVar == null) {
            super.onMeasure(i, i2);
            return;
        }
        setCalendarItemHeight(((size - bVar.B()) - this.mDelegate.k()) / 6);
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Calendar calendar;
        Bundle bundle = (Bundle) parcelable;
        Parcelable parcelable2 = bundle.getParcelable("super");
        this.mDelegate.L = (Calendar) bundle.getSerializable("selected_calendar");
        this.mDelegate.M = (Calendar) bundle.getSerializable("index_calendar");
        b bVar = this.mDelegate;
        OnCalendarSelectListener onCalendarSelectListener = bVar.E;
        if (!(onCalendarSelectListener == null || (calendar = bVar.L) == null)) {
            onCalendarSelectListener.onCalendarSelect(calendar, false);
        }
        Calendar calendar2 = this.mDelegate.M;
        if (calendar2 != null) {
            scrollToCalendar(calendar2.getYear(), this.mDelegate.M.getMonth(), this.mDelegate.M.getDay());
        }
        update();
        super.onRestoreInstanceState(parcelable2);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Parcelable onSaveInstanceState() {
        if (this.mDelegate == null) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putSerializable("selected_calendar", this.mDelegate.L);
        bundle.putSerializable("index_calendar", this.mDelegate.M);
        return bundle;
    }

    public void scrollToCalendar(int i, int i2, int i3) {
        scrollToCalendar(i, i2, i3, false, true);
    }

    public void scrollToCurrent() {
        scrollToCurrent(false);
    }

    public void scrollToNext(boolean z) {
        MonthViewPager monthViewPager = this.mMonthPager;
        monthViewPager.setCurrentItem(monthViewPager.getCurrentItem() + 1, z);
    }

    public void scrollToPre(boolean z) {
        MonthViewPager monthViewPager = this.mMonthPager;
        monthViewPager.setCurrentItem(monthViewPager.getCurrentItem() - 1, z);
    }

    public void setAnchorCalendar(Calendar calendar) {
        b bVar = this.mDelegate;
        if (bVar != null) {
            bVar.K = calendar;
        }
    }

    public void setAutoChangeMonth(boolean z) {
        b bVar = this.mDelegate;
        if (bVar != null) {
            bVar.M(z);
        }
    }

    public void setBackground(int i, int i2) {
        this.mWeekBar.setBackgroundColor(i);
        this.mWeekLine.setBackgroundColor(i2);
    }

    public final void setCalendarItemHeight(int i) {
        if (this.mDelegate.d() != i) {
            this.mDelegate.P(i);
            this.mMonthPager.updateItemHeight();
        }
    }

    public void setCurrentDayTextSize(int i) {
        this.mDelegate.Q(i);
    }

    public void setDateTextFont(String str) {
        this.mDelegate.R(str);
    }

    public void setDateTextGravity(int i) {
        b bVar = this.mDelegate;
        CalendarDateTextGravity calendarDateTextGravity = CalendarDateTextGravity.Top;
        if (i != calendarDateTextGravity.getCode()) {
            calendarDateTextGravity = CalendarDateTextGravity.Center;
        }
        bVar.N(calendarDateTextGravity);
    }

    public void setDateTopGap(int i) {
        b bVar = this.mDelegate;
        if (bVar != null) {
            bVar.S(i);
            MonthViewPager monthViewPager = this.mMonthPager;
            if (monthViewPager != null) {
                ViewGroup.LayoutParams layoutParams = monthViewPager.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.topMargin = a.c(getContext(), 41.0f) + i;
                    this.mMonthPager.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setDayTextSize(int i) {
        this.mDelegate.T(i);
    }

    public void setDisableRanges(List<Pair<Calendar, Calendar>> list) {
        if (a.r(list)) {
            this.mDelegate.U(list);
            Calendar calendar = this.mDelegate.L;
            if (calendar != null && !isInRange(calendar)) {
                b bVar = this.mDelegate;
                bVar.L = bVar.s();
                b bVar2 = this.mDelegate;
                bVar2.M = bVar2.L;
            }
            this.mMonthPager.updateRange();
        }
    }

    public void setOnCalendarSelectListener(OnCalendarSelectListener onCalendarSelectListener) {
        this.mDelegate.E = onCalendarSelectListener;
    }

    public void setOnMonthChangeListener(OnMonthChangeListener onMonthChangeListener) {
        this.mDelegate.I = onMonthChangeListener;
    }

    public void setOnMonthUIRangeChangeListener(OnMonthUIRangeChangeListener onMonthUIRangeChangeListener) {
        this.mDelegate.J = onMonthUIRangeChangeListener;
    }

    public void setRange(int i, int i2, int i3, int i4, int i5, int i6) {
        setRange(i, i2, i3, i4, i5, i6, null);
    }

    public void setScrollable(boolean z) {
        MonthViewPager monthViewPager = this.mMonthPager;
        if (monthViewPager != null) {
            monthViewPager.setScrollable(z);
        }
    }

    public void setSelectedTextColor(int i) {
        b bVar = this.mDelegate;
        if (bVar != null && bVar.z() != i) {
            this.mDelegate.Y(i);
            MonthViewPager monthViewPager = this.mMonthPager;
            if (monthViewPager != null) {
                monthViewPager.updateStyle();
            }
        }
    }

    public void setTextColor(int i, int i2, int i3, int i4, int i5) {
        b bVar = this.mDelegate;
        if (bVar != null && this.mMonthPager != null) {
            bVar.Z(i, i2, i3, i4, i5);
            this.mMonthPager.updateStyle();
        }
    }

    public void setWeekBarTextColor(int i) {
        b bVar = this.mDelegate;
        if (bVar != null && bVar.F() != i) {
            this.mDelegate.a0(i);
            WeekBar weekBar = this.mWeekBar;
            if (weekBar != null) {
                weekBar.setTextColor(this.mDelegate.F());
            }
        }
    }

    public final void update() {
        this.mWeekBar.onWeekStartChange(this.mDelegate.E());
        this.mMonthPager.updateScheme();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    public void updateMonthArrowStatus() {
        boolean z;
        Object tag;
        Object tag2;
        PagerAdapter adapter = this.mMonthPager.getAdapter();
        boolean z2 = false;
        if (adapter != null) {
            if (adapter.getCount() == 2) {
                boolean z3 = this.mMonthPager.getCurrentItem() != 0;
                if (this.mMonthPager.getCurrentItem() == 0) {
                    z2 = true;
                }
                z2 = z3;
                z = z2;
            } else if (adapter.getCount() >= 3) {
                boolean z4 = this.mMonthPager.getCurrentItem() != 0;
                if (this.mMonthPager.getCurrentItem() != adapter.getCount() - 1) {
                    z2 = true;
                }
                z = z2;
                z2 = z4;
            }
            tag = getTag(R$id.iv_left);
            if (tag instanceof View) {
                ((View) tag).setEnabled(z2);
            }
            tag2 = getTag(R$id.iv_right);
            if (!(tag2 instanceof View)) {
                ((View) tag2).setEnabled(z);
                return;
            }
            return;
        }
        z = false;
        tag = getTag(R$id.iv_left);
        if (tag instanceof View) {
        }
        tag2 = getTag(R$id.iv_right);
        if (!(tag2 instanceof View)) {
        }
    }

    public CalendarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDelegate = new b(context, attributeSet);
        init(context);
    }

    public void scrollToCalendar(int i, int i2, int i3, boolean z, boolean z2) {
        scrollToCalendar(i, i2, i3, z, z2, true);
    }

    public void scrollToCurrent(boolean z) {
        scrollToCurrent(z, false);
    }

    public void setRange(int i, int i2, int i3, int i4, int i5, int i6, List<Pair<Calendar, Calendar>> list) {
        setRange(i, i2, i3, i4, i5, i6, list, null);
    }

    public void scrollToCalendar(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        Calendar calendar = new Calendar();
        calendar.setYear(i);
        calendar.setMonth(i2);
        calendar.setDay(i3);
        if (calendar.isAvailable() && isInRange(calendar)) {
            OnCalendarInterceptListener onCalendarInterceptListener = this.mDelegate.D;
            if (onCalendarInterceptListener == null || !onCalendarInterceptListener.onCalendarIntercept(calendar)) {
                this.mMonthPager.scrollToCalendar(i, i2, i3, z, z2, z3);
            } else {
                this.mDelegate.D.onCalendarInterceptClick(calendar, false);
            }
        }
    }

    public void scrollToCurrent(boolean z, boolean z2) {
        if (isInRange(this.mDelegate.g())) {
            Calendar a2 = this.mDelegate.a();
            OnCalendarInterceptListener onCalendarInterceptListener = this.mDelegate.D;
            if (onCalendarInterceptListener == null || !onCalendarInterceptListener.onCalendarIntercept(a2)) {
                if (!z2) {
                    b bVar = this.mDelegate;
                    bVar.L = bVar.a();
                    b bVar2 = this.mDelegate;
                    Calendar calendar = bVar2.L;
                    bVar2.M = calendar;
                    this.mWeekBar.onDateSelected(calendar, bVar2.E(), false);
                } else {
                    b bVar3 = this.mDelegate;
                    bVar3.L = null;
                    bVar3.M = null;
                }
                if (this.mMonthPager.getVisibility() == 0) {
                    this.mMonthPager.scrollToCurrent(z);
                    return;
                }
                return;
            }
            this.mDelegate.D.onCalendarInterceptClick(a2, false);
        }
    }

    public void setRange(int i, int i2, int i3, int i4, int i5, int i6, List<Pair<Calendar, Calendar>> list, HashMap<String, Calendar> hashMap) {
        if (a.a(i, i2, i3, i4, i5, i6) <= 0) {
            if (list == null || a.r(list)) {
                this.mDelegate.X(i, i2, i3, i4, i5, i6);
                this.mDelegate.U(list);
                this.mDelegate.O(hashMap);
                Calendar calendar = this.mDelegate.L;
                if (calendar != null && !isInRange(calendar)) {
                    b bVar = this.mDelegate;
                    bVar.L = bVar.s();
                    b bVar2 = this.mDelegate;
                    bVar2.M = bVar2.L;
                }
                this.mMonthPager.updateRange();
            }
        }
    }
}
