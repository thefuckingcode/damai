package com.taobao.android.dinamicx.widget.calander;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.taobao.android.dinamic.R$styleable;
import com.taobao.android.dinamicx.widget.calander.CalendarView;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class b {
    private boolean A;
    int B;
    CalendarView.OnClickCalendarPaddingListener C;
    CalendarView.OnCalendarInterceptListener D;
    CalendarView.OnCalendarSelectListener E;
    CalendarView.OnCalendarLongClickListener F;
    CalendarView.OnInnerDateSelectedListener G;
    CalendarView.OnYearChangeListener H;
    CalendarView.OnMonthChangeListener I;
    CalendarView.OnMonthUIRangeChangeListener J;
    Calendar K;
    @Nullable
    Calendar L;
    @Nullable
    Calendar M;
    List<Pair<Calendar, Calendar>> N;
    HashMap<String, Calendar> O;
    ConcurrentHashMap<String, Pair<String, String>> P = new ConcurrentHashMap<>();
    CalendarDateTextGravity Q;
    String R;
    int S;
    private boolean T = true;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private Calendar z;

    b(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CalendarView);
        this.i = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_calendar_padding, 0.0f);
        this.j = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_calendar_padding_left, 0.0f);
        this.k = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_calendar_padding_right, 0.0f);
        int i2 = this.i;
        if (i2 != 0) {
            this.j = i2;
            this.k = i2;
        }
        this.o = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CalendarView_week_text_size, a.c(context, 12.0f));
        this.y = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_week_bar_height, (float) a.c(context, 40.0f));
        this.n = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_week_line_margin, (float) a.c(context, 0.0f));
        this.A = obtainStyledAttributes.getBoolean(R$styleable.CalendarView_month_view_scrollable, true);
        this.a = obtainStyledAttributes.getInt(R$styleable.CalendarView_month_view_auto_select_day, 0);
        this.c = obtainStyledAttributes.getInt(R$styleable.CalendarView_month_view_show_mode, 0);
        this.b = obtainStyledAttributes.getInt(R$styleable.CalendarView_week_start_with, 2);
        this.d = obtainStyledAttributes.getInt(R$styleable.CalendarView_select_mode, 0);
        this.m = obtainStyledAttributes.getColor(R$styleable.CalendarView_week_background, -1);
        this.l = obtainStyledAttributes.getColor(R$styleable.CalendarView_week_line_background, 0);
        this.e = obtainStyledAttributes.getColor(R$styleable.CalendarView_week_text_color, -13421773);
        obtainStyledAttributes.getColor(R$styleable.CalendarView_current_day_text_color, SupportMenu.CATEGORY_MASK);
        this.g = obtainStyledAttributes.getColor(R$styleable.CalendarView_selected_text_color, -1);
        this.f = obtainStyledAttributes.getColor(R$styleable.CalendarView_current_month_text_color, -15658735);
        this.p = obtainStyledAttributes.getInt(R$styleable.CalendarView_min_year, 1971);
        this.q = obtainStyledAttributes.getInt(R$styleable.CalendarView_max_year, GLMapStaticValue.MAP_PARAMETERNAME_POLYGON_FILL_CONTROL);
        this.r = obtainStyledAttributes.getInt(R$styleable.CalendarView_min_year_month, 1);
        this.s = obtainStyledAttributes.getInt(R$styleable.CalendarView_max_year_month, 12);
        this.t = obtainStyledAttributes.getInt(R$styleable.CalendarView_min_year_day, 1);
        this.u = obtainStyledAttributes.getInt(R$styleable.CalendarView_max_year_day, -1);
        this.v = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CalendarView_day_text_size, a.c(context, 16.0f));
        this.x = (int) obtainStyledAttributes.getDimension(R$styleable.CalendarView_calendar_height, (float) a.c(context, 56.0f));
        if (this.p <= 1900) {
            this.p = 1900;
        }
        if (this.q >= 2099) {
            this.q = 2099;
        }
        obtainStyledAttributes.recycle();
        H();
    }

    private void H() {
        this.z = new Calendar();
        Date date = new Date();
        this.z.setYear(a.d("yyyy", date));
        this.z.setMonth(a.d("MM", date));
        this.z.setDay(a.d("dd", date));
        this.z.setCurrentDay(true);
        W(this.p, this.r, this.q, this.s);
    }

    private void W(int i2, int i3, int i4, int i5) {
        this.p = i2;
        this.r = i3;
        this.q = i4;
        this.s = i5;
        if (i4 < this.z.getYear()) {
            this.q = this.z.getYear();
        }
        if (this.u == -1) {
            this.u = a.g(this.q, this.s);
        }
        this.B = (((this.z.getYear() - this.p) * 12) + this.z.getMonth()) - this.r;
    }

    /* access modifiers changed from: package-private */
    public int A() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public int B() {
        return this.y;
    }

    /* access modifiers changed from: package-private */
    public int C() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public int D() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public int E() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public int F() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public int G() {
        return this.o;
    }

    public boolean I() {
        return this.T;
    }

    /* access modifiers changed from: package-private */
    public boolean J() {
        return this.A;
    }

    /* access modifiers changed from: package-private */
    public boolean K() {
        return this.h;
    }

    public void L(int i2, int i3, Calendar calendar, Calendar calendar2) {
        Pair<String, String> pair = new Pair<>(calendar.getDateString(), calendar2.getDateString());
        ConcurrentHashMap<String, Pair<String, String>> concurrentHashMap = this.P;
        concurrentHashMap.put(i2 + "-" + i3, pair);
    }

    public void M(boolean z2) {
        this.T = z2;
    }

    public void N(CalendarDateTextGravity calendarDateTextGravity) {
        this.Q = calendarDateTextGravity;
    }

    public void O(HashMap<String, Calendar> hashMap) {
        this.O = hashMap;
    }

    /* access modifiers changed from: package-private */
    public void P(int i2) {
        this.x = i2;
    }

    /* access modifiers changed from: package-private */
    public void Q(int i2) {
        this.w = i2;
    }

    public void R(String str) {
        this.R = str;
    }

    public void S(int i2) {
        this.S = i2;
    }

    /* access modifiers changed from: package-private */
    public void T(int i2) {
        this.v = i2;
    }

    /* access modifiers changed from: package-private */
    public void U(List<Pair<Calendar, Calendar>> list) {
        this.N = list;
    }

    public void V(boolean z2) {
        this.A = z2;
    }

    /* access modifiers changed from: package-private */
    public void X(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.p = i2;
        this.r = i3;
        this.t = i4;
        this.q = i5;
        this.s = i6;
        this.u = i7;
        if (i7 == -1) {
            this.u = a.g(i5, i6);
        }
        this.B = (((this.z.getYear() - this.p) * 12) + this.z.getMonth()) - this.r;
    }

    public void Y(int i2) {
        this.g = i2;
    }

    /* access modifiers changed from: package-private */
    public void Z(int i2, int i3, int i4, int i5, int i6) {
        this.f = i3;
    }

    /* access modifiers changed from: package-private */
    public Calendar a() {
        Calendar calendar = new Calendar();
        calendar.setYear(this.z.getYear());
        calendar.setWeek(this.z.getWeek());
        calendar.setMonth(this.z.getMonth());
        calendar.setDay(this.z.getDay());
        calendar.setCurrentDay(true);
        return calendar;
    }

    public void a0(int i2) {
        this.e = i2;
    }

    public CalendarDateTextGravity b() {
        return this.Q;
    }

    public HashMap<String, Calendar> c() {
        return this.O;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.x;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public Calendar g() {
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.w;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f;
    }

    public String j() {
        return this.R;
    }

    public int k() {
        return this.S;
    }

    /* access modifiers changed from: package-private */
    public int l() {
        return this.v;
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public List<Pair<Calendar, Calendar>> n() {
        return this.N;
    }

    /* access modifiers changed from: package-private */
    public final Calendar o() {
        Calendar calendar = new Calendar();
        calendar.setYear(this.q);
        calendar.setMonth(this.s);
        calendar.setDay(this.u);
        calendar.setCurrentDay(calendar.equals(this.z));
        return calendar;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public int r() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public final Calendar s() {
        Calendar calendar = new Calendar();
        calendar.setYear(this.p);
        calendar.setMonth(this.r);
        calendar.setDay(this.t);
        calendar.setCurrentDay(calendar.equals(this.z));
        return calendar;
    }

    /* access modifiers changed from: package-private */
    public int t() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public int u() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public int v() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public int w() {
        return this.c;
    }

    public Pair<String, String> x(int i2, int i3) {
        ConcurrentHashMap<String, Pair<String, String>> concurrentHashMap = this.P;
        return concurrentHashMap.get(i2 + "-" + i3);
    }

    /* access modifiers changed from: package-private */
    public int y() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public int z() {
        return this.g;
    }
}
