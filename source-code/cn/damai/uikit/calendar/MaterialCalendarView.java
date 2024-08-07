package cn.damai.uikit.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$string;
import cn.damai.uikit.R$style;
import cn.damai.uikit.R$styleable;
import cn.damai.uikit.calendar.format.DayFormatter;
import cn.damai.uikit.calendar.format.TitleFormatter;
import cn.damai.uikit.calendar.format.WeekDayFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import tb.gm2;
import tb.qf1;
import tb.x7;
import tb.y20;

/* compiled from: Taobao */
public class MaterialCalendarView extends ViewGroup {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DAY_NAMES_ROW = 1;
    private static final int DEFAULT_DAYS_IN_WEEK = 7;
    private static final int DEFAULT_MAX_WEEKS = 6;
    public static final int DEFAULT_TILE_SIZE_DP = 44;
    private static final TitleFormatter DEFAULT_TITLE_FORMATTER = new y20();
    public static final int HORIZONTAL = 1;
    public static final int INVALID_TILE_DIMENSION = -10;
    public static final int SELECTION_MODE_MULTIPLE = 2;
    public static final int SELECTION_MODE_NONE = 0;
    public static final int SELECTION_MODE_RANGE = 3;
    public static final int SELECTION_MODE_SINGLE = 1;
    public static final int SHOW_ALL = 7;
    public static final int SHOW_DECORATED_DISABLED = 4;
    public static final int SHOW_DEFAULTS = 4;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OTHER_MONTHS = 1;
    public static final int SHOW_OUT_OF_RANGE = 2;
    public static final int VERTICAL = 0;
    private int accentColor;
    private CalendarPagerAdapter<?> adapter;
    private boolean allowClickDaysOutsideCurrentMonth;
    private int arrowColor;
    private final DirectionButton buttonFuture;
    private final DirectionButton buttonPast;
    CharSequence calendarContentDescription;
    private CalendarMode calendarMode;
    private CalendarDay currentMonth;
    private final ArrayList<DayViewDecorator> dayViewDecorators;
    private int firstDayOfWeek;
    private Drawable leftArrowMask;
    private OnDateSelectedListener listener;
    private boolean mDynamicHeightEnabled;
    private CalendarDay maxDate;
    private CalendarDay minDate;
    private OnMonthChangedListener monthListener;
    private final View.OnClickListener onClickListener;
    private final ViewPager.OnPageChangeListener pageChangeListener;
    private final CalendarPager pager;
    private OnRangeSelectedListener rangeListener;
    private Drawable rightArrowMask;
    @SelectionMode
    private int selectionMode;
    private d state;
    private int tileHeight;
    private int tileWidth;
    private final TextView title;
    private final gm2 titleChanger;
    private LinearLayout topbar;

    /* compiled from: Taobao */
    public static class SavedState extends View.BaseSavedState {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean allowClickDaysOutsideCurrentMonth;
        boolean cacheCurrentPosition;
        CalendarMode calendarMode;
        int color;
        CalendarDay currentMonth;
        int dateTextAppearance;
        boolean dynamicHeightEnabled;
        int firstDayOfWeek;
        CalendarDay maxDate;
        CalendarDay minDate;
        int orientation;
        List<CalendarDay> selectedDates;
        int selectionMode;
        int showOtherDates;
        int tileHeightPx;
        int tileWidthPx;
        boolean topbarVisible;
        int weekDayTextAppearance;

        /* compiled from: Taobao */
        public static final class a implements Parcelable.Creator<SavedState> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-738910835")) {
                    return new SavedState(parcel, null);
                }
                return (SavedState) ipChange.ipc$dispatch("-738910835", new Object[]{this, parcel});
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1519923824")) {
                    return new SavedState[i];
                }
                return (SavedState[]) ipChange.ipc$dispatch("1519923824", new Object[]{this, Integer.valueOf(i)});
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1769572251")) {
                ipChange.ipc$dispatch("-1769572251", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.color);
            parcel.writeInt(this.dateTextAppearance);
            parcel.writeInt(this.weekDayTextAppearance);
            parcel.writeInt(this.showOtherDates);
            parcel.writeByte(this.allowClickDaysOutsideCurrentMonth ? (byte) 1 : 0);
            parcel.writeParcelable(this.minDate, 0);
            parcel.writeParcelable(this.maxDate, 0);
            parcel.writeTypedList(this.selectedDates);
            parcel.writeInt(this.firstDayOfWeek);
            parcel.writeInt(this.orientation);
            parcel.writeInt(this.tileWidthPx);
            parcel.writeInt(this.tileHeightPx);
            parcel.writeInt(this.topbarVisible ? 1 : 0);
            parcel.writeInt(this.selectionMode);
            parcel.writeInt(this.dynamicHeightEnabled ? 1 : 0);
            CalendarMode calendarMode2 = this.calendarMode;
            if (calendarMode2 == CalendarMode.WEEKS) {
                parcel.writeInt(1);
            } else if (calendarMode2 == CalendarMode.MONTHS) {
                parcel.writeInt(2);
            } else if (calendarMode2 == CalendarMode.MONTHS_CATEGORY) {
                parcel.writeInt(4);
            } else {
                parcel.writeInt(3);
            }
            parcel.writeParcelable(this.currentMonth, 0);
            parcel.writeByte(this.cacheCurrentPosition ? (byte) 1 : 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.color = 0;
            this.dateTextAppearance = 0;
            this.weekDayTextAppearance = 0;
            this.showOtherDates = 4;
            this.allowClickDaysOutsideCurrentMonth = true;
            this.minDate = null;
            this.maxDate = null;
            this.selectedDates = new ArrayList();
            this.firstDayOfWeek = 1;
            this.orientation = 0;
            this.tileWidthPx = -1;
            this.tileHeightPx = -1;
            this.topbarVisible = true;
            this.selectionMode = 1;
            this.dynamicHeightEnabled = false;
            this.calendarMode = CalendarMode.MONTHS;
            this.currentMonth = null;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            boolean z = false;
            this.color = 0;
            this.dateTextAppearance = 0;
            this.weekDayTextAppearance = 0;
            this.showOtherDates = 4;
            this.allowClickDaysOutsideCurrentMonth = true;
            this.minDate = null;
            this.maxDate = null;
            this.selectedDates = new ArrayList();
            this.firstDayOfWeek = 1;
            this.orientation = 0;
            this.tileWidthPx = -1;
            this.tileHeightPx = -1;
            this.topbarVisible = true;
            this.selectionMode = 1;
            this.dynamicHeightEnabled = false;
            CalendarMode calendarMode2 = CalendarMode.MONTHS;
            this.calendarMode = calendarMode2;
            this.currentMonth = null;
            this.color = parcel.readInt();
            this.dateTextAppearance = parcel.readInt();
            this.weekDayTextAppearance = parcel.readInt();
            this.showOtherDates = parcel.readInt();
            this.allowClickDaysOutsideCurrentMonth = parcel.readByte() != 0;
            ClassLoader classLoader = CalendarDay.class.getClassLoader();
            this.minDate = (CalendarDay) parcel.readParcelable(classLoader);
            this.maxDate = (CalendarDay) parcel.readParcelable(classLoader);
            parcel.readTypedList(this.selectedDates, CalendarDay.CREATOR);
            this.firstDayOfWeek = parcel.readInt();
            this.orientation = parcel.readInt();
            this.tileWidthPx = parcel.readInt();
            this.tileHeightPx = parcel.readInt();
            this.topbarVisible = parcel.readInt() == 1;
            this.selectionMode = parcel.readInt();
            this.dynamicHeightEnabled = parcel.readInt() == 1;
            int readInt = parcel.readInt();
            if (readInt == 1) {
                this.calendarMode = CalendarMode.WEEKS;
            } else if (readInt == 2) {
                this.calendarMode = calendarMode2;
            } else if (readInt == 4) {
                this.calendarMode = CalendarMode.MONTHS_CATEGORY;
            } else {
                this.calendarMode = CalendarMode.MONTHS_LABEL;
            }
            this.currentMonth = (CalendarDay) parcel.readParcelable(classLoader);
            this.cacheCurrentPosition = parcel.readByte() != 0 ? true : z;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface SelectionMode {
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Taobao */
    public @interface ShowOtherDates {
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1889276954")) {
                ipChange.ipc$dispatch("-1889276954", new Object[]{this, view});
            } else if (view == MaterialCalendarView.this.buttonFuture) {
                MaterialCalendarView.this.pager.setCurrentItem(MaterialCalendarView.this.pager.getCurrentItem() + 1, true);
            } else if (view == MaterialCalendarView.this.buttonPast) {
                MaterialCalendarView.this.pager.setCurrentItem(MaterialCalendarView.this.pager.getCurrentItem() - 1, true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            int[] iArr = new int[CalendarMode.values().length];
            a = iArr;
            iArr[CalendarMode.MONTHS.ordinal()] = 1;
            a[CalendarMode.WEEKS.ordinal()] = 2;
            a[CalendarMode.MONTHS_LABEL.ordinal()] = 3;
            try {
                a[CalendarMode.MONTHS_CATEGORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    /* compiled from: Taobao */
    public static class c extends ViewGroup.MarginLayoutParams {
        public c(int i) {
            super(-1, i);
        }
    }

    /* compiled from: Taobao */
    public class d {
        private static transient /* synthetic */ IpChange $ipChange;
        private final CalendarMode a;
        private final int b;
        private final CalendarDay c;
        private final CalendarDay d;
        private final boolean e;

        /* synthetic */ d(MaterialCalendarView materialCalendarView, e eVar, a aVar) {
            this(materialCalendarView, eVar);
        }

        private d(MaterialCalendarView materialCalendarView, e eVar) {
            this.a = eVar.a;
            this.b = eVar.b;
            this.c = eVar.d;
            this.d = eVar.e;
            this.e = eVar.c;
        }
    }

    /* compiled from: Taobao */
    public class e {
        private static transient /* synthetic */ IpChange $ipChange;
        private CalendarMode a = CalendarMode.MONTHS;
        private int b = Calendar.getInstance().getFirstDayOfWeek();
        private boolean c = false;
        private CalendarDay d = null;
        private CalendarDay e = null;

        public e() {
        }

        public void f() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1116022847")) {
                ipChange.ipc$dispatch("-1116022847", new Object[]{this});
                return;
            }
            MaterialCalendarView materialCalendarView = MaterialCalendarView.this;
            materialCalendarView.commit(new d(materialCalendarView, this, null));
        }

        public e g(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1150811988")) {
                return (e) ipChange.ipc$dispatch("1150811988", new Object[]{this, Boolean.valueOf(z)});
            }
            this.c = z;
            return this;
        }

        public e h(CalendarMode calendarMode) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "223056238")) {
                return (e) ipChange.ipc$dispatch("223056238", new Object[]{this, calendarMode});
            }
            this.a = calendarMode;
            return this;
        }

        public e i(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1925933280")) {
                return (e) ipChange.ipc$dispatch("-1925933280", new Object[]{this, Integer.valueOf(i)});
            }
            this.b = i;
            return this;
        }

        public e j(@Nullable CalendarDay calendarDay) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "654753046")) {
                return (e) ipChange.ipc$dispatch("654753046", new Object[]{this, calendarDay});
            }
            this.e = calendarDay;
            return this;
        }

        public e k(@Nullable CalendarDay calendarDay) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-823573372")) {
                return (e) ipChange.ipc$dispatch("-823573372", new Object[]{this, calendarDay});
            }
            this.d = calendarDay;
            return this;
        }
    }

    public MaterialCalendarView(Context context) {
        this(context, null);
    }

    private static int clampSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "345557849")) {
            return ((Integer) ipChange.ipc$dispatch("345557849", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? i : size;
        }
        return Math.min(i, size);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0065, code lost:
        if (r1.isBefore(r2) == false) goto L_0x0096;
     */
    private void commit(d dVar) {
        CalendarPagerAdapter<?> calendarPagerAdapter;
        CalendarDay calendarDay;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773850848")) {
            ipChange.ipc$dispatch("-1773850848", new Object[]{this, dVar});
            return;
        }
        CalendarDay calendarDay2 = null;
        if (this.adapter != null && dVar.e) {
            calendarDay2 = this.adapter.f(this.pager.getCurrentItem());
            if (this.calendarMode != dVar.a) {
                CalendarDay selectedDate = getSelectedDate();
                CalendarMode calendarMode2 = this.calendarMode;
                if ((calendarMode2 == CalendarMode.MONTHS || calendarMode2 == CalendarMode.MONTHS_LABEL || calendarMode2 == CalendarMode.MONTHS_CATEGORY) && selectedDate != 0) {
                    Calendar calendar = calendarDay2.getCalendar();
                    calendar.add(2, 1);
                    CalendarDay from = CalendarDay.from(calendar);
                    if (!selectedDate.equals(calendarDay2)) {
                        if (selectedDate.isAfter(calendarDay2)) {
                        }
                    }
                } else if (calendarMode2 == CalendarMode.WEEKS) {
                    Calendar calendar2 = calendarDay2.getCalendar();
                    calendar2.add(7, 6);
                    CalendarDay from2 = CalendarDay.from(calendar2);
                    if (selectedDate == null || (!selectedDate.equals(calendarDay2) && !selectedDate.equals(from2) && (!selectedDate.isAfter(calendarDay2) || !selectedDate.isBefore(from2)))) {
                        calendarDay2 = from2;
                    }
                }
                calendarDay2 = selectedDate;
            }
        }
        this.state = dVar;
        this.calendarMode = dVar.a;
        this.firstDayOfWeek = dVar.b;
        this.minDate = dVar.c;
        this.maxDate = dVar.d;
        int i = b.a[this.calendarMode.ordinal()];
        if (i == 1) {
            calendarPagerAdapter = new MonthPagerAdapter(this);
        } else if (i == 2) {
            calendarPagerAdapter = new WeekPagerAdapter(this);
        } else if (i == 3) {
            calendarPagerAdapter = new MonthLabelPagerAdapter(this);
        } else if (i == 4) {
            calendarPagerAdapter = new MonthCategoryPagerAdapter(this);
        } else {
            throw new IllegalArgumentException("Provided display mode which is not yet implemented");
        }
        CalendarPagerAdapter<?> calendarPagerAdapter2 = this.adapter;
        if (calendarPagerAdapter2 == null) {
            this.adapter = calendarPagerAdapter;
        } else {
            this.adapter = calendarPagerAdapter2.o(calendarPagerAdapter);
        }
        this.pager.setAdapter(this.adapter);
        setRangeDates(this.minDate, this.maxDate);
        this.pager.setLayoutParams(new c(this.calendarMode.visibleWeeksCount + 1));
        if (this.selectionMode != 1 || this.adapter.h().isEmpty()) {
            calendarDay = CalendarDay.today();
        } else {
            calendarDay = this.adapter.h().get(0);
        }
        setCurrentDate(calendarDay);
        if (calendarDay2 != null) {
            this.pager.setCurrentItem(this.adapter.e(calendarDay2));
        }
        invalidateDecorators();
        updateUi();
    }

    private int dpToPx(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "183651421")) {
            return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
        }
        return ((Integer) ipChange.ipc$dispatch("183651421", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    private static int getThemeAccentColor(Context context) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "932071039")) {
            return ((Integer) ipChange.ipc$dispatch("932071039", new Object[]{context})).intValue();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            i = 16843829;
        } else {
            i = context.getResources().getIdentifier("colorAccent", RichTextNode.ATTR, context.getPackageName());
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.data;
    }

    private int getWeekCountBasedOnMode() {
        CalendarPagerAdapter<?> calendarPagerAdapter;
        CalendarPager calendarPager;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-125638939")) {
            return ((Integer) ipChange.ipc$dispatch("-125638939", new Object[]{this})).intValue();
        }
        CalendarMode calendarMode2 = this.calendarMode;
        int i = calendarMode2.visibleWeeksCount;
        if (calendarMode2.equals(CalendarMode.MONTHS) || this.calendarMode.equals(CalendarMode.MONTHS_LABEL) || this.calendarMode.equals(CalendarMode.MONTHS_CATEGORY)) {
            z = true;
        }
        if (z && this.mDynamicHeightEnabled && (calendarPagerAdapter = this.adapter) != null && (calendarPager = this.pager) != null) {
            Calendar calendar = (Calendar) calendarPagerAdapter.f(calendarPager.getCurrentItem()).getCalendar().clone();
            calendar.set(5, calendar.getActualMaximum(5));
            calendar.setFirstDayOfWeek(getFirstDayOfWeek());
            i = calendar.get(4);
        }
        return i + 1;
    }

    private void setRangeDates(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785217240")) {
            ipChange.ipc$dispatch("785217240", new Object[]{this, calendarDay, calendarDay2});
            return;
        }
        CalendarDay calendarDay3 = this.currentMonth;
        this.adapter.t(calendarDay, calendarDay2);
        this.currentMonth = calendarDay3;
        if (calendarDay != null) {
            if (!calendarDay.isAfter(calendarDay3)) {
                calendarDay = this.currentMonth;
            }
            this.currentMonth = calendarDay;
        }
        this.pager.setCurrentItem(this.adapter.e(calendarDay3), false);
        updateUi();
    }

    private void setupChildren() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1763850810")) {
            ipChange.ipc$dispatch("-1763850810", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.topbar = linearLayout;
        linearLayout.setOrientation(0);
        this.topbar.setClipChildren(false);
        this.topbar.setClipToPadding(false);
        addView(this.topbar, new c(1));
        this.buttonPast.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.topbar.addView(this.buttonPast, new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.title.setGravity(17);
        this.topbar.addView(this.title, new LinearLayout.LayoutParams(0, -1, 5.0f));
        this.buttonFuture.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.topbar.addView(this.buttonFuture, new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.pager.setId(R$id.mcv_pager);
        this.pager.setOffscreenPageLimit(1);
        addView(this.pager, new c(this.calendarMode.visibleWeeksCount + 1));
    }

    public static boolean showDecoratedDisabled(@ShowOtherDates int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1492915067")) {
            return (i & 4) != 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1492915067", new Object[]{Integer.valueOf(i)})).booleanValue();
    }

    public static boolean showOtherMonths(@ShowOtherDates int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1571730805")) {
            return (i & 1) != 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1571730805", new Object[]{Integer.valueOf(i)})).booleanValue();
    }

    public static boolean showOutOfRange(@ShowOtherDates int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "276633908")) {
            return (i & 2) != 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("276633908", new Object[]{Integer.valueOf(i)})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateUi() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "519733643")) {
            ipChange.ipc$dispatch("519733643", new Object[]{this});
            return;
        }
        this.titleChanger.f(this.currentMonth);
        this.buttonPast.setEnabled(canGoBack());
        this.buttonFuture.setEnabled(canGoForward());
    }

    public void addDecorator(DayViewDecorator dayViewDecorator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-488034694")) {
            ipChange.ipc$dispatch("-488034694", new Object[]{this, dayViewDecorator});
        } else if (dayViewDecorator != null) {
            this.dayViewDecorators.add(dayViewDecorator);
            this.adapter.s(this.dayViewDecorators);
        }
    }

    public void addDecorators(Collection<? extends DayViewDecorator> collection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "610497050")) {
            ipChange.ipc$dispatch("610497050", new Object[]{this, collection});
        } else if (collection != null) {
            this.dayViewDecorators.addAll(collection);
            this.adapter.s(this.dayViewDecorators);
        }
    }

    public boolean allowClickDaysOutsideCurrentMonth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-242311056")) {
            return this.allowClickDaysOutsideCurrentMonth;
        }
        return ((Boolean) ipChange.ipc$dispatch("-242311056", new Object[]{this})).booleanValue();
    }

    public boolean canGoBack() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-910112985")) {
            return this.pager.getCurrentItem() > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-910112985", new Object[]{this})).booleanValue();
    }

    public boolean canGoForward() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "469100671")) {
            return this.pager.getCurrentItem() < this.adapter.getCount() - 1;
        }
        return ((Boolean) ipChange.ipc$dispatch("469100671", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1683572233")) {
            return layoutParams instanceof c;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1683572233", new Object[]{this, layoutParams})).booleanValue();
    }

    public void clearSelection() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-311997559")) {
            ipChange.ipc$dispatch("-311997559", new Object[]{this});
            return;
        }
        List<CalendarDay> selectedDates = getSelectedDates();
        this.adapter.a();
        for (CalendarDay calendarDay : selectedDates) {
            dispatchOnDateSelected(calendarDay, false);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchOnDateSelected(CalendarDay calendarDay, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-3825362")) {
            ipChange.ipc$dispatch("-3825362", new Object[]{this, calendarDay, Boolean.valueOf(z)});
            return;
        }
        OnDateSelectedListener onDateSelectedListener = this.listener;
        if (onDateSelectedListener != null) {
            onDateSelectedListener.onDateSelected(this, calendarDay, z);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchOnMonthChanged(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1891571951")) {
            ipChange.ipc$dispatch("-1891571951", new Object[]{this, calendarDay});
            return;
        }
        OnMonthChangedListener onMonthChangedListener = this.monthListener;
        if (onMonthChangedListener != null) {
            onMonthChangedListener.onMonthChanged(this, calendarDay);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchOnRangeSelected(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "225006211")) {
            ipChange.ipc$dispatch("225006211", new Object[]{this, calendarDay, calendarDay2});
            return;
        }
        OnRangeSelectedListener onRangeSelectedListener = this.rangeListener;
        ArrayList arrayList = new ArrayList();
        Calendar instance = Calendar.getInstance();
        instance.setTime(calendarDay.getDate());
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(calendarDay2.getDate());
        while (true) {
            if (!instance.before(instance2) && !instance.equals(instance2)) {
                break;
            }
            CalendarDay from = CalendarDay.from(instance);
            this.adapter.p(from, true);
            arrayList.add(from);
            instance.add(5, 1);
        }
        if (onRangeSelectedListener != null) {
            onRangeSelectedListener.onRangeSelected(this, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1090512419")) {
            ipChange.ipc$dispatch("1090512419", new Object[]{this, sparseArray});
            return;
        }
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchSaveInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "132023616")) {
            ipChange.ipc$dispatch("132023616", new Object[]{this, sparseArray});
            return;
        }
        dispatchFreezeSelfOnly(sparseArray);
    }

    public int getArrowColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1504729093")) {
            return this.arrowColor;
        }
        return ((Integer) ipChange.ipc$dispatch("1504729093", new Object[]{this})).intValue();
    }

    public CharSequence getCalendarContentDescription() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2042410129")) {
            return (CharSequence) ipChange.ipc$dispatch("-2042410129", new Object[]{this});
        }
        CharSequence charSequence = this.calendarContentDescription;
        return charSequence != null ? charSequence : getContext().getString(R$string.calendar);
    }

    public CalendarDay getCurrentDate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "851316915")) {
            return this.adapter.f(this.pager.getCurrentItem());
        }
        return (CalendarDay) ipChange.ipc$dispatch("851316915", new Object[]{this});
    }

    public int getFirstDayOfWeek() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1029407720")) {
            return this.firstDayOfWeek;
        }
        return ((Integer) ipChange.ipc$dispatch("1029407720", new Object[]{this})).intValue();
    }

    public Drawable getLeftArrowMask() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1144630378")) {
            return this.leftArrowMask;
        }
        return (Drawable) ipChange.ipc$dispatch("1144630378", new Object[]{this});
    }

    public CalendarDay getMaximumDate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1749166676")) {
            return this.maxDate;
        }
        return (CalendarDay) ipChange.ipc$dispatch("-1749166676", new Object[]{this});
    }

    public CalendarDay getMinimumDate() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1377850110")) {
            return this.minDate;
        }
        return (CalendarDay) ipChange.ipc$dispatch("1377850110", new Object[]{this});
    }

    public Drawable getRightArrowMask() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "976276391")) {
            return this.rightArrowMask;
        }
        return (Drawable) ipChange.ipc$dispatch("976276391", new Object[]{this});
    }

    public CalendarDay getSelectedDate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1601534495")) {
            return (CalendarDay) ipChange.ipc$dispatch("1601534495", new Object[]{this});
        }
        List<CalendarDay> h = this.adapter.h();
        if (h.isEmpty()) {
            return null;
        }
        return h.get(h.size() - 1);
    }

    @NonNull
    public List<CalendarDay> getSelectedDates() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-753049517")) {
            return this.adapter.h();
        }
        return (List) ipChange.ipc$dispatch("-753049517", new Object[]{this});
    }

    public int getSelectionColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-739676408")) {
            return this.accentColor;
        }
        return ((Integer) ipChange.ipc$dispatch("-739676408", new Object[]{this})).intValue();
    }

    @SelectionMode
    public int getSelectionMode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "946221218")) {
            return this.selectionMode;
        }
        return ((Integer) ipChange.ipc$dispatch("946221218", new Object[]{this})).intValue();
    }

    @ShowOtherDates
    public int getShowOtherDates() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2025861587")) {
            return this.adapter.i();
        }
        return ((Integer) ipChange.ipc$dispatch("-2025861587", new Object[]{this})).intValue();
    }

    public int getTileHeight() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "217620874")) {
            return this.tileHeight;
        }
        return ((Integer) ipChange.ipc$dispatch("217620874", new Object[]{this})).intValue();
    }

    @Deprecated
    public int getTileSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1204601520")) {
            return Math.max(this.tileHeight, this.tileWidth);
        }
        return ((Integer) ipChange.ipc$dispatch("1204601520", new Object[]{this})).intValue();
    }

    public int getTileWidth() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "750131737")) {
            return this.tileWidth;
        }
        return ((Integer) ipChange.ipc$dispatch("750131737", new Object[]{this})).intValue();
    }

    public int getTitleAnimationOrientation() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "555599405")) {
            return this.titleChanger.i();
        }
        return ((Integer) ipChange.ipc$dispatch("555599405", new Object[]{this})).intValue();
    }

    public boolean getTopbarVisible() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1058254830")) {
            return this.topbar.getVisibility() == 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1058254830", new Object[]{this})).booleanValue();
    }

    public void goToNext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1744946926")) {
            ipChange.ipc$dispatch("-1744946926", new Object[]{this});
        } else if (canGoForward()) {
            CalendarPager calendarPager = this.pager;
            calendarPager.setCurrentItem(calendarPager.getCurrentItem() + 1, true);
        }
    }

    public void goToPrevious() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-717512050")) {
            ipChange.ipc$dispatch("-717512050", new Object[]{this});
        } else if (canGoBack()) {
            CalendarPager calendarPager = this.pager;
            calendarPager.setCurrentItem(calendarPager.getCurrentItem() - 1, true);
        }
    }

    public void invalidateDecorators() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "762120021")) {
            ipChange.ipc$dispatch("762120021", new Object[]{this});
            return;
        }
        this.adapter.l();
    }

    public boolean isDynamicHeightEnabled() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2012365351")) {
            return this.mDynamicHeightEnabled;
        }
        return ((Boolean) ipChange.ipc$dispatch("2012365351", new Object[]{this})).booleanValue();
    }

    public boolean isPagingEnabled() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-564390213")) {
            return this.pager.isPagingEnabled();
        }
        return ((Boolean) ipChange.ipc$dispatch("-564390213", new Object[]{this})).booleanValue();
    }

    public e newState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1312375021")) {
            return new e();
        }
        return (e) ipChange.ipc$dispatch("1312375021", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public void onDateClicked(@NonNull CalendarDay calendarDay, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-368922960")) {
            ipChange.ipc$dispatch("-368922960", new Object[]{this, calendarDay, Boolean.valueOf(z)});
            return;
        }
        int i = this.selectionMode;
        if (i == 2) {
            this.adapter.p(calendarDay, z);
            dispatchOnDateSelected(calendarDay, z);
        } else if (i != 3) {
            this.adapter.a();
            this.adapter.p(calendarDay, true);
            dispatchOnDateSelected(calendarDay, true);
        } else {
            this.adapter.p(calendarDay, z);
            if (this.adapter.h().size() > 2) {
                this.adapter.a();
                this.adapter.p(calendarDay, z);
                dispatchOnDateSelected(calendarDay, z);
            } else if (this.adapter.h().size() == 2) {
                List<CalendarDay> h = this.adapter.h();
                if (h.get(0).isAfter(h.get(1))) {
                    dispatchOnRangeSelected(h.get(1), h.get(0));
                } else {
                    dispatchOnRangeSelected(h.get(0), h.get(1));
                }
            } else {
                this.adapter.p(calendarDay, z);
                dispatchOnDateSelected(calendarDay, z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDateUnselected(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "98126949")) {
            ipChange.ipc$dispatch("98126949", new Object[]{this, calendarDay});
            return;
        }
        dispatchOnDateSelected(calendarDay, false);
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1215522979")) {
            ipChange.ipc$dispatch("-1215522979", new Object[]{this, accessibilityEvent});
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MaterialCalendarView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "396621135")) {
            ipChange.ipc$dispatch("396621135", new Object[]{this, accessibilityNodeInfo});
            return;
        }
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MaterialCalendarView.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12435563")) {
            ipChange.ipc$dispatch("-12435563", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i3 - i) - paddingLeft) - getPaddingRight();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int i6 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                int measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                childAt.layout(i6, paddingTop, measuredWidth + i6, measuredHeight);
                paddingTop = measuredHeight;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1231402461")) {
            ipChange.ipc$dispatch("-1231402461", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        int weekCountBasedOnMode = getWeekCountBasedOnMode();
        if (getTopbarVisible()) {
            weekCountBasedOnMode++;
        }
        int i3 = paddingLeft / 7;
        int i4 = paddingTop / weekCountBasedOnMode;
        int i5 = this.tileWidth;
        int i6 = -1;
        if (i5 == -10 && this.tileHeight == -10) {
            if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
                i3 = (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) ? i4 : -1;
            } else if (mode2 == 1073741824) {
                i3 = Math.min(i3, i4);
            }
            i4 = -1;
        } else {
            if (i5 > 0) {
                i3 = i5;
            }
            int i7 = this.tileHeight;
            if (i7 > 0) {
                i6 = i3;
                i4 = i7;
            } else {
                i6 = i3;
            }
            i3 = -1;
        }
        if (i3 > 0) {
            i4 = i3;
        } else if (i3 <= 0) {
            int dpToPx = i6 <= 0 ? dpToPx(44) : i6;
            if (i4 <= 0) {
                i4 = dpToPx(44);
            }
            i3 = dpToPx;
        } else {
            i3 = i6;
        }
        int i8 = i3 * 7;
        setMeasuredDimension(clampSize(getPaddingLeft() + getPaddingRight() + i8, i), clampSize((weekCountBasedOnMode * i4) + getPaddingTop() + getPaddingBottom(), i2));
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) ((c) childAt.getLayoutParams())).height * i4, 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2074261880")) {
            ipChange.ipc$dispatch("2074261880", new Object[]{this, parcelable});
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        newState().i(savedState.firstDayOfWeek).h(savedState.calendarMode).k(savedState.minDate).j(savedState.maxDate).g(savedState.cacheCurrentPosition).f();
        setSelectionColor(savedState.color);
        setDateTextAppearance(savedState.dateTextAppearance);
        setWeekDayTextAppearance(savedState.weekDayTextAppearance);
        setShowOtherDates(savedState.showOtherDates);
        setAllowClickDaysOutsideCurrentMonth(savedState.allowClickDaysOutsideCurrentMonth);
        clearSelection();
        for (CalendarDay calendarDay : savedState.selectedDates) {
            setDateSelected(calendarDay, true);
        }
        setTitleAnimationOrientation(savedState.orientation);
        setTileWidth(savedState.tileWidthPx);
        setTileHeight(savedState.tileHeightPx);
        setTopbarVisible(savedState.topbarVisible);
        setSelectionMode(savedState.selectionMode);
        setDynamicHeightEnabled(savedState.dynamicHeightEnabled);
        setCurrentDate(savedState.currentMonth);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2130830267")) {
            return (Parcelable) ipChange.ipc$dispatch("-2130830267", new Object[]{this});
        }
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.color = getSelectionColor();
        savedState.dateTextAppearance = this.adapter.d();
        savedState.weekDayTextAppearance = this.adapter.j();
        savedState.showOtherDates = getShowOtherDates();
        savedState.allowClickDaysOutsideCurrentMonth = allowClickDaysOutsideCurrentMonth();
        savedState.minDate = getMinimumDate();
        savedState.maxDate = getMaximumDate();
        savedState.selectedDates = getSelectedDates();
        savedState.firstDayOfWeek = getFirstDayOfWeek();
        savedState.orientation = getTitleAnimationOrientation();
        savedState.selectionMode = getSelectionMode();
        savedState.tileWidthPx = getTileWidth();
        savedState.tileHeightPx = getTileHeight();
        savedState.topbarVisible = getTopbarVisible();
        savedState.calendarMode = this.calendarMode;
        savedState.dynamicHeightEnabled = this.mDynamicHeightEnabled;
        savedState.currentMonth = this.currentMonth;
        savedState.cacheCurrentPosition = this.state.e;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1390442777")) {
            return this.pager.dispatchTouchEvent(motionEvent);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1390442777", new Object[]{this, motionEvent})).booleanValue();
    }

    public void removeDecorator(DayViewDecorator dayViewDecorator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-990611753")) {
            ipChange.ipc$dispatch("-990611753", new Object[]{this, dayViewDecorator});
            return;
        }
        this.dayViewDecorators.remove(dayViewDecorator);
        this.adapter.s(this.dayViewDecorators);
    }

    public void removeDecorators() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-36827092")) {
            ipChange.ipc$dispatch("-36827092", new Object[]{this});
            return;
        }
        this.dayViewDecorators.clear();
        this.adapter.s(this.dayViewDecorators);
    }

    public void selectRange(CalendarDay calendarDay, CalendarDay calendarDay2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1565037791")) {
            ipChange.ipc$dispatch("-1565037791", new Object[]{this, calendarDay, calendarDay2});
            return;
        }
        clearSelection();
        if (calendarDay != null && calendarDay2 != null) {
            if (calendarDay.isAfter(calendarDay2)) {
                dispatchOnRangeSelected(calendarDay2, calendarDay);
            } else {
                dispatchOnRangeSelected(calendarDay, calendarDay2);
            }
        }
    }

    public void setAllowClickDaysOutsideCurrentMonth(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "776927840")) {
            ipChange.ipc$dispatch("776927840", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.allowClickDaysOutsideCurrentMonth = z;
    }

    public void setArrowColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1538161347")) {
            ipChange.ipc$dispatch("-1538161347", new Object[]{this, Integer.valueOf(i)});
        } else if (i != 0) {
            this.arrowColor = i;
            this.buttonPast.setColor(i);
            this.buttonFuture.setColor(i);
            invalidate();
        }
    }

    public void setContentDescriptionArrowFuture(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2001783035")) {
            ipChange.ipc$dispatch("-2001783035", new Object[]{this, charSequence});
            return;
        }
        this.buttonFuture.setContentDescription(charSequence);
    }

    public void setContentDescriptionArrowPast(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-632160490")) {
            ipChange.ipc$dispatch("-632160490", new Object[]{this, charSequence});
            return;
        }
        this.buttonPast.setContentDescription(charSequence);
    }

    public void setContentDescriptionCalendar(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1671004547")) {
            ipChange.ipc$dispatch("1671004547", new Object[]{this, charSequence});
            return;
        }
        this.calendarContentDescription = charSequence;
    }

    public void setCurrentDate(@Nullable Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1031564244")) {
            ipChange.ipc$dispatch("1031564244", new Object[]{this, calendar});
            return;
        }
        setCurrentDate(CalendarDay.from(calendar));
    }

    public void setDateSelected(@Nullable Calendar calendar, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "188093612")) {
            ipChange.ipc$dispatch("188093612", new Object[]{this, calendar, Boolean.valueOf(z)});
            return;
        }
        setDateSelected(CalendarDay.from(calendar), z);
    }

    public void setDateTextAppearance(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "711055778")) {
            ipChange.ipc$dispatch("711055778", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.adapter.q(i);
    }

    public void setDayFormatter(DayFormatter dayFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-821617326")) {
            ipChange.ipc$dispatch("-821617326", new Object[]{this, dayFormatter});
            return;
        }
        CalendarPagerAdapter<?> calendarPagerAdapter = this.adapter;
        if (dayFormatter == null) {
            dayFormatter = DayFormatter.DEFAULT;
        }
        calendarPagerAdapter.r(dayFormatter);
    }

    public void setDynamicHeightEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1698384783")) {
            ipChange.ipc$dispatch("1698384783", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mDynamicHeightEnabled = z;
    }

    public void setHeaderTextAppearance(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-341853823")) {
            ipChange.ipc$dispatch("-341853823", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.title.setTextAppearance(getContext(), i);
    }

    public void setLeftArrowMask(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1598551424")) {
            ipChange.ipc$dispatch("1598551424", new Object[]{this, drawable});
            return;
        }
        this.leftArrowMask = drawable;
        this.buttonPast.setImageDrawable(drawable);
    }

    public void setOnDateChangedListener(OnDateSelectedListener onDateSelectedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "348488121")) {
            ipChange.ipc$dispatch("348488121", new Object[]{this, onDateSelectedListener});
            return;
        }
        this.listener = onDateSelectedListener;
    }

    public void setOnMonthChangedListener(OnMonthChangedListener onMonthChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1764461208")) {
            ipChange.ipc$dispatch("1764461208", new Object[]{this, onMonthChangedListener});
            return;
        }
        this.monthListener = onMonthChangedListener;
    }

    public void setOnRangeSelectedListener(OnRangeSelectedListener onRangeSelectedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-991115584")) {
            ipChange.ipc$dispatch("-991115584", new Object[]{this, onRangeSelectedListener});
            return;
        }
        this.rangeListener = onRangeSelectedListener;
    }

    public void setOnTitleClickListener(View.OnClickListener onClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "917954876")) {
            ipChange.ipc$dispatch("917954876", new Object[]{this, onClickListener2});
            return;
        }
        this.title.setOnClickListener(onClickListener2);
    }

    public void setPagingEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1442582079")) {
            ipChange.ipc$dispatch("1442582079", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.pager.setPagingEnabled(z);
        updateUi();
    }

    public void setRightArrowMask(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1187815755")) {
            ipChange.ipc$dispatch("1187815755", new Object[]{this, drawable});
            return;
        }
        this.rightArrowMask = drawable;
        this.buttonFuture.setImageDrawable(drawable);
    }

    public void setSelectedDate(@Nullable Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "875403944")) {
            ipChange.ipc$dispatch("875403944", new Object[]{this, calendar});
            return;
        }
        setSelectedDate(CalendarDay.from(calendar));
    }

    public void setSelectionColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1081108634")) {
            ipChange.ipc$dispatch("1081108634", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i == 0) {
            if (isInEditMode()) {
                i = -7829368;
            } else {
                return;
            }
        }
        this.accentColor = i;
        this.adapter.u(i);
        invalidate();
    }

    public void setSelectionMode(@SelectionMode int i) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1342806872")) {
            ipChange.ipc$dispatch("-1342806872", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = this.selectionMode;
        this.selectionMode = i;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    this.selectionMode = 0;
                    if (i2 != 0) {
                        clearSelection();
                    }
                } else {
                    clearSelection();
                }
            }
        } else if ((i2 == 2 || i2 == 3) && !getSelectedDates().isEmpty()) {
            setSelectedDate(getSelectedDate());
        }
        CalendarPagerAdapter<?> calendarPagerAdapter = this.adapter;
        if (this.selectionMode != 0) {
            z = true;
        }
        calendarPagerAdapter.v(z);
    }

    public void setShowOtherDates(@ShowOtherDates int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-135926251")) {
            ipChange.ipc$dispatch("-135926251", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.adapter.w(i);
    }

    public void setTileHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1511156824")) {
            ipChange.ipc$dispatch("1511156824", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tileHeight = i;
        requestLayout();
    }

    public void setTileHeightDp(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1360354436")) {
            ipChange.ipc$dispatch("1360354436", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setTileHeight(dpToPx(i));
    }

    public void setTileSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-401276174")) {
            ipChange.ipc$dispatch("-401276174", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tileWidth = i;
        this.tileHeight = i;
        requestLayout();
    }

    public void setTileSizeDp(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1758246046")) {
            ipChange.ipc$dispatch("1758246046", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setTileSize(dpToPx(i));
    }

    public void setTileWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-52165615")) {
            ipChange.ipc$dispatch("-52165615", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tileWidth = i;
        requestLayout();
    }

    public void setTileWidthDp(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2048923139")) {
            ipChange.ipc$dispatch("-2048923139", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setTileWidth(dpToPx(i));
    }

    public void setTitleAnimationOrientation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692299901")) {
            ipChange.ipc$dispatch("1692299901", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.titleChanger.j(i);
    }

    public void setTitleFormatter(TitleFormatter titleFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1102188910")) {
            ipChange.ipc$dispatch("-1102188910", new Object[]{this, titleFormatter});
            return;
        }
        if (titleFormatter == null) {
            titleFormatter = DEFAULT_TITLE_FORMATTER;
        }
        this.titleChanger.l(titleFormatter);
        this.adapter.x(titleFormatter);
        updateUi();
    }

    public void setTitleMonths(CharSequence[] charSequenceArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1978987334")) {
            ipChange.ipc$dispatch("-1978987334", new Object[]{this, charSequenceArr});
            return;
        }
        setTitleFormatter(new qf1(charSequenceArr));
    }

    public void setTopbarVisible(boolean z) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "2130250910")) {
            ipChange.ipc$dispatch("2130250910", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        LinearLayout linearLayout = this.topbar;
        if (!z) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        requestLayout();
    }

    public void setWeekDayFormatter(WeekDayFormatter weekDayFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-999054254")) {
            ipChange.ipc$dispatch("-999054254", new Object[]{this, weekDayFormatter});
            return;
        }
        CalendarPagerAdapter<?> calendarPagerAdapter = this.adapter;
        if (weekDayFormatter == null) {
            weekDayFormatter = WeekDayFormatter.DEFAULT;
        }
        calendarPagerAdapter.y(weekDayFormatter);
    }

    public void setWeekDayLabels(CharSequence[] charSequenceArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807658678")) {
            ipChange.ipc$dispatch("1807658678", new Object[]{this, charSequenceArr});
            return;
        }
        setWeekDayFormatter(new x7(charSequenceArr));
    }

    public void setWeekDayTextAppearance(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "133577202")) {
            ipChange.ipc$dispatch("133577202", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.adapter.z(i);
    }

    public boolean shouldDelayChildPressedState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "834754417")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("834754417", new Object[]{this})).booleanValue();
    }

    public d state() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "677732244")) {
            return this.state;
        }
        return (d) ipChange.ipc$dispatch("677732244", new Object[]{this});
    }

    public MaterialCalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dayViewDecorators = new ArrayList<>();
        a aVar = new a();
        this.onClickListener = aVar;
        AnonymousClass2 r1 = new ViewPager.OnPageChangeListener() {
            /* class cn.damai.uikit.calendar.MaterialCalendarView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1686132085")) {
                    ipChange.ipc$dispatch("-1686132085", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "302182954")) {
                    ipChange.ipc$dispatch("302182954", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1447963542")) {
                    ipChange.ipc$dispatch("1447963542", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                MaterialCalendarView.this.titleChanger.k(MaterialCalendarView.this.currentMonth);
                MaterialCalendarView materialCalendarView = MaterialCalendarView.this;
                materialCalendarView.currentMonth = materialCalendarView.adapter.f(i);
                MaterialCalendarView.this.updateUi();
                MaterialCalendarView materialCalendarView2 = MaterialCalendarView.this;
                materialCalendarView2.dispatchOnMonthChanged(materialCalendarView2.currentMonth);
            }
        };
        this.pageChangeListener = r1;
        this.minDate = null;
        this.maxDate = null;
        this.accentColor = 0;
        this.arrowColor = -16777216;
        this.tileHeight = -10;
        this.tileWidth = -10;
        this.selectionMode = 1;
        this.allowClickDaysOutsideCurrentMonth = true;
        if (Build.VERSION.SDK_INT >= 19) {
            setClipToPadding(false);
            setClipChildren(false);
        } else {
            setClipChildren(true);
            setClipToPadding(true);
        }
        DirectionButton directionButton = new DirectionButton(getContext());
        this.buttonPast = directionButton;
        directionButton.setContentDescription(getContext().getString(R$string.previous));
        TextView textView = new TextView(getContext());
        this.title = textView;
        DirectionButton directionButton2 = new DirectionButton(getContext());
        this.buttonFuture = directionButton2;
        directionButton2.setContentDescription(getContext().getString(R$string.next));
        CalendarPager calendarPager = new CalendarPager(getContext());
        this.pager = calendarPager;
        directionButton.setOnClickListener(aVar);
        directionButton2.setOnClickListener(aVar);
        gm2 gm2 = new gm2(textView);
        this.titleChanger = gm2;
        gm2.l(DEFAULT_TITLE_FORMATTER);
        calendarPager.setOnPageChangeListener(r1);
        calendarPager.setPageTransformer(false, new ViewPager.PageTransformer(this) {
            /* class cn.damai.uikit.calendar.MaterialCalendarView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.PageTransformer
            public void transformPage(View view, float f) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1956147430")) {
                    ipChange.ipc$dispatch("1956147430", new Object[]{this, view, Float.valueOf(f)});
                    return;
                }
                view.setAlpha((float) Math.sqrt((double) (1.0f - Math.abs(f))));
            }
        });
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.MaterialCalendarView, 0, 0);
        try {
            int integer = obtainStyledAttributes.getInteger(R$styleable.MaterialCalendarView_mcv_calendarMode, 0);
            this.firstDayOfWeek = obtainStyledAttributes.getInteger(R$styleable.MaterialCalendarView_mcv_firstDayOfWeek, -1);
            gm2.j(obtainStyledAttributes.getInteger(R$styleable.MaterialCalendarView_mcv_titleAnimationOrientation, 0));
            if (this.firstDayOfWeek < 0) {
                this.firstDayOfWeek = Calendar.getInstance().getFirstDayOfWeek();
            }
            newState().i(this.firstDayOfWeek).h(CalendarMode.values()[integer]).f();
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(R$styleable.MaterialCalendarView_mcv_tileSize, -10);
            if (layoutDimension > -10) {
                setTileSize(layoutDimension);
            }
            int layoutDimension2 = obtainStyledAttributes.getLayoutDimension(R$styleable.MaterialCalendarView_mcv_tileWidth, -10);
            if (layoutDimension2 > -10) {
                setTileWidth(layoutDimension2);
            }
            int layoutDimension3 = obtainStyledAttributes.getLayoutDimension(R$styleable.MaterialCalendarView_mcv_tileHeight, -10);
            if (layoutDimension3 > -10) {
                setTileHeight(layoutDimension3);
            }
            setArrowColor(obtainStyledAttributes.getColor(R$styleable.MaterialCalendarView_mcv_arrowColor, -16777216));
            Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.MaterialCalendarView_mcv_leftArrowMask);
            setLeftArrowMask(drawable == null ? getResources().getDrawable(R$drawable.mcv_action_previous) : drawable);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.MaterialCalendarView_mcv_rightArrowMask);
            setRightArrowMask(drawable2 == null ? getResources().getDrawable(R$drawable.mcv_action_next) : drawable2);
            setSelectionColor(obtainStyledAttributes.getColor(R$styleable.MaterialCalendarView_mcv_selectionColor, getThemeAccentColor(context)));
            CharSequence[] textArray = obtainStyledAttributes.getTextArray(R$styleable.MaterialCalendarView_mcv_weekDayLabels);
            if (textArray != null) {
                setWeekDayFormatter(new x7(textArray));
            }
            CharSequence[] textArray2 = obtainStyledAttributes.getTextArray(R$styleable.MaterialCalendarView_mcv_monthLabels);
            if (textArray2 != null) {
                setTitleFormatter(new qf1(textArray2));
            }
            setHeaderTextAppearance(obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarView_mcv_headerTextAppearance, R$style.TextAppearance_MaterialCalendarWidget_Header));
            setWeekDayTextAppearance(obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarView_mcv_weekDayTextAppearance, R$style.TextAppearance_MaterialCalendarWidget_WeekDay));
            setDateTextAppearance(obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarView_mcv_dateTextAppearance, R$style.TextAppearance_MaterialCalendarWidget_Date));
            setShowOtherDates(obtainStyledAttributes.getInteger(R$styleable.MaterialCalendarView_mcv_showOtherDates, 4));
            setAllowClickDaysOutsideCurrentMonth(obtainStyledAttributes.getBoolean(R$styleable.MaterialCalendarView_mcv_allowClickDaysOutsideCurrentMonth, true));
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
        obtainStyledAttributes.recycle();
        this.adapter.x(DEFAULT_TITLE_FORMATTER);
        setupChildren();
        CalendarDay calendarDay = CalendarDay.today();
        this.currentMonth = calendarDay;
        setCurrentDate(calendarDay);
        if (isInEditMode()) {
            removeView(this.pager);
            MonthView monthView = new MonthView(this, this.currentMonth, getFirstDayOfWeek());
            monthView.setSelectionColor(getSelectionColor());
            monthView.setDateTextAppearance(this.adapter.d());
            monthView.setWeekDayTextAppearance(this.adapter.j());
            monthView.setShowOtherDates(getShowOtherDates());
            addView(monthView, new c(this.calendarMode.visibleWeeksCount + 1));
        }
    }

    /* access modifiers changed from: protected */
    public c generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1989075434")) {
            return new c(1);
        }
        return (c) ipChange.ipc$dispatch("-1989075434", new Object[]{this});
    }

    @Override // android.view.ViewGroup
    public c generateLayoutParams(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1573571067")) {
            return new c(1);
        }
        return (c) ipChange.ipc$dispatch("1573571067", new Object[]{this, attributeSet});
    }

    public void setCurrentDate(@Nullable Date date) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1309865572")) {
            ipChange.ipc$dispatch("1309865572", new Object[]{this, date});
            return;
        }
        setCurrentDate(CalendarDay.from(date));
    }

    public void setDateSelected(@Nullable Date date, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1131326948")) {
            ipChange.ipc$dispatch("-1131326948", new Object[]{this, date, Boolean.valueOf(z)});
            return;
        }
        setDateSelected(CalendarDay.from(date), z);
    }

    public void setSelectedDate(@Nullable Date date) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1354018616")) {
            ipChange.ipc$dispatch("1354018616", new Object[]{this, date});
            return;
        }
        setSelectedDate(CalendarDay.from(date));
    }

    public void setTitleMonths(@ArrayRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1146766980")) {
            ipChange.ipc$dispatch("1146766980", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setTitleMonths(getResources().getTextArray(i));
    }

    public void setWeekDayLabels(@ArrayRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "946936960")) {
            ipChange.ipc$dispatch("946936960", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        setWeekDayLabels(getResources().getTextArray(i));
    }

    public void addDecorators(DayViewDecorator... dayViewDecoratorArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-535204872")) {
            ipChange.ipc$dispatch("-535204872", new Object[]{this, dayViewDecoratorArr});
            return;
        }
        addDecorators(Arrays.asList(dayViewDecoratorArr));
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1535001305")) {
            return new c(1);
        }
        return (ViewGroup.LayoutParams) ipChange.ipc$dispatch("-1535001305", new Object[]{this, layoutParams});
    }

    public void setCurrentDate(@Nullable CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1876435863")) {
            ipChange.ipc$dispatch("-1876435863", new Object[]{this, calendarDay});
            return;
        }
        setCurrentDate(calendarDay, true);
    }

    public void setDateSelected(@Nullable CalendarDay calendarDay, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-577548833")) {
            ipChange.ipc$dispatch("-577548833", new Object[]{this, calendarDay, Boolean.valueOf(z)});
        } else if (calendarDay != null) {
            this.adapter.p(calendarDay, z);
        }
    }

    public void setSelectedDate(@Nullable CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1324896235")) {
            ipChange.ipc$dispatch("-1324896235", new Object[]{this, calendarDay});
            return;
        }
        clearSelection();
        if (calendarDay != null) {
            setDateSelected(calendarDay, true);
        }
    }

    public void setCurrentDate(@Nullable CalendarDay calendarDay, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1960076171")) {
            ipChange.ipc$dispatch("1960076171", new Object[]{this, calendarDay, Boolean.valueOf(z)});
        } else if (calendarDay != null) {
            this.pager.setCurrentItem(this.adapter.e(calendarDay), z);
            updateUi();
        }
    }

    /* access modifiers changed from: protected */
    public void onDateClicked(DayView dayView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-250199583")) {
            ipChange.ipc$dispatch("-250199583", new Object[]{this, dayView});
            return;
        }
        CalendarDay currentDate = getCurrentDate();
        CalendarDay date = dayView.getDate();
        int month = currentDate.getMonth();
        int month2 = date.getMonth();
        CalendarMode calendarMode2 = this.calendarMode;
        if (calendarMode2 == CalendarMode.MONTHS || calendarMode2 == CalendarMode.MONTHS_LABEL || calendarMode2 == CalendarMode.MONTHS_CATEGORY) {
            if (!this.allowClickDaysOutsideCurrentMonth && month != month2) {
                return;
            }
            if (month != month2) {
                if (currentDate.isAfter(date)) {
                    goToPrevious();
                } else if (currentDate.isBefore(date)) {
                    goToNext();
                }
            }
        }
        onDateClicked(dayView.getDate(), !dayView.isChecked());
    }
}
